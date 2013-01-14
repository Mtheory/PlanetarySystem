/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.incedofortis.converter;

import org.incedofortis.model.Planet;
import org.incedofortis.service.PlanetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Marcin Chojnowski
 */
public class PlanetConverter implements Converter<String, Planet>
{

    @Autowired
    PlanetService service;
    static final Logger log = LoggerFactory.getLogger(PlanetConverter.class);

    @Override
    public Planet convert(String id)
    {
      
        if (id == null)
        {           
            return new Planet();
        }
        else
        {
            log.debug("Planet converter 2 else");
            log.debug("Planet converter findall: " + service.findAll().size());
            Planet get = service.get(Long.valueOf(id));
            log.debug("3. Planet converter string id = " + get.getId());
            return get;
        }

    }
}
