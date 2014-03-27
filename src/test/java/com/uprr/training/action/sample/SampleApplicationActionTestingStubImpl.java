package com.uprr.training.action.sample;

import java.util.ArrayList;
import java.util.List;

import com.uprr.netcontrol.shared.components.datetime.NCDate;
import com.uprr.netcontrol.shared.components.datetime.NCDateTime;
import com.uprr.netcontrol.shared.components.datetime.NCDateTimeFactory;
import com.uprr.netcontrol.shared.components.datetime.NCTimeZoneEnum;
import com.uprr.ui.shared.user.ActiveUserId;

/**
 * A stub implementation of the action class that will be used for testing.
 * @author Steven A. Wicklund
 */
public class SampleApplicationActionTestingStubImpl implements SampleApplicationAction {

	@Override
	public SampleReply doThatCrazyThing(String locationCirc7, Integer yard,
			Integer track, ActiveUserId userId) {
		SampleReply reply = new SampleReply();
		reply.setCount(42);
		reply.setPing("Pong");
		reply.setSpringAmazing(true);
		reply.setWhen(NCDateTimeFactory.createDateTime("2013-12-11T10:09:08Z"));
		reply.setUserId(userId);
		List<SpringFact> facts = new ArrayList<SpringFact>();
		facts.add(new SpringFact("testable", true));
		facts.add(new SpringFact("clear", true));
		facts.add(new SpringFact("fails fast", true));
		facts.add(new SpringFact("easy", false));
		reply.setSpringFacts(facts);
		return reply;
	}

	@Override
	public String doSomeOtherThing(String trainSymbol, NCDate trainDate,
			NCDateTime departTime) {
		return "Read from JSON: JavaBean {trainDate=["+trainDate.getMonth().getMonthNumber()+"/"+trainDate.getDayOfMonth()+"/"+trainDate.getYear()+"]," +
				" departTime=["+departTime.formatLocalTime("HH:mm:ss", NCTimeZoneEnum.US_CENTRAL)+" CENTRAL] trainSymbol=["+trainSymbol+"]}";
	}

}
