package com.security.converter;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.security.model.User;

@Component
public class UserToUserDetail implements Converter<User, UserDetails> {

	@Override
	public UserDetails convert(User source) {
		
		UserDetailImpl userDetail = new UserDetailImpl();
		userDetail.setUserName(source.getUserName());
		userDetail.setPassword(source.getPassword());
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		source.getRoleList().forEach((a) ->{
			authorities.add(new SimpleGrantedAuthority(a.getRoles()));
		});
		
		userDetail.setAuthority(authorities);
		return userDetail;
	}

}
