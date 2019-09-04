package model;

import java.util.ArrayList;

public class Palco implements Magazzino {
	private String nome;
	private ArrayList<Prodotto> prodottiImmagazzinati = new ArrayList<Prodotto>();
	
	public Palco(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Prodotto> getForniture() {
		return prodottiImmagazzinati;
	}

	public void setForniture(ArrayList<Prodotto> prodottiImmagazzinati) {
		this.prodottiImmagazzinati = prodottiImmagazzinati;
	}

	
	
}