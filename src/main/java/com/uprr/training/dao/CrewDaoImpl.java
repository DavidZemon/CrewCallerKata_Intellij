package com.uprr.training.dao;

import com.uprr.training.pojos.CrewMember;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author David Zemon (dczemon)
 */
@Transactional
@SuppressWarnings("unchecked")
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
    public List<CrewMember> getCrewForDate(Date date) {
        return null;
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
