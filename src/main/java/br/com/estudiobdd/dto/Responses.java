package br.com.estudiobdd.dto;

import java.time.LocalDateTime;
import java.util.List;
import br.com.estudiobdd.model.*;

public final class Responses { private Responses() {}
 public record UsuarioRes(Long id,String nome,String email) {}
 public record ProjetoRes(Long id,String nome,String descricao,String contextoDominio,LocalDateTime dataCriacao,long quantidadeHistorias) {}
 public record PassoRes(Long id,TipoPasso tipo,String texto,Integer posicao) {}
 public record CenarioRes(Long id,String titulo,Integer posicao,OrigemCenario origem,List<PassoRes> passos) {}
 public record SugestaoRes(Long id,String ferramenta,String promptUtilizado,String conteudo,DecisaoSugestao decisao,MotivoRejeicao motivoRejeicao,String justificativa,LocalDateTime dataRegistro,LocalDateTime dataDecisao,Long registradaPorId,Long decididaPorId) {}
 public record HistoriaRes(Long id,String titulo,String papel,String objetivo,String beneficio,Prioridade prioridade,LocalDateTime dataCriacao,LocalDateTime dataAtualizacao,Long projetoId,String projetoNome,Long autorId,String autorNome,List<CenarioRes> cenarios,List<SugestaoRes> sugestoes) {}
}
