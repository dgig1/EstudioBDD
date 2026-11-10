package br.com.estudiobdd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projetos", uniqueConstraints = {
        @UniqueConstraint(name = "uk_projeto_nome", columnNames = "nome")
})
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true, length = 150)
    private String nome;

    @Column(length = 1000)
    private String descricao;

    @Column(name = "contexto_dominio", columnDefinition = "TEXT")
    private String contextoDominio;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id ASC")
    private List<HistoriaUsuario> historias = new ArrayList<>();

    protected Projeto() {}

    public Projeto(String nome, String descricao, String contextoDominio) {
        this.nome = nome;
        this.descricao = descricao;
        this.contextoDominio = contextoDominio;
    }

    @PrePersist
    void aoCriar() {
        if (dataCriacao == null) dataCriacao = LocalDateTime.now();
    }

    public void adicionarHistoria(HistoriaUsuario historia) {
        historias.add(historia);
        historia.setProjeto(this);
    }

    public void removerHistoria(HistoriaUsuario historia) {
        historias.remove(historia);
        historia.setProjeto(null);
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getContextoDominio() { return contextoDominio; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public List<HistoriaUsuario> getHistorias() { return historias; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setContextoDominio(String contextoDominio) { this.contextoDominio = contextoDominio; }
}
