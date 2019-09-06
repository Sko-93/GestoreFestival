package model;

import java.util.ArrayList;

public class Ufficio implements Magazzino {
	private String nome;
	private int numeroPersoneUfficio;
	
	public Ufficio(String nome, int numeroPersoneUfficio) {
		super();
		this.nome = nome;
		this.numeroPersoneUfficio = numeroPersoneUfficio;
	}

	public String getNome() {
		return null;
	}

	public void setNome(String nome) {
	}

	public ArrayList<Prodotto> getProdottiImmagazzinati() {
		return null;
	}

	public void setprodottiImmagazzinati(ArrayList<Prodotto> forniture) {
	}

}
