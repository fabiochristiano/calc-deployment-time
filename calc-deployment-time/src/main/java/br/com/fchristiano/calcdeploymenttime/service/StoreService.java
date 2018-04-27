package br.com.fchristiano.calcdeploymenttime.service;

import java.util.List;

import br.com.fchristiano.calcdeploymenttime.entity.DeploymentTime;

public interface StoreService {

	String beginDeployment(String component, String action, Integer buildNumber);

	String endDeployment(String component, String action, Integer buildNumber, String status);
	
	List<DeploymentTime> getAllDeploymentTime();
	

}
