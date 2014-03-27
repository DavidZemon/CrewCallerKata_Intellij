package com.uprr.training.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uprr.netcontrol.shared.components.datetime.jackson2.serialization.NCDateTimeCoreModule2;
import com.uprr.ui.shared.user.jackson2.serialization.ActiveUserIdCoreModule2;

/**
 * This class is used to register custom JSON/Jackson mapping modules.  
 * Specifically, in this application, there is custom logic for transforming NCDateTime objects.  
 * @author Steven A. Wicklund
 */
public class SpringMVCJacksonObjectMapper extends ObjectMapper  {
	public SpringMVCJacksonObjectMapper() {
		super();
		this.registerModule(new NCDateTimeCoreModule2());
		this.registerModule(new ActiveUserIdCoreModule2());
	}

}
