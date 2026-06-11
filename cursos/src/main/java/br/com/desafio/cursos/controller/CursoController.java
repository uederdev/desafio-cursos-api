package br.com.desafio.cursos.controller;

import br.com.desafio.cursos.dto.CursoCreate;
import br.com.desafio.cursos.dto.DadosCurso;
import br.com.desafio.cursos.service.CursoService;
import br.com.desafio.cursos.util.Utils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/apis/v1/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DadosCurso> create(@Valid @RequestBody CursoCreate model){
        DadosCurso newCurso = service.create(model);
        URI uri = Utils.getURI("/apis/v1/cursos/{id}",newCurso.id());
        return ResponseEntity.created(uri).body(newCurso);
    }

    @GetMapping
    public ResponseEntity<List<DadosCurso>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
}
