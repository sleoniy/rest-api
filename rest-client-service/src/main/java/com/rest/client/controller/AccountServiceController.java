package com.rest.client.controller;

import javax.ws.rs.Path;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import reactor.core.publisher.Mono;


@RestController
@Api(value = "/valorant")
@RequestMapping("/valorant")
@Path("/valorant")
public class AccountServiceController {


  // private final ValorantProxy proxy;
  //
  // @Autowired
  // public AccountServiceController( final ValorantProxy proxy) {
  // this.proxy = proxy;
  //
  // }

  // @ApiOperation(value = "Gets rank of specified player", tags = "valorant")
  @RequestMapping(value = "/api", method = RequestMethod.GET)
  public Mono<String> fetchRank() {
    return Mono.just("Hello World");
    // proxy.fetchRank(battleTag);
  }
}
