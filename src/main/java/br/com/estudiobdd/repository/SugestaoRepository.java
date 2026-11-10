package br.com.estudiobdd.repository;

import br.com.estudiobdd.model.Sugestao;
import br.com.estudiobdd.model.DecisaoSugestao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {
    List<Sugestao> findByHistoriaIdOrderByDataRegistroAsc(Long historiaId);
    List<Sugestao> findByHistoriaIdAndDecisao(Long historiaId, DecisaoSugestao decisao);
    long countByHistoriaIdAndDecisao(Long historiaId, DecisaoSugestao decisao);
}
