package ada.tech.Biblioteca.controller;

import ada.tech.Biblioteca.model.dto.LivroDTO;
import ada.tech.Biblioteca.service.EditoraService;
import ada.tech.Biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listar() {
        return ResponseEntity.ok(livroService.listar());
    }

    @GetMapping("/id")
    public ResponseEntity<LivroDTO> pegarUm(@PathVariable("id") Long id) {
        return ResponseEntity.ok(livroService.pegarPorId(id));
    }

    @PostMapping
    public ResponseEntity<LivroDTO> criar(@RequestBody LivroDTO livroDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.criar(livroDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> editar(@RequestBody LivroDTO livroDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(livroService.editar(livroDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id) {
        livroService.deletar(id);

        return ResponseEntity.ok("Livro com id "+id+" removido com sucesso");
    }
}
