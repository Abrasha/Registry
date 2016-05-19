package edu.kpi.repo;


import edu.kpi.model.Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegistryRepo extends JpaRepository<Registry, Integer> {

    List<Registry> findByDate(LocalDate date);

    List<Registry> findByPrincipalId(Integer id);

    Registry findOneBySeriesAndNumber(String series, Integer number);

}
