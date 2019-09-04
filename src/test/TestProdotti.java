package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.*;

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
	
	

}
