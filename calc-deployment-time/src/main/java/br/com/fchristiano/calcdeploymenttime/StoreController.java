package br.com.fchristiano.calcdeploymenttime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

	@RequestMapping("/store")
    public String index() {
        return "Greetings from Spring Boot!";
    }
	
	@ResponseStatus(HttpStatus.OK)
    @PostMapping("/store/{component}/{action}")
	public String getById(@PathVariable String component, @PathVariable String action) {
		return component;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/store/{component}/{action}/{status}")
	public String getById(@PathVariable String component, @PathVariable String action, @PathVariable String status) {
		return component;
	}
	
}
