package com.struts.invoicegen.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.struts.invoicegen.dao.GstPercentageDao;
import com.struts.invoicegen.dto.TaxDetailsDto;
import com.struts.invoicegen.util.HibernateUtil;

public class GstPercentageModel {

	GstPercentageDao gstDao = new GstPercentageDao();
	Session sess = HibernateUtil.getSessionFactory().openSession();
	public String saveGstPercentage(TaxDetailsDto taxDetails){
		sess.beginTransaction();
		gstDao.setCgstper(taxDetails.getCgstPercentage());
		gstDao.setSgstper(taxDetails.getSgstPercentage());
		gstDao.setIgstper(taxDetails.getIgstPercentage());
		sess.save(gstDao);
		sess.getTransaction().commit();
		return "success";
	}
	public List<GstPercentageDao> fetchgstperfields() {
		sess.beginTransaction();
		System.out.println("in gst fetch fields ");
		Query query = sess.createQuery("from GstPercentageDao");
		List<GstPercentageDao> gstList = query.list();
		System.out.println("gstList"+gstList);
		sess.close();
		return gstList;
	}
	public String updateGstPercentage(TaxDetailsDto taxDetails) {
		sess.beginTransaction();
		Query gstquery = sess.createQuery("update GstPercentageDao set gstActiveFlag = 0");
		int result = gstquery.executeUpdate();
		System.out.println("hhhhhhhhhh"+result);
		sess.getTransaction().commit();
		return "success";
	}
}
