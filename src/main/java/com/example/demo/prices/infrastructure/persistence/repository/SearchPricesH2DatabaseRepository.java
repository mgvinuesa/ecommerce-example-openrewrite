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
package com.example.demo.prices.infrastructure.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.prices.domain.model.Price;
import com.example.demo.prices.domain.repository.SearchPricesRepository;
import com.example.demo.prices.infrastructure.persistence.mapper.PriceEntityMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchPricesH2DatabaseRepository implements SearchPricesRepository {

	private SearchPricesJPARepository repository;

	private PriceEntityMapper mapper;

	@Override
	public List<Price> getPricesByDateBrandAndProduct(LocalDateTime date, Long brandIdentification,
			Long productIdentification) {
		return this.mapper
				.map(this.repository.findByBrandIdentificationAndProductIdentificationAndStartDateBeforeAndEndDateAfter(
						brandIdentification, productIdentification, date, date));
	}

}
