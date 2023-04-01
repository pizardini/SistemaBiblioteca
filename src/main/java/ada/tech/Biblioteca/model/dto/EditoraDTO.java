package ada.tech.Biblioteca.model.dto;

import ada.tech.Biblioteca.model.entity.CategoriaEntity;
import ada.tech.Biblioteca.model.entity.EditoraEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditoraDTO {
    private Long id;
    private String nome;
    private String descricao;

//    public EditoraDTO update(EditoraEntity editora) {
//        this.id = editora.getId();
//        this.nome = editora.getNome();
//        this.descricao = editora.getDescricao();
//        return this;
//    }

}

