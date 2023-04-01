package ada.tech.Biblioteca.controller;

import ada.tech.Biblioteca.model.dto.EditoraDTO;
import ada.tech.Biblioteca.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public ResponseEntity<List<EditoraDTO>> listar() {
        return ResponseEntity.ok(editoraService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditoraDTO> pegarUm(@PathVariable("id") Long id) {
        return ResponseEntity.ok(editoraService.pegarPorId(id));
    }

    @PostMapping
    public ResponseEntity<EditoraDTO> criar(@RequestBody EditoraDTO editoraDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(editoraService.criar(editoraDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditoraDTO> editar(@RequestBody EditoraDTO editoraDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(editoraService.editar(editoraDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id) {
        editoraService.deletar(id);

        return ResponseEntity.ok("Editora com id "+id+" removido com sucesso");
    }
}
