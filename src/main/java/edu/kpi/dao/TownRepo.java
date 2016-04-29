/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kpi.dao;

import edu.kpi.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Hmelmin
 */
@Repository
public interface TownRepo extends JpaRepository<Town, Integer>{

    List<Town> findByRegion_Name(String name);

}