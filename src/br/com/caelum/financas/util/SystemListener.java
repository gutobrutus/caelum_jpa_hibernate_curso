package br.com.caelum.financas.util;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.caelum.financas.modelo.Movimentacao;

public class SystemListener {
	Movimentacao movimentacao;
	
	@PrePersist
	public void prePersist(Object entidade) {
		System.out.println("Avisa o financeiro que existe uma nova movimentação...");
	}
}
