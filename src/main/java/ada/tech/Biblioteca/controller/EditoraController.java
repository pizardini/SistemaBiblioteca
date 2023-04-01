package ada.tech.Biblioteca.controller;

import ada.tech.Biblioteca.model.dto.EditoraDTO;
import ada.tech.Biblioteca.service.EditoraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
@Slf4j
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(editoraService.listar());
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> pegarUm(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(editoraService.pegarPorId(id));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody EditoraDTO editoraDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(editoraService.criar(editoraDTO));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(@RequestBody EditoraDTO editoraDTO, @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(editoraService.editar(editoraDTO, id));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id) {

        try {
            editoraService.deletar(id);
            return ResponseEntity.ok("Editora com id "+id+" removido com sucesso");
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
