package model;

import java.io.Serializable;

public class tipologiaPagamentoBean implements Serializable {
 
	int idPaymentType;
	String paymentName;
	
	public tipologiaPagamentoBean(int idPaymentType, String paymentName) {
		super();
		this.idPaymentType = idPaymentType;
		this.paymentName = paymentName;
	}

	@Override
	public String toString() {
		return "tipologiaPagamento [idPaymentType=" + idPaymentType + ", paymentName=" + paymentName + "]";
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
	
	
	
}
