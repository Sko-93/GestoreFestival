package model;

import java.util.ArrayList;

public interface Magazzino {

	public String getNome();
	
	public void setNome(String nome);
	
	public ArrayList<Prodotto> getForniture();
	
	public void setForniture(ArrayList<Prodotto> forniture);
}