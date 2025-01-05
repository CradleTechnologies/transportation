package com.cradletechnologies.transportation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cradletechnologies.transportation.filter.TrucksReportDataFilter;
import com.cradletechnologies.transportation.model.TransportExpenses;
import com.cradletechnologies.transportation.model.TrucksList_Report;

public interface TransportExpensesRepository  extends JpaRepository<TransportExpenses, Integer>, JpaSpecificationExecutor<TransportExpenses>{


	@Modifying
    @Query(
            value = "truncate table transport_expenses",
            nativeQuery = true
    )
    void truncateTransportExpenses();
	
	@Modifying
    @Query(
            value = "INSERT INTO \r\n"
            		+ "transport_expenses  \r\n"
            		+ "(record_date, truck_id, transport_id, expense_id, amount) \r\n"
            		+ "SELECT transport_date, truck_id, id, '0', transport_charges\r\n"
            		+ "FROM transportations ;\r\n"
            		+ " ",
            nativeQuery = true
    )
    void fillTransportExpenses_Transportations();
	
	@Modifying
    @Query(
            value = "INSERT INTO \r\n"
            		+ "transport_expenses  \r\n"
            		+ "(record_date, truck_id, transport_id, expense_id, amount)\r\n"
            		+ "SELECT expense_date, truck_id, '0', id, -amount_paid \r\n"
            		+ "FROM expenses ;\r\n"
            		+ " ",
            nativeQuery = true
    )
    void fillTransportExpenses_Expenses();
	
	
	//Reports
	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.TrucksList_Report(t.id, t.registrationNo, t.staff.staffName, t.capacity, t.status,  COALESCE(sum(tr.transportCharges),0)-COALESCE(sum(e.amountPaid),0) ) \r\n"
			+ "FROM TransportExpenses te \r\n"
			+ "LEFT JOIN Trucks t ON te.truckId = t.id \r\n"
			+ "LEFT JOIN Transportations tr ON te.transportId = tr.id \r\n"
			+ "LEFT JOIN Expenses e ON te.expenseId = e.id \r\n"
			+ "WHERE t.status = 'ACTIVE' \r\n"
			+ "GROUP BY t.id \r\n"
			+ "ORDER BY t.id ASC")
	public List<TrucksList_Report> getTrucksListReport();
	

	@Query("SELECT COUNT(t.id) \r\n"
			+ "FROM Trucks t \r\n")
//			+ "WHERE t.status = 'ACTIVE' \r\n")
	public int getAvailableTrucksCount();
	
//	
//	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.TrucksList_Report(c.id, c.firstName, c.lastName, c.truckName, c.status,  COALESCE(-sum(pm.amountPaid),0)+COALESCE(sum(t.transportCharges),0)-COALESCE(sum(ci.amount),0)+COALESCE(sum(co.amount),0) ) \r\n"
//			+ "FROM TransportExpenses pb \r\n"
//			+ "LEFT JOIN Trucks c ON pb.truckId = c.id \r\n"
//			+ "LEFT JOIN Transportations t ON pb.transportationId = t.id \r\n"
//			+ "LEFT JOIN Payments pm ON pb.paymentId = pm.id \r\n"
//			+ "WHERE c.status = 'ACTIVE' \r\n"
//			+ "GROUP BY c.id \r\n"
//			+ "ORDER BY c.id ASC")
//	public TrucksList_Report getTruckReport(int truckId);
//
//	
//	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.Transportation( date(pb.recordDate), c.truckName, COALESCE(sum(p.amountPaid),0), COALESCE(sum(b.transportCharges),0),  COALESCE(sum(p.amountPaid),0) - COALESCE(sum(b.transportCharges),0) + COALESCE(sum(ci.amount),0) - COALESCE(sum(co.amount),0) ) \r\n"			
//			+ "FROM TransportExpenses pb  \r\n"
//			+ "LEFT JOIN Transportations b ON pb.transportationId = b.id \r\n"
//			+ "LEFT JOIN Payments p ON pb.paymentId = p.id \r\n"
//			+ "LEFT JOIN Trucks c ON pb.truckId = c.id \r\n"
//			+ "WHERE pb.truckId = :id")
//			
//	public Transportation findTransportExpense(@Param("id") String id);
//	
//
//
	@Query("SELECT DISTINCT new com.cradletechnologies.transportation.model.TrucksList_Report(t.id, t.registrationNo, t.staff.staffName, t.capacity, t.status,  COALESCE(sum(tr.transportCharges),0)-COALESCE(sum(e.amountPaid),0) ) \r\n"
			+ "FROM TransportExpenses te \r\n"
			+ "LEFT JOIN Trucks t ON te.truckId = t.id \r\n"
			+ "LEFT JOIN Transportations tr ON te.transportId = tr.id \r\n"
			+ "LEFT JOIN Expenses e ON te.expenseId = e.id \r\n"
			+ "GROUP BY t.id \r\n"
			+ "ORDER BY t.id ASC")
	public Page<TrucksList_Report> getTrucksReportForDatatable(TrucksReportDataFilter trucksReportDataFilter,
			Pageable pageable);
	

}

