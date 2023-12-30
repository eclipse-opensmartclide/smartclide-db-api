package org.eclipse.opensmartclide.dbapi.repository;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.eclipse.opensmartclide.dbapi.model.GitCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
class GitCredentialsRepositoryTest {

	@Autowired
	private GitCredentialsRepository gitCredentialsRepository;

    @BeforeEach
    public void setUp() {
    	GitCredentials gitCredentials = new GitCredentials();
    	gitCredentials.setId(Long.toString(1L));
    	gitCredentials.setUser_id("testGitCredentialsUserId");
    	gitCredentials.setType("testGitCredentialsType");
    	gitCredentials.setUrl("testGitCredentialsUrl");
    	gitCredentials.setUsername("testGitCredentialsUsername");
    	gitCredentials.setToken("testGitCredentialsToken");
    	
    	gitCredentialsRepository.save(gitCredentials);
    }
    
    @Test
    public void assertGitCredentialsIdPersisted() {
    	Optional<GitCredentials> gitCredentials = gitCredentialsRepository.findById(Long.toString(1L));
    	String gitCredentialsId = gitCredentials.get().getId();
    	assertEquals(Long.toString(1L), gitCredentialsId);
    }
    
    @Test
    public void assertGitCredentialsUserIdPersisted() {
    	Optional<GitCredentials> gitCredentials = gitCredentialsRepository.findById(Long.toString(1L));
    	String gitCredentialsUserId = gitCredentials.get().getUser_id();
    	assertEquals("testGitCredentialsUserId", gitCredentialsUserId);
    }
    
    @Test
    public void assertGitCredentialsTypePersisted() {
    	Optional<GitCredentials> gitCredentials = gitCredentialsRepository.findById(Long.toString(1L));
    	String gitCredentialsType = gitCredentials.get().getType();
    	assertEquals("testGitCredentialsType", gitCredentialsType);
    }
    
    @Test
    public void assertGitCredentialsUrlPersisted() {
    	Optional<GitCredentials> gitCredentials = gitCredentialsRepository.findById(Long.toString(1L));
    	String gitCredentialsUrl = gitCredentials.get().getUrl();
    	assertEquals("testGitCredentialsUrl", gitCredentialsUrl);
    }
    
    @Test
    public void assertGitCredentialsUsernamePersisted() {
    	Optional<GitCredentials> gitCredentials = gitCredentialsRepository.findById(Long.toString(1L));
    	String gitCredentialsUsername = gitCredentials.get().getUsername();
    	assertEquals("testGitCredentialsUsername", gitCredentialsUsername);
    }
    
    @Test
    public void assertGitCredentialsTokenPersisted() {
    	Optional<GitCredentials> gitCredentials = gitCredentialsRepository.findById(Long.toString(1L));
    	String gitCredentialsToken = gitCredentials.get().getToken();
    	assertEquals("testGitCredentialsToken", gitCredentialsToken);
    }

}
