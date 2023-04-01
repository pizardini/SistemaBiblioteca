package ada.tech.Biblioteca.service;

import ada.tech.Biblioteca.model.dto.LivroDTO;
import ada.tech.Biblioteca.model.entity.LivroEntity;
import ada.tech.Biblioteca.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public LivroDTO pegarPorId(Long id) {
        Optional<LivroEntity> livroEntityOp = repository.findById(id);

        if(livroEntityOp.isPresent()) {
            LivroEntity livroEntity = livroEntityOp.get();
            return new LivroDTO().update(livroEntity);
        }

        throw new EntityNotFoundException("Livro não encontrado");
    }

    public LivroDTO criar(LivroDTO livroDTO) {
        LivroEntity livro = new LivroEntity().update(livroDTO);
        livro = repository.save(livro);

        return new LivroDTO().update(livro);
    }

    public LivroDTO editar(LivroDTO livroDTO, Long id) {
        if(repository.existsById(id)) {
            LivroEntity livroEntity = new LivroEntity().update(livroDTO);
            livroEntity.setId(id);
            livroEntity = repository.save(livroEntity);

            return new LivroDTO().update(livroEntity);
        }

        throw new EntityNotFoundException("Livro não encontrado");
    }

    public void deletar(Long id) {
        Optional<LivroEntity> livroEntityOp = repository.findById(id);

        if(livroEntityOp.isPresent()) {
            LivroEntity livroEntity = livroEntityOp.get();
            repository.delete(livroEntity);
            return;
        }

        throw new EntityNotFoundException("Livro não encontrado");
    }

    public List<LivroDTO> listar() {
        List<LivroEntity> listaEntities = repository.findAll();
        return listaEntities.stream().map(livroEntity -> new LivroDTO().update(livroEntity)).toList();
    }
}
