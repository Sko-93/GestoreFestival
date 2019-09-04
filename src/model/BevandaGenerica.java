package model;

import java.util.ArrayList;

public class BevandaGenerica implements Prodotto {

	private String nome;
	private ArrayList<String> puntiVendita= new ArrayList<String>();

	//è possibile inserire una stringa vuota qualora non si conosca un punto vendita iniziale
	public BevandaGenerica(String nome, String puntoVendita) {
		this.nome = nome;
		puntiVendita.add(puntoVendita);
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
			prodottoStringa+= puntiVendita.get(i)+ " ";	
		return prodottoStringa;
	}

	public int getQuantita() {
		return 0;
	}

	public void setQuantita(int i) {}

	public double getPrezzo() {
		return 0;
	}

}
