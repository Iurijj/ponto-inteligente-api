package com.pontointeligente.api.service;

import java.util.Optional;
import java.util.UUID;

import com.pontointeligente.api.administrativo.entidade.Funcionario;

public interface FuncionarioService {

	Funcionario salvar(Funcionario funcionario);
	
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	Optional<Funcionario> buscarPorEmail(String email);
	
	Optional<Funcionario> buscarPorCodigo(UUID code);
	
}
