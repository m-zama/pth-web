package jp.co.stylez.pth.service.impl;


import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.stylez.pth.web.entity.UserEntity;
import jp.co.stylez.pth.web.repository.UserRepository;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserLoginService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
//	@Override
//	@Transactional(readOnly = true)
//	public UserLoginDetails loadUserByUsername(String email) throws UsernameNotFoundException{
//		List<User> userList = Optional.ofNullable(userRepository.findByEmail(email)).orElseThrow(() -> new UsernameNotFoundException("user not found."));
//		return new UserLoginDetails(userList.get(0), getAuthorities(userList.get(0)));
//	}
//	
	private Collection<GrantedAuthority> getAuthorities(UserEntity user){
//		if(user.isAdmin()){
			return AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
//		}else{
//			return AuthorityUtils.createAuthorityList("ROLE_USER");
//		}
	}
	@Transactional
	public UserEntity save(UserEntity account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		userRepository.save(account);
		return account;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity account = userRepository.findOneByEmail(username);
		if(account == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return createUser(account);
	}
	
//	public void signin(UserEntity account) {
//		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
//	}
//	
//	private Authentication authenticate(UserEntity account) {
//		return new UsernamePasswordAuthenticationToken(createUser(account), null,  getAuthorities(account));		
//	}
	
	private User createUser(UserEntity account) {
		return new User(account.getEmail(), account.getPassword(), getAuthorities(account));
	}

//	private GrantedAuthority createAuthority(UserEntity account) {
//		return new SimpleGrantedAuthority(account.getRole());
//	}
	
}
