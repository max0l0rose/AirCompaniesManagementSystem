package com.marshall.crazyairman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


// На собесе спросить
// 1. Как при реализации Query Method реализовать custom logic
// 2. Как симулировать на контроллере hateoas как на rest repo по умолчанию
// 3. Нужно ли вообще реализовывать hateoas на контроллере, или только на сущности.

// Почитать про Rest ресурсы

@SpringBootApplication
@EnableJpaAuditing
public class AirCompaniesManagementSystemApp {
	public static void main(String[] args) {
		SpringApplication.run(AirCompaniesManagementSystemApp.class, args);
	}
}

