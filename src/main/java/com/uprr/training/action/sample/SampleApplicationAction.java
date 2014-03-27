package com.uprr.training.action.sample;

import com.uprr.netcontrol.shared.components.datetime.NCDate;
import com.uprr.netcontrol.shared.components.datetime.NCDateTime;
import com.uprr.ui.shared.user.ActiveUserId;

/**
 * This interface defines the Application functions that may be performed.
 * By using an interface, it becomes possible to replace the implementation
 * with stubs for Controller testing.
 */
public interface SampleApplicationAction {

    SampleReply doThatCrazyThing(String locationCirc7, Integer yard,
                                 Integer track, ActiveUserId userId);

    String doSomeOtherThing(String trainSymbol, NCDate trainDate,
                            NCDateTime departTime);

}
