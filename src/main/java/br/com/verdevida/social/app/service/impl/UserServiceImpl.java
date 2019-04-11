package br.com.verdevida.social.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.verdevida.social.app.entity.UserEntity;
import br.com.verdevida.social.app.exception.BusinessLogicException;
import br.com.verdevida.social.app.repository.IUserRepository;
import br.com.verdevida.social.app.service.IUserService;
import br.com.verdevida.social.app.util.ExpectThat;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username);
		if(ExpectThat.isNull(user)) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}

	@Override
	public UserEntity confirm(UserEntity userEntity) throws BusinessLogicException {
		try {
			return userRepository.save(userEntity);
		} catch (Exception e) {
			throw new BusinessLogicException(e);
		}
	}
	
}
