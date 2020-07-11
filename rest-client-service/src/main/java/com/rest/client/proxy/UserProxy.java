package com.rest.client.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import com.rest.client.model.User;

@FeignClient(name = "${http.protocol}://rest-service-swype", path = "/test/")
@RibbonClient(name = "rest-service-swype")
@Component
public interface UserProxy {

  @GetMapping("/hello")
  User getUserInfo();
}

