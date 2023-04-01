package ada.tech.Biblioteca.model.mapper;

import ada.tech.Biblioteca.model.dto.LivroDTO;
import ada.tech.Biblioteca.model.entity.LivroEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivroMapper {

    public LivroDTO update(LivroEntity livro) {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setNome(livro.getNome());
        livroDTO.setIsbn(livro.getIsbn());
        return livroDTO;
    }

    public LivroEntity update(LivroDTO livro) {
        LivroEntity livroEntity = new LivroEntity();
        livroEntity.setNome(livro.getNome());
        livroEntity.setIsbn(livro.getIsbn());
        return livroEntity;
    }

    public List<LivroEntity> updateListEntity(List<LivroDTO> listaDTO) {
        return listaDTO.stream().map(livroDTO -> this.update(livroDTO)).toList();
    }

    public List<LivroDTO> updateListDTO(List<LivroEntity> listaEntity) {
        return listaEntity.stream().map(livroEntity -> this.update(livroEntity)).toList();
    }
}
