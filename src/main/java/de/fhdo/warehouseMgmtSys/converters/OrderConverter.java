package de.fhdo.warehouseMgmtSys.converters;

import de.fhdo.warehouseMgmtSys.domain.Order;
import de.fhdo.warehouseMgmtSys.dto.OrderDto;

public class OrderConverter {

    //Convert from Entity to DTOs
    public static OrderDto toDto(Order orderEntity) {
        return new OrderDto(
               orderEntity.getOrderId(),
               orderEntity.getCustomerId(),
               orderEntity.getStatus(),
               orderEntity.getCreatedDate()
        );
    }

    //Convert from Dto to Entity
    public static Order toEntity(OrderDto orderDto) {
        Order OrderEntity =  new Order();
        OrderEntity.setOrderId(orderDto.getOrderId());
        OrderEntity.setCustomerId(orderDto.getCustomerId());
        OrderEntity.setStatus(orderDto.getOrderStatus());
        OrderEntity.setCreatedDate(orderDto.getCreatedAt());

        return OrderEntity;
    }
}
