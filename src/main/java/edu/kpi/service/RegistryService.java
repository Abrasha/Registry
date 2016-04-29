package edu.kpi.service;

import edu.kpi.dao.RegistryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Abrasha on 29-Apr-16.
 */
@Service
public class RegistryService {

    @Autowired
    private RegistryRepo registryRepo;


    private void testRegistryInsertion() {

    }

}
