/**
 * 
 */
package org.eclipse.opensmartclide.dbapi.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.opensmartclide.dbapi.model.Service;
import org.eclipse.opensmartclide.dbapi.repository.ServiceRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

// Mockito
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

// WebMvcTest
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * @author asal
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ServiceController.class)
public class ServiceControllerTest {
	
	@MockBean
    private ServiceRepository serviceRepository;
	
	@MockBean
	private MongoTemplate template;
   
	@Autowired
    private MockMvc mvc;
    
	@Test
	public void getAllServicesEndpoint() throws Exception {
		// mock services repository
		Service service = new Service();
		service.setName("TestService-1");
		List<Service> services = new ArrayList<>(Arrays.asList(service));
		when(serviceRepository.findAll()).thenReturn(services);
		
		String uri = "/services";
		
		// perform test
		mvc.perform(MockMvcRequestBuilders.get(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(services.size()))
		.andDo(MockMvcResultHandlers.print());	
	}
}
