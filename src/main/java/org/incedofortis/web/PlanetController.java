package org.incedofortis.web;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.SessionFactory;
import org.incedofortis.model.Moon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import org.incedofortis.model.Planet;
import org.incedofortis.service.MoonService;
import org.incedofortis.service.PlanetService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

/**
 *
 * @author Marcin Chojnowski
 */
@Controller
public class PlanetController
{

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    PlanetService planetService;
    @Autowired
    MoonService moonService;
    static final Logger log = LoggerFactory.getLogger(PlanetController.class);

    @Transactional
    @RequestMapping( value = "/addPlanet.htm", method = RequestMethod.POST)
    public ModelAndView addPlanet(Planet planet, Model model, Errors errors)
    {

        String validationResult = validatePlanet(planet, model, errors);
        if (validationResult.length() > 0)
        {
            return sendBackToForm(planet, validationResult);
        }
        planetService.addPlanet(planet);
        return new ModelAndView("redirect:/allPlanets.htm");

    }

    @RequestMapping( value = "/addPlanet.htm")
    public String addPlanet()
    {        
        return "addPlanet";
    }

    @RequestMapping( "/allPlanets.htm")
    @Transactional
    public ModelAndView allPlanets()
    {
        List<Planet> planets = planetService.findAll();
        List<Moon> moons = moonService.findAll();


        ModelAndView mav = new ModelAndView("allPlanets");
        mav.addObject("planets", planets);
        mav.addObject("moons", moons);
        return mav;
    }

    /**
     * Helper Methods ******************************************************
     */
    private String validatePlanet(Planet planet1, Model model, Errors errors)
    {
        StringBuilder result = new StringBuilder();

        List<Planet> listM = planetService.getByName(planet1.getDescription());
        //name  must not be empty
        if (planet1.getDescription() == null || planet1.getDescription().equals(
                ""))
        {
            result.append("Name  cannot be empty. <br />");
        }

        //name must not already be used
        if (!listM.isEmpty())
        {
            result.append("This name is already used.<br />");
        }        
        
        if (errors.hasErrors())
        {
            for (ObjectError e : errors.getAllErrors())
            {
                result.append(e.getDefaultMessage());
                result.append("<br />");
            }
        }

        return result.toString();
    }

    private ModelAndView sendBackToForm(Planet planet1, String errors)
    {

        ModelAndView mav = new ModelAndView("addPlanet");
        mav.addObject("errors", errors);
        return mav;
    }
}
