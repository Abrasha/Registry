package edu.kpi.boot;

import edu.kpi.dao.*;
import edu.kpi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Abrasha on 01-Apr-16.
 */
@Service
public class UserService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    AccTypeDAO accTypeDAO;
    @Autowired
    RegionDAO regionDAO;
    @Autowired
    TownDAO townDAO;
    @Autowired
    PropertyTypeDAO propertyTypeDAO;
    @Autowired
    PropertyDAO propertyDAO;
    @Autowired
    PersonTypeDAO personTypeDAO;
    @Autowired
    PersonDAO personDAO;
    @Autowired
    NotaryTypeDAO notaryTypeDAO;
    @Autowired
    NotaryDAO notaryDAO;
    
    public User addUser(User user) {
        return userDAO.save(user);
    }

    public AccountType addAccountType(AccountType accType) {
        return accTypeDAO.save(accType);
    }
    
    public Region addRegion(Region region){
        return regionDAO.save(region);
    }
    
    public Town addTown(Town town){
        return townDAO.save (town);
    }
    
    public PropertyType addPropertyType (PropertyType prtype){
        return propertyTypeDAO.save(prtype);
    }
   
    public Property addProperty(Property property){
        return propertyDAO.save(property);
    }
    
    public PersonType addPersonType(PersonType ptype ){
        return personTypeDAO.save(ptype);
    }
    
    public Person addPerson(Person person){
        return personDAO.save(person);
    }
    
    public NotaryType addNotaryType(NotaryType ntype){
        return notaryTypeDAO.save(ntype);
    }
    
    public Notary AddNotary(Notary notary){
        return notaryDAO.save(notary);
    }
            
            
}