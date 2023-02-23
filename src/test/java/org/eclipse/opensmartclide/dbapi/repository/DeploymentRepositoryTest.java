package org.eclipse.opensmartclide.dbapi.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import org.eclipse.opensmartclide.dbapi.model.Deployment;
import org.eclipse.opensmartclide.dbapi.model.Service;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
class DeploymentRepositoryTest {

	@Autowired
	DeploymentRepository deploymentRepository;

    @Before
    public void setUp() throws Exception {
    	Deployment deployment = new Deployment();
    	deployment.setId(Long.toString(1L));
    	deployment.setUser_id("testDeploymentUserId");
    	deployment.setUser("testDeploymentUser");
    	deployment.setGit_credentials_id("testDeploymentGitCredentialsId");
    	deployment.setName("testDeploymentName");
    	deployment.setProject("testDeploymentProject");
    	deployment.setService_url("testDeploymentServiceUrl");
    	deployment.setK8s_url("testDeploymentK8sUrl");
    	deployment.setPort(8080);
    	deployment.setReplicas(2);
    	deployment.setWorkflow_id("testDeploymentWorkflowId");
    	deployment.setService_id("testDeploymentServiceId");
    	deployment.setVersion("testDeploymentVersion");
    	deployment.setState("testDeploymentState");
    	
    	Date createdDate = new SimpleDateFormat("dd/mm/yyyy").parse("01/10/2022");
    	Date updatedDate = new SimpleDateFormat("dd/mm/yyyy").parse("02/10/2022");
    	Date stoppedDate = new SimpleDateFormat("dd/mm/yyyy").parse("03/10/2022");    	
    	deployment.setCreated(createdDate);
    	deployment.setUpdated(updatedDate);
    	deployment.setStopped(stoppedDate);
    	
    	deploymentRepository.save(deployment);
    }
    
    @Test
    public void assertDeploymentIdPersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	String deploymentId = deployment.get().getId();
    	assertEquals(Long.toString(1L), deploymentId);
    }

    @Test
    public void assertDeploymentUserIdPersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	String deploymentUserId = deployment.get().getUser_id();
    	assertEquals("testDeploymentUserId", deploymentUserId);
    }
    
    @Test
    public void assertDeploymentUserPersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	String deploymentUser = deployment.get().getUser();
    	assertEquals("testDeploymentUser", deploymentUser);
    }
    
    @Test
    public void assertDeploymentGitCredentialsIdPersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	String deploymentGitCredentialsId = deployment.get().getGit_credentials_id();
    	assertEquals("testDeploymentGitCredentialsId", deploymentGitCredentialsId);
    }
    
    @Test
    public void assertDeploymentNamePersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	String deploymentName = deployment.get().getName();
    	assertEquals("testDeploymentName", deploymentName);
    }
    
    @Test
    public void assertDeploymentProjectPersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	String deploymentProject = deployment.get().getProject();
    	assertEquals("testDeploymentProject", deploymentProject);
    }
    
    @Test
    public void assertDeploymentServiceUrlPersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	String deploymentUrl = deployment.get().getService_url();
    	assertEquals("testDeploymentServiceUrl", deploymentUrl);
    }
    
    @Test
    public void assertDeploymentK8sUrlPersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	String deploymentK8sUrl = deployment.get().getK8s_url();
    	assertEquals("testDeploymentK8sUrl", deploymentK8sUrl);
    }
	
    @Test
    public void assertDeploymentPortPersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	Integer deploymentPort = deployment.get().getPort();
    	assertEquals(8080, deploymentPort);
    }
    
    @Test
    public void assertDeploymentReplicasPersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	Integer deploymentReplicas = deployment.get().getReplicas();
    	assertEquals(2, deploymentReplicas);
    }
    
    @Test
    public void assertDeploymentWorkflowIdPersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	String deploymentWorkflowId = deployment.get().getWorkflow_id();
    	assertEquals("testDeploymentWorkflowId", deploymentWorkflowId);
    }
    
    @Test
    public void assertDeploymentServiceIdPersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	String deploymentServiceId = deployment.get().getService_id();
    	assertEquals("testDeploymentServiceId", deploymentServiceId);
    }
    
    @Test
    public void assertDeploymentVersionPersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	String deploymentVersion = deployment.get().getVersion();
    	assertEquals("testDeploymentVersion", deploymentVersion);
    }
    
    @Test
    public void assertDeploymentStatePersisted() {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	String deploymentState = deployment.get().getState();
    	assertEquals("testDeploymentState", deploymentState);
    }
    
    @Test
    public void assertDeploymentCreatedDatePersisted() throws ParseException {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	Date deploymentCreatedDate = deployment.get().getCreated();
    	assertTrue(deploymentCreatedDate.equals(new SimpleDateFormat("dd/mm/yyyy").parse("01/10/2022")));
    }
    
    @Test
    public void assertDeploymentUpdatedDatePersisted() throws ParseException {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	Date deploymentUpdatedDate = deployment.get().getUpdated();
    	assertTrue(deploymentUpdatedDate.equals(new SimpleDateFormat("dd/mm/yyyy").parse("02/10/2022")));
    }
    
    @Test
    public void assertDeploymentStoppedDatePersisted() throws ParseException {
    	Optional<Deployment> deployment = deploymentRepository.findById(Long.toString(1L));
    	Date deploymentStoppedDate = deployment.get().getStopped();
    	assertTrue(deploymentStoppedDate.equals(new SimpleDateFormat("dd/mm/yyyy").parse("03/10/2022")));
    }
}
