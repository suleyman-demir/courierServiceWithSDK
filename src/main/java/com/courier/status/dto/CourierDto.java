package com.courier.status.dto;


import com.courier.status.model.CourierEntity;

import java.util.List;

public record CourierDto (
        Long courierId,
        String courierName,
        String courierPhone,
        List<Long> couriersCargosIds
        //List<CargoDto> allCargos,
        //List<Long> CargosOnCourier
) {
    public static CourierDto convert (CourierEntity from) {
        return new CourierDto(
                from.getCourierId(),
                from.getCourierName(),
                from.getCourierPhone(),
                from.getCouriersCargosIds()

        );
    }


    public static CourierEntity convert (CourierDto from) {
        return new CourierEntity(
                from.courierId,
                from.courierName,
                from.courierPhone,
                from.couriersCargosIds
        );
    }
}
