package br.com.estudiobdd.config;

import br.com.estudiobdd.model.*;
import br.com.estudiobdd.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DadosIniciais {
    @Bean CommandLineRunner carregarDados(UsuarioRepository usuarios, ProjetoRepository projetos,
            HistoriaUsuarioRepository historias, CenarioRepository cenarios) {
        return args -> {
            if (usuarios.count() > 0 || projetos.count() > 0) return;
            Usuario usuario = usuarios.save(new Usuario("Ana Analista", "ana@estudiobdd.local"));
            Projeto projeto = projetos.save(new Projeto("Projeto Demonstração", "Projeto inicial do Estúdio BDD", "Sistema de documentação de requisitos e critérios de aceite."));
            HistoriaUsuario historia = historias.save(new HistoriaUsuario("Cadastrar uma história", "Analista de requisitos", "registrar uma história de usuário", "organizar os requisitos do projeto", Prioridade.ALTA, projeto, usuario));
            Cenario cenario = new Cenario("Cadastro com dados válidos", 1, OrigemCenario.HUMANO);
            cenario.adicionarPasso(new Passo(TipoPasso.DADO, "que estou na tela de histórias", 1));
            cenario.adicionarPasso(new Passo(TipoPasso.QUANDO, "preencho os campos obrigatórios e salvo", 2));
            cenario.adicionarPasso(new Passo(TipoPasso.ENTAO, "a história deve ser cadastrada", 3));
            historia.adicionarCenario(cenario);
            cenarios.save(cenario);
        };
    }
}
