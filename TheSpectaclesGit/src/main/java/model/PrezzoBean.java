package model;

import java.io.Serializable;
import java.sql.Date;

public class PrezzoBean implements Serializable  {
	
	private static final long serialVersionUID = -4959563723922476262L;
	
	int idPrezzo;
	int prezzo;
	int iva;
	String idOcchiale;
	Date data;
	float totalPrice;
	

	public PrezzoBean() {
		
	}
	
	public PrezzoBean(int idPrezzo, int prezzo, int iva, String idOcchiale,Date data){
		this.idPrezzo=idPrezzo;
		this.prezzo=prezzo;
		this.iva=iva;
		this.idOcchiale=idOcchiale;
		this.data=data;
	}

	

	public int getIdPrezzo() {
		return idPrezzo;
	}

	public void setIdPrezzo(int idPrezzo) {
		this.idPrezzo = idPrezzo;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public String getIdOcchiale() {
		return idOcchiale;
	}

	public void setIdOcchiale(String idOcchiale) {
		this.idOcchiale = idOcchiale;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PrezzoBean [idPrezzo=" + idPrezzo + ", prezzo=" + prezzo + ", iva=" + iva + ", idOcchiale=" + idOcchiale
				+ ", data=" + data + ", totalPrice=" + totalPrice + "]";
	}


	
}