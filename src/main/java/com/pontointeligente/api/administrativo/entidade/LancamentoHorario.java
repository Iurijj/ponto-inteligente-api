package com.pontointeligente.api.administrativo.entidade;

import java.util.Date;
import java.util.UUID;

import com.pontointeligente.api.administrativo.enumerador.TipoHorario;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "lancamentohorario")
public class LancamentoHorario extends AbstractEntity {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id @Column(name = "id")
	@SequenceGenerator(name = "seq_lctohorario", allocationSize = 1, sequenceName = "seq_lctohorario")
	@GeneratedValue(generator = "seq_lctohorario", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "code", unique = true)
	private UUID code;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "localizacao")
	private String localizacao;
	
	@Column(name = "tipohorario")
	private Integer tipoHorario;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	
	public LancamentoHorario() {}
	
	public LancamentoHorario(Date data) {
		this.data = data;
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
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public TipoHorario getTipoHorario() {
		return TipoHorario.valueOf(tipoHorario);
	}
	
	public void setTipoHorario(TipoHorario tipoHorario) {
		this.tipoHorario = ((tipoHorario != null)? tipoHorario.getTipo() : null);
	}
	
	@Override
	public String getDescricaoEntity() {
		return "Lançamento Horário";
	}
	
	
}