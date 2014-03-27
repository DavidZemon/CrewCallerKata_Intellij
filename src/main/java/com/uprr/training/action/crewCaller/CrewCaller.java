package com.uprr.training.action.crewCaller;

import com.uprr.training.pojos.CrewMember;
import com.uprr.training.temp.CrewDao;
import com.uprr.training.temp.CrewDialer;

import java.util.Date;
import java.util.List;

/**
 * @author David Zemon (dczemon)
 */
public class CrewCaller {
    private final CrewDao crewDao;
    private final CrewDialer crewDialer;

    /**
     *
     * @param crewDao
     * @param crewDialer
     */
    public CrewCaller(CrewDao crewDao, CrewDialer crewDialer) {
        this.crewDao = crewDao;
        this.crewDialer = crewDialer;
    }

    public void callCrew() {
        List<CrewMember> crew = this.crewDao.getCrewForDate(new Date());
        for (CrewMember crewMember : crew) this.crewDialer.callCrewMember(crewMember.getPhone());
    }
}
