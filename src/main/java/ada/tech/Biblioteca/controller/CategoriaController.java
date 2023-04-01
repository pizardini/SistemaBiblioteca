package ada.tech.Biblioteca.controller;

import ada.tech.Biblioteca.model.dto.CategoriaDTO;
import ada.tech.Biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


//    @GetMapping
//    public List<CategoriaDTO> listar(){
//        return categoriaService.listar();
//    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listar() {
        return ResponseEntity.ok(categoriaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> pegarUm(@PathVariable("id") Long id){
        return ResponseEntity.ok(categoriaService.pegarPorId(id));
    }

//    @PostMapping
//    public CategoriaDTO criar(@RequestBody CategoriaDTO categoriaDTO) {
//        return categoriaService.criar(categoriaDTO);
//    }
    @PostMapping
    public ResponseEntity<CategoriaDTO> criar(@RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.criar(categoriaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> editar(
            @RequestBody CategoriaDTO categoriaDTO,
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(categoriaService.editar(categoriaDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id) {
        categoriaService.deletar(id);

        return ResponseEntity.ok("Categoria com id "+id+" removido com sucesso!");
    }
}

