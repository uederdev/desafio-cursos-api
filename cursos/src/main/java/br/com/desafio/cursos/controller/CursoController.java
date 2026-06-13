package br.com.desafio.cursos.controller;

import br.com.desafio.cursos.dto.CursoCreate;
import br.com.desafio.cursos.dto.CursoUpdate;
import br.com.desafio.cursos.dto.DadosCurso;
import br.com.desafio.cursos.service.CursoService;
import br.com.desafio.cursos.util.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/apis/v1/cursos")
@Tag( name = "Cursos", description = "Endpoints para gerenciar cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(
            summary = "Cria um novo curso",
            description = "Endpoint responsável pela criação de um novo curso",
            tags = {"Cursos"}
    )
    public ResponseEntity<DadosCurso> create(@Valid @RequestBody CursoCreate model){
        DadosCurso newCurso = service.create(model);
        URI uri = Utils.getURI("/apis/v1/cursos/{id}",newCurso.id());
        return ResponseEntity.created(uri).body(newCurso);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Edita um curso existente",
            description = "Endpoint responsável pela atualização do curso",
            tags = {"Cursos"}
    )
    public ResponseEntity<DadosCurso> update(@PathVariable("id") UUID id, @Valid @RequestBody CursoUpdate model){
        DadosCurso curso = service.update(id, model);
        return ResponseEntity.ok().body(curso);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Exclui um curso existente",
            description = "Endpoint responsável pela exclusão do curso selecionado",
            tags = {"Cursos"}
    )
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/active")
    @Operation(
            summary = "Ativa ou desativa um curso",
            description = "Endpoint responsável pela ativação/desativação de um curso",
            tags = {"Cursos"}
    )
    public ResponseEntity<DadosCurso> setEnable(@PathVariable("id") UUID id){
        DadosCurso curso = service.setEnable(id);
        return ResponseEntity.ok().body(curso);
    }

    @GetMapping
    @Operation(
            summary = "Exibe uma lista de cursos",
            description = "Endpoint responsável pela listagem de todos os cursos cadastrados",
            tags = {"Cursos"}
    )
    public ResponseEntity<List<DadosCurso>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category){
        return ResponseEntity.ok().body(service.findAll(name, category));
    }

}
