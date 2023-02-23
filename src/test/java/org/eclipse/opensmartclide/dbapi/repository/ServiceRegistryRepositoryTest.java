package org.eclipse.opensmartclide.dbapi.repository;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.eclipse.opensmartclide.dbapi.model.ServiceRegistry;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
class ServiceRegistryRepositoryTest {

	@Autowired
	ServiceRegistryRepository serviceRegistryRepository;

    @Before
    public void setUp() {
    	ServiceRegistry serviceRegistry = new ServiceRegistry();   	
    	serviceRegistry.setId(Long.toString(1L));
    	serviceRegistry.setUser_id("testServiceRegistryUserId");
    	serviceRegistry.setType("testServiceRegistryType");
    	serviceRegistry.setUrl("testServiceRegistryUrl");
    	serviceRegistry.setUsername("testServiceRegistryUsername");
    	serviceRegistry.setToken("testServiceRegistryToken");
    	serviceRegistryRepository.save(serviceRegistry);
    }
    
    @Test
    public void assertServiceRegistryIdPersisted() {
    	Optional<ServiceRegistry> serviceRegistry = serviceRegistryRepository.findById(Long.toString(1L));
    	String serviceRegistryId = serviceRegistry.get().getId();
    	assertEquals(Long.toString(1L), serviceRegistryId);
    }
    
    @Test
    public void assertServiceRegistryUserIdPersisted() {
    	Optional<ServiceRegistry> serviceRegistry = serviceRegistryRepository.findById(Long.toString(1L));
    	String serviceRegistryUserId = serviceRegistry.get().getUser_id();
    	assertEquals("testServiceRegistryUserId", serviceRegistryUserId);
    }
    
    @Test
    public void assertServiceRegistryTypePersisted() {
    	Optional<ServiceRegistry> serviceRegistry = serviceRegistryRepository.findById(Long.toString(1L));
    	String serviceRegistryType = serviceRegistry.get().getType();
    	assertEquals("testServiceRegistryType", serviceRegistryType);
    }
    
    @Test
    public void assertServiceRegistryUrlPersisted() {
    	Optional<ServiceRegistry> serviceRegistry = serviceRegistryRepository.findById(Long.toString(1L));
    	String serviceRegistryUrl = serviceRegistry.get().getUrl();
    	assertEquals("testServiceRegistryUrl", serviceRegistryUrl);
    }
    
    @Test
    public void assertServiceRegistryUsernamePersisted() {
    	Optional<ServiceRegistry> serviceRegistry = serviceRegistryRepository.findById(Long.toString(1L));
    	String serviceRegistryUsername = serviceRegistry.get().getUsername();
    	assertEquals("testServiceRegistryUsername", serviceRegistryUsername);
    }
    
    @Test
    public void assertServiceRegistryTokenPersisted() {
    	Optional<ServiceRegistry> serviceRegistry = serviceRegistryRepository.findById(Long.toString(1L));
    	String serviceRegistryToken = serviceRegistry.get().getToken();
    	assertEquals("testServiceRegistryToken", serviceRegistryToken);
    }
}
