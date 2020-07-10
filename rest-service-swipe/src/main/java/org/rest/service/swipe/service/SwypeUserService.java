package org.rest.service.swipe.service;

import org.rest.service.swipe.Application;
import org.rest.service.swipe.common.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SwypeUserService implements ISwypeUserService{

	  private static final Logger logger = LoggerFactory.getLogger(SwypeUserService.class);

	  @Autowired
	  public SwypeUserService() {
		  
	  }
	  
	@Override
	public User getUserInfo() {
		return new User("Steve","Leo");
	}

}
