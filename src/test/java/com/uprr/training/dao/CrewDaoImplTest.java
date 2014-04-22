package com.uprr.training.dao;

import com.uprr.training.pojos.Constants;
import com.uprr.training.pojos.CrewMember;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.joda.time.DateTimeUtils.fromJulianDay;
import static org.junit.Assert.assertEquals;

/**
 * Created by igen006 on 4/9/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class CrewDaoImplTest {
    @Autowired
    private CrewDao crewDao;

    @Test
    public void testGetAllCrew() throws Exception {
        List<CrewMember> myList = this.crewDao.getAllCrew();

        assertEquals(Constants.CREW_MEMBERS, myList);
    }

    @Test
    public void testGetCrewForDate() throws Exception {
        DateTime testDate = new DateTime(fromJulianDay((double) 2456768));

        List<CrewMember> myList = this.crewDao.getCrewForDate(testDate);

        assertEquals(Constants.CREW_MEMBERS, myList);
    }
}
