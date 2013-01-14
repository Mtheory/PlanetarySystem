package org.incedofortis.DAO;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.incedofortis.model.Moon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marcin Chojnowski
 */
@Repository // spring
@Transactional
public class MoonDAO
{

    @Autowired
    private SessionFactory sessionFactory;
    static final Logger log = LoggerFactory.getLogger(MoonDAO.class);

    @Transactional
    public List<Moon> findAll()
    {
        List<Moon> moon = sessionFactory.getCurrentSession().createQuery("FROM Moon").list();
        return moon;
    }
    
    

    @Transactional
    public void addMoon(Moon p)
    {
        log.debug("add moon nameL " +  p.getName());
        log.debug("add moon " + p.getPlanet());
        log.debug("add moon planet distance " + p.getPlanet().getDistanceFromTheSun());
        log.debug("add moon planet name" + p.getPlanet().getDescription());
        
        sessionFactory.getCurrentSession().save(p);
    }
     @Transactional
    public void editMoon(Moon p)
    {
        Session currentSession = sessionFactory.getCurrentSession();       
        currentSession.saveOrUpdate(p);
    }
 
    @Transactional
    public Moon get(Long valueOf)
    {
        Moon m =  (Moon) sessionFactory.getCurrentSession().get(Moon.class,valueOf);  
        return m;
    }
     @Transactional
    public List<Moon> getByName(String name)
    {
        List<Moon> m =  (List<Moon>) sessionFactory.getCurrentSession().createQuery("select m from Moon as m where m.name=:me").setParameter("me", name).list();  
        return m;
    }
}
