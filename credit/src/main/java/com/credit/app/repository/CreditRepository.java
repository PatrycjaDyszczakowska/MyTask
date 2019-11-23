package com.credit.app.repository;

import com.credit.app.model.Credit;
import org.springframework.data.repository.CrudRepository;

public interface CreditRepository extends CrudRepository<Credit, Integer> {
}
