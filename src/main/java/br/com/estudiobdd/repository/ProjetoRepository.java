package br.com.estudiobdd.repository;

import br.com.estudiobdd.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    boolean existsByNome(String nome);
}
