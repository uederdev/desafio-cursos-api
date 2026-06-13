package br.com.desafio.cursos.repository;

import br.com.desafio.cursos.dto.DadosCurso;
import br.com.desafio.cursos.entity.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, UUID> {

    @Query("select c from CursoModel c where upper(c.name) like upper(concat('%', :name, '%')) and upper(c.category) like upper(concat('%', :category, '%')) ")
    List<CursoModel> findAllByNameAndCategory(String name, String category);

    @Query("select c from CursoModel c where upper(c.category) like upper(concat('%', :category, '%')) ")
    List<CursoModel> findAllByCategory(String category);

    @Query("select c from CursoModel c where upper(c.name) like upper(concat('%', :name, '%')) ")
    List<CursoModel> findAllByName(String name);
}
