package br.com.estudiobdd.repository;

import br.com.estudiobdd.model.HistoriaUsuario;
import br.com.estudiobdd.model.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistoriaUsuarioRepository extends JpaRepository<HistoriaUsuario, Long> {
    boolean existsByProjetoIdAndTitulo(Long projetoId, String titulo);
    List<HistoriaUsuario> findByProjetoId(Long projetoId);
    List<HistoriaUsuario> findByProjetoIdAndPrioridade(Long projetoId, Prioridade prioridade);
    List<HistoriaUsuario> findByPrioridade(Prioridade prioridade);
}
