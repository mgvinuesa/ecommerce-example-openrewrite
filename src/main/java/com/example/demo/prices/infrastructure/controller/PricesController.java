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
package com.example.demo.prices.infrastructure.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.prices.domain.usecase.search.SearchPrices;
import com.example.demo.prices.domain.usecase.search.SearchPricesResult;
import com.example.demo.prices.domain.usecase.search.SearchPricesUseCase;
import com.example.demo.prices.infrastructure.controller.model.PriceListResponse;
import com.example.demo.prices.infrastructure.controller.model.SearchPricesRequest;

@RestController
@RequestMapping(path = "/prices")
@AllArgsConstructor
public class PricesController {

	private SearchPricesUseCase getPriceUseCase;

	@PostMapping(path = "/search")
	public PriceListResponse getPrices(@RequestBody SearchPricesRequest searchRequest) {
		SearchPrices command = SearchPrices.builder().brandIdentification(searchRequest.getBrandIdentification())
				.productIdentification(searchRequest.getProductIdentification())
				.currentDate(searchRequest.getCurrentDate()).build();
		SearchPricesResult result = getPriceUseCase.getPrices(command);
		return new PriceListResponse(result.getPriceList());
	}
}
