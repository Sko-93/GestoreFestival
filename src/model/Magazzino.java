package model;

import java.util.ArrayList;

public interface Magazzino {

	public String getNome();
	
	public void setNome(String nome);
	
	public ArrayList<Prodotto> getProdottiImmagazzinati();
	
	public void setprodottiImmagazzinati(ArrayList<Prodotto> forniture);
}