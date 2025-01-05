package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.Expenses;

public interface ExpensesService {

	List<Expenses> getAllExpenses();
	
	Expenses saveExpense(Expenses expense);
	
	Expenses getExpense(int id);
	
	void deleteExpense(int id);
	
	Page<Expenses> getExpensesForDatatable(String queryString, Pageable pageable);
}
