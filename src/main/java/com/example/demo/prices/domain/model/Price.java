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
package com.example.demo.prices.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;


import lombok.Builder;
import lombok.Getter;

import com.example.demo.prices.domain.model.UnusedClass;

@Builder
@Getter
public class Price {

	private Long priceIdentification;

	private Long brandIdentification;
	private Long productIdentification;

	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal price;
	private Currency currency;

}
