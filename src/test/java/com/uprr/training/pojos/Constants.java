package com.uprr.training.pojos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igen006 on 4/21/2014.
 */
public class Constants {
    public static final List<CrewMember> CREW_MEMBERS = new ArrayList<CrewMember>();

    static {
        CREW_MEMBERS.add(new CrewMember(0, "David", "Zemon", "6363950126"));
        CREW_MEMBERS.add(new CrewMember(1, "Jon", "Doe", "4025550123"));
        CREW_MEMBERS.add(new CrewMember(2, "Carl", "Brooks", "4025442919"));
    }
}
