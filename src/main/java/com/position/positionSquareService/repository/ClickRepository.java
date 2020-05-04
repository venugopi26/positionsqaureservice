package com.position.positionSquareService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.position.positionSquareService.model.GoogleClicks;

/**
 * 
 * @author venu
 *
 */
@Repository
public interface ClickRepository extends JpaRepository<GoogleClicks,Long>{

}
