package com.uprr.training.dao;

import com.uprr.training.pojos.CrewMember;
import org.joda.time.LocalDate;

import java.util.List;

/**
 * @author David Zemon (dczemon)
 */
public interface CrewDao {
    List<CrewMember> getCrewForDate(LocalDate date);

    List<CrewMember> getAllCrew();
}
