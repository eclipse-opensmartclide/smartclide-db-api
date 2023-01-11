/**
 * 
 */
package org.eclipse.opensmartclide.dbapi.controller;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.eclipse.opensmartclide.dbapi.model.Service;
import org.eclipse.opensmartclide.dbapi.repository.ServiceRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author asal
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ServiceController.class)
class ServiceControllerTest {
	
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private ServiceRepository repository;

	@Test
	void getAllServicesEndpoint() throws Exception {
		
		Service service = new Service();
		service.setName("TestService");
		List<Service> services = Arrays.asList(service);
		repository.saveAll(services);
		
		mvc.perform(MockMvcRequestBuilders
				.get("/services")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.services").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.services[*].id").isNotEmpty());
		
	}

}
