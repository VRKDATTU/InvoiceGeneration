package com.struts.invoicegen.action;

import java.util.List;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.invoicegen.dao.TaxInvoiceDao;
import com.struts.invoicegen.dto.ServicesDto;
import com.struts.invoicegen.dto.TaxInvoiceServicesDto;
import com.struts.invoicegen.model.TaxInvoiceModel;

public class TaxInvoice extends ActionSupport implements ModelDriven<TaxInvoiceServicesDto>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TaxInvoiceServicesDto taxDto = new TaxInvoiceServicesDto();
	TaxInvoiceModel taxModel = new TaxInvoiceModel();
	List<TaxInvoiceDao> invoicelist;
	
	private  TaxInvoiceServicesDto taxInvDto;
	private List<TaxInvoiceServicesDto> taxInvDtoList;
	private List<ServicesDto> servDtoList;
	
	

	public List<TaxInvoiceDao> getInvoicelist() {
		return invoicelist;
	}

	public void setInvoicelist(List<TaxInvoiceDao> invoicelist) {
		this.invoicelist = invoicelist;
	}

	public TaxInvoiceServicesDto getTaxInvDto() {
		return taxInvDto;
	}

	public void setTaxInvDto(TaxInvoiceServicesDto taxInvDto) {
		this.taxInvDto = taxInvDto;
	}

	public List<TaxInvoiceServicesDto> getTaxInvDtoList() {
		return taxInvDtoList;
	}

	public void setTaxInvDtoList(List<TaxInvoiceServicesDto> taxInvDtoList) {
		this.taxInvDtoList = taxInvDtoList;
	}

	public List<ServicesDto> getServDtoList() {
		return servDtoList;
	}

	public void setServDtoList(List<ServicesDto> servDtoList) {
		this.servDtoList = servDtoList;
	}

	
	@Override
	public TaxInvoiceServicesDto getModel() {
		// TODO Auto-generated method stub
		return taxDto;
	}
	
	public String invoiceFields()
	{
		taxModel.saveInvoiceFields(taxDto);
		this.invoicelist = taxModel.fetchInvoiceDetails();
		return SUCCESS;
	}

	public String fetchinvoiceFields()
	{
		this.invoicelist = taxModel.fetchInvoiceDetails();
		return SUCCESS;
	}
}
