package org.eclipse.opensmartclide.dbapi.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import org.eclipse.opensmartclide.dbapi.model.Workflow;
import org.eclipse.opensmartclide.dbapi.repository.WorkflowRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
class WorkflowRepositoryTest {

	@Autowired
	WorkflowRepository workflowRepository;

    @Before
    public void setUp() throws Exception {
    	Workflow workflow = new Workflow();
    	workflow.setId(Long.toString(1L));
    	workflow.setUser_id("testWorkflowUserId");
    	workflow.setGit_credentials_id("testWorkflowGitCredentialsId");
    	workflow.setName("testWorkflowName");
    	workflow.setUrl("testWorkflowUrl");
    	workflow.setDescription("testWorkflowDescription");
    	workflow.setIs_public(true);
    	Date createdDate = new SimpleDateFormat("dd/mm/yyyy").parse("15/09/2022");
    	Date updatedDate = new SimpleDateFormat("dd/mm/yyyy").parse("11/07/2022");
    	workflow.setCreated(createdDate);
    	workflow.setUpdated(updatedDate);
    	workflowRepository.save(workflow);
    }
    
    @Test
    public void assertWorkflowIdPersisted() {
    	Optional<Workflow> workflow = workflowRepository.findById(Long.toString(1L));
    	String workflowId = workflow.get().getId();
    	assertEquals(Long.toString(1L), workflowId);
    }
    
    @Test
    public void assertWorkflowUserIdPersisted() {
    	Optional<Workflow> workflow = workflowRepository.findById(Long.toString(1L));
    	String workflowUserId = workflow.get().getUser_id();
    	assertEquals("testWorkflowUserId", workflowUserId);
    }
    
    @Test
    public void assertWorkflowGitCredentialsIdPersisted() {
    	Optional<Workflow> workflow = workflowRepository.findById(Long.toString(1L));
    	String workflowGitCredentialsId = workflow.get().getGit_credentials_id();
    	assertEquals("testWorkflowGitCredentialsId", workflowGitCredentialsId);
    }
    
    @Test
    public void assertWorkflowNamePersisted() {
    	Optional<Workflow> workflow = workflowRepository.findById(Long.toString(1L));
    	String workflowName = workflow.get().getName();
    	assertEquals("testWorkflowName", workflowName);
    }
    
    @Test
    public void assertWorkflowUrlPersisted() {
    	Optional<Workflow> workflow = workflowRepository.findById(Long.toString(1L));
    	String workflowUrl = workflow.get().getUrl();
    	assertEquals("testWorkflowUrl", workflowUrl);
    }
    
    @Test
    public void assertWorkflowDescriptionPersisted() {
    	Optional<Workflow> workflow = workflowRepository.findById(Long.toString(1L));
    	String workflowDescription = workflow.get().getDescription();
    	assertEquals("testWorkflowDescription", workflowDescription);
    }
    
    @Test
    public void assertWorkflowCreatedDatePersisted() throws ParseException {
    	Optional<Workflow> workflow = workflowRepository.findById(Long.toString(1L));
    	Date workflowCreatedDate = workflow.get().getCreated();
    	assertTrue(workflowCreatedDate.equals(new SimpleDateFormat("dd/mm/yyyy").parse("15/09/2022")));
    }
    
    @Test
    public void assertWorkflowUpdatedDatePersisted() throws ParseException {
    	Optional<Workflow> workflow = workflowRepository.findById(Long.toString(1L));
    	Date workflowUpdatedDate = workflow.get().getUpdated();
    	assertTrue(workflowUpdatedDate.equals(new SimpleDateFormat("dd/mm/yyyy").parse("11/07/2022")));
    }
}
