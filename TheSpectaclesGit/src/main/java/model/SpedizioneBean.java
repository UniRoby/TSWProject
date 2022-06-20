package model;
import java.io.Serializable;
import java.sql.Date;

public class SpedizioneBean implements Serializable {
	
	int idShipment;
	Date dateShipment;
	int idOrder;
	int shipmentType;
	
	public SpedizioneBean(int idShipment, Date dateShipment, int idOrder, int shipmentType) {
		this.idShipment = idShipment;
		this.dateShipment = dateShipment;
		this.idOrder = idOrder;
		this.shipmentType = shipmentType;
	}

	public int getIdShipment() {
		return idShipment;
	}

	public void setIdShipment(int idShipment) {
		this.idShipment = idShipment;
	}

	public Date getDateShipment() {
		return dateShipment;
	}

	public void setDateShipment(Date dateShipment) {
		this.dateShipment = dateShipment;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(int shipmentType) {
		this.shipmentType = shipmentType;
	}

	@Override
	public String toString() {
		return "Spedizione [idShipment=" + idShipment + ", dateShipment=" + dateShipment + ", idOrder=" + idOrder
				+ ", shipmentType=" + shipmentType + "]";
	}
	
	
}
