package ada.tech.Biblioteca.model.entity;

import ada.tech.Biblioteca.model.dto.CategoriaDTO;
import ada.tech.Biblioteca.model.dto.LivroDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="livro")
public class LivroEntity {

    @Id
    private Long id;
    @Column(name="nome", nullable = false, unique = true)
    private String nome;

    @Column(name="isbn", nullable = false, unique = true, length = 13)
    private String isbn;

    private Long editora_id;
    private Long categoria_id;

    public LivroEntity update(LivroDTO livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.isbn = livro.getIsbn();
        return this;
    }
}
