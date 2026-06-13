package br.com.desafio.cursos.service;

import br.com.desafio.cursos.dto.CursoCreate;
import br.com.desafio.cursos.dto.CursoUpdate;
import br.com.desafio.cursos.dto.DadosCurso;
import br.com.desafio.cursos.entity.CursoModel;
import br.com.desafio.cursos.mapper.CursoMapper;
import br.com.desafio.cursos.repository.CursoRepository;
import br.com.desafio.cursos.util.Utils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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

    public List<DadosCurso> findAll(String name, String category) {
        if (name == null && category == null) {
            return cursoRepository.findAll().stream().map(mapper::toDto).toList();
        } else if (name == null) {
            return cursoRepository.findAllByCategory(category).stream().map(mapper::toDto).toList();
        } else if (category == null) {
            return cursoRepository.findAllByName(name).stream().map(mapper::toDto).toList();
        } else {
            return cursoRepository.findAllByNameAndCategory(name, category).stream().map(mapper::toDto).toList();
        }
    }

    public DadosCurso findById(UUID id) {
        CursoModel cursoModel = cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado!"));
        return mapper.toDto(cursoModel);
    }

    @Transactional
    public DadosCurso update(UUID id, @Valid CursoUpdate model) {
        DadosCurso dadosCurso = findById(id);
        CursoModel cursoModel = mapper.toModel(dadosCurso);
        Utils.copyNonFieldsNull(dadosCurso, cursoModel);
        Utils.copyNonFieldsNull(model, cursoModel);
        CursoModel cursoUpdate = cursoRepository.save(cursoModel);
        return mapper.toDto(cursoUpdate);
    }

    @Transactional
    public void delete(UUID id) {
        cursoRepository.deleteById(id);
    }

    @Transactional
    public DadosCurso setEnable(UUID id) {
        DadosCurso dadosCurso = findById(id);
        CursoModel cursoModel = mapper.toModel(dadosCurso);
        Boolean newStatus = dadosCurso.active() ? false : true;
        cursoModel.setActive(newStatus);
        CursoModel cursoUpdated = cursoRepository.save(cursoModel);
        return mapper.toDto(cursoUpdated);
    }

}
