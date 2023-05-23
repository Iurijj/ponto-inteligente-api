package com.pontointeligente.api.administrativo.enumerador;

public enum TipoPerfil {
	
	
	ROLE_ADMIN(1, "Administrador"),
	ROLE_USUARIO(2, "Usuário");
	
	
	private Integer tipo;
	private String descricao;

	
	private TipoPerfil(Integer tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	
	public Integer getTipo() {
		return tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
	public static TipoPerfil valueOf(Integer tipo) {
		
		if(tipo == null) {
			return null;
		}
		
		for (TipoPerfil tipoPerfil : TipoPerfil.values()) {
			
			if(tipoPerfil.getTipo().equals(tipo)) {
				return tipoPerfil;
			}
			
		}
		
		throw new IllegalArgumentException(String.format("Nenhum tipo equivalente com o valor: %s", tipo));
		
	}

	
}
