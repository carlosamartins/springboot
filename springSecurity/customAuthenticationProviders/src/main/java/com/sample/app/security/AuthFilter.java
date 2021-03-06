package com.sample.app.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.sample.app.security.bearertoken.BearerAuthenticationToken;
import com.sample.app.security.secrettoken.SecretAuthenticationToken;

public class AuthFilter extends AbstractAuthenticationProcessingFilter {

	public AuthFilter(final RequestMatcher requiresAuth) {
		super(requiresAuth);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		if (request.getHeader("bearerToken") != null) {
			BearerAuthenticationToken token = new BearerAuthenticationToken(request.getHeader("bearerToken"));

			return getAuthenticationManager().authenticate(token);
		}

		SecretAuthenticationToken token = new SecretAuthenticationToken(request.getHeader("secretToken"));

		return getAuthenticationManager().authenticate(token);

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);

	}

}
