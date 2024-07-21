package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "seq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "codigo_carro", length = 10, nullable = false, unique = true)
    private String codigoCarro;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(
            name = "id_marca_fk",
            foreignKey = @ForeignKey(name = "fk_carro_marca"),
            referencedColumnName = "id",
            nullable = false
    )
    private Marca marca;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="carro_acessorio",
            joinColumns= {@JoinColumn(name="carro_id")},
            inverseJoinColumns= {@JoinColumn(name="acessorio_id")})
    private List<Acessorio> acessorios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoCarro() {
        return codigoCarro;
    }

    public void setCodigoCarro(String codigoCarro) {
        this.codigoCarro = codigoCarro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
}
