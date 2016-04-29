package edu.kpi.dao;


import edu.kpi.model.Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegistryRepo extends JpaRepository<Registry, Integer> {

    List<Registry> findByDate(LocalDate date);
    Registry findOneBySeriesAndNumber(String series, Integer number);

}
