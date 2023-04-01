package ada.tech.Biblioteca.repository;

import ada.tech.Biblioteca.model.entity.EditoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<EditoraEntity, Long> {
}
