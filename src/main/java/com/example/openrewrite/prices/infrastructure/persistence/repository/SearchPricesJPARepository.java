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
package com.example.openrewrite.prices.infrastructure.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.openrewrite.prices.infrastructure.persistence.entity.PriceEntity;

@Repository
public interface SearchPricesJPARepository extends CrudRepository<PriceEntity, Long> {

	List<PriceEntity> findByBrandIdentification(Long brandIdentification);

	List<PriceEntity> findByProductIdentification(Long productIdentification);

	List<PriceEntity> findByBrandIdentificationAndProductIdentificationAndStartDateBeforeAndEndDateAfter(
			Long brandIdentification, Long productIdentification, LocalDateTime startDate, LocalDateTime endDate);
}
