package ada.tech.Biblioteca.model.dto;

import ada.tech.Biblioteca.model.entity.CategoriaEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {
    private Long id;
    private String nome;
    private String descricao;

//    public CategoriaDTO update(CategoriaEntity categoria) {
//        this.id = categoria.getId();
//        this.nome = categoria.getNome();
//        this.descricao = categoria.getDescricao();
//        return this;
//    }

}

