package com.pontointeligente.api.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
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
						  + "WHERE lh.funcionario.code = :code ")
)
public interface LancamentoHorarioRepository extends JpaRepository<LancamentoHorario, Long> {
	
	public static final String FIND_ALL_BY_FUNCIONARIO = "lancamentohorariorepository.findByFuncionarioCode";
	
	LancamentoHorario findByCode(UUID code);
	
	@Transactional(readOnly = true)
	Page<LancamentoHorario> findByFuncionarioId(@Param("code") UUID code);
	
	@Transactional(readOnly = true)
	Page<LancamentoHorario> findByFuncionarioId(@Param("code")UUID code, Pageable pageable);

}
