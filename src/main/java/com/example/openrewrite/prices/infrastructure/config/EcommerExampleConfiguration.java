/*
 * Copyright 2023 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.openrewrite.prices.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.openrewrite.prices.application.PricesService;
import com.example.openrewrite.prices.domain.repository.SearchPricesRepository;
import com.example.openrewrite.prices.domain.usecase.search.SearchPricesUseCase;
import com.example.openrewrite.prices.infrastructure.persistence.mapper.PriceEntityMapper;
import com.example.openrewrite.prices.infrastructure.persistence.repository.SearchPricesH2DatabaseRepository;
import com.example.openrewrite.prices.infrastructure.persistence.repository.SearchPricesJPARepository;

@Configuration
public class EcommerExampleConfiguration {

	@Bean
	public SearchPricesUseCase pricesService(SearchPricesRepository getPricesRepository) {
		return new PricesService(getPricesRepository);
	}

	@Bean
	public SearchPricesRepository pricesRepository(SearchPricesJPARepository jpaRepository, PriceEntityMapper priceMapper) {
		return new SearchPricesH2DatabaseRepository(jpaRepository, priceMapper);
	}
}
