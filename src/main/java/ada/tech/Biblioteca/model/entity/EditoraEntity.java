package ada.tech.Biblioteca.model.entity;

import ada.tech.Biblioteca.model.dto.CategoriaDTO;
import ada.tech.Biblioteca.model.dto.EditoraDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="editora")
public class EditoraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incremento de id
    private Long id;
    @Column(name="nome", nullable = false, unique = true, length = 255)
    private String nome;

    @Column(name="descricao")
    private String descricao;

    public EditoraEntity update(EditoraDTO editora) {
        this.id = editora.getId();
        this.nome = editora.getNome();
        this.descricao = editora.getDescricao();
        return this;
    }
}
