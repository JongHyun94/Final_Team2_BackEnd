package com.mycompany.webapp.security;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//설정과 관련된 객체다.
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//폼인증 비활성화 
		http.httpBasic().disable();
		
		//서버 세션 비활성화
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		//사이트간 요청 위조 방지 비활성화
		http.csrf().disable();
		
		//CORS 설정(다른 도메인에서 요청을 허가)
		http.cors();
		
		//JWT 인증 필터 추가
		
		//어느 필터 전에 추가 하겠다. 추가할거 , 기준점
		//우리가만든 JwtAuthenticationFilter에서 먼저 이름 권한을 들고 와야됨.
		http.addFilterBefore(new JwtAuthenticationFilter(userDetailsService), UsernamePasswordAuthenticationFilter.class);
		
		
		//요청 경로 권한 설정
		http.authorizeRequests()
			//권한 계층 정보 설정 
			.expressionHandler(securityExpressionHandler())
			//요청 경로 권한 설정
			//ROLE_ 를 넣는상황 hasAuthority
			//.antMatchers(HttpMethod.POST,"/boards").hasAuthority("ROLE_USER")
				/*
				 * .antMatchers("/sabang_m").hasAuthority("ROLE_ADMIN")
				 * .antMatchers("/palbang_m").hasAuthority("ROLE_ADMIN")
				 * .antMatchers("/order_m").hasAuthority("ROLE_ADMIN")
				 * .antMatchers("/inquiry_m").hasAuthority("ROLE_ADMIN")
				 * .antMatchers("/profit_m").hasAuthority("ROLE_ADMIN")
				 */
			//hasAuthority는 한개 속성 넣고
			//hasAnyRole 은 여러개 넣을 수 있다.
			
			//밑에 하위 경로까지 ** 그 이외의 모든 경로 허가 
			.antMatchers("/**").permitAll();	
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
        	.dataSource(dataSource)
        	//인증
        	.usersByUsernameQuery(
        			"select user_id as username, user_password as password, user_enabled as enabled "
        			+ "from users "
        			+ "where user_id=?")
        	//권한 참조
        	.authoritiesByUsernameQuery(""
        			+ "select user_id as username, user_authority as authority "
        			+ "from users "
        			+ "where user_id=?")
        	.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//Uid에 해당이 되는 권한을 확인을 할때 sql에서 가져와서 권한 인증을 해줌
	
	//사용자의 상세 정보를 가져오는 서비스 객체를 Spring 관리 객체로 등록
	//JWTAuthenticationFilter에서 사용
	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}
	
	//인증된 정보를 관리하는 객체를 Spring 관리 객체로 등록
	//AuthController에서 사용
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	//권한 계층 객체 설정 
	//ROLE_ 를 넣어야됨 
	public RoleHierarchyImpl roleHierarchyImpl() {
		RoleHierarchyImpl roleHierarchyImpl = new RoleHierarchyImpl();
		roleHierarchyImpl.setHierarchy("ROLE_MASTER > ROLE_DOCTOR");
		roleHierarchyImpl.setHierarchy("ROLE_MASTER > ROLE_NURSE");
		roleHierarchyImpl.setHierarchy("ROLE_MASTER > ROLE_INSPECTOR");
		roleHierarchyImpl.setHierarchy("ROLE_DOCTOR > ROLE_NURSE");
		
		return roleHierarchyImpl;
	}
	
	//권한 계층 객체를 이용한 웹 시큐리티 처리 객체 생성
	public SecurityExpressionHandler<FilterInvocation> securityExpressionHandler(){
		DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
        defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchyImpl());
        return defaultWebSecurityExpressionHandler;
	}
	
	//다른 도메인의 접근을 허용하는 객체를 Spring 관리 객체 등록
	//메소드를 자동실행해서 리턴된 객체를 Spring 관리 객체 등록. 
	//메소드에 붙어서 메소드에 리턴된 객체를 관리객체로 만들음.
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		//모든 요청 사이트 허용
		configuration.addAllowedOrigin("*");
		//모든 요청 방식 허용(GET, POST, PUT, DELETE)
		configuration.addAllowedMethod("*");
		//모든 요청 헤더 허용
		configuration.addAllowedHeader("*");
		//요청 헤더의 Authorization을 이용해서 사용자 인증(로그인 처리) 하지 않음
		//토큰으로 인증처리를 해야되기때문에 안되겠금 설정함.
		configuration.setAllowCredentials(false);
		
		//모든URL 요청에 대해서 위 내용을 적용
		UrlBasedCorsConfigurationSource ccs = new UrlBasedCorsConfigurationSource();
		ccs.registerCorsConfiguration("/**", configuration);
		
		return ccs;
	}
}
