/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.incedofortis.web;

import java.util.List;
import org.incedofortis.model.Moon;
import org.incedofortis.model.Planet;
import org.incedofortis.service.MoonService;
import org.incedofortis.service.PlanetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Marcin Chojnowski
 */
@Controller
public class MoonController
{

    @Autowired
    private MoonService moonService;
    @Autowired
    private PlanetService planetService;
    static final Logger log = LoggerFactory.getLogger(MoonController.class);

    @Transactional
    @RequestMapping( value = "/addMoon.htm", method = RequestMethod.POST)
    public ModelAndView addMoon(Moon myMoon, Model model, Errors errors)
    {
        String validationResult = validateMoon(myMoon, model, errors);
       
        if (validationResult.length() > 0)
        {
            
            return sendBackToForm(myMoon, validationResult);
        }
        
        moonService.addMoon(myMoon);
        return new ModelAndView("redirect:/allMoons.htm");
    }

    @Transactional
    @RequestMapping( value = "/editMoon.htm", method = RequestMethod.POST)
    public ModelAndView editMoon(Moon myMoon, Errors errors)
    {

        if (errors.hasErrors())
        {

            ModelAndView mav = new ModelAndView("addMoon");
            mav.addObject("errors", errors);
            return mav;
        }



        moonService.editMoon(myMoon);
        return new ModelAndView("redirect:/allMoons.htm");
    }

    @RequestMapping( value = "/addMoon.htm")
    public String addMoon(Model model)
    {
        List<Planet> allPlanets = planetService.findAll();
        model.addAttribute("myMoon", new Moon());
        model.addAttribute("allPlanets", allPlanets);
        return "addMoon";
    }

    @RequestMapping( value = "/editMoon.htm")
    public String editMoon(Long id, Model model)
    {
        Moon moon = moonService.get(id);
        List<Planet> allPlanets = planetService.findAll();
        model.addAttribute("myMoon", moon);
        model.addAttribute("allPlanets", allPlanets);
        return "editMoon";
    }

    @RequestMapping( "/allMoons.htm")
    @Transactional
    public ModelAndView allMoons()
    {

        List<Moon> moons = moonService.findAll();
        ModelAndView mav = new ModelAndView("allMoons");
        mav.addObject("moons", moons);
        return mav;
    }

    /**
     * Helper Methods ******************************************************
     */
    private String validateMoon(Moon myMoon, Model model, Errors errors)
    {
        StringBuilder result = new StringBuilder();

        List<Moon> listM = moonService.getByName(myMoon.getName());
        //name and planet must not be empty
        if (myMoon.getName() == null || myMoon.getName().equals(""))
        {
            result.append("Name  cannot be empty. <br />");

        }

        if (myMoon.getPlanet() == null || myMoon.getPlanet().getDescription() ==
                null || myMoon.getPlanet().getDescription().equals(""))
        {
            myMoon.setPlanet(new Planet());
            result.append("Planet cannot be empty. Select one. <br />");
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
        log.debug("validateMoon ends");
        return result.toString();
    }

    private ModelAndView sendBackToForm(Moon moon, String errors)
    {
        List<Planet> allPlanets = planetService.findAll();
        ModelAndView mav = new ModelAndView("addMoon");
        mav.addObject("myMoon", moon);
        mav.addObject("allPlanets", allPlanets);
        mav.addObject("errors", errors);
        
        return mav;
    }
}
