package org.eclipse.opensmartclide.dbapi.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.eclipse.opensmartclide.dbapi.model.Service;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataMongoTest
class ServiceRepositoryTest {
	
	@Autowired
	ServiceRepository serviceRepository;

    @Before
    public void setUp() throws Exception  {
    	Service service = new Service();
    	service.setId(Long.toString(1L));
    	service.setName("testServiceName");
    	service.setUser_id("testUserId");
    	service.setRegistry_id("testRegistryId");
    	service.setWorkspace_id("testWorkSpaceId");
    	service.setGit_credentials_id("testGitCredentialsId");
    	service.setUrl("testServiceUrl");
    	service.setDescription("testServiceDescription");
    	service.setIsPublic(true);
    	service.setLicence("testServiceLicense");
    	service.setFramework("testServiceFramework");
    	Date createdDate = new SimpleDateFormat("dd/mm/yyyy").parse("10/01/2022");
    	Date updatedDate = new SimpleDateFormat("dd/mm/yyyy").parse("20/03/2022");
    	service.setCreated(createdDate);
    	service.setUpdated(updatedDate);
    	serviceRepository.save(service);
    }

    @Test
    public void assertServiceIdPersisted() {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	String serviceId = service.get().getId();
    	assertEquals(Long.toString(1L), serviceId);
    }
    
    @Test
    public void assertServiceNamePersisted() {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	String serviceName = service.get().getName();
    	assertEquals("testServiceName", serviceName);
    }
    
    @Test
    public void assertServiceUserIdPersisted() {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	String serviceUserId = service.get().getUser_id();
    	assertEquals("testUserId", serviceUserId);
    }
    
    @Test
    public void assertServiceRegistryIdPersisted() {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	String serviceRegistryId = service.get().getRegistry_id();
    	assertEquals("testRegistryId", serviceRegistryId);
    }
    
    @Test
    public void assertServiceWorkspaceIdPersisted() {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	String serviceWorkspaceId = service.get().getWorkspace_id();
    	assertEquals("testWorkSpaceId", serviceWorkspaceId);
    }
    
    @Test
    public void assertServiceGitCredentialsIdPersisted() {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	String serviceGitCredentialsId = service.get().getGit_credentials_id();
    	assertEquals("testGitCredentialsId", serviceGitCredentialsId);
    }
    
    @Test
    public void assertServiceUrlPersisted() {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	String serviceUrl = service.get().getUrl();
    	assertEquals("testServiceUrl", serviceUrl);
    }
    
    @Test
    public void assertServiceDescriptionPersisted() {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	String serviceDescription = service.get().getDescription();
    	assertEquals("testServiceDescription", serviceDescription);
    }
    
    @Test
    public void assertServiceIsPublic() {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	boolean serviceIsPublic = service.get().getIsPublic();
    	assertTrue(serviceIsPublic == true);
    }
    
    @Test
    public void assertServiceLicensePersisted() {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	String serviceLicense = service.get().getLicence();
    	assertEquals("testServiceLicense", serviceLicense);
    }
    
    @Test
    public void assertServiceFrameworkPersisted() {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	String serviceFramework = service.get().getFramework();
    	assertEquals("testServiceFramework", serviceFramework);
    }
    
    @Test
    public void assertServiceCreatedDatePersisted() throws ParseException {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	Date serviceCreatedDate = service.get().getCreated();
    	assertTrue(serviceCreatedDate.equals(new SimpleDateFormat("dd/mm/yyyy").parse("10/01/2022")));
    }
    
    @Test
    public void assertServiceUpdatedDatePersisted() throws ParseException {
    	Optional<Service> service = serviceRepository.findById(Long.toString(1L));
    	Date serviceUpdatedDate = service.get().getUpdated();
    	assertTrue(serviceUpdatedDate.equals(new SimpleDateFormat("dd/mm/yyyy").parse("20/03/2022")));
    }
}
