package com.uprr.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * This class loads the application context for testing.
 * For simplicity, it will by default use development configuration settings, if they are not already set.
 *
 * @author Steven A. Wicklund
 */
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public abstract class AbstractContextControllerTests {
    static {
        String env = System.getProperty("uprr.implementation.environment");
        if (env == null || env.trim().equals("")) {
            System.setProperty("uprr.implementation.environment", "dev");
        }
        String jbossName = System.getProperty("jbs.name");
        if (jbossName == null || jbossName.trim().equals("")) {
            System.setProperty("jbs.name", "localhost");
        }
    }

    @Autowired
    protected WebApplicationContext wac;

}
