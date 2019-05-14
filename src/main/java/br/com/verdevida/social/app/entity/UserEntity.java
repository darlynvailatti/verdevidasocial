package br.com.verdevida.social.app.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.verdevida.social.app.pattern.repository.AbstractEntity;

@Entity
@Table(name = "user_entity")
public class UserEntity extends AbstractEntity implements UserDetails{
	 
	@Id
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq_gen")
    private Long id;
 
    @Column(nullable = false, unique = true)
    private String username;
 
    private String password;
    
    private Boolean enabled;
    
    private Boolean nonExpired;
    
    private Boolean nonLocked;
    
    private Boolean credentialsNonExpired;
	 
	@Override
	public Long getId() {
		return this.id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.nonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.nonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setNonExpired(Boolean nonExpired) {
		this.nonExpired = nonExpired;
	}

	public void setNonLocked(Boolean nonLocked) {
		this.nonLocked = nonLocked;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	
	
}
