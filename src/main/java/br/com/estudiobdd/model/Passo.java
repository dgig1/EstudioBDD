package br.com.estudiobdd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "passos", uniqueConstraints = {
        @UniqueConstraint(name = "uk_passo_posicao_cenario", columnNames = {"cenario_id", "posicao"})
})
public class Passo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TipoPasso tipo;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String texto;

    @Column(nullable = false)
    private Integer posicao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cenario_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_passo_cenario"))
    private Cenario cenario;

    protected Passo() {}

    public Passo(TipoPasso tipo, String texto, Integer posicao) {
        this.tipo = tipo;
        this.texto = texto;
        this.posicao = posicao;
    }

    public Long getId() { return id; }
    public TipoPasso getTipo() { return tipo; }
    public String getTexto() { return texto; }
    public Integer getPosicao() { return posicao; }
    public Cenario getCenario() { return cenario; }
    public void setTipo(TipoPasso tipo) { this.tipo = tipo; }
    public void setTexto(String texto) { this.texto = texto; }
    public void setPosicao(Integer posicao) { this.posicao = posicao; }
    public void setCenario(Cenario cenario) { this.cenario = cenario; }
}
