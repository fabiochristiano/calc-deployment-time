package br.com.fchristiano.calcdeploymenttime.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import br.com.fchristiano.calcdeploymenttime.entity.DeploymentTime;

@Transactional
public interface DeploymentTimeRepository extends CrudRepository<DeploymentTime, Long> {

	List<DeploymentTime> findAll();
	
}
