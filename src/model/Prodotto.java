package model;

import java.util.ArrayList;

public interface Prodotto {

	public String getNome();

	public ArrayList<String> getPuntiVendita();

	public int getQuantita();

	public void setQuantita(int i);
	
}
