package br.com.fchristiano.calcdeploymenttime.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;


@Transactional
public interface DeploymentTimeDao extends CrudRepository<DeploymentTime, Long>  {
	
	
}
