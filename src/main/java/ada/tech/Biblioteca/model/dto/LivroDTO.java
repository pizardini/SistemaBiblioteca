package ada.tech.Biblioteca.model.dto;

import ada.tech.Biblioteca.model.entity.CategoriaEntity;
import ada.tech.Biblioteca.model.entity.LivroEntity;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDTO {
    private Long id;
    private String nome;
    private EditoraDTO editora;
    private CategoriaDTO categoria;
    @Size(max = 13, message="isbn acima do limite")
    private String isbn;

//    public LivroDTO update(LivroEntity livro) {
//        this.id = livro.getId();
//        this.nome = livro.getNome();
//        this.isbn = livro.getIsbn();
//        return this;
//    }

}

