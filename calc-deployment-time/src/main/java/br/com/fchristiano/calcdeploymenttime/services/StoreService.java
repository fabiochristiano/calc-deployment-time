package br.com.fchristiano.calcdeploymenttime.services;

import java.util.List;

import br.com.fchristiano.calcdeploymenttime.models.DeploymentTime;

public interface StoreService {

	String beginDeployment(String component, String action, Integer buildNumber);

	String endDeployment(String component, String action, Integer buildNumber, String status);
	
	List<DeploymentTime> getAllDeploymentTime();
	

}
