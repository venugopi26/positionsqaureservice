/**
 * 
 */
package com.position.positionSquareService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.position.positionSquareService.model.Client;

/**
 * @author anush
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	@Query("select c from Client c where c.pan = ?1")
	Client getClientBypan(String panNumber);

}

