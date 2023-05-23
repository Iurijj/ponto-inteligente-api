package com.pontointeligente.api.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.pontointeligente.api.administrativo.entidade.Empresa;
import com.pontointeligente.api.repository.EmpresaRepository;

@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceTest {

	@MockBean
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	private static final String CNPJ_VALIDO = "89525680000170";
	
	@BeforeAll
	public void setUp() throws Exception {
		BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
	}
	
	@Test
	public void testBuscarEmpresaPorCnpj() {
	
		Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(CNPJ_VALIDO);
	
		assertTrue(empresa.isPresent());
		
	}
	
	@Test
	public void testSalvarEmpresa() {
	
		Empresa empresa = this.empresaService.salvar(new Empresa());
		assertNotNull(empresa);
		
	}
	
	
}
