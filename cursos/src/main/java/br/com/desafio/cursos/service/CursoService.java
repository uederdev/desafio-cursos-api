package br.com.desafio.cursos.service;

import br.com.desafio.cursos.dto.CursoCreate;
import br.com.desafio.cursos.dto.DadosCurso;
import br.com.desafio.cursos.mapper.CursoMapper;
import br.com.desafio.cursos.model.CursoModel;
import br.com.desafio.cursos.repository.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoService {

    private final CursoMapper mapper;
    private final CursoRepository cursoRepository;

    public CursoService(CursoMapper mapper, CursoRepository cursoRepository) {
        this.mapper = mapper;
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public DadosCurso create(@Valid CursoCreate dados) {
        CursoModel model = mapper.toModel(dados);
        model.active();
        CursoModel newCurso = cursoRepository.save(model);
        return mapper.toDto(newCurso);
    }

    public List<DadosCurso> findAll() {
        return cursoRepository.findAll().stream().map(mapper::toDto).toList();
    }
}
