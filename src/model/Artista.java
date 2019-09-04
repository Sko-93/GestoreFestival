package model;

public class Artista {
	private String nome;
	private int numeroComponenti;
	private int numeroAccompagnatori;
	
	
	public Artista(String nome, int numeroComponenti, int numeroAccompagnatori) {
		super();
		this.nome = nome;
		this.numeroComponenti = numeroComponenti;
		this.numeroAccompagnatori = numeroAccompagnatori;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroComponenti() {
		return numeroComponenti;
	}

	public void setNumeroComponenti(int numeroComponenti) {
		this.numeroComponenti = numeroComponenti;
	}

	public int getNumeroAccompagnatori() {
		return numeroAccompagnatori;
	}

	public void setNumeroAccompagnatori(int numeroAccompagnatori) {
		this.numeroAccompagnatori = numeroAccompagnatori;
	}
}
