package com.uprr.training.controller.sample;

import com.uprr.training.action.sample.SampleReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping("/get/*")   //browser URL http://localhost:8080/tng/crewCaller/secure/jas/sample/*
//Note: requests must all begin /secure/jas (defined the in the web.xml <url-pattern>)
/**
 * This is the main class handling the all JSON requests for this request map URL.
 * Modify the mapping above to correspond with your application URL, and then add mappings below
 * for any actions supported.
 */
public class CrewCallerController {

    private static final Logger LOG = LoggerFactory.getLogger(CrewCallerController.class);

    /**
     * This method handles requests coming to this server for URL's ending
     * /secure/jas/get/all
     *
     * @return a POJO that will be mapped to become the response JSON data.
     * @see com.uprr.ui.shared.user.spring.mvc.ActiveUserHandlerMethodArgumentResolver
     */
    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    SampleReply sampleRequest() {
        return null;
    }

    /**
     * This method handles requests coming to this server for URL's ending
     * /secure/jas/sample/anotherRequest
     *
     * @param bean   the POJO populated automatically by Spring from the request parameters
     * @param locale the user's Locale, as set in the User's browser settings.
     * @return a POJO that will be mapped to become the response JSON data.
     */
    @RequestMapping(value = "anotherRequest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    String someOtherNonSecuredRequest(@Valid @RequestBody FormBean bean, Locale locale) {
        return null;
    }

}
