package br.com.fchristiano.calcdeploymenttime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fchristiano.calcdeploymenttime.entity.DeploymentTime;
import br.com.fchristiano.calcdeploymenttime.service.StoreService;

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
	@PostMapping("/store/{component}/{action}/{version}")
	public String postBeginDeployment(@PathVariable String component, @PathVariable String action,
			@PathVariable String version) {
		return storeService.beginDeployment(component, action, version);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/store/{component}/{action}/{version}/{status}")
	public String postEndDeployment(@PathVariable String component, @PathVariable String action,
			@PathVariable String version, @PathVariable String status) {
		return storeService.endDeployment(component, action, version, status);
	}

}
