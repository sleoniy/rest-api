package com.rest.client.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.rest.client.model.User;

@FeignClient(contextId = "user.service", name = "${http.protocol}://rest-swipe-services",
    path = "/api/swipe/user")
@RibbonClient(name = "rest-swipe-services")
public interface UserProxy {

  @GetMapping("/get-user-info")
  User getUserInfo();
}

