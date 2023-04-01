package ada.tech.Biblioteca.model.entity;


import ada.tech.Biblioteca.model.dto.CategoriaDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incremento de id
    private Long id;
    @Column (name="nome", nullable = false, unique = true, length = 100)
    private String nome;

    @Column (name="descrição")
    private String descricao;

    public CategoriaEntity update(CategoriaDTO categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
        return this;
    }
}
