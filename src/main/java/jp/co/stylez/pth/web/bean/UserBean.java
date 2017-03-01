package jp.co.stylez.pth.web.bean;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UserBean {

	private int id;
	private String username;
	private String password;
	private boolean enabled;
	private boolean userNonLocked;
	private boolean userNonExpired;
	private boolean credentialsNonExpired;
	private Collection<? extends GrantedAuthority> authority;

	public UserBean() {

	}

	public UserBean(String username, String password) {
		this();
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isUserNonLocked() {
		return userNonLocked;
	}

	public void setUserNonLocked(boolean userNonLocked) {
		this.userNonLocked = userNonLocked;
	}

	public boolean isUserNonExpired() {
		return userNonExpired;
	}

	public void setUserNonExpired(boolean userNonExpired) {
		this.userNonExpired = userNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Collection<? extends GrantedAuthority> getAuthority() {
		return authority;
	}

	public void setAuthority(Collection<? extends GrantedAuthority> authority) {
		this.authority = authority;
	}

}
