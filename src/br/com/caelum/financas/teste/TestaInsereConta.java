package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Augusto Silva Ribeiro");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("1648-5");
		conta.setAgencia("5230665-2");
		
		ContaDao dao = new ContaDao(manager);
		
		manager.getTransaction().begin();
		dao.salva(conta);
		manager.getTransaction().commit();
		manager.close();
		long fim = System.currentTimeMillis();
		System.out.println("Conta Gravada com sucesso, em: "+ (fim - inicio) + "ms");
	}

}
