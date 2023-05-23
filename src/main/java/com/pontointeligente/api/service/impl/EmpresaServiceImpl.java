package com.pontointeligente.api.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontointeligente.api.administrativo.entidade.Empresa;
import com.pontointeligente.api.repository.EmpresaRepository;
import com.pontointeligente.api.service.EmpresaService;
import com.pontointeligente.api.utils.MensagemUtil;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		
		String msgLog = String.format(MensagemUtil.TEMPLATE_MSG_LOG_BUSCA, "empresa", "CNPJ", cnpj);
		
		log.info(msgLog);
		Empresa empresaLocalizada = this.empresaRepository.findByCnpj(cnpj);
		
		return Optional.ofNullable(empresaLocalizada);
	
	}

	@Override
	public Empresa salvar(Empresa empresa) {
		
		String infoEmpresaMSgLog = String.format("empresa: ", empresa);
		String msgLog = String.format(MensagemUtil.TEMPLATE_MSG_LOG_SALVAR, infoEmpresaMSgLog);
		
		log.info(msgLog);
		
		return this.empresaRepository.save(empresa);
	
	}
	

}
