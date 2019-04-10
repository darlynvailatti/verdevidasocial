package br.com.verdevida.social.app.rest.resource.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.verdevida.social.app.VerdeVidaApi;
import br.com.verdevida.social.app.rest.resource.ILogin;

@RestController
@RequestMapping(VerdeVidaApi.contextPath + "/login")
public class LoginResourceImpl implements ILogin{

	private static final Logger log = LoggerFactory.getLogger(LoginResourceImpl.class);
	
	
}
