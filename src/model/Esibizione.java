package model;

import java.util.GregorianCalendar;

public class Esibizione {
	private GregorianCalendar data;
	private Artista artista;
	
	
	public Esibizione(GregorianCalendar data, Artista artista) {
		super();
		this.data = data;
		this.artista = artista;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtisti(Artista artista) {
		this.artista = artista;
	}
	
	 
	
}
