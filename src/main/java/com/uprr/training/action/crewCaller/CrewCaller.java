package com.uprr.training.action.crewCaller;

import com.uprr.training.dao.CrewDao;
import com.uprr.training.dao.CrewDialerDao;
import com.uprr.training.pojos.CrewMember;
import org.joda.time.DateTime;

import java.util.List;

/**
 * @author David Zemon (dczemon)
 */
public class CrewCaller {
    private final CrewDao crewDao;
    private final CrewDialerDao crewDialerDao;

    /**
     * @param crewDao
     * @param crewDialerDao
     */
    public CrewCaller(CrewDao crewDao, CrewDialerDao crewDialerDao) {
        this.crewDao = crewDao;
        this.crewDialerDao = crewDialerDao;
    }

    public void callCrew() {
        List<CrewMember> crew = this.crewDao.getCrewForDate(new DateTime());
        for (CrewMember crewMember : crew) this.crewDialerDao.callCrewMember(crewMember.getPhone());
    }
}
