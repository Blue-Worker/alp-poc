package com.alp.poc.tms.data;

public class DeliveryOrder {
	
	private String carrier = "";
	
	private String delNum = "";
	
	private String orderNum = "";
	
	private String addr = "";

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDelNum() {
		return delNum;
	}

	public void setDelNum(String delNum) {
		this.delNum = delNum;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

}
