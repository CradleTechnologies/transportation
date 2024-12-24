package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.PayBoxes;

public interface PayBoxesService {
	
	List<PayBoxes> getAllPayBoxes();
	
	PayBoxes savePayBox(PayBoxes payBox);
	
	PayBoxes getPayBox(int id);
	
	void deletePayBox(int id);
	
	Page<PayBoxes> getPayBoxesForDatatable(String queryString, Pageable pageable);

}
