package ada.tech.Biblioteca.controller;

import ada.tech.Biblioteca.model.dto.CategoriaDTO;
import ada.tech.Biblioteca.model.dto.MensagemDTO;
import ada.tech.Biblioteca.service.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@Slf4j
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


//    @GetMapping
//    public List<CategoriaDTO> listar(){
//        return categoriaService.listar();
//    }

    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(categoriaService.listar());
        } catch (Exception e) {
            log.error(e.getMessage());
            //e.printStackTrace(); //log pra mostrar toda a cadeira de erro
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDTO(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> pegarUm(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(categoriaService.pegarPorId(id));
        }
        catch(EntityNotFoundException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MensagemDTO(e.getMessage()));
        }
        catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDTO(e.getMessage()));
        }
    }

//    @PostMapping
//    public CategoriaDTO criar(@RequestBody CategoriaDTO categoriaDTO) {
//        return categoriaService.criar(categoriaDTO);
//    }
    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.criar(categoriaDTO));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDTO(e.getMessage()));
        }



    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(@RequestBody @Valid CategoriaDTO categoriaDTO, @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(categoriaService.editar(categoriaDTO, id));
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MensagemDTO(e.getMessage()));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDTO(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable("id") Long id) {
        try {
            categoriaService.deletar(id);
            return ResponseEntity.ok(new MensagemDTO("Categoria com id "+id+" removido com sucesso!"));
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MensagemDTO(e.getMessage()));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDTO(e.getMessage()));
        }
    }
}

