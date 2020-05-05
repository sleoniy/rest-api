package com.rest.client.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.client.model.Account;
import com.rest.client.proxy.ValorantProxy;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//For swagger
@Api(value = "Valorant Stat Controller", tags = "valorant")
@RestController
@RequestMapping("/valorant")
public class AccountServiceController {


//	private final ValorantProxy proxy;
//	
//	@Autowired
//	public AccountServiceController( final ValorantProxy proxy) {
//		this.proxy = proxy;
//		
//	}

	@ApiOperation( value = "Gets rank of specified player", tags = "valorant")
	@RequestMapping(value = "/rank", method = RequestMethod.GET)
	public String fetchRank(@RequestParam(name = "battletag") final String battleTag) {
		return proxy.fetchRank(battleTag);
	}
}
