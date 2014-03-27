package com.uprr.training.action.sample;

import com.uprr.netcontrol.shared.components.datetime.NCDate;
import com.uprr.netcontrol.shared.components.datetime.NCDateTime;
import com.uprr.netcontrol.shared.components.datetime.NCDateTimeFactory;
import com.uprr.ui.shared.user.ActiveUserId;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an implementation of the defined Application Action interface.
 * It should be Spring injected into a controller
 *
 * @author Steven A. Wicklund
 */
public class SampleApplicationActionImpl implements SampleApplicationAction {

    @Override
    public SampleReply doThatCrazyThing(String locationCirc7, Integer yard,
                                        Integer track, ActiveUserId userId) {
        SampleReply sampleReply = new SampleReply();
        sampleReply.setCount(111);
        sampleReply.setPing("pong");
        sampleReply.setWhen(NCDateTimeFactory.createDateTime(2012, 12, 24, 1, 2, 3));
        List<SpringFact> springIs = new ArrayList<SpringFact>();
        sampleReply.setUserId(userId);
        SpringFact fact = new SpringFact("Fun", true);
        springIs.add(fact);
        sampleReply.setSpringFacts(springIs);
        return sampleReply;
    }

    @Override
    public String doSomeOtherThing(String trainSymbol, NCDate trainDate,
                                   NCDateTime departTime) {
        return "Your application logic goes here";
    }

}
