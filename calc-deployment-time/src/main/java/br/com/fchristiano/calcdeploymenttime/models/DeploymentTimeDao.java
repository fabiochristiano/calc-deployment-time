package br.com.fchristiano.calcdeploymenttime.models;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DeploymentTimeDao extends CrudRepository<DeploymentTime, Long> {

	List<DeploymentTime> findAll();
	
}
