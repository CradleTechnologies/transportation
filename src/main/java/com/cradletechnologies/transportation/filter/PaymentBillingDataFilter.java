package com.cradletechnologies.transportation.filter;

import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.cradletechnologies.transportation.model.PaymentBilling;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class PaymentBillingDataFilter implements Specification<PaymentBilling> {

    String userQuery;

	public PaymentBillingDataFilter(String queryString) {
		this.userQuery = queryString;
	}

	@Override
	public Predicate toPredicate(Root<PaymentBilling> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		ArrayList<Predicate> predicates = new ArrayList<>();
		if (userQuery != null && userQuery != "") {
            predicates.add(criteriaBuilder.like(root.get("clients").get("clientName"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("paymentId"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("transportationId"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("cashInId"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("cashOutId"), '%' + userQuery + '%'));
        }
        return (!predicates.isEmpty() ? criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()])) : null);
    }

}

