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
            value = "truncate table payment_transportation",
            nativeQuery = true
    )
    void truncatePaymentBilling();
	
	@Modifying
    @Query(
            value = "INSERT INTO \r\n"
            		+ "payment_transportation  \r\n"
            		+ "(record_date, client_id, payment_id, transportation_id, amount) \r\n"
            		+ "SELECT payment_date, client_id, id, '0', amount_paid\r\n"
            		+ "FROM payments ;\r\n"
            		+ " ",
            nativeQuery = true
    )
    void fillPaymentBilling_Payments();
	
	@Modifying
    @Query(
            value = "INSERT INTO \r\n"
            		+ "payment_transportation  \r\n"
            		+ "(record_date, client_id, payment_id, transportation_id, amount)\r\n"
            		+ "SELECT transport_date, client_id, '0', id, -transport_charges \r\n"
            		+ "FROM transportations ;\r\n"
            		+ " ",
            nativeQuery = true
    )
    void fillPaymentBilling_Billing();
	
	
	
	//Reports
	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.ClientsList_Report(c.id, c.firstName, c.lastName, c.clientName, c.status,  COALESCE(-sum(pm.amountPaid),0)+COALESCE(sum(t.transportCharges),0) ) \r\n"
			+ "FROM PaymentBilling pb \r\n"
			+ "LEFT JOIN Clients c ON pb.clientId.id = c.id \r\n"
			+ "LEFT JOIN Transportations t ON pb.transportationId.id = t.id \r\n"
			+ "LEFT JOIN Payments pm ON pb.paymentId.id = pm.id \r\n"
			+ "WHERE c.status = 'ACTIVE' \r\n"
			+ "GROUP BY c.id \r\n"
			+ "ORDER BY c.id ASC")
	public List<ClientsList_Report> getClientsListReport();
	

	@Query("SELECT COUNT(p.id) \r\n"
			+ "FROM Clients p \r\n"
			+ "WHERE p.status = 'ACTIVE' \r\n")
	public int getClientsCount();
	
	
//	@Query("SELECT COALESCE(SUM(pm.amountPaid),0) \r\n"
//			+ "FROM PaymentBilling pb \r\n"
//			+ "LEFT JOIN Payments pm ON pb.paymentId = pm.id \r\n")
//	public Double getTotalRevenue();
//	
//	
//	@Query("SELECT COALESCE(SUM(t.transportation_charges),0) \r\n"
//			+ "FROM PaymentBilling pb \r\n"
//			+ "LEFT JOIN Transportations t ON pb.transportationId = t.id \r\n")
//	public Double getTotalInvoices();
	
	

	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.ClientsList_Report(c.id, c.firstName, c.lastName, c.clientName, c.status,  COALESCE(-sum(pm.amountPaid),0)+COALESCE(sum(t.transportCharges),0) ) \r\n"
			+ "FROM PaymentBilling pb \r\n"
			+ "LEFT JOIN Clients c ON pb.clientId.id = c.id \r\n"
			+ "LEFT JOIN Transportations t ON pb.transportationId.id = t.id \r\n"
			+ "LEFT JOIN Payments pm ON pb.paymentId.id = pm.id \r\n"
			+ "WHERE c.status = 'ACTIVE' \r\n"
			+ "GROUP BY c.id \r\n"
			+ "ORDER BY c.id ASC")
	public Page<ClientsList_Report> getClientsReportForDatatable(ClientsReportDataFilter clientsReportDataFilter,
			Pageable pageable);
	
	
	
	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.ClientsList_Report(c.id, c.firstName, c.lastName, c.clientName, c.status,  COALESCE(-sum(pm.amountPaid),0)+COALESCE(sum(t.transportCharges),0) ) \r\n"
			+ "FROM PaymentBilling pb \r\n"
			+ "LEFT JOIN Clients c ON pb.clientId.id = c.id \r\n"
			+ "LEFT JOIN Transportations t ON pb.transportationId.id = t.id \r\n"
			+ "LEFT JOIN Payments pm ON pb.paymentId.id = pm.id \r\n"
			+ "WHERE c.status = 'ACTIVE' \r\n"
			+ "GROUP BY c.id \r\n"
			+ "ORDER BY c.id ASC")
	public ClientsList_Report getClientReport(int clientId);


}

