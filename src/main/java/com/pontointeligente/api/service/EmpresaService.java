package com.pontointeligente.api.service;

import java.util.Optional;

import com.pontointeligente.api.administrativo.entidade.Empresa;

public interface EmpresaService {

	Optional<Empresa> buscarPorCnpj(String cnpj);
	
	Empresa salvar(Empresa empresa);
	
}
