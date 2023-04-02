package ada.tech.Biblioteca.model.dto;

import ada.tech.Biblioteca.model.entity.CategoriaEntity;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CategoriaDTO {
    private Long id;
    @NotBlank(message = "nome deve conter algum valor")
    @Size(max = 100, message = "tamanho máximo excedido")
    private String nome;
    private String descricao;

//    public CategoriaDTO update(CategoriaEntity categoria) {
//        this.id = categoria.getId();
//        this.nome = categoria.getNome();
//        this.descricao = categoria.getDescricao();
//        return this;
//    }


//    @NotNull - só restringe se for nulo
//    @NotEmpty - só restring se for nulo ou vazio - serve para coleções, listas, arrays
//    @NotBlank - restringe nulo, vazio ou só espaços
}

