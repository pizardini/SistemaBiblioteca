package ada.tech.Biblioteca.repository;

import ada.tech.Biblioteca.model.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
}
