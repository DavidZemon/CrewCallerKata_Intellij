package com.uprr.training.controller.crewCaller;

import com.uprr.training.dao.CrewDao;
import com.uprr.training.pojos.CrewMember;
import org.joda.time.LocalDate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * browser URL http://localhost:8080/crewCaller/secure/jas/get/*
 */
@Controller
@RequestMapping("/get/*")
class CrewCallerController {
    @Inject
    private CrewDao crewDao;

    /**
     * This method handles requests coming to this server for URL's ending
     * /secure/jas/get/all
     *
     * @return a POJO that will be mapped to become the response JSON data.
     */
    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CrewMember> getAllCrew() {
        return this.crewDao.getAllCrew();
    }

    /**
     * Return crew available on a given date
     *
     * @param date Date requested for the crew
     * @return List of crew members available on that date; Null if none are available
     */
    @RequestMapping(value = "date", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CrewMember> getCrewForDate(@RequestParam("date") long date) {
        return this.crewDao.getCrewForDate(new LocalDate(date));
    }
}
