package com.pontointeligente.api.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontointeligente.api.administrativo.entidade.Empresa;
import com.pontointeligente.api.repository.EmpresaRepository;
import com.pontointeligente.api.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		
		log.info("Buscando empresa pelo CNPJ {}", cnpj);
		Empresa empresaLocalizada = this.empresaRepository.findByCnpj(cnpj);
		
		return Optional.ofNullable(empresaLocalizada);
	
	}

	@Override
	public Empresa salvar(Empresa empresa) {
	
		log.info("Salvando a empresa {}", empresa);
		return this.empresaRepository.save(empresa);
	
	}
	

}
