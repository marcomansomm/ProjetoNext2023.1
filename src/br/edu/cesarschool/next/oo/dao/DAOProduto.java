package br.edu.cesarschool.next.oo.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.entidade.Produto;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class DAOProduto {
	private DAOGenerico daoGen = new DAOGenerico(Produto.class);
	//														

	public boolean incluir(Produto prod) {
		return daoGen.incluir(prod);
		/*
		Produto prodBusca = buscar(prod.getCodigo());
		if (prodBusca != null) {
			return false;
		} else {
			cadastro.incluir(prod, prod.getCodigo());
			return true;
		} 
		*/		
	}
	public boolean alterar(Produto prod) {
		return daoGen.alterar(prod);
		/* 
		Produto prodBusca = buscar(prod.getCodigo());
		if (prodBusca == null) {
			return false;
		} else {
			cadastro.alterar(prod, prod.getCodigo());
			return true;
		}	
		*/	
	}
	public Produto buscar(String codigo) {
		return (Produto)daoGen.buscar(codigo);
		/*
		return (Produto)cadastro.buscar(codigo); 
		*/
	}
	public Produto[] buscarTodos() {
		return (Produto[])daoGen.buscarTodos();
		/* 
		Serializable[] rets = cadastro.buscarTodos(Produto.class);
		Produto[] prods = new Produto[rets.length];
		for(int i=0; i<rets.length; i++) {
			prods[i] = (Produto)rets[i];
		}
		return prods;
		*/
	}
}
