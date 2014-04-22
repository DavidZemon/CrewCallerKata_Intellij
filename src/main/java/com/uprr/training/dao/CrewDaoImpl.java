package com.uprr.training.dao;

import com.uprr.training.pojos.CrewMember;
import com.uprr.training.pojos.Dates;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.joda.time.DateTimeUtils.toJulianDayNumber;

/**
 * @author David Zemon (dczemon)
 */
@SuppressWarnings("unchecked")
@Transactional
public class CrewDaoImpl implements CrewDao {

    private SessionFactory sf;

    public CrewDaoImpl(SessionFactory sf) {
        this.sf = sf;
    }

    /**
     * Get all available crew members for a given date
     *
     * @param date Date that crew should be available
     * @return List of crew members; Null if none available
     */
    @Override
    public List<CrewMember> getCrewForDate(DateTime date) {
        long requestedDate = toJulianDayNumber(date.getMillis());
        List<CrewMember> validCrew = new ArrayList<CrewMember>();

        List<CrewMember> allCrew = this.getAllCrew();
        for (CrewMember crewMember : allCrew)
            for (Dates availableDay : crewMember.getDates())
                if (availableDay.getDate().longValue() == requestedDate) {
                    validCrew.add(crewMember);
                    break;
                }

        return validCrew;
    }

    /**
     * Retrieve a list of all active crew members
     *
     * @return List of crew members in the database
     */
    @Override
    public List<CrewMember> getAllCrew() {
        return (List<CrewMember>) sf.getCurrentSession().createQuery("from CrewMember").list();
    }
}
