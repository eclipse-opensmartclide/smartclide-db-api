package org.eclipse.opensmartclide.dbapi.repository;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.eclipse.opensmartclide.dbapi.model.CiManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
class CiManagerRepositoryTest {

	@Autowired
	private CiManagerRepository ciManagerRepository;

    @BeforeEach
    public void setUp() throws Exception {
    	CiManager ciManager = new CiManager();
    	ciManager.setId(Long.toString(1L));
    	ciManager.setUser_id("testCiManagerUserId");
    	ciManager.setType("testCiManagerType");
    	ciManager.setUrl("testCiManagerUrl");
    	ciManager.setUsername("testCiManagerUsername");
    	ciManager.setToken("testCiManagerToken");
    	
    	ciManagerRepository.save(ciManager);
    }
    
    @Test
    public void assertCiManagerIdPersisted() {
    	Optional<CiManager> ciManager = ciManagerRepository.findById(Long.toString(1L));
    	String ciManagerId = ciManager.get().getId();
    	assertEquals(Long.toString(1L), ciManagerId);
    }
    
    @Test
    public void assertCiManagerUserIdPersisted() {
    	Optional<CiManager> ciManager = ciManagerRepository.findById(Long.toString(1L));
    	String ciManagerUserId = ciManager.get().getUser_id();
    	assertEquals("testCiManagerUserId", ciManagerUserId);
    }
    
    @Test
    public void assertCiManagerTypePersisted() {
    	Optional<CiManager> ciManager = ciManagerRepository.findById(Long.toString(1L));
    	String ciManagerType = ciManager.get().getType();
    	assertEquals("testCiManagerType", ciManagerType);
    }
    
    @Test
    public void assertCiManagerUrlPersisted() {
    	Optional<CiManager> ciManager = ciManagerRepository.findById(Long.toString(1L));
    	String ciManagerUrl = ciManager.get().getUrl();
    	assertEquals("testCiManagerUrl", ciManagerUrl);
    }
    
    @Test
    public void assertCiManagerUsernamePersisted() {
    	Optional<CiManager> ciManager = ciManagerRepository.findById(Long.toString(1L));
    	String ciManagerUsername = ciManager.get().getUsername();
    	assertEquals("testCiManagerUsername", ciManagerUsername);
    }
    
    @Test
    public void assertCiManagerTokenPersisted() {
    	Optional<CiManager> ciManager = ciManagerRepository.findById(Long.toString(1L));
    	String ciManagerToken = ciManager.get().getToken();
    	assertEquals("testCiManagerToken", ciManagerToken);
    }

}
