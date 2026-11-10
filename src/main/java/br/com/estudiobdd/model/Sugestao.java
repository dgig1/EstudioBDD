package br.com.estudiobdd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "sugestoes")
public class Sugestao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 120)
    private String ferramenta;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String promptUtilizado;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String conteudo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 12)
    private DecisaoSugestao decisao = DecisaoSugestao.PENDENTE;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private MotivoRejeicao motivoRejeicao;

    @Column(columnDefinition = "TEXT")
    private String justificativa;

    @Column(name = "data_registro", nullable = false, updatable = false)
    private LocalDateTime dataRegistro;

    @Column(name = "data_decisao")
    private LocalDateTime dataDecisao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "historia_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_sugestao_historia"))
    private HistoriaUsuario historia;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "registrada_por_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_sugestao_registrada_por"))
    private Usuario registradaPor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decidida_por_id",
            foreignKey = @ForeignKey(name = "fk_sugestao_decidida_por"))
    private Usuario decididaPor;

    protected Sugestao() {}

    public Sugestao(String ferramenta, String promptUtilizado, String conteudo,
                    HistoriaUsuario historia, Usuario registradaPor) {
        this.ferramenta = ferramenta;
        this.promptUtilizado = promptUtilizado;
        this.conteudo = conteudo;
        this.historia = historia;
        this.registradaPor = registradaPor;
    }

    @PrePersist
    void aoCriar() {
        if (dataRegistro == null) dataRegistro = LocalDateTime.now();
        if (decisao == null) decisao = DecisaoSugestao.PENDENTE;
    }

    public Long getId() { return id; }
    public String getFerramenta() { return ferramenta; }
    public String getPromptUtilizado() { return promptUtilizado; }
    public String getConteudo() { return conteudo; }
    public DecisaoSugestao getDecisao() { return decisao; }
    public MotivoRejeicao getMotivoRejeicao() { return motivoRejeicao; }
    public String getJustificativa() { return justificativa; }
    public LocalDateTime getDataRegistro() { return dataRegistro; }
    public LocalDateTime getDataDecisao() { return dataDecisao; }
    public HistoriaUsuario getHistoria() { return historia; }
    public Usuario getRegistradaPor() { return registradaPor; }
    public Usuario getDecididaPor() { return decididaPor; }
    public void setHistoria(HistoriaUsuario historia) { this.historia = historia; }
    public void decidir(DecisaoSugestao decisao, MotivoRejeicao motivo, String justificativa, Usuario usuario) {
        if (this.decisao != DecisaoSugestao.PENDENTE) throw new IllegalStateException("Sugestão já decidida.");
        if (decisao == DecisaoSugestao.REJEITADA && motivo == null) throw new IllegalArgumentException("Motivo obrigatório.");
        this.decisao = decisao; this.motivoRejeicao = motivo; this.justificativa = justificativa;
        this.decididaPor = usuario; this.dataDecisao = LocalDateTime.now();
    }
}
