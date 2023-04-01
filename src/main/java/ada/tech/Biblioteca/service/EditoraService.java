package ada.tech.Biblioteca.service;

import ada.tech.Biblioteca.model.dto.CategoriaDTO;
import ada.tech.Biblioteca.model.dto.EditoraDTO;
import ada.tech.Biblioteca.model.entity.CategoriaEntity;
import ada.tech.Biblioteca.model.entity.EditoraEntity;
import ada.tech.Biblioteca.repository.CategoriaRepository;
import ada.tech.Biblioteca.repository.EditoraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository repository;

    public EditoraDTO pegarPorId(Long id) {
        Optional<EditoraEntity> editoraEntityOp = repository.findById(id);

        if(editoraEntityOp.isPresent()) {
            EditoraEntity editoraEntity = editoraEntityOp.get();
            return new EditoraDTO().update(editoraEntity);
        }

        throw new EntityNotFoundException();
    }

    public EditoraDTO criar(EditoraDTO editoraDTO) {
        EditoraEntity editora = new EditoraEntity().update(editoraDTO);
        editora = repository.save(editora);

        return new EditoraDTO().update(editora);
    }

    public EditoraDTO editar(EditoraDTO editoraDTO, Long id) {
        if (repository.existsById(id)) {
            EditoraEntity editoraEntity = new EditoraEntity().update(editoraDTO);
            editoraEntity.setId(id);
            editoraEntity = repository.save(editoraEntity);

            return new EditoraDTO().update(editoraEntity);
        }

        throw new EntityNotFoundException();
    }

    public void deletar(Long id) {
        Optional<EditoraEntity> editoraEntityOp = repository.findById(id);

        if(editoraEntityOp.isPresent()) {
            EditoraEntity editoraEntity = editoraEntityOp.get();
            repository.delete(editoraEntity);
            return;
        }

        throw new EntityNotFoundException();
    }

    public List<EditoraDTO> listar() {
        List<EditoraEntity> listaEntities = repository.findAll();
        return listaEntities.stream().map(editoraEntity -> new EditoraDTO().update(editoraEntity)).toList();
    }
}
