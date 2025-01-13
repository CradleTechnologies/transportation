package com.cradletechnologies.transportation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cradletechnologies.transportation.filter.ClientsReportDataFilter;
import com.cradletechnologies.transportation.model.ClientsList_Report;
import com.cradletechnologies.transportation.model.PaymentBilling;
import com.cradletechnologies.transportation.model.Transportation;
import com.cradletechnologies.transportation.model.TrucksList_Report;

public interface PaymentBillingRepository
		extends JpaRepository<PaymentBilling, Integer>, JpaSpecificationExecutor<PaymentBilling> {

	@Modifying
	@Query(value = "truncate table payment_transportation", nativeQuery = true)
	void truncatePaymentBilling();

	@Modifying
	@Query(value = "INSERT INTO \r\n" + "payment_transportation  \r\n"
			+ "(record_date, client_id, payment_id, transportation_id, cash_in_id, cash_out_id, amount) \r\n"
			+ "SELECT payment_date, client_id, id, '0', '0', '0', amount_paid\r\n" 
			+ "FROM payments ;\r\n"
			+ " ", nativeQuery = true)
	void fillPaymentBilling_Payments();

	@Modifying
	@Query(value = "INSERT INTO \r\n" + "payment_transportation  \r\n"
			+ "(record_date, client_id, payment_id, transportation_id, cash_in_id, cash_out_id, amount)\r\n"
			+ "SELECT transport_date, client_id, '0', id, '0', '0', -transport_charges \r\n"
			+ "FROM transportations ;\r\n" 
			+ " ", nativeQuery = true)
	void fillPaymentBilling_Billing();

	@Modifying
	@Query(value = "INSERT INTO \r\n" + "payment_transportation  \r\n"
			+ "(record_date, client_id, payment_id, transportation_id, cash_in_id, cash_out_id, amount)\r\n"
			+ "SELECT record_date, client_id, '0', '0', id, '0', amount \r\n" 
			+ "FROM cash_in ;\r\n"
			+ " ", nativeQuery = true)
	void fillPaymentBilling_CashIn();

	@Modifying
	@Query(value = "INSERT INTO \r\n" + "payment_transportation  \r\n"
			+ "(record_date, client_id, payment_id, transportation_id, cash_in_id, cash_out_id, amount)\r\n"
			+ "SELECT record_date, client_id, '0', '0', '0', id, -amount \r\n" 
			+ "FROM cash_out ;\r\n"
			+ " ", nativeQuery = true)
	void fillPaymentBilling_CashOut();

	// Client Balances Report
	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.ClientsList_Report(c.id, date(pb.recordDate), c.firstName, c.lastName, c.clientName, c.telNo, a.areaName, COALESCE(sum(t.transportCharges),0), COALESCE(-sum(pm.amountPaid),0), -COALESCE(sum(ci.amount),0), COALESCE(sum(co.amount),0), c.status,  COALESCE(-sum(pm.amountPaid),0)+COALESCE(sum(t.transportCharges),0)-COALESCE(sum(ci.amount),0)+COALESCE(sum(co.amount),0) ) \r\n"
			+ "FROM PaymentBilling pb \r\n" 
			+ "LEFT JOIN Clients c ON pb.clientId = c.id \r\n"
			+ "LEFT JOIN Transportations t ON pb.transportationId = t.id \r\n"
			+ "LEFT JOIN Payments pm ON pb.paymentId = pm.id \r\n" 
			+ "LEFT JOIN CashIn ci ON pb.cashInId = ci.id \r\n"
			+ "LEFT JOIN CashOut co ON pb.cashOutId = co.id \r\n" 
			+ "LEFT JOIN Areas a ON c.area.id = a.id \r\n" 
			+ "WHERE c.status = 'ACTIVE' \r\n"
			+ "GROUP BY c.id \r\n" 
			+ "ORDER BY c.id ASC")
	public List<ClientsList_Report> getClientsListReport();
	
	// Trucks Performance Report
	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.TrucksList_Report( t.id, t.registrationNo, s.staffName, t.capacity, COALESCE(sum(tr.transportCharges),0), COALESCE(sum(e.amountPaid),0), t.status, COALESCE(sum(tr.transportCharges),0)-COALESCE(sum(e.amountPaid),0) ) \r\n"
			+"FROM TransportExpenses te \r\n"
			+"LEFT JOIN Trucks t ON te.truckId = t.id \r\n"
			+"LEFT JOIN Transportations tr ON te.transportId = tr.id \r\n"
			+"LEFT JOIN Expenses e ON te.expenseId = e.id \r\n"
			+"LEFT JOIN Staffs s ON t.staff.id = s.id \r\n"
			+"GROUP BY te.truckId \r\n"
			+"ORDER BY te.truckId ASC")
	public List<TrucksList_Report> getTrucksListReport();

	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.ClientsList_Report(c.id, date(pb.recordDate), c.firstName, c.lastName, c.clientName, c.telNo, a.areaName, COALESCE(sum(t.transportCharges),0), COALESCE(-sum(pm.amountPaid),0), -COALESCE(sum(ci.amount),0), COALESCE(sum(co.amount),0), c.status,  COALESCE(-sum(pm.amountPaid),0)+COALESCE(sum(t.transportCharges),0)-COALESCE(sum(ci.amount),0)+COALESCE(sum(co.amount),0) ) \r\n"
			+ "FROM PaymentBilling pb \r\n" 
			+ "LEFT JOIN Clients c ON pb.clientId = c.id \r\n"
			+ "LEFT JOIN Transportations t ON pb.transportationId = t.id \r\n"
			+ "LEFT JOIN Payments pm ON pb.paymentId = pm.id \r\n" 
			+ "LEFT JOIN CashIn ci ON pb.cashInId = ci.id \r\n"
			+ "LEFT JOIN CashOut co ON pb.cashOutId = co.id \r\n" 
			+ "LEFT JOIN Areas a ON c.area.id = a.id \r\n" 
			+ "WHERE c.id = :CLIENT_ID \r\n"
			+ "GROUP BY pb.recordDate \r\n" 
			+ "ORDER BY pb.recordDate ASC")
	List<ClientsList_Report> getClientStatementReport(@Param("CLIENT_ID")int CLIENT_ID);

	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.TrucksList_Report( t.id, date(te.recordDate), t.registrationNo, s.staffName, s.telNo, t.capacity, COALESCE(sum(tr.transportCharges),0), COALESCE(sum(e.amountPaid),0), t.status, COALESCE(sum(tr.transportCharges),0)-COALESCE(sum(e.amountPaid),0) ) \r\n"
			+ "FROM TransportExpenses te \r\n"
			+ "LEFT JOIN Trucks t ON te.truckId = t.id \r\n"
			+ "LEFT JOIN Transportations tr ON te.transportId = tr.id \r\n"
			+ "LEFT JOIN Expenses e ON te.expenseId = e.id \r\n"
			+ "LEFT JOIN Staffs s ON t.staff.id = s.id \r\n"
			+ "WHERE te.truckId = :TRUCK_ID \r\n"
			+ "GROUP BY te.recordDate \r\n"
			+ "ORDER BY te.recordDate ASC")
	List<TrucksList_Report> getTruckPerformanceReport(@Param("TRUCK_ID")int TRUCK_ID);
	

	@Query("SELECT COUNT(p.id) \r\n" + "FROM Clients p \r\n" + "WHERE p.status = 'ACTIVE' \r\n")
	public int getClientsCount();

	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.ClientsList_Report(c.id, c.firstName, c.lastName, c.clientName, c.status,  COALESCE(-sum(pm.amountPaid),0)+COALESCE(sum(t.transportCharges),0)-COALESCE(sum(ci.amount),0)+COALESCE(sum(co.amount),0) ) \r\n"
			+ "FROM PaymentBilling pb \r\n" + "LEFT JOIN Clients c ON pb.clientId = c.id \r\n"
			+ "LEFT JOIN Transportations t ON pb.transportationId = t.id \r\n"
			+ "LEFT JOIN Payments pm ON pb.paymentId = pm.id \r\n" 
			+ "LEFT JOIN CashIn ci ON pb.cashInId = ci.id \r\n"
			+ "LEFT JOIN CashOut co ON pb.cashOutId = co.id \r\n" 
			+ "WHERE c.status = 'ACTIVE' \r\n"
			+ "GROUP BY c.id \r\n" 
			+ "ORDER BY c.id ASC")
	public ClientsList_Report getClientReport(int clientId);

	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.Transportation( date(pb.recordDate), c.clientName, COALESCE(sum(p.amountPaid),0), COALESCE(sum(b.transportCharges),0),  COALESCE(sum(p.amountPaid),0) - COALESCE(sum(b.transportCharges),0) + COALESCE(sum(ci.amount),0) - COALESCE(sum(co.amount),0) ) \r\n"
			+ "FROM PaymentBilling pb  \r\n" 
			+ "LEFT JOIN Transportations b ON pb.transportationId = b.id \r\n"
			+ "LEFT JOIN Payments p ON pb.paymentId = p.id \r\n" 
			+ "LEFT JOIN CashIn ci ON pb.cashInId = ci.id \r\n"
			+ "LEFT JOIN CashOut co ON pb.cashOutId = co.id \r\n" 
			+ "LEFT JOIN Clients c ON pb.clientId = c.id \r\n"
			+ "WHERE pb.clientId = :id")

	public Transportation findPaymentBilling(@Param("id") String id);

	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.ClientsList_Report(c.id, c.firstName, c.lastName, c.clientName, COALESCE(sum(t.transportCharges),0), COALESCE(-sum(pm.amountPaid),0), -COALESCE(sum(ci.amount),0), COALESCE(sum(co.amount),0), c.status,  COALESCE(-sum(pm.amountPaid),0)+COALESCE(sum(t.transportCharges),0)-COALESCE(sum(ci.amount),0)+COALESCE(sum(co.amount),0) ) \r\n"
			+ "FROM PaymentBilling pb \r\n" + "LEFT JOIN Clients c ON pb.clientId = c.id \r\n"
			+ "LEFT JOIN Transportations t ON pb.transportationId = t.id \r\n"
			+ "LEFT JOIN Payments pm ON pb.paymentId = pm.id \r\n" 
			+ "LEFT JOIN CashIn ci ON pb.cashInId = ci.id \r\n"
			+ "LEFT JOIN CashOut co ON pb.cashOutId = co.id \r\n" 
//			+ "WHERE c.status = 'ACTIVE' \r\n"
			+ "GROUP BY c.id \r\n" 
			+ "ORDER BY c.id ASC")
	public Page<ClientsList_Report> getClientsReportForDatatable(ClientsReportDataFilter clientsReportDataFilter,
			Pageable pageable);
	
}
