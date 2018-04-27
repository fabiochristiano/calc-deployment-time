package br.com.fchristiano.calcdeploymenttime.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fchristiano.calcdeploymenttime.models.DeploymentTime;
import br.com.fchristiano.calcdeploymenttime.models.DeploymentTimeDao;

@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
	private DeploymentTimeDao deploymentTimeDao;

	@Override
	public String beginDeployment(String component, String action, Integer buildNumber) {
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

	@Override
	public String endDeployment(String component, String action, Integer buildNumber, String status) {
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

	@Override
	public List<DeploymentTime> getAllDeploymentTime() {
		List<DeploymentTime> list = new ArrayList<>();
		deploymentTimeDao.findAll().forEach(e -> list.add(e));
		return list;
	}
}
