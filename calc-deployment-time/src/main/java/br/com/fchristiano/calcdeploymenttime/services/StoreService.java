package br.com.fchristiano.calcdeploymenttime.services;

public interface StoreService {

	String beginDeployment(String component, String action, Integer buildNumber);

	String endDeployment(String component, String action, Integer buildNumber, String status);

}
