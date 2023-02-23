package org.eclipse.opensmartclide.dbapi.repository;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.eclipse.opensmartclide.dbapi.model.DeploymentPlatform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
class DeploymentPlatformRepositoryTest {

	@Autowired
	private DeploymentPlatformRepository deploymentPlatformRepository;

    @BeforeEach
    public void setUp() throws Exception {
    	DeploymentPlatform deploymentPlatform = new DeploymentPlatform();
    	deploymentPlatform.setId(Long.toString(1L));
    	deploymentPlatform.setUser_id("testDeploymentPlatformUserId");
    	deploymentPlatform.setUrl("testDeploymentPlatformUrl");
    	deploymentPlatform.setUsername("testDeploymentPlatformUsername");
    	deploymentPlatform.setToken("testDeploymentPlatformToken");
    	
    	deploymentPlatformRepository.save(deploymentPlatform);
    }
    
    @Test
    public void assertDeploymentPlatformIdPersisted() {
    	Optional<DeploymentPlatform> deploymentPlatform = deploymentPlatformRepository.findById(Long.toString(1L));
    	String deploymentPlatformId = deploymentPlatform.get().getId();
    	assertEquals(Long.toString(1L), deploymentPlatformId);
    }
    
    @Test
    public void assertDeploymentPlatformUserIdPersisted() {
    	Optional<DeploymentPlatform> deploymentPlatform = deploymentPlatformRepository.findById(Long.toString(1L));
    	String deploymentPlatformUserId = deploymentPlatform.get().getUser_id();
    	assertEquals("testDeploymentPlatformUserId", deploymentPlatformUserId);
    }
    
    @Test
    public void assertDeploymentPlatformUrlPersisted() {
    	Optional<DeploymentPlatform> deploymentPlatform = deploymentPlatformRepository.findById(Long.toString(1L));
    	String deploymentPlatformUrl = deploymentPlatform.get().getUrl();
    	assertEquals("testDeploymentPlatformUrl", deploymentPlatformUrl);
    }
    
    @Test
    public void assertDeploymentPlatformUsernamePersisted() {
    	Optional<DeploymentPlatform> deploymentPlatform = deploymentPlatformRepository.findById(Long.toString(1L));
    	String deploymentPlatformUsername = deploymentPlatform.get().getUsername();
    	assertEquals("testDeploymentPlatformUsername", deploymentPlatformUsername);
    }
    
    @Test
    public void assertDeploymentPlatformTokenPersisted() {
    	Optional<DeploymentPlatform> deploymentPlatform = deploymentPlatformRepository.findById(Long.toString(1L));
    	String deploymentPlatformToken = deploymentPlatform.get().getToken();
    	assertEquals("testDeploymentPlatformToken", deploymentPlatformToken);
    }

}
