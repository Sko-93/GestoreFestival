package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controller.*;
import model.*;

public class TestProdotti {
	GestoreFestival g1=new GestoreFestival();
	
	@Test
	public void registraProdottoGenerico() {
		g1.aggiungiProdottoStorico("Pinot grigio", "Metro");
		assertEquals(g1.trova("Pinot grigio", g1.getStoricoProdotti())!=null, true);
	}

	@Before
	public void setup(){
		g1.aggiungiProdottoStorico("Coca-Cola", "Metro");	
		g1.aggiungiProdottoStorico("Redbull", "Metro");	
		g1.aggiungiProdottoStorico("Monster", "Metro");	
		
	}

	@Test
	public void testAggiungiPuntoVendita() {
		g1.aggiungiPuntoVendita("Redbull", "Ipercoop");
		assertEquals(g1.trova("Redbull", g1.getStoricoProdotti()).getPuntiVendita().contains("Ipercoop"), true);
	}
	
	@Test
	public void testRegistraAcquisto() {
		g1.registraAcquisto("Pinot grigio", "Metro", 15, 13.5);
		assertEquals(g1.trova("Pinot grigio", g1.getProdottiAcquistati())!=null, true);
	}
	
	@Test
	public void testRegistraAcquistoProdottoNonRegistrato() {
		g1.registraAcquisto("Fanta", "Metro", 15, 3.5);
		assertEquals(g1.trova("Fanta", g1.getStoricoProdotti())!=null, true);
	}
	
	@Test
	public void StampaListaProdotti(){
		g1.aggiungiProdottoListaSpesa("Chinotto", 15, 13.5);
		g1.aggiungiProdottoListaSpesa("Fanta", 15, 3.5);
		g1.aggiungiProdottoListaSpesa("Monster", 15, 13.5);
		System.out.print("-Lista spesa:\n");
		g1.stampaProdotti(g1.getListaSpesa());
		System.out.print("\n");
		g1.registraAcquisto("Chinotto", "Metro", 15, 13.5);
		g1.registraAcquisto("Chinotto", "Ipercoop", 11, 12);
		g1.registraAcquisto("Fanta", "Metro", 15, 3.5);
		System.out.print("-Lista spesa attuale:\n");
		g1.stampaProdotti(g1.getListaSpesa());
		System.out.print("\n-Lista prodotti acquistati:\n");
		g1.stampaProdotti(g1.getProdottiAcquistati());
		System.out.print("\n-Lista prodotti storico:\n");
		g1.stampaProdotti(g1.getStoricoProdotti()); 
	}
	
	@Test
	public void calcolaSpesaTotale(){
		g1.registraAcquisto("Chinotto", "Metro", 15, 2);
		g1.registraAcquisto("Chinotto", "Ipercoop", 11, 1.5);
		g1.registraAcquisto("Fanta", "Metro", 10, 3.5);
		double k=g1.calcolaSpesaTotale(g1.getProdottiAcquistati());
		assertEquals(k==81.5, true);
	}
	
	@Test
	public void depositaOggetti(){
		g1.aggiungiPalco("Santa Giuliana");
		g1.registraAcquisto("Chinotto", "Metro", 15, 2);
		Magazzino magazzino= g1.trovaMagazzino("Santa Giuliana", g1.getZoneStoccaggio());
		g1.depositaAcquisto(magazzino, g1.getProdottiAcquistati());
		assertEquals(magazzino.getProdottiImmagazzinati().isEmpty(), false);
	}
	
	@Test
	public void smistaOggetti(){
		g1.aggiungiPalco("Santa Giuliana");
		g1.aggiungiPalco("Carducci");
		g1.registraAcquisto("Chinotto", "Metro", 15, 2);
		ArrayList<Prodotto> prodottiDaSmistare= new ArrayList<Prodotto>();
		prodottiDaSmistare.add(new BevandaSpecifica("Chinotto", "Metro", 15, 2));
		prodottiDaSmistare.add(new BevandaSpecifica("Monster", "Metro", 15, 2));
		prodottiDaSmistare.add(new BevandaSpecifica("Redbull", "Metro", 15, 2));
		Magazzino magazzino1= g1.trovaMagazzino("Santa Giuliana", g1.getZoneStoccaggio());
		Magazzino magazzino2= g1.trovaMagazzino("Carducci", g1.getZoneStoccaggio());
		g1.depositaAcquisto(magazzino1, g1.getProdottiAcquistati());
		g1.smistaProdotti(prodottiDaSmistare, magazzino1, magazzino2);
		assertEquals(magazzino2.getProdottiImmagazzinati().isEmpty(), false);
	}

}
