package ada.tech.Biblioteca.repository;

import ada.tech.Biblioteca.model.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

//    List<CategoriaEntity> findByNome (String nome); //notação que o spring entende sem comportamento, por causa do nome
}
