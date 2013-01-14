/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.incedofortis.service;

import java.util.ArrayList;
import java.util.List;
import org.incedofortis.DAO.MoonDAO;
import org.incedofortis.model.Moon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marcin Chojnowski
 */
@Service
@Transactional
public class MoonService
{

    @Autowired
    MoonDAO moonDAO;
    static final Logger log = LoggerFactory.getLogger(MoonDAO.class);

    public List<Moon> findAll()
    {
        return moonDAO.findAll();

    }

    public List<Moon> findAll(Long planetId)
    {
        List<Moon> moons = moonDAO.findAll();
        List<Moon> resultList = new ArrayList<Moon>();
        for (Moon m : moons)
        {
            if (m.getPlanet().getId().equals(planetId))
            {
                resultList.add(m);
            } else {}

        }
        return resultList;

    }

    public void addMoon(Moon p)
    {
        moonDAO.addMoon(p);
    }
    public void editMoon(Moon p)
    {
        moonDAO.editMoon(p);
    }

    public Moon get(Long id)
    {
        return moonDAO.get(id);



    }
    public List<Moon> getByName(String name)
    {
        return moonDAO.getByName(name);

    }
}
