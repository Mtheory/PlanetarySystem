/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.incedofortis.DAO;

import java.util.List;
import org.hibernate.SessionFactory;

import org.incedofortis.model.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marcin Chojnowski
 */
@Repository 
@Transactional
public class PlanetDAO
{
    @Autowired
    private SessionFactory sessionFactory;
    static final Logger log = LoggerFactory.getLogger(PlanetDAO.class);
    
    @Transactional
    public List<Planet> findAll()
    {
        
        List<Planet> planet = sessionFactory.getCurrentSession().
		createQuery( "FROM Planet" ).list();
        
        
        
        return planet;
        
    }
    @Transactional
    public void addPlanet(Planet p)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(p);
    }
    @Transactional
    public Planet get(Long id)
    {
        return (Planet) sessionFactory.getCurrentSession().get(Planet.class,id); 
    }
    @Transactional
    public List<Planet> getByName(String name)
    {
        List<Planet> m =  (List<Planet>) sessionFactory.getCurrentSession().createQuery("select p from Planet as p where p.description=:de").setParameter("de", name).list();
        return m;
    }
    
}
