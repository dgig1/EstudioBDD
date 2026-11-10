package br.com.estudiobdd.repository;

import br.com.estudiobdd.model.Passo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PassoRepository extends JpaRepository<Passo, Long> {
    List<Passo> findByCenarioIdOrderByPosicaoAsc(Long cenarioId);
}
