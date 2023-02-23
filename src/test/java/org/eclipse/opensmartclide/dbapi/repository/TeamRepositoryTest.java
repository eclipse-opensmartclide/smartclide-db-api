package org.eclipse.opensmartclide.dbapi.repository;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.eclipse.opensmartclide.dbapi.model.Team;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
class TeamRepositoryTest {

	@Autowired
	TeamRepository teamRepository;

    @Before
    public void setUp() {
    	Team team = new Team();
    	team.setId(Long.toString(1L));
    	team.setName("testTeamName");
    	teamRepository.save(team);
    }

    @Test
    public void assertTeamIdPersisted() {
    	Optional<Team> team = teamRepository.findById(Long.toString(1L));
    	String teamId = team.get().getId();
    	assertEquals(Long.toString(1L), teamId);
    }
    
    @Test
    public void assertTeamNamePersisted() {
    	Optional<Team> team = teamRepository.findById(Long.toString(1L));
    	String teamName = team.get().getName();
    	assertEquals("testTeamName", teamName);
    }
}
