package com.pontointeligente.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.pontointeligente.api.administrativo.entidade.LancamentoHorario;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@NamedQueries(
		@NamedQuery(name = LancamentoHorarioRepository.FIND_ALL_BY_FUNCIONARIO,
					query = "SELECT lh "
						  + "FROM LancamentoHorario lh "
						  + "WHERE lh.funcionario.id = :funcionarioId ")
)
public interface LancamentoHorarioRepository extends JpaRepository<LancamentoHorario, Long> {
	
	public static final String FIND_ALL_BY_FUNCIONARIO = "LancamentoHorarioRepository.findByFuncionarioId";
	
	@Transactional(readOnly = true)
	List<LancamentoHorario> findByFuncionarioId(@Param("funcionarioId") Integer funcionarioId);
	
	@Transactional(readOnly = true)
	List<LancamentoHorario> findByFuncionarioId(@Param("funcionarioId") Integer funcionarioId, 
												Pageable pageable);

}
