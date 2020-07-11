package org.rest.service.swipe.controller;

import org.rest.service.swipe.common.User;
import org.rest.service.swipe.service.ISwypeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/test/")
@Api(value = "TEST")
public class SwypeController {



  private final ISwypeUserService service;

  @Autowired
  public SwypeController(final ISwypeUserService service) {
    this.service = service;

  }

  @ApiOperation(value = "Gets user account information")
  @GetMapping(value = "/hello")
  public User getUserInfo() {
    return service.getUserInfo();
    // proxy.fetchRank(battleTag);
  }
}
