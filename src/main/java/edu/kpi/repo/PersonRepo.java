/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kpi.repo;

import edu.kpi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hmelmin
 */
@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    Person findOnByCode(String code);

}
