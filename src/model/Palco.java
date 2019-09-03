package model;

import java.util.ArrayList;

public class Palco implements Magazzino {
	private String nome;
	private ArrayList<BevandaSpecifica> forniture = new ArrayList<BevandaSpecifica>();
	
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

	public ArrayList<BevandaSpecifica> getForniture() {
		return forniture;
	}

	public void setForniture(ArrayList<BevandaSpecifica> forniture) {
		this.forniture = forniture;
	}

	
	
}