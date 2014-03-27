package com.uprr.training.temp;

import com.uprr.training.pojos.CrewMember;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author David Zemon (dczemon)
 */
public class CrewDaoImpl implements CrewDao {
    private static List<CrewMember> staticCrewList;
    static {
        staticCrewList = new ArrayList<CrewMember>();
        staticCrewList.add(new CrewMember(0, "David", "Zemon", "6363950126"));
        staticCrewList.add(new CrewMember(1, "Jon", "Doe", "4025550123"));
        staticCrewList.add(new CrewMember(2, "Carl", "Brooks", "4025442919"));
    }

    /**
     * Get all available crew members for a given date
     * @param date Date that crew should be available
     * @return List of crew members; Null if none available
     */
    @Override
    public List<CrewMember> getCrewForDate(Date date) {
        // TODO: Add real database access
        return CrewDaoImpl.staticCrewList;
    }

    /**
     * Retrieve a list of all active crew members
     * @return List of crew members in the database
     */
    @Override
    public List<CrewMember> getAllCrew() {
        // TODO: Add real database access
        return CrewDaoImpl.staticCrewList;
    }
}