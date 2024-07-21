package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "acessorio")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio_seq")
    @SequenceGenerator(name = "acessorio_seq", sequenceName = "seq_acessorio", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "codigo_acessorio", length = 10, nullable = false, unique = true)
    private String codigoAcessorio;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "acessorios")
    private List<Carro> carros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoAcessorio() {
        return codigoAcessorio;
    }

    public void setCodigoAcessorio(String codigoAcessorio) {
        this.codigoAcessorio = codigoAcessorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
