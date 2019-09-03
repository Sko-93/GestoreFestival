package model;

import java.util.ArrayList;

public class BevandaSpecifica implements Prodotto {

	private String nome;
	private ArrayList<String> puntiVendita= new ArrayList<String>();
	private int quantita;
	private double prezzo;

	public BevandaSpecifica(String nome, String puntoVendita, int quantita, double prezzo) {
		this.nome = nome;
		puntiVendita.add(puntoVendita);
		this.quantita = quantita;
		this.prezzo = prezzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getPuntiVendita() {
		return puntiVendita;
	}

	public void setPuntoVendita(ArrayList<String> puntiVendita) {
		this.puntiVendita = puntiVendita;
	}

	//se il primo elemento dell'ArrayList è la stringa vuota viene sostituita altrimenti viene inserito il nuovo punto vendita	
	public void aggiungiPuntoVendita(String nuovoPunto) {
		if(puntiVendita.get(0)=="")
			puntiVendita.set(0, nuovoPunto);
		else
			puntiVendita.add(nuovoPunto);
	}

	public String toString() {
		String prodottoStringa= this.nome+ " ";
		for(int i=0; i<puntiVendita.size(); i++) 
			prodottoStringa+= puntiVendita.get(i)+ " "+ this.quantita+ " "+ this.prezzo;
		return prodottoStringa;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita= quantita;
	}

}
