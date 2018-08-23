/*Table structure for table `company master ` */

CREATE TABLE `mst_company` (
  `cid` INT(11) NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(255) DEFAULT NULL,
  `company_gstin` VARCHAR(255) DEFAULT NULL,
  `company_created_date` DATE DEFAULT NULL,
  `company_created_ip` VARCHAR(255) DEFAULT NULL,
  `company_shrtname` VARCHAR(255) DEFAULT NULL,
  `company_activeflag` int(11) NOT NULL,
  PRIMARY KEY (`cid`)
) ;

/*Table structure for table `address master ` */

CREATE TABLE `mst_address` (
  `aid` INT(11) NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(255) DEFAULT NULL,
  `locality` VARCHAR(255) DEFAULT NULL,
  `address_state` VARCHAR(255) DEFAULT NULL,
  `address_statecode` VARCHAR(255) DEFAULT NULL,
  `address_companyid` INT(11) NOT NULL,
  `address_created_date` DATE DEFAULT NULL,
  `address_created_ip` VARCHAR(255) DEFAULT NULL,
  `address_shrtname` VARCHAR(255) DEFAULT NULL,
  `address_activeflag` int(11) ,
  PRIMARY KEY (`aid`),
  Foreign Key (`address_companyid`) REFERENCES `mst_company`(`cid`));
  
  /*Table structure for table `bank master ` */  
CREATE TABLE `mst_bank` (
  `bid` INT(11) NOT NULL AUTO_INCREMENT,
  `bank_name` VARCHAR(255) DEFAULT NULL,
  `bank_acnum` VARCHAR(255) DEFAULT NULL,
  `branch_name` VARCHAR(255) DEFAULT NULL,
  `bank_ifsccode` VARCHAR(255) DEFAULT NULL,
  `bank_companyid` INT(11) NOT NULL,
  `bank_created_date` DATE DEFAULT NULL,
  `bank_created_ip` VARCHAR(255) DEFAULT NULL,
  `bank_shrtname` VARCHAR(255) DEFAULT NULL,
  `bank_activeflag` int(11) NOT NULL,
  PRIMARY KEY (`bid`),
  Foreign Key (`bank_companyid`) REFERENCES `mst_company`(`cid`));



  /*Table structure for table `tax invoice ` */
  
 CREATE TABLE `tax_invoice` (
  `tid` INT(11) NOT NULL AUTO_INCREMENT,
  `invoice_num` VARCHAR(255) DEFAULT NULL,
  `invoice_date` VARCHAR(255) DEFAULT NULL,
  `invoice_purposeofcreation` VARCHAR(255) DEFAULT NULL,
  `invoice_createdby` VARCHAR(255) DEFAULT NULL,
  `invoice_plcofsupply` VARCHAR(255) DEFAULT NULL,
  `invoice_orderrefnum` VARCHAR(255) DEFAULT NULL,
  `invoice_servicesbycmpid` INT(11) NOT NULL,
  `invoice_servicestocmpid` INT(11) NOT NULL,
  `invoice_servicestoaddressid` INT(11) NOT NULL,
  `invoice_servicesbyaddressid` INT(11) NOT NULL,
  `invoice_serviceid`INT(11) NOT NULL,
  `invoice_taxdetailstid` INT(11) NOT NULL,
  `invoice_bankid` INT(11) NOT NULL,
  `invoice_servicesbycmpname` VARCHAR(255) DEFAULT NULL,
  `invoice_servicestocmpname` VARCHAR(255) DEFAULT NULL,
  `invoice_servicestoaddressname` VARCHAR(255) DEFAULT NULL,
  `invoice_servicesbyaddressname` VARCHAR(255) DEFAULT NULL,
  `invoice_created_date` DATE DEFAULT NULL,
  `invoice_created_ip` VARCHAR(255) DEFAULT NULL,
   PRIMARY KEY (`tid`),
  Foreign Key (`invoice_servicesbycmpid`) REFERENCES `mst_company`(`cid`),
  Foreign Key (`invoice_servicestocmpid`) REFERENCES `mst_company`(`cid`),
  Foreign Key (`invoice_servicestoaddressid`) REFERENCES `mst_address`(`aid`),
  Foreign Key (`invoice_servicesbyaddressid`) REFERENCES `mst_address`(`aid`),
  Foreign Key (`invoice_bankid`) REFERENCES `mst_bank`(`bid`)
  );
  


  /*Table structure for table `tax details ` */
  
 CREATE TABLE `tax_details` (
  `taxid` INT(11) NOT NULL AUTO_INCREMENT,
  `sgstper` double NOT NULL,
  `cgstper`  double NOT NULL,
  `igstper`  double NOT NULL,
  `cgstamount` double NOT NULL,
  `sgstamount` double NOT NULL,
  `igstamount` double NOT NULL,
  `tax_invoiceid` INT(11) NOT NULL,
  `value_befor_tax` double NOT NULL,
  `value_after_tax` double NOT NULL,
  `tax_shrtname` VARCHAR(255) DEFAULT NULL,
  `taxdetails_createdby` VARCHAR(255) DEFAULT NULL,
  `taxdetails_created_date` DATE DEFAULT NULL,
  `taxdetails_created_ip` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`taxid`),
  FOREIGN KEY (`tax_invoiceid`) REFERENCES `tax_invoice`(`tid`)
  );


  
  /* table structure for service table */  

  
 CREATE TABLE `service` (
  `serviceid` INT(11) NOT NULL AUTO_INCREMENT,
  `sacnumber` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `valueofservice` VARCHAR(255) DEFAULT NULL,
  `service_taxinvoiceid` INT(11) NOT NULL,
  `service_createdby` VARCHAR(255) DEFAULT NULL,
  `service_created_date` DATE DEFAULT NULL,
  `service_created_ip` VARCHAR(255) DEFAULT NULL,
   PRIMARY KEY (`serviceid`),
   FOREIGN KEY (`service_taxinvoiceid`) REFERENCES `tax_invoice`(`tid`)
   );

 ALTER TABLE tax_invoice
ADD FOREIGN KEY (invoice_taxdetailstid) REFERENCES tax_details(taxid);