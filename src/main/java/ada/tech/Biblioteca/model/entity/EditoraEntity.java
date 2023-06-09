package ada.tech.Biblioteca.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "editora")
    private List<LivroEntity> listaLivros;

//    public EditoraEntity update(EditoraDTO editora) {
//        this.id = editora.getId();
//        this.nome = editora.getNome();
//        this.descricao = editora.getDescricao();
//        return this;
//    }
}
