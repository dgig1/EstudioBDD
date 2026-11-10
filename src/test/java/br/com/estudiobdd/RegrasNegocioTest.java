package br.com.estudiobdd;

import br.com.estudiobdd.dto.Requests.*;
import br.com.estudiobdd.model.*;
import br.com.estudiobdd.service.EstudioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RegrasNegocioTest {
    @Autowired EstudioService service;

    private Long[] base() {
        var u = service.criarUsuario(new UsuarioReq("Ana", "ana" + System.nanoTime() + "@teste.com"));
        var p = service.criarProjeto(new ProjetoReq("Projeto " + System.nanoTime(), "Teste", "BDD"));
        return new Long[]{u.id(), p.id()};
    }
    private Long historia(Long[] ids) {
        return service.criarHistoria(new HistoriaReq("História", "Analista", "cadastrar requisito", "organizar", Prioridade.MEDIA, ids[1], ids[0])).id();
    }

    @Test void rejeitaCenarioSemEntao() {
        Long[] ids = base(); Long h = historia(ids);
        var req = new CenarioReq("Cenário inválido", 1, OrigemCenario.HUMANO,
                List.of(new PassoReq(TipoPasso.DADO, "que estou no sistema", 1), new PassoReq(TipoPasso.QUANDO, "clico em salvar", 2)));
        assertThrows(IllegalArgumentException.class, () -> service.criarCenario(h, req, ids[0]));
    }

    @Test void rejeitaSugestaoSemMotivo() {
        Long[] ids = base(); Long h = historia(ids);
        Long sugestao = service.criarSugestao(h, new SugestaoReq("ChatGPT", "Revise", "Sugestão", ids[0])).id();
        assertThrows(IllegalArgumentException.class, () -> service.decidirSugestao(sugestao,
                new DecisaoReq(DecisaoSugestao.REJEITADA, null, "Não serve", ids[0])));
    }

    @Test void bloqueiaExportacaoComSugestaoPendente() {
        Long[] ids = base(); Long h = historia(ids);
        service.criarCenario(h, new CenarioReq("Cenário válido", 1, OrigemCenario.HUMANO,
                List.of(new PassoReq(TipoPasso.DADO, "que estou no sistema", 1), new PassoReq(TipoPasso.QUANDO, "clico em salvar", 2), new PassoReq(TipoPasso.ENTAO, "vejo confirmação", 3))), ids[0]);
        service.criarSugestao(h, new SugestaoReq("ChatGPT", "Revise", "Sugestão", ids[0]));
        assertThrows(IllegalArgumentException.class, () -> service.exportarFeature(h));
    }
}
