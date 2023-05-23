package com.pontointeligente.api.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pontointeligente.api.administrativo.entidade.LancamentoHorario;
import com.pontointeligente.api.repository.LancamentoHorarioRepository;
import com.pontointeligente.api.service.LancamentoService;
import com.pontointeligente.api.utils.MensagemUtil;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	
	private static final Logger log = LoggerFactory.getLogger(LancamentoHorario.class);
	
	
	@Autowired
	private LancamentoHorarioRepository lancamentoHorarioRepository;
	
	
	@Override
	public Page<LancamentoHorario> buscarPorFuncionario(UUID code, PageRequest pageRequest) {
		
		String msgLog = String.format(MensagemUtil.TEMPLATE_MSG_LOG_BUSCA, "lançamento", "codigo", code);
		log.info(msgLog);
		
		return this.lancamentoHorarioRepository.findByFuncionarioId(code, pageRequest);
		
	}

	@Override
	public Optional<LancamentoHorario> buscarPorCodigo(UUID code) {
		
		String msgLog = String.format(MensagemUtil.TEMPLATE_MSG_LOG_BUSCA, "lançamento", "codigo", code);
		log.info(msgLog);
		
		LancamentoHorario lancamentoHorario = this.lancamentoHorarioRepository.findByCode(code);
		return Optional.ofNullable(lancamentoHorario);
		
	}

	@Override
	public LancamentoHorario salvar(LancamentoHorario lancamentoHorario) {
		
		String infoFuncMSgLog = String.format("lançamento: ", lancamentoHorario);
		String msgLog = String.format(MensagemUtil.TEMPLATE_MSG_LOG_SALVAR, infoFuncMSgLog);
		
		log.info(msgLog);
		
		return this.lancamentoHorarioRepository.save(lancamentoHorario);
	
	}

	@Override
	public void remover(UUID code) {
		
		Optional<LancamentoHorario> lctoLocalizado = this.buscarPorCodigo(code);
		
		if(lctoLocalizado.isPresent()) {
			this.removerLancamento(lctoLocalizado.get());
		}
				
	}

	private void removerLancamento(LancamentoHorario lctoLocalizado) {
	
		String infoFuncMSgLog = String.format("lançamento: ", lctoLocalizado);
		String msgLog = String.format(MensagemUtil.TEMPLATE_MSG_LOG_REMOVER, infoFuncMSgLog);
		
		log.info(msgLog);

		this.lancamentoHorarioRepository.delete(lctoLocalizado);
	
	}

}
