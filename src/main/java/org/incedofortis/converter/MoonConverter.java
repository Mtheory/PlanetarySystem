/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.incedofortis.converter;

import org.incedofortis.model.Moon;
import org.incedofortis.service.MoonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Marcin Chojnowski
 */
public class MoonConverter implements Converter<String, Moon>
{

    @Autowired
    MoonService service;
    static final Logger log = LoggerFactory.getLogger(MoonConverter.class);

    @Override
    public Moon convert(String id)
    {
        log.debug(" converter string id = " + id);
        if (id == null)
        {
            log.debug("converter empty id");
            return new Moon();
        }
        else
        {
            log.debug("2 else");
            log.debug("findall: " + service.findAll().size());
            Moon get = service.get(Long.valueOf(id));
            log.debug("3.  converter string id = " + get.getId());
            return get;
        }
        
        
    }
}
