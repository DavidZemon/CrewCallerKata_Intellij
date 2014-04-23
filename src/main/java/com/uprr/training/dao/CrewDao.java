package com.uprr.training.dao;

import com.uprr.training.pojos.CrewMember;
import org.joda.time.DateTime;

import java.util.List;

/**
 * @author David Zemon (dczemon)
 */
public interface CrewDao {
    List<CrewMember> getCrewForDate(DateTime date);

    List<CrewMember> getAllCrew();
}
