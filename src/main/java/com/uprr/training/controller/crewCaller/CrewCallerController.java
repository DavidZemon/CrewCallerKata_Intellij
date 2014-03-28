package com.uprr.training.controller.crewCaller;

import com.uprr.training.pojos.CrewMember;
import com.uprr.training.temp.CrewDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private static final Logger LOG = LoggerFactory.getLogger(CrewCallerController.class);

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
}
