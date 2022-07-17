package model;

import java.io.Serializable;
import java.util.UUID;


public class OcchialeOrdineBean implements Serializable {

	private static final long serialVersionUID = -1258634432830603623L;
	private int idOcchialeOrdine;
	private UUID idOrdine;
	private OcchialeBean occhiale;
	private String idOcchiale;
	private int prezzoEffettivo;
	private float iva;
	private int quantita;

	public OcchialeOrdineBean() {
		this.idOcchialeOrdine = 0;
		this.occhiale = null;
		this.prezzoEffettivo = 0;
		this.iva = 0;
		this.quantita = 0;
	}
	
	

	public OcchialeOrdineBean(
			int idOcchialeOrdine,
			UUID idOrdine,
			OcchialeBean occhiale,
			int prezzoEffettivo,
			float iva,
			int quantita
	) {
		this.idOcchialeOrdine = idOcchialeOrdine;
		this.idOrdine = idOrdine;
		this.occhiale = occhiale;
		this.prezzoEffettivo = prezzoEffettivo;
		this.iva = iva;
		this.quantita = quantita;
	}
	public OcchialeOrdineBean(
			int idOcchialeOrdine,
			UUID idOrdine,
			String idOcchiale,
			int prezzoEffettivo,
			float iva,
			int quantita
	) {
		this.idOcchialeOrdine = idOcchialeOrdine;
		this.idOrdine = idOrdine;
		this.idOcchiale = idOcchiale;
		this.prezzoEffettivo = prezzoEffettivo;
		this.iva = iva;
		this.quantita = quantita;
	}

	public int getIdOcchialeOrdine() {
		return idOcchialeOrdine;
	}

	public UUID getIdOrdine() {
		return idOrdine;
	}

	public OcchialeBean getProdotto() {
		return occhiale;
	}
	public String getIdProdotto() {
		return idOcchiale;
	}
	public void setIdProdotto(String id) {
		this.idOcchiale=id;
	}

	public float getPrezzoEffettivo() {
		return prezzoEffettivo;
	}

	public float getIva() {
		return iva;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setIdOcchialeOrdine(int iIdOcchialeOrdine) {
		this.idOcchialeOrdine = idOcchialeOrdine;
	}

	public void setIdOrdine(UUID idOrdine) {
		this.idOrdine = idOrdine;
	}

	public void setProdotto(OcchialeBean occhiale) {
		this.occhiale = occhiale;
	}

	public void setPrezzoEffettivo(int prezzoEffettivo) {
		this.prezzoEffettivo = prezzoEffettivo;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public String toString() {
		return "OcchialeOrdineBean [idOcchialeOrdine=" + idOcchialeOrdine + ", idOrdine=" + idOrdine + ", occhiale=" + idOcchiale + ",prezzoEffettivo="
				+ prezzoEffettivo+ ", iva=" + iva + ", quantita=" +quantita  + "]";
	}
}
