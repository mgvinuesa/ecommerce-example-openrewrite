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
package com.example.demo.prices.infrastructure.controller.model;

import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonFormat;

//Don't use lombok due to bad integration with Jackson & JsonFormat annotation
public class SearchPricesRequest {

	private Long productIdentification;
	private Long brandIdentification;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime currentDate;

	public SearchPricesRequest() {
	}

	public SearchPricesRequest(Long productIdentification, Long brandIdentification, LocalDateTime currentDate) {
		super();
		this.productIdentification = productIdentification;
		this.brandIdentification = brandIdentification;
		this.currentDate = currentDate;
	}

	public Long getProductIdentification() {
		return productIdentification;
	}

	public void setProductIdentification(Long productIdentification) {
		this.productIdentification = productIdentification;
	}

	public Long getBrandIdentification() {
		return brandIdentification;
	}

	public void setBrandIdentification(Long brandIdentification) {
		this.brandIdentification = brandIdentification;
	}

	public LocalDateTime getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDateTime currentDate) {
		this.currentDate = currentDate;
	}

}
