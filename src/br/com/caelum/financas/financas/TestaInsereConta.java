package br.com.caelum.financas.financas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Maria Clara Ribeiro");
		conta.setBanco("Caixa Econômica Federal");
		conta.setNumero("1536-7");
		conta.setAgencia("14362");
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
		long fim = System.currentTimeMillis();
		System.out.println("Conta Gravada com sucesso, em: "+ (fim - inicio) + "ms");
	}

}
