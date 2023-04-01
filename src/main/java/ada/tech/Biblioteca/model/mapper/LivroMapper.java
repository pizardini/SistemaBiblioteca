package ada.tech.Biblioteca.model.mapper;

import ada.tech.Biblioteca.model.dto.LivroDTO;
import ada.tech.Biblioteca.model.entity.LivroEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivroMapper {
    private EditoraMapper editoraMapper = new EditoraMapper();
    private CategoriaMapper categoriaMapper = new CategoriaMapper();

    public LivroDTO update(LivroEntity livroEntity) {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livroEntity.getId());
        livroDTO.setNome(livroEntity.getNome());
        livroDTO.setIsbn(livroEntity.getIsbn());
        livroDTO.setEditora(editoraMapper.update(livroEntity.getEditoraEntity()));
        livroDTO.setCategoria(categoriaMapper.update(livroEntity.getCategoriaEntity()));
        return livroDTO;
    }

    public LivroEntity update(LivroDTO livroDTO) {
        LivroEntity livroEntity = new LivroEntity();
        livroEntity.setNome(livroDTO.getNome());
        livroEntity.setIsbn(livroDTO.getIsbn());
        livroEntity.setEditoraEntity(editoraMapper.update(livroDTO.getEditora()));
        livroEntity.setCategoriaEntity(categoriaMapper.update(livroDTO.getCategoria()));
        return livroEntity;
    }

    public List<LivroEntity> updateListEntity(List<LivroDTO> listaDTO) {
        return listaDTO.stream().map(livroDTO -> this.update(livroDTO)).toList();
    }

    public List<LivroDTO> updateListDTO(List<LivroEntity> listaEntity) {
        return listaEntity.stream().map(livroEntity -> this.update(livroEntity)).toList();
    }
}
