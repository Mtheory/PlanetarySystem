/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.incedofortis.service;

import java.util.List;
import org.incedofortis.DAO.PlanetDAO;
import org.incedofortis.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marcin Chojnowski
 */
@Service @Transactional
public class PlanetService
{
    @Autowired 
    PlanetDAO planetDAO;
   
    
    public List<Planet> findAll()
    {
       
        return planetDAO.findAll();
        
    }
    public void addPlanet(Planet p){
        planetDAO.addPlanet(p);
    }

    public Planet get(Long id)
    {
        return planetDAO.get(id);
            
    }
    public List<Planet> getByName(String name)
    {
        return planetDAO.getByName(name);

    }
  
    
}
