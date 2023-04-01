package ada.tech.Biblioteca.controller;

import ada.tech.Biblioteca.model.dto.CategoriaDTO;
import ada.tech.Biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping
    public List<CategoriaDTO> listar(){
        return categoriaService.listar();
    }

    @GetMapping("/{id}")
    public CategoriaDTO pegarUm(@PathVariable("id") Long id){
        return categoriaService.pegarPorId(id);
    }

    @PostMapping
    public CategoriaDTO criar(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.criar(categoriaDTO);
    }

    @PutMapping("/{id}")
    public CategoriaDTO editar(
            @RequestBody CategoriaDTO categoriaDTO,
            @PathVariable("id") Long id) {

        return categoriaService.editar(categoriaDTO, id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable("id") Long id) {
        categoriaService.deletar(id);

        return "Categoria com id "+id+" removido com sucesso!";
    }
}

