package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;
import br.com.caelum.financas.util.TipoMovimentacao;

public class TestaInsereMovimentacao {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Movimentacao mov = new Movimentacao();
		mov.setDescricao("Teste");
		mov.setTipoMovimentacao(TipoMovimentacao.entrada);
		mov.setValor(new BigDecimal(250.00));
		
		manager.getTransaction().begin();
		manager.persist(mov);
		manager.getTransaction().commit();
		manager.close();
		
		
		
		

	}

}
