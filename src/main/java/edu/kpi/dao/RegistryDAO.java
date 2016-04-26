package edu.kpi.dao;


import edu.kpi.model.Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistryDAO extends JpaRepository<Registry, Integer> {
}
