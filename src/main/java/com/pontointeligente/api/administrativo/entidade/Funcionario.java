package com.pontointeligente.api.administrativo.entidade;

import java.math.BigDecimal;
import java.util.UUID;

import com.pontointeligente.api.administrativo.enumerador.TipoPerfil;
import com.pontointeligente.api.common.entidade.AbstractEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
public class Funcionario extends AbstractEntity {

	
	private static final long serialVersionUID = 1L;

	
	@Id @Column(name = "id")
	@SequenceGenerator(name = "seq_funcionario", allocationSize = 1, sequenceName = "seq_funcionario")
	@GeneratedValue(generator = "seq_funcionario", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "code", unique = true)
	private UUID code;
	
	@Column(name = "nome")
	@Size(min = 2, max = 120, message = "nome: deve possuir no mínimo {min} e no máximo {max} caracteres")
	private String nome;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "cpf", unique = true)
	@Size(min = 11, message = "cpf: deve possuir {min} caracteres")
	private String cpf;

	@Column(name = "valorhora")
	private BigDecimal valorHora;

	@Column(name = "horasjornadadiaria")
	private Double horasJornadaDiaria;

	@Column(name = "horasintervalodiaria")
	private Double horasIntervaloDiaria;

	@Column(name = "tipoperfil")
	private Integer tipoPerfil;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	
	public Funcionario() {}
	
	public Funcionario(TipoPerfil perfil) {
		
		this();
		this.setTipoPerfil(perfil);

	}
	
	@Override
	@PrePersist
	public void prePersist() {
		super.generateUUID();
	}
	

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public UUID getCode() {
		return this.code;
	}

	@Override
	protected void setCode(UUID code) {
		this.code = code;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Double getHorasJornadaDiaria() {
		return horasJornadaDiaria;
	}

	public void setHorasJornadaDiaria(Double horasJornadaDiaria) {
		this.horasJornadaDiaria = horasJornadaDiaria;
	}

	public Double getHorasIntervaloDiaria() {
		return horasIntervaloDiaria;
	}

	public void setHorasIntervaloDiaria(Double horasIntervaloDiaria) {
		this.horasIntervaloDiaria = horasIntervaloDiaria;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public TipoPerfil getTipoPerfil() {
		return TipoPerfil.valueOf(tipoPerfil);
	}
	
	public void setTipoPerfil(TipoPerfil tipoPerfil) {
		this.tipoPerfil = ((tipoPerfil != null)? tipoPerfil.getTipo() : null);
	}
	
	@Override
	public String getDescricaoEntity() {
		return "Funcionário";
	}
	
	
}
