package edu.kpi.dao;

import edu.kpi.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccTypeDAO extends JpaRepository<AccountType, Integer> {
}
