package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;
import br.com.caelum.financas.util.TipoMovimentacao;

public class TestaSalvaMovimentacaoComConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		Conta conta = new Conta();
		conta.setBanco("Bradesco");
		conta.setAgencia("2536");
		conta.setNumero("554488-2");
		conta.setTitular("João Andrade");
		
		manager.persist(conta);//Se não houver esse persist antes de persistir a conta ocorre a exceção
		
		Movimentacao mov = new Movimentacao();
		mov.setConta(conta);
		mov.setDescricao("Teste para ver a exceção de persistir sem ter a conta");
		mov.setValor(new BigDecimal(258.69));
		mov.setTipoMovimentacao(TipoMovimentacao.saida);
		
		manager.persist(mov);
		
		manager.getTransaction().commit();
		manager.close();
	}

}
