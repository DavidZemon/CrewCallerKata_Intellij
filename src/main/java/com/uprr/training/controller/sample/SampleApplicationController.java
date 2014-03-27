package com.uprr.training.controller.sample;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uprr.training.action.sample.*;
import com.uprr.ui.shared.user.ActiveUserId;
import com.uprr.ui.shared.user.spring.mvc.ActiveUser;

@Controller
@RequestMapping("/sample/*")   //browser URL http://localhost:8080/tng/crewCaller/secure/jas/sample/*
                               //Note: requests must all begin /secure/jas (defined the in the web.xml <url-pattern>)
/**
 * This is the main class handling the all JSON requests for this request map URL.  
 * Modify the mapping above to correspond with your application URL, and then add mappings below
 * for any actions supported.
 */
public class SampleApplicationController {
	
	private static final Logger LOG = LoggerFactory.getLogger(SampleApplicationController.class); 
	
	private SampleApplicationAction applicationAction;

	/**
	 * The Spring configuration files need to provide the proper implementation of this application Action handler. 
	 * @param applicationAction
	 */
	public void setSampleAction(SampleApplicationAction applicationAction) {
		this.applicationAction = applicationAction;
	}


	/**
	 * This method handles requests coming to this server for URL's ending
	 * /secure/jas/sample/sampleRequest
	 * @param locationCirc7, track and yard are parameters passed on the request.   The names specified after the 
	 *  RequestParam (e.g. @RequestParam("locationCirc7") ) define the parameters name on the request. This is optional
	 *  but recommended, as Angular can reorder the parameters which can mess up your mappings. 
	 * 
	 * @param userId the userId of the caller - this is populated from request.getUserPrincipal() set by SiteMinder.  
	 * 	  Alternately, in a testing environment (where the userPrincipal in not set) it is possible to 
	 *    set the request header attribute SMUSER to a specified ID, to test that this tag is functioning. 
	 *    Note: if the user id is not set in either location, the tag will return a UserId of "UNKNOWN" and log an error,
	 *    if an actual UserId is required, the application must trap for the missing ID. 
	 *    @see com.uprr.ui.shared.user.spring.mvc.ActiveUserHandlerMethodArgumentResolver
     *
	 * @return a POJO that will be mapped to become the response JSON data.
	 */
	@RequestMapping(value="sampleRequest", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SampleReply sampleRequest(@RequestParam("locationCirc7") String locationCirc7,
			 @RequestParam("track") Integer track, @RequestParam("yard") Integer yard, @ActiveUser ActiveUserId userId) {
		if (userId.equals(ActiveUserId.UNKNOWN_USER)) {
			LOG.warn("An UNKNOWN user was detected");
		}
		return  applicationAction.doThatCrazyThing(locationCirc7, yard, track, userId);
	}
	
	/**
	 * This method handles requests coming to this server for URL's ending
	 * /secure/jas/sample/anotherRequest
	 * @param formBean the POJO populated automatically by Spring from the request parameters
	 * @param locale the user's Locale, as set in the User's browser settings.
	 * @return a POJO that will be mapped to become the response JSON data.
	 */
	@RequestMapping(value="anotherRequest", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String someOtherNonSecuredRequest(@Valid @RequestBody FormBean bean, Locale locale) {
		return  applicationAction.doSomeOtherThing(bean.getTrainSymbol(), bean.getTrainDate(), bean.getDepartTime());
	}  

}
