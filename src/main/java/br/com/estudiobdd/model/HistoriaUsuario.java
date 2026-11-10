package br.com.estudiobdd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "historias_usuario", uniqueConstraints = {
        @UniqueConstraint(name = "uk_historia_titulo_projeto", columnNames = {"projeto_id", "titulo"})
})
public class HistoriaUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 180)
    private String titulo;

    @NotBlank
    @Column(nullable = false, length = 300)
    private String papel;

    @NotBlank
    @Column(nullable = false, length = 500)
    private String objetivo;

    @NotBlank
    @Column(nullable = false, length = 500)
    private String beneficio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Prioridade prioridade = Prioridade.MEDIA;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "projeto_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_historia_projeto"))
    private Projeto projeto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "autor_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_historia_autor"))
    private Usuario autor;

    @OneToMany(mappedBy = "historia", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("posicao ASC")
    private List<Cenario> cenarios = new ArrayList<>();

    @OneToMany(mappedBy = "historia", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("dataRegistro ASC")
    private List<Sugestao> sugestoes = new ArrayList<>();

    protected HistoriaUsuario() {}

    public HistoriaUsuario(String titulo, String papel, String objetivo, String beneficio,
                           Prioridade prioridade, Projeto projeto, Usuario autor) {
        this.titulo = titulo;
        this.papel = papel;
        this.objetivo = objetivo;
        this.beneficio = beneficio;
        this.prioridade = prioridade == null ? Prioridade.MEDIA : prioridade;
        this.projeto = projeto;
        this.autor = autor;
    }

    @PrePersist
    void aoCriar() {
        LocalDateTime agora = LocalDateTime.now();
        if (dataCriacao == null) dataCriacao = agora;
        dataAtualizacao = agora;
    }

    @PreUpdate
    void aoAtualizar() { dataAtualizacao = LocalDateTime.now(); }

    public void adicionarCenario(Cenario cenario) {
        cenarios.add(cenario);
        cenario.setHistoria(this);
    }

    public void adicionarSugestao(Sugestao sugestao) {
        sugestoes.add(sugestao);
        sugestao.setHistoria(this);
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getPapel() { return papel; }
    public String getObjetivo() { return objetivo; }
    public String getBeneficio() { return beneficio; }
    public Prioridade getPrioridade() { return prioridade; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public LocalDateTime getDataAtualizacao() { return dataAtualizacao; }
    public Projeto getProjeto() { return projeto; }
    public Usuario getAutor() { return autor; }
    public List<Cenario> getCenarios() { return cenarios; }
    public List<Sugestao> getSugestoes() { return sugestoes; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setPapel(String papel) { this.papel = papel; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
    public void setBeneficio(String beneficio) { this.beneficio = beneficio; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }
    public void setProjeto(Projeto projeto) { this.projeto = projeto; }
    public void setAutor(Usuario autor) { this.autor = autor; }
}
