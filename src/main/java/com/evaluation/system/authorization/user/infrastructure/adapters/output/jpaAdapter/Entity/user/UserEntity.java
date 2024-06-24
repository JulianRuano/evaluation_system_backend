package com.evaluation.system.authorization.user.infrastructure.adapters.output.jpaAdapter.Entity.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.evaluation.system.authorization.auth.domain.model.Authority;
import com.evaluation.system.authorization.user.infrastructure.adapters.output.jpaAdapter.Entity.role.RoleEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})})
public class UserEntity implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private String name;
	private String email;
	private String cellPhone;
	@Builder.Default
	private boolean enabled = true;
	private String profile;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private RoleEntity role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> authorities = new HashSet<>();
		authorities.add(new Authority(role.getRolName()));
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
}
