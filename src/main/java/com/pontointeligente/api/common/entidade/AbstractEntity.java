package com.pontointeligente.api.common.entidade;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class AbstractEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	public abstract Long getId();
	
	public abstract UUID getCode();
	protected abstract void setCode(UUID code);
	
	
	public abstract void prePersist();
	
	public abstract String getDescricaoEntity();
	
	protected void generateUUID() {
		
		if(this.getCode() == null) {
			this.setCode(UUID.randomUUID());
		}
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		AbstractEntity other = (AbstractEntity)obj;
		if(this.getId() == null || other.getId() == null) {
			return false;
		}
		
		return this.getId().equals(other.getId());
		
	}
	
	@Override
	public int hashCode() {
		
		if(this.getId() == null) {
			return super.hashCode();
		}
		
		final int literal1 = 17;
		final int literal2 = 37;
		
		return new HashCodeBuilder(literal1, literal2).append(this.getId()).toHashCode();
	
	}
	
	
}
