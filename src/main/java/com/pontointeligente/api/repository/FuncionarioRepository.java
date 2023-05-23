package com.pontointeligente.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.pontointeligente.api.administrativo.entidade.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	@Transactional(readOnly = true)
	Funcionario findByCpf(String cpf);
	
	@Transactional(readOnly = true)
	Funcionario findByEmail(String email);
	
	@Transactional(readOnly = true)
	Funcionario findByCpfOrEmail(String cpf, String email);
	
	@Transactional(readOnly = true)
	Funcionario findByCode(UUID code);
	
}
