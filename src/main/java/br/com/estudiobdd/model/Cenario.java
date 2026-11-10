package br.com.estudiobdd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cenarios", uniqueConstraints = {
        @UniqueConstraint(name = "uk_cenario_titulo_historia", columnNames = {"historia_id", "titulo"})
})
public class Cenario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 180)
    private String titulo;

    @Column(nullable = false)
    private Integer posicao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrigemCenario origem = OrigemCenario.HUMANO;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "historia_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_cenario_historia"))
    private HistoriaUsuario historia;

    @OneToMany(mappedBy = "cenario", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("posicao ASC")
    private List<Passo> passos = new ArrayList<>();

    protected Cenario() {}

    public Cenario(String titulo, Integer posicao, OrigemCenario origem) {
        this.titulo = titulo;
        this.posicao = posicao;
        this.origem = origem == null ? OrigemCenario.HUMANO : origem;
    }

    public void adicionarPasso(Passo passo) {
        passos.add(passo);
        passo.setCenario(this);
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public Integer getPosicao() { return posicao; }
    public OrigemCenario getOrigem() { return origem; }
    public HistoriaUsuario getHistoria() { return historia; }
    public List<Passo> getPassos() { return passos; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setPosicao(Integer posicao) { this.posicao = posicao; }
    public void setOrigem(OrigemCenario origem) { this.origem = origem; }
    public void setHistoria(HistoriaUsuario historia) { this.historia = historia; }
}
