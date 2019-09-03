package model;

import java.util.ArrayList;

public interface Magazzino {

	public String getNome();
	
	public void setNome(String nome);
	
	public ArrayList<BevandaSpecifica> getForniture();
	
	public void setForniture(ArrayList<BevandaSpecifica> forniture);
}