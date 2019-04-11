package br.com.verdevida.social.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.verdevida.social.app.entity.UserEntity;
import br.com.verdevida.social.app.exception.BusinessLogicException;
import br.com.verdevida.social.app.pattern.service.IService;

public interface IUserService extends IService, UserDetailsService {

	UserEntity confirm(UserEntity userEntity) throws BusinessLogicException;
	
}
