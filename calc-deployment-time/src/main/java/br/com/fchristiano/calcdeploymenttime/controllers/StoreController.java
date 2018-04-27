package br.com.fchristiano.calcdeploymenttime.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fchristiano.calcdeploymenttime.models.DeploymentTime;
import br.com.fchristiano.calcdeploymenttime.models.DeploymentTimeDao;

@RestController
public class StoreController {

	@Autowired
	private DeploymentTimeDao deploymentTimeDao;

	@RequestMapping("/store")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/store/{component}/{action}/{buildNumber}")
	public String postBeginDeployment(@PathVariable String component, @PathVariable String action,
			@PathVariable Integer buildNumber) {
		String deploymentTimeId = "";
		Date date = new Date();
		try {
			DeploymentTime user = new DeploymentTime(component, action, buildNumber, date);
			deploymentTimeDao.save(user);
			deploymentTimeId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "Error creating the deploymentTime: " + ex.toString();
		}
		return "User succesfully created with id = " + deploymentTimeId;
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/store/{component}/{action}/{buildNumber}/{status}")
	public String postEndDeployment(@PathVariable String component, @PathVariable String action,
			@PathVariable Integer buildNumber, @PathVariable String status) {
		String deploymentTimeId = "";
		Date date = new Date();
		try {
			DeploymentTime user = new DeploymentTime(component, action, buildNumber, date, status);
			deploymentTimeDao.save(user);
			deploymentTimeId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "Error creating the deploymentTime: " + ex.toString();
		}
		return "User succesfully created with id = " + deploymentTimeId;
	}

}
