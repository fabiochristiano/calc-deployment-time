package br.com.fchristiano.calcdeploymenttime.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fchristiano.calcdeploymenttime.models.DeploymentTime;
import br.com.fchristiano.calcdeploymenttime.services.StoreService;

@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;

	@RequestMapping("/store")
	public ResponseEntity<List<DeploymentTime>> index() {
		List<DeploymentTime> list = storeService.getAllDeploymentTime();
		return new ResponseEntity<List<DeploymentTime>>(list, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/store/{component}/{action}/{buildNumber}")
	public String postBeginDeployment(@PathVariable String component, @PathVariable String action,
			@PathVariable Integer buildNumber) {
		return storeService.beginDeployment(component, action, buildNumber);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/store/{component}/{action}/{buildNumber}/{status}")
	public String postEndDeployment(@PathVariable String component, @PathVariable String action,
			@PathVariable Integer buildNumber, @PathVariable String status) {
		return storeService.endDeployment(component, action, buildNumber, status);
	}

}
