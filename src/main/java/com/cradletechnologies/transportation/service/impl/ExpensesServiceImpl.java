package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.exception.ResourceNotFoundException;
import com.cradletechnologies.transportation.filter.ExpensesDataFilter;
import com.cradletechnologies.transportation.model.Expenses;
import com.cradletechnologies.transportation.repository.ExpensesRepository;
import com.cradletechnologies.transportation.service.ExpensesService;

@Service
public class ExpensesServiceImpl implements ExpensesService{

	private ExpensesRepository expensesRepository;
	public ExpensesServiceImpl(ExpensesRepository expensesRepository) {
		super();
		this.expensesRepository = expensesRepository;
	}
	
	
	@Override
	public List<Expenses> getAllExpenses() {
		return this.expensesRepository.findAll();
	}
	
	
	@Override
	public Expenses saveExpense(Expenses expense) {
		return this.expensesRepository.save(expense);
	}
	
	
	@Override
	public Expenses getExpense(int id) {
		Optional<Expenses> optional = expensesRepository.findById(id);
        Expenses expense = null;
        if (optional.isPresent()) {
            expense = optional.get();
        } else {
            throw new RuntimeException("Expense not found for id : " + id);
        }
        return expense;
    }
	
	
	@Override
	public void deleteExpense(int id) {
		expensesRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Expense does not exist in the db with the id : ", "Id", id));
		expensesRepository.deleteById(id);
		
	}
	
	
	@Override
	public Page<Expenses> getExpensesForDatatable(String queryString, Pageable pageable) {
		ExpensesDataFilter expensesDataFilter = new ExpensesDataFilter(queryString);
		return expensesRepository.findAll(expensesDataFilter, pageable);
	}

}
