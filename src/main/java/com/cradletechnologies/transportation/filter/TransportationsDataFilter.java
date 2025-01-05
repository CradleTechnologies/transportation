package com.cradletechnologies.transportation.filter;

import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.cradletechnologies.transportation.model.Transportations;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class TransportationsDataFilter implements Specification<Transportations> {

	String userQuery;
	
	public TransportationsDataFilter(String queryString) {
		this.userQuery = queryString;
	}
	
	@Override
	public Predicate toPredicate(Root<Transportations> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		ArrayList<Predicate> predicates = new ArrayList<>();
		if(userQuery!=null && userQuery!="") {
			predicates.add(criteriaBuilder.like(root.get("truck").get("registrationNo"), '%'+userQuery+'%'));
			predicates.add(criteriaBuilder.like(root.get("client").get("clientName"), '%'+userQuery+'%'));
			predicates.add(criteriaBuilder.like(root.get("area").get("areaName"), '%'+userQuery+'%'));
		}
		return(!predicates.isEmpty()?criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()])):null);
	}

	

}
