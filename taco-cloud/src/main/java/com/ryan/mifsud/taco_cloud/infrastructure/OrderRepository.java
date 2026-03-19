package com.ryan.mifsud.taco_cloud.infrastructure;

import org.springframework.data.repository.CrudRepository;

import com.ryan.mifsud.taco_cloud.domain.DTO.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    TacoOrder save(TacoOrder order);
}
