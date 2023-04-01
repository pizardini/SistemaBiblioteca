package ada.tech.Biblioteca.controller;

import ada.tech.Biblioteca.model.dto.LivroDTO;
import ada.tech.Biblioteca.service.EditoraService;
import ada.tech.Biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<LivroDTO> listar() {
        return livroService.listar();
    }

    @GetMapping("/id")
    public LivroDTO pegarUm(@PathVariable("id") Long id) {
        return livroService.pegarPorId(id);
    }

    @PostMapping
    public LivroDTO criar(@RequestBody LivroDTO livroDTO) {
        return livroService.criar(livroDTO);
    }

    @PutMapping("/{id}")
    public LivroDTO editar(@RequestBody LivroDTO livroDTO, @PathVariable("id") Long id) {
        return livroService.editar(livroDTO, id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable("id") Long id) {
        livroService.deletar(id);

        return "Livro com id "+id+" removido com sucesso";
    }
}
