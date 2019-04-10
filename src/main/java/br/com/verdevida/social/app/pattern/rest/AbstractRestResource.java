package br.com.verdevida.social.app.pattern.rest;

import javax.annotation.ManagedBean;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.verdevida.social.app.VerdeVidaContext;
import br.com.verdevida.social.app.security.TokenAuthenticationService;

@ManagedBean
public abstract class AbstractRestResource {

	@Autowired
	private HttpServletRequest request;
	
	protected VerdeVidaContext getContext() {
		String header = request.getHeader("Authorization");
        VerdeVidaContext context = TokenAuthenticationService.getContextByToken(header);
        return context;
	}
	
}
