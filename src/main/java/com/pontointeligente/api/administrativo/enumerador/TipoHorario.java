package com.pontointeligente.api.administrativo.enumerador;

public enum TipoHorario {

	
	INICIO_JORNADA(1, "Início Jornada"),
	FIM_JORNADA(2, "Fim Jornada"),
	INICIO_INTERVALO(3, "Início Intervalo"),
	FIM_INTERVALO(4, "Fim Intervalo"),
	INICIO_PAUSA(5, "Início Pausa"),
	FIM_PAUSA(6, "Fim Pausa");
	
	
	private Integer tipo;
	private String descricao;

	
	private TipoHorario(Integer tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	
	public Integer getTipo() {
		return tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
	public static TipoHorario valueOf(Integer tipo) {
		
		if(tipo == null) {
			return null;
		}
		
		for (TipoHorario tipoHorario : TipoHorario.values()) {
			
			if(tipoHorario.getTipo().equals(tipo)) {
				return tipoHorario;
			}
			
		}
		
		throw new IllegalArgumentException(String.format("Nenhum tipo equivalente com o valor: %s", tipo));
		
	}
	
}
