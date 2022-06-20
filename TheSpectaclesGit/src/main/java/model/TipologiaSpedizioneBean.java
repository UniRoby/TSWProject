package model;

import java.io.Serializable;

public class TipologiaSpedizioneBean implements Serializable {
	
	int idShipmentType;
	String shipmentName;
	int shipmentCost;
	
	public TipologiaSpedizioneBean(int idShipmentType, String shipmentName, int shipmentCost) {
		super();
		this.idShipmentType = idShipmentType;
		this.shipmentName = shipmentName;
		this.shipmentCost = shipmentCost;
	}

	public int getIdShipmentType() {
		return idShipmentType;
	}

	public void setIdShipmentType(int idShipmentType) {
		this.idShipmentType = idShipmentType;
	}

	public String getShipmentName() {
		return shipmentName;
	}

	public void setShipmentName(String shipmentName) {
		this.shipmentName = shipmentName;
	}

	public int getShipmentCost() {
		return shipmentCost;
	}

	public void setShipmentCost(int shipmentCost) {
		this.shipmentCost = shipmentCost;
	}

	@Override
	public String toString() {
		return "TipologiaSpedizione [idShipmentType=" + idShipmentType + ", shipmentName=" + shipmentName
				+ ", shipmentCost=" + shipmentCost + "]";
	}
	
	
	
	
}
