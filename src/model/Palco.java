package model;

import java.util.ArrayList;

public class Palco implements Magazzino {
	private String nome;
	private ArrayList<Prodotto> prodottiImmagazzinati = new ArrayList<Prodotto>();
	private ArrayList<Esibizione> listaEsibizioni = new ArrayList<Esibizione>();
	
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

	public ArrayList<Esibizione> getListaEsibizioni() {
		return listaEsibizioni;
	}

	public void setListaEsibizioni(ArrayList<Esibizione> listaEsibizioni) {
		this.listaEsibizioni = listaEsibizioni;
	}

	public ArrayList<Prodotto> getProdottiImmagazzinati() {
		return prodottiImmagazzinati;
	}

	public void setprodottiImmagazzinati(ArrayList<Prodotto> prodottiImmagazzinati) {
		this.prodottiImmagazzinati = prodottiImmagazzinati;
	}

	
}