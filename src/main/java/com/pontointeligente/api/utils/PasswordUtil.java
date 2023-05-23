package com.pontointeligente.api.utils;

import static com.pontointeligente.api.utils.StringUtil.isVazia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

	private static final Logger log = LoggerFactory.getLogger(PasswordUtil.class);
	
	public PasswordUtil() {}
	
	
	public static String gerarBCrypt(String senha) {
		
		if(isVazia(senha)) {
			return senha;
		}
		
		log.info("Gerando hash com Bcrypt");
		//TODO estudar como funciona
		BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
		
		return bcryptEncoder.encode(senha);
		
	}
	
	
}
