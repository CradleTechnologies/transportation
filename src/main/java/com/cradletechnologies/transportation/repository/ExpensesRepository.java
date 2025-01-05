package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cradletechnologies.transportation.model.Expenses;

public interface ExpensesRepository extends JpaRepository<Expenses, Integer> , JpaSpecificationExecutor<Expenses>{


}
