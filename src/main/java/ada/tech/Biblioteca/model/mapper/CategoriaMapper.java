package ada.tech.Biblioteca.model.mapper;

import ada.tech.Biblioteca.model.dto.CategoriaDTO;
import ada.tech.Biblioteca.model.entity.CategoriaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaMapper {

    public CategoriaDTO update(CategoriaEntity categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNome(categoria.getNome());
        categoriaDTO.setDescricao(categoria.getDescricao());
        return categoriaDTO;
    }

    public CategoriaEntity update(CategoriaDTO categoria) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNome(categoria.getNome());
        categoriaEntity.setDescricao(categoria.getDescricao());
        return categoriaEntity;
    }

    public List<CategoriaEntity> updateListEntity(List<CategoriaDTO> listaDTO) {
        return listaDTO.stream().map(categoriaDTO -> this.update(categoriaDTO)).toList();
    }

    public List<CategoriaDTO> updateListDTO(List<CategoriaEntity> listaEntity) {
        return listaEntity.stream().map(categoriaEntity -> this.update(categoriaEntity)).toList();
    }
}
