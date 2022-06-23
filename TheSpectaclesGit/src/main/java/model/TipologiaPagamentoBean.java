package model;

import java.io.Serializable;

public class TipologiaPagamentoBean implements Serializable {
 
	int idPaymentType;
	String paymentName;
	
	public TipologiaPagamentoBean() {
		
	}
	public TipologiaPagamentoBean(int idPaymentType, String paymentName) {
		super();
		this.idPaymentType = idPaymentType;
		this.paymentName = paymentName;
	}
	public int getIdPaymentType() {
		return idPaymentType;
	}
	public void setIdPaymentType(int idPaymentType) {
		this.idPaymentType = idPaymentType;
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	public String toString() {
		return "tipologiaPagamento [idPaymentType=" + idPaymentType + ", paymentName=" + paymentName + "]";
	}
}