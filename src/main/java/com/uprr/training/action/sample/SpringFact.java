package com.uprr.training.action.sample;

/**
 * Another POJO used in the reply.  This on to demonstrate list serialization.
 * @author Steven A. Wicklund
 *
 */
public class SpringFact {
	private String factName;
	private boolean fact;
	
	public SpringFact(String factName, boolean isThatAFact) {
		this.factName= factName;
		fact = isThatAFact;
	}
	
	public String getFactName() {
		return factName;
	}
	public void setFactName(String factName) {
		this.factName = factName;
	}
	public boolean isFact() {
		return fact;
	}
	public void setFact(boolean fact) {
		this.fact = fact;
	}
}
