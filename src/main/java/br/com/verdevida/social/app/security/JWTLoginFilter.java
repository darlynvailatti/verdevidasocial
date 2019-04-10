package br.com.verdevida.social.app.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.verdevida.social.app.entity.UserEntity;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter{

	private static final Logger log = LoggerFactory.getLogger(JWTLoginFilter.class);
	
	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		UserEntity usuario = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
		String login = usuario.getLogin();
		String password = usuario.getPassword();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(login, password);
		return getAuthenticationManager().authenticate(authentication);
	}
	
	@Override
	protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth
    ) throws IOException, ServletException {
		TokenAuthenticationService.addAuthentication(res, auth);
	}
	
	
	

}
