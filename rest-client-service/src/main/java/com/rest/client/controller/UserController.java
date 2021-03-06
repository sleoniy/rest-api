package com.rest.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rest.client.model.User;
import com.rest.client.proxy.UserProxy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/test/")
@Api(value = "TEST")
public class UserController {


  private final UserProxy proxy;

  @Autowired
  public UserController(final UserProxy proxy) {
    this.proxy = proxy;

  }

  @ApiOperation(value = "Gets user account information")
  @GetMapping(value = "/hello")
  public User getUserInfo() {
    return proxy.getUserInfo();
    // proxy.fetchRank(battleTag);
  }
}
