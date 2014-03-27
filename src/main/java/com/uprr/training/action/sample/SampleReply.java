package com.uprr.training.action.sample;

import java.util.List;

import com.uprr.netcontrol.shared.components.datetime.NCDateTime;
import com.uprr.ui.shared.user.ActiveUserId;

/**
 * This is an example of a POJO that is returned from the Sample Application.
 * It uses several types of variables to demonstrate the JSON mapping process.  
 * @author Steven A. Wicklund
 *
 */
public class SampleReply {
    private String ping;
    private int count;
    private NCDateTime when;  //note: this NCDateTime variable will use a custom JSON mapping  
    private boolean springAmazing;
    private ActiveUserId userId;
    private List<SpringFact> springFacts;
    private String employeeId;
    
    public String getPing() {
        return ping;
    }
    public void setPing(String ping) {
        this.ping = ping;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public NCDateTime getWhen() {
        return when;
    }
    public void setWhen(NCDateTime when) {
        this.when = when;
    }
    public boolean isSpringAmazing() {
        return springAmazing;
    }
    public void setSpringAmazing(boolean springAmazing) {
        this.springAmazing = springAmazing;
    }
    public List<SpringFact> getSpringFacts() {
        return springFacts;
    }
    public void setSpringFacts(List<SpringFact> springIs) {
        this.springFacts = springIs;
    }
    public ActiveUserId getUserId() {
        return userId;
    }
    public void setUserId(ActiveUserId userId) {
        this.userId = userId;
    }
    
    public String getEmployeeId() {
        return userId.getEmployeeId();
    }
    
}
