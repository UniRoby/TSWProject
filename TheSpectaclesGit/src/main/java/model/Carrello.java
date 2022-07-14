package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Carrello implements Serializable {
	
	private static final long serialVersionUID = 3497262402613555555L;
	private ArrayList<OcchialeBean> car;
	private int dimensione;
	private float tot;
	
	public Carrello () {
		car= new ArrayList<OcchialeBean>();
		dimensione= 0;
		tot=0;
		
	}
	
	/**
	 * Aggiunge un prodotto nel carrello.
	 * @param prod
	 */
	public void addCarrello (OcchialeBean prod) {
		car.add(prod);
		dimensione= dimensione + 1;
	}
	
	/**
	 * Elimina il prodotto che gli viene passato come parametro.
	 * @param prod
	 */
	public void deleteProduct (OcchialeBean prod) {
		
		for (OcchialeBean p : car) {
			if (p.getIdGlasses().equals(prod.getIdGlasses())) {
				car.remove(p);
				dimensione= dimensione - 1;
			break;
			}
		}
	}
	
	public OcchialeBean prendiProdotto(String id) {
		OcchialeBean bean=new OcchialeBean();
		for(int i=0;i<car.size();i++) {
			if(car.get(i).getIdGlasses().equals(id)) {
				bean.setIdGlasses(car.get(i).getIdGlasses());
				bean.setDescription(car.get(i).getDescription());
				bean.setAvailability(car.get(i).getAvailability());
				bean.setNameGlasses(car.get(i).getNameGlasses());
				bean.setPrice(car.get(i).getPrice());
				bean.setQuantity(car.get(i).getQuantity());
				bean.setTotPrezzo(car.get(i).getTotPrezzo());
			}
		}
		return bean;
	}
	
	/**
	 * Rimuove tutto il contenuto del carrello.
	 */
	public void delete () {
		car.removeAll(car);
		dimensione= 0;
	}
	
	/**
	 * Restituisce tutto il contenuto del carrello.
	 * @return prodotti nel carrello
	 */
	public ArrayList<OcchialeBean> getCarrello (){
		return new ArrayList<>(car);
	}
	
	/**
	 * Controlla se un prodotto è gia presente nel carrello, se è presente restituisce true e se non lo è restituisce false.
	 * @param code
	 * @return true or false
	 */
	public boolean searchProdotto (String code) {
		
		boolean trovato= false;
		
		for (int i= 0; i < car.size(); i++) {
			if (car.get(i).getIdGlasses().equals(code))
				trovato= true;
		}
		
		return trovato;
	}
	
	/**
	 * Restituisce il numero di elementi presenti nell'ArrayList.
	 * @return dimensione
	 */
	public int getDimensione () {
		return dimensione;
	}
	
	/**
	 * Calcola il prezzo del prodotto in base alla quantità scelta dal cliente e restituisce il prezzo totale.
	 * @param quant
	 * @param id
	 * @return prezzo totale
	 */
	public float getPrezzoTotale (int quant, String id) {
		
		for (int i= 0; i < car.size(); i++) {
			if (car.get(i).getIdGlasses().equals(id)) {
				
				tot= car.get(i).getPrice() * quant;
				car.get(i).setTotPrezzo(tot);
				
				System.out.println("\ntot: "+tot);
			}
				}
		return tot;
	}
	
	public float calcolaSpesa() {
		float var1=0.00f;
		
		for(int i=0; i<car.size();i++) {
			var1=var1 + car.get(i).getTotPrezzo();
		}
		
		return var1;
	}
	
	public void insertQuantita(String code, int q) {
		for (int i= 0; i < car.size(); i++) {
			if (car.get(i).getIdGlasses().equals(code)) {
				System.out.println("Disponibilità: "+car.get(i).getAvailability());
				System.out.println("\n Stampa if di InsertQuantita: "+(q<=car.get(i).getAvailability()));
				if(q<=car.get(i).getAvailability())
					car.get(i).setQuantity(q);
				else 
					car.get(i).setQuantity(car.get(i).getAvailability());
			}
			System.out.println("Quantità scelta corretta in Occhiale Bean: "+car.get(i).getQuantity());
		}
	}
}