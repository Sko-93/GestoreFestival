package controller;

import java.util.ArrayList;
import model.*;

public class GestoreFestival {

	private ArrayList<Prodotto> storicoProdotti= new  ArrayList<Prodotto>();
	private ArrayList<Prodotto> listaSpesa= new ArrayList<Prodotto>();
	private ArrayList<Prodotto> prodottiAcquistati= new ArrayList<Prodotto>();
	private ArrayList<Magazzino> zoneStoccaggio = new ArrayList<Magazzino>();

	public void aggiungiProdottoStorico(String nomeProdotto, String puntoVendita) {
		Prodotto prodotto = trova(nomeProdotto, storicoProdotti);
		if(prodotto==null)
			storicoProdotti.add(new BevandaGenerica(nomeProdotto, puntoVendita));
		else 
			System.out.println("Il prodotto è già stato inserito");
	}

	public void aggiungiProdottoListaSpesa(String nomeProdotto, int quantita, double prezzoPreventivo) {
		Prodotto prodotto = trova(nomeProdotto, listaSpesa);
		if(prodotto== null)
			listaSpesa.add(new BevandaSpecifica(nomeProdotto, "", quantita, prezzoPreventivo));
		else
			prodotto.setQuantita(prodotto.getQuantita()+quantita);
	}

	//STATE da implementare
	public void registraAcquisto(String nomeProdotto, String puntoVendita, int quantita, double prezzoUnitario) {
		Prodotto prodottoStorico = trova(nomeProdotto, storicoProdotti);
		Prodotto prodottoDaAcq= trova(nomeProdotto, listaSpesa);
		//verifica se il prodotto acquistato è stato registrato o meno, 
		//in caso non lo sia lo aggiunge ai prodotti nello storico
		if(prodottoStorico==null)
			storicoProdotti.add(new BevandaGenerica(nomeProdotto, puntoVendita));
		else if(!prodottoStorico.getPuntiVendita().contains(puntoVendita))
			prodottoStorico.getPuntiVendita().add(puntoVendita);
		//registra l'acquisto di un determinato prodotto
		prodottiAcquistati.add(new BevandaSpecifica(nomeProdotto, puntoVendita, quantita, prezzoUnitario));
		//se il prodotto è presente dalla lista dei prodotti da acquistare 
		//lo elimina se è stato acquistato in quantità adeguata
		if(prodottoDaAcq!=null)
			if(prodottoDaAcq.getQuantita()==quantita)
				listaSpesa.remove(prodottoDaAcq);
			else
				prodottoDaAcq.setQuantita(prodottoDaAcq.getQuantita()-quantita);
	} 
	
	public double calcolaSpesaTotale(ArrayList<Prodotto> prodotti) {
		double k=0;
		for(int i=0; i<prodotti.size(); i++) {
			k+= prodotti.get(i).getQuantita()*prodotti.get(i).getPrezzo();
		}
		return k;
	}
	
	public void aggiungiPalco(String nome) {
		zoneStoccaggio.add(new Palco(nome));
	}

	public void aggiungiPuntoVendita(String nomeProdotto, String Puntovendita){
		Prodotto prodotto= trova(nomeProdotto, storicoProdotti);	
		if(prodotto==null)
			System.out.println("Prodotto non trovato");
		else if(prodotto.getPuntiVendita().contains(Puntovendita))
			System.out.println("Punto vendita già inserito");
		else
			prodotto.getPuntiVendita().add(Puntovendita);			
	}
	
	public void depositaAcquisto(Magazzino magazzino, ArrayList<Prodotto> prodottiImmagazzinati) {
		magazzino.getProdottiImmagazzinati().addAll(prodottiImmagazzinati);		
	}
	
	public void smistaProdotti(ArrayList<Prodotto> prodottiSmistati, Magazzino cedente, Magazzino ricevente){
		for(int i=0; i<prodottiSmistati.size(); i++) {
			Prodotto prodottoDaSmist=trova(prodottiSmistati.get(i).getNome(), cedente.getProdottiImmagazzinati());
			if(prodottoDaSmist!=null && prodottiSmistati.get(i).getQuantita()<=prodottoDaSmist.getQuantita()) {
				int nuovaQuantita= prodottiSmistati.get(i).getQuantita()-prodottoDaSmist.getQuantita();
				if(nuovaQuantita==0)
					cedente.getProdottiImmagazzinati().remove(prodottoDaSmist);
				else
					prodottoDaSmist.setQuantita(nuovaQuantita);
				ricevente.getProdottiImmagazzinati().add(prodottoDaSmist);
			}
			else
				System.out.println("il prodotto "+ prodottiSmistati.get(i).getNome()+ " non è presente o non è in quenatità sufficiente nel magazzino: "+ cedente.getNome());
		}
	}

	public void stampaProdotti(ArrayList<Prodotto> listaProdotti) {
		for(int i=0; i<listaProdotti.size(); i++) {
			System.out.println(listaProdotti.get(i).toString());
		}
	}

	public ArrayList<Prodotto> getProdottiAcquistati() {
		return prodottiAcquistati;
	}

	public void setProdottiAcquistati(ArrayList<Prodotto> prodottiAcquistati) {
		this.prodottiAcquistati = prodottiAcquistati;
	}

	public ArrayList<Prodotto> getStoricoProdotti() {
		return storicoProdotti;
	}

	public void setStoricoProdotti(ArrayList<Prodotto> storicoProdotti) {
		this.storicoProdotti = storicoProdotti;
	}

	public ArrayList<Prodotto> getListaSpesa() {
		return listaSpesa;
	}

	public void setListaSpesa(ArrayList<Prodotto> listaSpesa) {
		this.listaSpesa = listaSpesa;
	}

	public ArrayList<Magazzino> getZoneStoccaggio() {
		return zoneStoccaggio;
	}

	public void setZoneStoccaggio(ArrayList<Magazzino> zoneStoccaggio) {
		this.zoneStoccaggio = zoneStoccaggio;
	}

	public Prodotto trova(String nome, ArrayList<Prodotto> listaOggetti) {
		for(int i=0; i<listaOggetti.size(); i++) {
			if(listaOggetti.get(i).getNome()== nome)
				return listaOggetti.get(i);
		}
		return null;
	}
	
	public int trovaMagazzino(String nomeMagazzino, ArrayList<Magazzino> arrayListMagazzino) {
		for(int i=0; i<arrayListMagazzino.size(); i++) {
			if(arrayListMagazzino.get(i).getNome()== nomeMagazzino)
				return i;
		}
		return -1;
	}
	

}


