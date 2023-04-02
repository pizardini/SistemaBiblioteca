package ada.tech.Biblioteca.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="livro")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nome", nullable = false, unique = true)
    private String nome;

    @Column(name="isbn", nullable = false, unique = true, length = 13)
    private String isbn;

//    private Long editora_id;
    @ManyToOne
    @JoinColumn(name="editora")
    private EditoraEntity editora;

//    private Long categoria_id;
    @ManyToOne
    @JoinColumn(name="categoria")
    private CategoriaEntity categoria;

//    public LivroEntity update(LivroDTO livro) {
//        this.id = livro.getId();
//        this.nome = livro.getNome();
//        this.isbn = livro.getIsbn();
//        return this;
//    }
}
