/**
 * 
 */
package com.position.positionSquareService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.position.positionSquareService.model.User;

/**
 * @author anush
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User getuserByEmailId(String emailId);

	User validateUser(String mobileNumber, String password);

	User getuserByMobileNumber(String mobileNumber);

}

