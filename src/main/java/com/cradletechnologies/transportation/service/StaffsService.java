package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.Staffs;

public interface StaffsService {

	List<Staffs> getAllStaffs();
	
	Staffs saveStaff(Staffs staff);
	
	Staffs getStaff(int id);
	
	void deleteStaff(int id);
	
	Page<Staffs> getStaffsForDatatable(String queryString, Pageable pageable);
}
