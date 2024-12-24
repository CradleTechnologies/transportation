package com.cradletechnologies.transportation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cradletechnologies.transportation.filter.ClientsReportDataFilter;
import com.cradletechnologies.transportation.model.ClientsList_Report;
import com.cradletechnologies.transportation.model.PaymentBilling;

public interface PaymentBillingRepository  extends JpaRepository<PaymentBilling, Integer>, JpaSpecificationExecutor<PaymentBilling>{


	@Modifying
    @Query(
            value = "truncate table payment_billing",
            nativeQuery = true
    )
    void truncatePaymentBilling();
	
	@Modifying
    @Query(
            value = "INSERT INTO \r\n"
            		+ "payment_billing  \r\n"
            		+ "(record_date, client_id, payment_id, billing_id, sales_id, amount) \r\n"
            		+ "SELECT payment_date, client_id, id, '0', '0', amount_paid\r\n"
            		+ "FROM payments_in ;\r\n"
            		+ " ",
            nativeQuery = true
    )
    void fillPaymentBilling_Payments();
	
	@Modifying
    @Query(
            value = "INSERT INTO \r\n"
            		+ "payment_billing  \r\n"
            		+ "(record_date, client_id, payment_id, billing_id, sales_id, amount)\r\n"
            		+ "SELECT record_date, source_id, '0', id, '0', -total \r\n"
            		+ "FROM product_purchases ;\r\n"
            		+ " ",
            nativeQuery = true
    )
    void fillPaymentBilling_Billing();
	
	
	@Modifying
	@Query(
			value = "INSERT INTO \r\n"
					+ "payment_billing  \r\n"
					+ "(record_date, client_id, payment_id, billing_id, sales_id, amount)\r\n"
					+ "SELECT record_date, customer_id, '0', '0', id, total \r\n"
					+ "FROM product_sales ;\r\n"
					+ " ",
					nativeQuery = true
			)
	void fillPaymentBilling_Sale();
	
	
	//Reports
	@Query("SELECT DISTINCT new com.cradletechnologies.resellermis.model.ClientsList_Report(p.id, p.firstName, p.lastName, p.clientname, p.status, COALESCE(-sum(pm.amountPaid),0)+COALESCE(sum(b.totals),0))\r\n"
			+ "FROM PaymentBilling pb\r\n"
			+ "LEFT JOIN Clients p ON pb.clientId = p.id\r\n"
			+ "LEFT JOIN ProductSales b ON pb.billingId = b.id\r\n"
			+ "LEFT JOIN PaymentsIn pm ON pb.paymentId = pm.id\r\n"
			+ "WHERE p.status = 'ACTIVE'\r\n"
			+ "GROUP BY p.id\r\n"
			+ "ORDER BY p.id ASC")
	public List<ClientsList_Report> getClientsListReport();
	

	@Query("SELECT COUNT(p.id) \r\n"
			+ "FROM Clients p \r\n"
			+ "WHERE p.status = 'ACTIVE' \r\n")
//			+ "FROM PaymentBilling pb \r\n"
//			+ "LEFT JOIN Pupils p ON pb.clientId = p.id \r\n")
	public int getClientsCount();
	
	
	@Query("SELECT COALESCE(SUM(pm.amountPaid),0) \r\n"
			+ "FROM PaymentBilling pb \r\n"
			+ "LEFT JOIN PaymentsIn pm ON pb.paymentId = pm.id \r\n")
	public Double getTotalRevenue();
	
	
	@Query("SELECT COALESCE(SUM(b.totals),0) \r\n"
			+ "FROM PaymentBilling pb \r\n"
			+ "LEFT JOIN ProductSales b ON pb.billingId = b.id \r\n")
	public Double getTotalInvoices();
	
	

	@Query("SELECT DISTINCT new com.cradletechnologies.resellermis.model.ClientsList_Report(p.id, p.firstName, p.lastName, p.clientname, p.status,  COALESCE(-sum(pm.amountPaid),0)+COALESCE(sum(b.totals),0) )\r\n"
			+ "FROM PaymentBilling pb\r\n"
			+ "LEFT JOIN Clients p ON pb.clientId = p.id\r\n"
			+ "LEFT JOIN ProductSales b ON pb.billingId = b.id\r\n"
			+ "LEFT JOIN PaymentsIn pm ON pb.paymentId = pm.id\r\n"
			+ "WHERE p.status = 'ACTIVE'\r\n"
			+ "GROUP BY p.id\r\n"
			+ "ORDER BY p.id ASC")
	public Page<ClientsList_Report> getClientsReportForDatatable(ClientsReportDataFilter clientsReportDataFilter,
			Pageable pageable);
	
	
	
	@Query("SELECT DISTINCT new com.cradletechnologies.resellermis.model.ClientsList_Report(p.id, p.firstName, p.lastName, p.clientname, p.status,  COALESCE(-sum(pm.amountPaid),0)+COALESCE(sum(b.totals),0) )\r\n"
			+ "FROM PaymentBilling pb\r\n"
			+ "LEFT JOIN Clients p ON pb.clientId = p.id\r\n"
			+ "LEFT JOIN ProductSales b ON pb.billingId = b.id\r\n"
			+ "LEFT JOIN PaymentsIn pm ON pb.paymentId = pm.id\r\n"
//			+ "WHERE p.activeStatus = 'ACTIVE'\r\n"
			+ "WHERE p.id = :clientId \r\n"
			+ "GROUP BY p.id\r\n"
			+ "ORDER BY p.id ASC")
	public ClientsList_Report getClientReport(int clientId);
	
//	
//	@Query("SELECT  new com.cradletechnologies.resellermis.model.Billing( pp.id, CONCAT(pp.firstName,' ', pp.lastName),  \r\n"
//			+ "COALESCE(sum(p.amountPaid),0),  \r\n"
//			+ "COALESCE(sum(b.newTransportCharges),0),  \r\n"
//			+ "COALESCE(sum(b.newDiscountAmount),0),  \r\n"
//			+ "COALESCE(sum(b.newBill),0),  \r\n"
////			+ "COALESCE(-sum(p.amountPaid),0)+COALESCE(sum(b.newProduct1Fee),0)+COALESCE(sum(b.newProduct2Fee),0)+COALESCE(sum(b.newProduct3Fee),0)+COALESCE(sum(b.newProduct4Fee),0)+COALESCE(sum(b.newProduct5Fee),0)+COALESCE(sum(b.newProduct6Fee),0)+COALESCE(sum(b.newProduct7Fee),0)+COALESCE(sum(b.newTransportCharges),0)-COALESCE(sum(b.newDiscountAmount),0), \r\n"
//			+ "COALESCE(-sum(p.amountPaid),0)+COALESCE(sum(b.newFeeCharges),0)+COALESCE(sum(b.newTransportCharges),0)-COALESCE(sum(b.newDiscountAmount),0), \r\n"
//			+ "pp.transportRate,  \r\n"
//			+ "pp.discountRate ) \r\n"
//			+ "FROM Pupils pp \r\n"
//			+ "LEFT JOIN PaymentBilling pb ON pp.id = pb.clientId \r\n"
//			+ "LEFT JOIN Billings_3 b ON pb.billingId = b.id \r\n"
//			+ "LEFT JOIN Payments p ON pb.paymentId = p.id \r\n"
//			+ "\r\n"
//			+ "WHERE pp.id= :id \r\n"
//			+ "GROUP by pp.id")
//	public Billing getClientsBillingInfo(@Param("id") int id);	
	

//	@Query("select ID, product, sum(sales),  purchasePrice, vatRateOut, transport, batch, truckId, truckNumber, driver, pack, expectedAmount, markup \r\n"
//			+ "        from\r\n"
//			+ "        (select p.id as ID, p.name as product, pi.quantity as sales, pi.batchDetails as batch, pi.unitPrice as purchasePrice, pi.vatRateOutput as vatRateOut, pi.transportIn+(pi.transportIn*pi.transportVat) as transport, pi.vatAmount as vatamountt, t.id as truckId, t.registrationNo as truckNumber, t.driversName as driver, pi.quantityPack as pack, pi.expectedAmount as expectedAmount, pi.markupAmount as markup \r\n"
//			+ "    from ProductPurchases pi \r\n"
//			+ "    left join Products p on pi.productId = p.id\r\n"
//			+ "    left join Trucks t on pi.truckId = t.id       \r\n"
//			+ "    \r\n"
//			+ "   union all\r\n"
//			+ "   \r\n"
//			+ "  select p.id as ID, p.name as product, -l.quantity as sales,  l.batchDetails as batch, l.unitPrice as unitprice1, l.vatRate as vatrate, '0' as unitprice2, l.vatAmount as vatamount, t.id as truckId, t.registrationNo as truckNumber, t.driversName as driver, l.quantityPack as pack, l.missedAmount as missedAmount, '0' as markup2 \r\n"
//			+ "  from ProductSales l \r\n"
//			+ "  left join Products p on l.productId = p.id\r\n"
//			+ "  left join Trucks t on l.truckId = t.id\r\n"
//			+ "  \r\n"
//			+ ") t\r\n"
//			+ "\r\n"
//			+ "\r\n"
//			+ "group by ID, product, batch, truckNumber\r\n"
//			+ "order by sum(sales) DESC\r\n"
//			+ "")
//	public ProductSalesGuide getPrices();

//	//Wow Just so Wow!!!
//	@Query(
//	        value = "SELECT ID, product, SUM(sales) AS sales, purchasePrice, vatRateOut, " +
//	                "SUM(transport) AS transport, batch, MAX(truckId) AS truckId, " +
//	                "MAX(truckNumber) AS truckNumber, MAX(driver) AS driver, " +
//	                "SUM(pack) AS pack, SUM(expectedAmount) AS expectedAmount, " +
//	                "SUM(markup) AS markup " +
//	                "FROM ( " +
//	                "    SELECT p.id AS ID, p.name AS product, pi.quantity AS sales, pi.batch_Details AS batch, " +
//	                "           pi.unit_Price AS purchasePrice, pi.vat_Rate_Output AS vatRateOut, " +
//	                "           (pi.transport_In + (pi.transport_In * pi.transport_Vat)) AS transport, " +
//	                "           pi.vat_Amount AS vatamountt, t.id AS truckId, " +
//	                "           t.registration_No AS truckNumber, t.drivers_Name AS driver, " +
//	                "           pi.quantity_Pack AS pack, pi.expected_Amount AS expectedAmount, " +
//	                "           pi.markup_Amount AS markup " +
//	                "    FROM Product_Purchases pi " +
//	                "    LEFT JOIN Products p ON pi.product_Id = p.id " +
//	                "    LEFT JOIN Trucks t ON pi.truck_Id = t.id " +
//	                "    " +
//	                "    UNION ALL " +
//	                "    " +
//	                "    SELECT p.id AS ID, p.name AS product, -l.quantity AS sales, " +
//	                "           l.batch_Details AS batch, l.unit_Price AS unitprice1, " +
//	                "           l.vat_Rate AS vatrate, '0' AS unitprice2, " +
//	                "           l.vat_Amount AS vatamount, t.id AS truckId, " +
//	                "           t.registration_No AS truckNumber, t.drivers_Name AS driver, " +
//	                "           l.quantity_Pack AS pack, l.missed_Amount AS missedAmount, '0' AS markup2 " +
//	                "    FROM Product_Sales l " +
//	                "    LEFT JOIN Products p ON l.product_Id = p.id " +
//	                "    LEFT JOIN Trucks t ON l.truck_Id = t.id " +
//	                ") t " +
//	                "GROUP BY ID, product, batch " +
//	                "ORDER BY sales DESC",
//	        nativeQuery = true
//	    )
//	public List<ProductSalesGuide>  getPrices();
//	
//	//Wow Just so Wow!!!
//	@Query(
//		    value = "SELECT ID, product, SUM(sales), purchasePrice, vatRateOut, " +
//		            "SUM(transport), batch, MAX(truckId), " +
//		            "MAX(truckNumber), MAX(driver), " +
//		            "SUM(pack), SUM(expectedAmount), " +
//		            "SUM(markup) " +
//		            "FROM ( " +
//		            "    SELECT p.id AS ID, p.name AS product, pi.quantity AS sales, pi.batch_Details AS batch, " +
//		            "           pi.unit_Price AS purchasePrice, pi.vat_Rate_Output AS vatRateOut, " +
//		            "           (pi.transport_In + (pi.transport_In * pi.transport_Vat)) AS transport, " +
//		            "           pi.vat_Amount AS vatamountt, t.id AS truckId, " +
//		            "           t.registration_No AS truckNumber, t.drivers_Name AS driver, " +
//		            "           pi.quantity_Pack AS pack, pi.expected_Amount AS expectedAmount, " +
//		            "           pi.markup_Amount AS markup " +
//		            "    FROM Product_Purchases pi " +
//		            "    LEFT JOIN Products p ON pi.product_Id = p.id " +
//		            "    LEFT JOIN Trucks t ON pi.truck_Id = t.id " +
//		            "    " +
//		            "    UNION ALL " +
//		            "    " +
//		            "    SELECT p.id AS ID, p.name AS product, -l.quantity AS sales, " +
//		            "           l.batch_Details AS batch, l.unit_Price AS unitprice1, " +
//		            "           l.vat_Rate AS vatrate, '0' AS unitprice2, " +
//		            "           l.vat_Amount AS vatamount, t.id AS truckId, " +
//		            "           t.registration_No AS truckNumber, t.drivers_Name AS driver, " +
//		            "           l.quantity_Pack AS pack, l.missed_Amount AS missedAmount, '0' AS markup2 " +
//		            "    FROM Product_Sales l " +
//		            "    LEFT JOIN Products p ON l.product_Id = p.id " +
//		            "    LEFT JOIN Trucks t ON l.truck_Id = t.id " +
//		            ") t " +
//		            "GROUP BY ID, product, batch " +
//		            "ORDER BY batch DESC",
//		    nativeQuery = true
//		)
//		public Page<ProductSalesGuide> getProductSalesGuideForDatatable(ProductSalesGuideDataFilter clientsReportDataFilter,
//		        Pageable pageable);
//
//
//    @Query(value = "SELECT t.ID, t.product, SUM(t.sales) AS sales, t.purchasePrice, t.vatRateOut, \r\n"
//    		+ "       SUM(t.transport) AS transport, t.batch, MAX(t.truckId) AS truckId, \r\n"
//    		+ "       MAX(t.truckNumber) AS truckNumber, MAX(t.driver) AS driver, \r\n"
//    		+ "       SUM(t.pack) AS pack, SUM(t.expectedAmount) AS expectedAmount, \r\n"
//    		+ "       SUM(t.markup) AS markup \r\n"
//    		+ "FROM ( \r\n"
//    		+ "    SELECT p.id AS ID, p.name AS product, pi.quantity AS sales, pi.batch_details AS batch, \r\n"
//    		+ "           pi.unit_price AS purchasePrice, pi.vat_rate_output AS vatRateOut, \r\n"
//    		+ "           (pi.transport_in + (pi.transport_in * pi.transport_vat)) AS transport, \r\n"
//    		+ "           t.id AS truckId, t.registration_no AS truckNumber, t.drivers_name AS driver, \r\n"
//    		+ "           pi.quantity_pack AS pack, pi.expected_amount AS expectedAmount, \r\n"
//    		+ "           pi.markup_amount AS markup \r\n"
//    		+ "    FROM product_purchases pi \r\n"
//    		+ "    LEFT JOIN products p ON pi.product_id = p.id \r\n"
//    		+ "    LEFT JOIN trucks t ON pi.truck_id = t.id \r\n"
//    		+ "\r\n"
//    		+ "    UNION ALL \r\n"
//    		+ "\r\n"
//    		+ "    SELECT p.id AS ID, p.name AS product, -l.quantity AS sales, \r\n"
//    		+ "           l.batch_details AS batch, l.unit_price AS purchasePrice, \r\n"
//    		+ "           '0' AS vatRateOut, '0' AS transport, t.id AS truckId, \r\n"
//    		+ "           t.registration_no AS truckNumber, t.drivers_name AS driver, \r\n"
//    		+ "           l.quantity_pack AS pack, l.missed_amount AS expectedAmount, '0' AS markup \r\n"
//    		+ "    FROM product_sales l \r\n"
//    		+ "    LEFT JOIN products p ON l.product_id = p.id \r\n"
//    		+ "    LEFT JOIN trucks t ON l.truck_id = t.id \r\n"
//    		+ ") t \r\n"
//    		+ "GROUP BY t.ID, t.product, t.batch \r\n"
//    		+ "ORDER BY t.batch DESC;\r\n"
//    		+ "", nativeQuery = true)
//    Page<ProductSalesGuide> fetchProductSalesGuide(Pageable pageable);

}

