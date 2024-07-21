package domain;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricula_seq")
    @SequenceGenerator(name = "matricula_seq", sequenceName = "seq_matricula", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "codigo", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "data")
    private Instant data;

    @Column(name = "valor")
    private Double valor;

    @ManyToOne
    @JoinColumn(
            name = "id_curso_fk",
            foreignKey = @ForeignKey(name = "fk_curso_matricula"),
            referencedColumnName = "id",
            nullable = false
    )
    private Curso curso;

    @OneToOne
    @JoinColumn(
            name = "id_aluno_fk",
            foreignKey = @ForeignKey(name = "fk_aluno_matricula"),
            referencedColumnName = "id",
            nullable = false
    )
    private Aluno aluno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
