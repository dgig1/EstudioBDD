package br.com.estudiobdd.repository;

import br.com.estudiobdd.model.Cenario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CenarioRepository extends JpaRepository<Cenario, Long> {
    boolean existsByHistoriaIdAndTitulo(Long historiaId, String titulo);
    List<Cenario> findByHistoriaIdOrderByPosicaoAsc(Long historiaId);
}
