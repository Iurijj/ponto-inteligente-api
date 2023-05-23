package com.pontointeligente.api.administrativo.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.pontointeligente.api.common.entidade.AbstractEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empresa")
public class Empresa extends AbstractEntity {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id @Column(name = "id")
	@SequenceGenerator(name = "seq_empresa", allocationSize = 1, sequenceName = "seq_empresa")
	@GeneratedValue(generator = "seq_empresa", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "code", unique = true)
	private UUID code;
	
	@Column(name = "razaosocial")
	@Size(min = 2, max = 120, message = "razaoSocial: deve possuir no mínimo {min} e no máximo {max} caracteres")
	private String razaoSocial;
	
	@Column(name = "cnpj", unique = true)
	@NotBlank
	@Size(min = 14, message = "cnpj: deve possuir {min} caracteres")
	private String cnpj;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "datafundacao")
	private Date dataFundacao;
	
	@OneToMany(mappedBy = "empresa", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Funcionario> funcionarios;
	
	
	public Empresa() {
		this.funcionarios = new ArrayList<Funcionario>();
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

	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Date getDataFundacao() {
		return dataFundacao;
	}
	
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	@Override
	public String getDescricaoEntity() {
		return "Empresa";
	}
	
	
}
