package com.marshall.crazyairman;


import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.stream.Collectors;


//@Configuration
//class MyRepositoryRestConfigurerAdapter extends RepositoryRestConfigurerAdapter {
//
//	@Autowired
//	private EntityManager entityManager;
//
//	@Override
//	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(e -> e.getJavaType()).collect(Collectors.toList()).toArray(new Class[0]));
//	}
//
//}


// add Id field in response
@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class SpringRestConfiguration implements RepositoryRestConfigurer {

	final EntityManager entityManager;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
//		config.setDefaultMediaType(MediaType.APPLICATION_JSON);
//		config.useHalAsDefaultJsonMediaType(false);
		Class[] cl = entityManager.getMetamodel().getEntities().stream().map(e -> e.getJavaType())
				.collect(Collectors.toList()).toArray(new Class[0]);
		config.exposeIdsFor(cl);
	}
}


//class qqq implements CommandLineRunner {
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@Override
//	public void run(String... args) throws Exception {
//		//try {
//			jdbcTemplate.update("CREATE DATABASE airman");
//		//} catch (DataAccessException e) {
//			//e.printStackTrace();
//		//}
//	}
//}


//@Configuration
//class JacksonMapperConfiguration
//{
//	@Bean
//	public Jackson2ObjectMapperBuilderCustomizer customizer()
//	{
//		return builder -> builder.serializerByType(BigDecimal.class, new ToStringSerializer());
//	}
//}



//public class WebappConfig extends WebMvcConfigurerAdapter {
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//		builder.serializerByType(ObjectId.class, new ToStringSerializer());
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(builder.build());
//		converters.add(converter);
//	}
//}
