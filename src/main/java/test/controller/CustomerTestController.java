package test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import test.CustomerDTO;

@RestController
public class CustomerTestController {
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/customers", method=RequestMethod.GET)
	public List<CustomerDTO> getCustomers(){
		
			ParameterizedTypeReference<List<CustomerDTO>> parameterizedTypeReference = new ParameterizedTypeReference<List<CustomerDTO>>() {}; 
			ResponseEntity<List<CustomerDTO>> response=this.restTemplate.exchange("http://customer-service/customerAll", HttpMethod.GET, null, parameterizedTypeReference);
			
			return response.getBody();
	}
}
