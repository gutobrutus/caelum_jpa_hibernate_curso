package br.com.caelum.financas.financas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
		
		EntityManager manager = factory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Augusto Ribeiro");
		conta.setBanco("Caixa Econômica Federal");
		conta.setNumero("1236-8");
		conta.setAgencia("0998");
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		long fim = System.currentTimeMillis();
		System.out.println("Conta Gravada com sucesso, em: "+ (fim - inicio) + "ms");
	}

}
