package com.pontointeligente.api.utils;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtilsTest {

	
	private static final String SENHA = "1234";
	private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
	
	
	
	@Test
	public void teestSenhaNull() {
		assertNull(PasswordUtil.gerarBCrypt(null));
	}
	
	@Test
	public void testGerarHashSenha() {
		
		String hash = PasswordUtil.gerarBCrypt(SENHA);
		assertTrue(bCryptEncoder.matches(SENHA, hash));
		
	}
	
}
