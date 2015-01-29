package com.uprr.training.dao;

import com.uprr.training.pojos.CrewMember;
import com.uprr.training.pojos.Dates;
import org.hibernate.SessionFactory;
import org.joda.time.LocalDate;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.joda.time.DateTimeUtils.toJulianDayNumber;

/**
 * @author David Zemon (dczemon)
 */
@SuppressWarnings("unchecked")
@Transactional
public class CrewDaoImpl implements CrewDao {

    private final SessionFactory sf;

    @Inject
    public CrewDaoImpl(SessionFactory sf) {
        this.sf = sf;
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

    /**
     * Get all available crew members for a given date
     *
     * @param date Date that crew should be available
     * @return List of crew members; Null if none available
     */
    @Override
    public List<CrewMember> getCrewForDate(LocalDate date) {
        long requestedDate = toJulianDayNumber(date.toDate().getTime());
        final List<CrewMember> validCrew = new ArrayList<>();

        final List<CrewMember> allCrew = this.getAllCrew();
        for (CrewMember crewMember : allCrew)
            for (Dates availableDay : crewMember.getDates())
                if (availableDay.getDate().longValue() == requestedDate) {
                    validCrew.add(crewMember);
                    break;
                }

        return validCrew;
    }
}
