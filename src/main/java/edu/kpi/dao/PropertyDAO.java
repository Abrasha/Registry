/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kpi.dao;
import edu.kpi.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hmelmin
 */
@Repository
public interface PropertyDAO extends JpaRepository<Property, Integer>{
    
}
