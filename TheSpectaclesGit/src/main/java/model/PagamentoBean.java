package model;
import java.io.Serializable;
import java.sql.Date;

public class PagamentoBean implements Serializable {
	
	int idPayment;
	Date date;
	int idPaymentType;
	int idOrder;
	int amount;
	
	public PagamentoBean(int idPayment, Date date, int idPaymentType, int idOrder, int amount) {
		
		this.idPayment = idPayment;
		this.date = date;
		this.idPaymentType = idPaymentType;
		this.idOrder = idOrder;
		this.amount = amount;
	}

	public int getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdPaymentType() {
		return idPaymentType;
	}

	public void setIdPaymentType(int idPaymentType) {
		this.idPaymentType = idPaymentType;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Pagamento [idPayment=" + idPayment + ", date=" + date + ", idPaymentType=" + idPaymentType
				+ ", idOrder=" + idOrder + ", amount=" + amount + "]";
	}
	
	
	
	
	
}
