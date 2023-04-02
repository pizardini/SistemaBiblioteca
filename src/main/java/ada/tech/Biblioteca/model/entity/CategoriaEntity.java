package ada.tech.Biblioteca.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table (name="categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incremento de id
    private Long id;
    @Column (name="nome", nullable = false, unique = true, length = 100)
    private String nome;

    @Column (name="descrição")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<LivroEntity> listaLivros;

//    public CategoriaEntity update(CategoriaDTO categoria) {
//        this.id = categoria.getId();
//        this.nome = categoria.getNome();
//        this.descricao = categoria.getDescricao();
//        return this;
//    }
}
