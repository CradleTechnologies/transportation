package com.cradletechnologies.transportation.filter;

import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.cradletechnologies.transportation.model.Expenses;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ExpensesDataFilter implements Specification<Expenses> {

    String userQuery;

	public ExpensesDataFilter(String queryString) {
		this.userQuery = queryString;
	}

	@Override
	public Predicate toPredicate(Root<Expenses> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		ArrayList<Predicate> predicates = new ArrayList<>();
		if (userQuery != null && userQuery != "") {
            predicates.add(criteriaBuilder.like(root.get("truck").get("registrationNo"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("paidFor"), '%' + userQuery + '%'));
        }
        return (!predicates.isEmpty() ? criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()])) : null);
    }

}
