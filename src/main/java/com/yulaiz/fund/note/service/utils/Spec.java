package com.yulaiz.fund.note.service.utils;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public interface Spec<T> extends Specification<T> {

    @Override
    default Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        addPredicate(root, predicates, criteriaBuilder);
        return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
    }

    @Nullable
    void addPredicate(Root<T> root, List<Predicate> predicates, CriteriaBuilder criteriaBuilder);
}
