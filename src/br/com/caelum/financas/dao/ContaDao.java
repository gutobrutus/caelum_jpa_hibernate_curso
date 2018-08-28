package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class ContaDao {
	private EntityManager manager;
	
	public ContaDao(EntityManager manager) {
		this.manager = manager;
	}
	public void salva(Conta conta) {
		this.manager.persist(conta);
	}
	public Conta busca(Integer id) {
		return this.manager.find(Conta.class, id);
	}
	public List<Conta> lista() {
		return this.manager
				.createQuery("select c from Conta c", Conta.class)
				.getResultList();
	}
	public void adiciona(Conta conta) {
		this.manager.persist(conta);
	}
	
	public void remove(Conta conta) {
		this.manager.remove(conta);
	} 
}
