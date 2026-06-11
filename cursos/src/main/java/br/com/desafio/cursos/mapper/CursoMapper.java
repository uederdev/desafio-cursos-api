package br.com.desafio.cursos.mapper;

import br.com.desafio.cursos.dto.CursoCreate;
import br.com.desafio.cursos.dto.DadosCurso;
import br.com.desafio.cursos.model.CursoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    CursoModel toModel(CursoCreate dto);
    CursoModel toModel(DadosCurso dto);
    DadosCurso toDto(CursoModel model);

}
