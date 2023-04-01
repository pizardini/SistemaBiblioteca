package ada.tech.Biblioteca.controller;

import ada.tech.Biblioteca.model.dto.EditoraDTO;
import ada.tech.Biblioteca.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public List<EditoraDTO> listar() {
        return editoraService.listar();
    }

    @GetMapping("/{id}")
    public EditoraDTO pegarUm(@PathVariable("id") Long id) {
        return editoraService.pegarPorId(id);
    }

    @PostMapping
    public EditoraDTO criar(@RequestBody EditoraDTO editoraDTO) {
        return editoraService.criar(editoraDTO);
    }

    @PutMapping("/{id}")
    public EditoraDTO editar(@RequestBody EditoraDTO editoraDTO, @PathVariable("id") Long id) {
        return editoraService.editar(editoraDTO, id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable("id") Long id) {
        editoraService.deletar(id);

        return "Editora com id "+id+" removido com sucesso";
    }
}
