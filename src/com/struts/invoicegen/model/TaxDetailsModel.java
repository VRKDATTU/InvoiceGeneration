package com.struts.invoicegen.model;

import java.util.Date;

import org.hibernate.Session;

import com.struts.invoicegen.dao.TaxDetailsDao;
import com.struts.invoicegen.dao.TaxInvoiceDao;
import com.struts.invoicegen.dto.TaxInvoiceServicesDto;
import com.struts.invoicegen.services.InvoicePdfGeneration;
import com.struts.invoicegen.util.HibernateUtil;

public class TaxDetailsModel {

	TaxDetailsDao taxDetailsDao = new TaxDetailsDao();
	private double cgstAmount = 0,igstAmount = 0 , sgstAmount = 0; 
	
	public String saveTaxDetails(double totalValOfServ, int currenttaxId, TaxInvoiceServicesDto taxDto) {
		
		taxDto.setTaxInvoiceId(currenttaxId);
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		if(taxDto.getIgstRadio().equals("Yes")){
			igstAmount = ((totalValOfServ*18)/100);
		}
		else
		{
			cgstAmount = ((totalValOfServ*9)/100);
			sgstAmount = ((totalValOfServ*9)/100);
		}
		double gstAmount = igstAmount+cgstAmount+sgstAmount;
		double valAfterTax =  totalValOfServ + igstAmount+cgstAmount+sgstAmount;
		taxDetailsDao.setCgstamount(cgstAmount);
		taxDetailsDao.setSgstamount(sgstAmount);
		taxDetailsDao.setIgstamount(igstAmount);
		taxDetailsDao.setGstAmount(gstAmount);
		taxDetailsDao.setValue_befor_tax(totalValOfServ);
		taxDetailsDao.setValue_after_tax(valAfterTax);
		taxDetailsDao.setTaxdetails_created_date(new Date());
		taxDetailsDao.setTaxInvoiceDao((TaxInvoiceDao) sess.get(TaxInvoiceDao.class,taxDto.getTaxInvoiceId()));
		sess.save(taxDetailsDao);
		sess.getTransaction().commit();
		InvoicePdfGeneration invGen = new InvoicePdfGeneration();
		invGen.generateInvoice(currenttaxId);
		return "success";
	}
}
