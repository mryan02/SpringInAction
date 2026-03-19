package com.ryan.mifsud.taco_cloud.infrastructure;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ryan.mifsud.taco_cloud.domain.DTO.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);

}
