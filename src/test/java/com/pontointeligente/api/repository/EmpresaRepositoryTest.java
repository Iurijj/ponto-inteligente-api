package com.pontointeligente.api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.pontointeligente.api.administrativo.entidade.Empresa;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {
	
	
	private static final String CNPJ_VALIDO = "89525680000170";

	private EmpresaRepository empresaRepository;
	
	 @BeforeEach
    public void setUp() {
		 empresaRepository = mock(EmpresaRepository.class);
    }
	
	@BeforeEach
	public void cadastrar() throws Exception {
		
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa teste 1");
		empresa.setCnpj(CNPJ_VALIDO);
		empresa.setDataFundacao(new GregorianCalendar(2022, 0, 22).getTime());
	
		this.empresaRepository.save(empresa);
		
	}
	
	@AfterEach
	public void deletarTodos() {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarPorCnpj() {
		
		Empresa empresaByCnpj = this.empresaRepository.findByCnpj(CNPJ_VALIDO);
		
		assertNotEquals(empresaByCnpj, null);
		assertEquals(CNPJ_VALIDO, empresaByCnpj.getCnpj());
		
	}
	
}
