/**
 * 
 */
package com.position.positionSquareService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.position.positionSquareService.utils.TaskValidation;

/**
 * @author anush
 *
 */

@Configuration
public class BeanConfig {
	
	@Bean
	public TaskValidation taskValidation() {
		return new TaskValidation();
	}

}
