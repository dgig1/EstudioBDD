package br.com.estudiobdd.dto;

import jakarta.validation.constraints.*;
import br.com.estudiobdd.model.*;

public final class Requests { private Requests() {}
 public record UsuarioReq(@NotBlank String nome, @Email @NotBlank String email) {}
 public record ProjetoReq(@NotBlank String nome, String descricao, String contextoDominio) {}
 public record HistoriaReq(@NotBlank String titulo, @NotBlank String papel, @NotBlank String objetivo, @NotBlank String beneficio, Prioridade prioridade, @NotNull Long projetoId, @NotNull Long autorId) {}
 public record CenarioReq(@NotBlank String titulo, Integer posicao, OrigemCenario origem, @NotNull java.util.List<@jakarta.validation.Valid PassoReq> passos) {}
 public record PassoReq(@NotNull TipoPasso tipo, @NotBlank String texto, @NotNull Integer posicao) {}
 public record SugestaoReq(@NotBlank String ferramenta, @NotBlank String promptUtilizado, @NotBlank String conteudo, @NotNull Long usuarioId) {}
 public record DecisaoReq(@NotNull DecisaoSugestao decisao, MotivoRejeicao motivoRejeicao, String justificativa, @NotNull Long usuarioId) {}
}
