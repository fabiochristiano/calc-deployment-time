package br.com.fchristiano.calcdeploymenttime.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fchristiano.calcdeploymenttime.entity.DeploymentTime;
import br.com.fchristiano.calcdeploymenttime.repository.DeploymentTimeRepository;

@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
	private DeploymentTimeRepository deploymentTimeRepository;

	@Override
	public String beginDeployment(String component, String action, String version) {
		String deploymentTimeId = "";
		Date date = new Date();
		DeploymentTime deploymentTime = new DeploymentTime(component, action, version, date);
		deploymentTimeRepository.save(deploymentTime);
		deploymentTimeId = String.valueOf(deploymentTime.getId());
		return "User succesfully created with id = " + deploymentTimeId;
	}

	@Override
	public String endDeployment(String component, String action, String version, String status) {
		String deploymentTimeId = "";
		Date date = new Date();
		DeploymentTime deploymentTime = new DeploymentTime(component, action, version, date, status);
		deploymentTimeRepository.save(deploymentTime);
		deploymentTimeId = String.valueOf(deploymentTime.getId());
		return "User succesfully created with id = " + deploymentTimeId;
	}

	@Override
	public List<DeploymentTime> getAllDeploymentTime() {
		List<DeploymentTime> list = new ArrayList<>();
		deploymentTimeRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
}
