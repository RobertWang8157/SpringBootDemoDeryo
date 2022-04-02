package com.example.demo.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.sercurity.MyUserDetailsService;
@Component
public class JwtResquestFulter extends OncePerRequestFilter{
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String authorizationHeader=request.getHeader("Authorization");
		String username=null;
		String jwt=null;
		
		   if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
	            jwt = authorizationHeader.substring(7);
	            username = jwtUtil.extractUsername(jwt);
	        }

	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
	            if (jwtUtil.validateToken(jwt, userDetails)) {
	                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
	                        userDetails, null, userDetails.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            }
	        }

//	          response.setHeader("Access-Control-Allow-Origin", "*");
//	          response.setHeader("Access-Control-Allow-Credentials", "true");
//	          response.setHeader("Access-Control-Allow-Methods",
//	          "POST, GET, OPTIONS, DELETE"); response.setHeader("Access-Control-Max-Age",
//	          "3600");


	        filterChain.doFilter(request, response);
	}

}
