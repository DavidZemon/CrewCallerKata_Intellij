package com.uprr.training.dao;

import com.uprr.training.pojos.Constants;
import com.uprr.training.pojos.CrewMember;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        assertEquals(myList, Constants.CREW_MEMBERS);
    }
}
