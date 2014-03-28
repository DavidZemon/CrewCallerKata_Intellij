package com.uprr.training.controller.crewCaller;

import com.uprr.training.pojos.CrewMember;
import com.uprr.training.temp.CrewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/get/*")   //browser URL http://localhost:8080/tng/crewCaller/secure/jas/get/*
//Note: requests must all begin /secure/jas (defined the in the web.xml <url-pattern>)
/**
 * This is the main class handling the all JSON requests for this request map URL.
 * Modify the mapping above to correspond with your application URL, and then add mappings below
 * for any actions supported.
 */
public class CrewCallerController {
    @Autowired
    private CrewDao crewDao;

    /**
     * This method handles requests coming to this server for URL's ending
     * /secure/jas/get/all
     *
     * @return a POJO that will be mapped to become the response JSON data.
     */
    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    List<CrewMember> getAllCrew() {
        return crewDao.getAllCrew();
    }

    /**
     * Return crew available on a given date
     *
     * @param date Date requested for the crew
     * @return List of crew members available on that date; Null if none are available
     */
    @RequestMapping(value = "date/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    List<CrewMember> getCrewForDate(@PathVariable("date") Date date) {
        return crewDao.getCrewForDate(date);
    }
}
