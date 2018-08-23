package com.struts.invoicegen.dto;

public class TaxDetailsDto {

	private double sgstPercentage;
	private double cgstPercentage;
	private double igstPercentage;
	private double cgstAmount;
	private double sgstAmount;
	private double igstAmount;
	private int taxInvoiceId;
	private double valueBeforTax;
	private double valueAfterTax;
	private int taxInvoice;
	
	
	
	public int getTaxInvoice() {
		return taxInvoice;
	}
	public void setTaxInvoice(int taxInvoice) {
		this.taxInvoice = taxInvoice;
	}
	public double getSgstPercentage() {
		return sgstPercentage;
	}
	public void setSgstPercentage(double sgstPercentage) {
		this.sgstPercentage = sgstPercentage;
	}
	public double getCgstPercentage() {
		return cgstPercentage;
	}
	public void setCgstPercentage(double cgstPercentage) {
		this.cgstPercentage = cgstPercentage;
	}
	public double getIgstPercentage() {
		return igstPercentage;
	}
	public void setIgstPercentage(double igstPercentage) {
		this.igstPercentage = igstPercentage;
	}
	public double getCgstAmount() {
		return cgstAmount;
	}
	public void setCgstAmount(double cgstAmount) {
		this.cgstAmount = cgstAmount;
	}
	public double getSgstAmount() {
		return sgstAmount;
	}
	public void setSgstAmount(double sgstAmount) {
		this.sgstAmount = sgstAmount;
	}
	public double getIgstAmount() {
		return igstAmount;
	}
	public void setIgstAmount(double igstAmount) {
		this.igstAmount = igstAmount;
	}
	public int getTaxInvoiceId() {
		return taxInvoiceId;
	}
	public void setTaxInvoiceId(int taxInvoiceId) {
		this.taxInvoiceId = taxInvoiceId;
	}
	public double getValueBeforTax() {
		return valueBeforTax;
	}
	public void setValueBeforTax(double valueBeforTax) {
		this.valueBeforTax = valueBeforTax;
	}
	public double getValueAfterTax() {
		return valueAfterTax;
	}
	public void setValueAfterTax(double valueAfterTax) {
		this.valueAfterTax = valueAfterTax;
	}
	
	
	
	
}
