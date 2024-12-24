package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.filter.StaffsDataFilter;
import com.cradletechnologies.transportation.model.Staffs;
import com.cradletechnologies.transportation.repository.StaffsRepository;
import com.cradletechnologies.transportation.service.StaffsService;

@Service
public class StaffsServiceImpl implements StaffsService {

	@Autowired
	private StaffsRepository staffsRepository;

	@Override
	public List<Staffs> getAllStaffs() {		
		return this.staffsRepository.findAll();
	}

	@Override
	public Staffs saveStaff(Staffs staff) {
		return this.staffsRepository.save(staff);
		
	}

	@Override
	public Staffs getStaff(int id) {
		Optional<Staffs> optional = staffsRepository.findById(id);
		Staffs staff = null;
		if(optional.isPresent()) {
			staff = optional.get();
		}
		else {
			throw new RuntimeException("Staff not found for id : "+id);
		}
		return staff;
	}

	@Override
	public void deleteStaff(int id) {
		this.staffsRepository.deleteById(id);
		
	}

	@Override
	public Page<Staffs> getStaffsForDatatable(String queryString, Pageable pageable) {
		StaffsDataFilter staffsDataFilter = new StaffsDataFilter(queryString);
		return staffsRepository.findAll(staffsDataFilter, pageable);
	}
	
	
}

