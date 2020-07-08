package com.rest.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rest.client.proxy.UserProxy;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/account")
public class UserController {


  private final UserProxy proxy;

  @Autowired
  public UserController(final UserProxy proxy) {
    this.proxy = proxy;

  }

  @ApiOperation(value = "Gets user account information", tags = "user")
  @RequestMapping(value = "/api", method = RequestMethod.GET)
  public Mono<String> fetchRank() {
    return Mono.just("Hello World");
    // proxy.fetchRank(battleTag);
  }
}
