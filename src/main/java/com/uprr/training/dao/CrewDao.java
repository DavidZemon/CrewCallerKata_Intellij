package com.uprr.training.dao;

import com.uprr.training.pojos.CrewMember;

import java.util.Date;
import java.util.List;

/**
 * @author David Zemon (dczemon)
 */
public interface CrewDao {
    List<CrewMember> getCrewForDate(Date date);

    List<CrewMember> getAllCrew();
}
