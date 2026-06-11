package br.com.desafio.cursos.repository;

import br.com.desafio.cursos.model.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, UUID> {
}
