package com.pontointeligente.api.common.entidade;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "logentity")
public class LogEntity extends AbstractEntity {

	
	private static final long serialVersionUID = 1L;

	
	@Id @Column(name = "id")
	@SequenceGenerator(name = "seq_empresa", allocationSize = 1, sequenceName = "seq_empresa")
	@GeneratedValue(generator = "seq_empresa", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "code", unique = true)
	private UUID code;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datacriacao", nullable = false)
	private Date dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataatualizacao", nullable = false)
	private Date dataAtualizacao;
	
	@Column(name = "identificadorentity")
	private String descricaoEntity;
	
	@Column(name = "nomeentity")
	private String nomeEntity;
	
	@Transient
	private AbstractEntity entity;
	
	
	public LogEntity() {
		this.descricaoEntity = "Entidade nao identificada";
		this.nomeEntity = "Entidade nao identificada";
	}
	
	public LogEntity(AbstractEntity entity) {
		
		this.entity = entity;
		
		this.descricaoEntity = entity.getDescricaoEntity();
		this.nomeEntity = entity.getClass().getName();
		
	}
	
	@Override
	@PrePersist
	public void prePersist() {
		
		super.generateUUID();
		
		if(this.entity.getId() == null) {
			
			this.setDataCriacao(new Date());
		
		}else {
			this.setDataAtualizacao(new Date());
		}
		
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
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String getDescricaoEntity() {
		return "";
	}

}
