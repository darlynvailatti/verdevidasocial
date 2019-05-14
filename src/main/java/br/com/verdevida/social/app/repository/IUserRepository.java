package br.com.verdevida.social.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.verdevida.social.app.entity.UserEntity;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<UserEntity, Long>{

	UserEntity findByUsername(String username);
	
}
