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

	@RequestMapping("/stores")
	public ResponseEntity<List<DeploymentTime>> index() {
		List<DeploymentTime> list = storeService.getAllDeploymentTime();
		return new ResponseEntity<List<DeploymentTime>>(list, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/stores/{component}/{action}/{version}")
	public ResponseEntity<String> postBeginDeployment(@PathVariable String component, @PathVariable String action,
			@PathVariable String version) {
		String retorno;
		try {
			retorno = storeService.beginDeployment(component, action, version);
		} catch (Exception ex) {
			return new ResponseEntity<String>("Error creating the deploymentTime: " + ex.toString(),
					HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(retorno, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/stores/{component}/{action}/{version}/{status}")
	public ResponseEntity<String> postEndDeployment(@PathVariable String component, @PathVariable String action,
			@PathVariable String version, @PathVariable String status) {
		String retorno;
		try {
			retorno = storeService.endDeployment(component, action, version, status);
		} catch (Exception ex) {
			return new ResponseEntity<String>("Error creating the deploymentTime: " + ex.toString(),
					HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(retorno, HttpStatus.OK);
	}

}
