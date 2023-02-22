package org.eclipse.opensmartclide.dbapi.repository;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.eclipse.opensmartclide.dbapi.model.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
    	User user = new User();
    	user.setId(Long.toString(1L));
    	user.setEmail("testUser@email.com");
    	user.setTeam_id("testUserTeamId");
    	userRepository.save(user);
    }
    
    @Test
    public void assertUserIdPersisted() {
    	Optional<User> user = userRepository.findById(Long.toString(1L));
    	String userId = user.get().getId();
    	assertEquals(Long.toString(1L), userId);
    }
    
    @Test
    public void assertUserEmailPersisted() {
    	Optional<User> user = userRepository.findById(Long.toString(1L));
    	String userEmail = user.get().getEmail();
    	assertEquals("testUser@email.com", userEmail);
    }
    
    @Test
    public void assertUserTeamIdPersisted() {
    	Optional<User> user = userRepository.findById(Long.toString(1L));
    	String userTeamId = user.get().getTeam_id();
    	assertEquals("testUserTeamId", userTeamId);
    }

}
