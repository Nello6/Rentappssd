package com.averysadproject.webapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import com.averysadproject.webapp.entities.Credentials;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.averysadproject.webapp.config" })
@PropertySource(value = { "classpath:application.properties" })
public class JdbcConfig 
{
	@Autowired
	private Environment environment;
	
	Credentials credentials = new Credentials();
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	
	@Bean 
	public NamedParameterJdbcTemplate getJdbcTemplate(DataSource dataSource) 
	{ 
	    return new NamedParameterJdbcTemplate(dataSource); 
	} 
	
	@Bean(name = "dataSource")
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		getVaultCredentials();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(credentials.getUsername());
		dataSource.setPassword(credentials.getPassword());
		
		return dataSource;
	}
	
	private void getVaultCredentials(){
		VaultEndpoint endpoint= new VaultEndpoint();
		endpoint.setScheme(environment.getRequiredProperty("spring.cloud.vault.scheme"));
		endpoint.setHost(environment.getRequiredProperty("spring.cloud.vault.host"));
		endpoint.setPort(8200);
		endpoint.setPath(environment.getRequiredProperty("spring.cloud.vault.path"));
		TokenAuthentication token = new TokenAuthentication(environment.getRequiredProperty("spring.cloud.vault.token"));
		VaultTemplate vaultTemplate = new VaultTemplate(endpoint,token);
		VaultResponse response = vaultTemplate.read(environment.getRequiredProperty("spring.cloud.vault.datapath"));

		ObjectMapper objectMapper = new ObjectMapper();
		assert response != null;
	 	credentials = objectMapper.convertValue(response.getData().get("data"), Credentials.class);
	}
	
	
	
	/*
	@Bean
	public DataSourceTransactionManager transactionManager()
	{
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		
		return transactionManager;
	}
	*/
}
