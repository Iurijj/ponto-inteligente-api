package com.pontointeligente.api.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.pontointeligente.api.administrativo.entidade.LancamentoHorario;

public interface LancamentoService {

	Page<LancamentoHorario> buscarPorFuncionario(UUID code, PageRequest pageRequest);
	
	Optional<LancamentoHorario> buscarPorCodigo(UUID uuid);
	
	LancamentoHorario salvar(LancamentoHorario lancamentoHorario);
	
	void remover(UUID code);
	
}
