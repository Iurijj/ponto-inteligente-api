package com.pontointeligente.api.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontointeligente.api.administrativo.entidade.Funcionario;
import com.pontointeligente.api.repository.FuncionarioRepository;
import com.pontointeligente.api.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	
	private static final Logger log = LoggerFactory.getLogger(Funcionario.class);
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	@Override
	public Funcionario salvar(Funcionario funcionario) {
		log.info("Salvando o funcionario {}", funcionario);
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf) {
		
		this.registrarLogConsultaFuncionario("CPF", cpf);
		
		Funcionario funcLocalizado = this.funcionarioRepository.findByCpf(cpf);
		return Optional.ofNullable(funcLocalizado);

	}
	
	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		
		this.registrarLogConsultaFuncionario("E-mail", email);
		
		Funcionario funcLocalizado = this.funcionarioRepository.findByEmail(email);
		return Optional.ofNullable(funcLocalizado);
		
	}

	@Override
	public Optional<Funcionario> buscarPorCodigo(UUID code) {
		
		this.registrarLogConsultaFuncionario("Código", code.toString());
		
		Funcionario funcLocalizado = this.funcionarioRepository.findByCode(code);
		return Optional.ofNullable(funcLocalizado);
		
	}
	
	private void registrarLogConsultaFuncionario(String nomeCampo, String valorCampo) {
		
		String msgLog = String.format("Buscando Funcionário pelo %s: %s", nomeCampo, valorCampo); 
		log.info(msgLog);
		
	}

	
}
