package jp.co.stylez.pth.web.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.co.stylez.pth.web.entity.UserEntity;

public class UserLoginDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private final UserEntity user;
	private final Collection<GrantedAuthority> authorities;

	public UserLoginDetails(UserEntity user, Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}

	public String getUsername() {
		return user.getEmail();
	};

	public String getPassword() {
		return user.getPassword();
	};

	public boolean isEnabled() {
		return true;
	};
	
	public boolean isAdmin() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	};

	public boolean isAccountNonExpired() {
		return true;
	};

	public boolean isCredentialsNonExpired() {
		return true;
	};

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	};
}
