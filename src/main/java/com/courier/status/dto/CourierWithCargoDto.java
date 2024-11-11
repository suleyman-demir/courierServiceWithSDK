package com.courier.status.dto;

import java.util.List;

public class CourierWithCargoDto {
    private CourierDto courier;
    private List<CargoDto> cargos;

    public CourierWithCargoDto(CourierDto courier, List<CargoDto> cargos) {
        this.courier = courier;
        this.cargos = cargos;
    }

    public CourierDto getCourier() {
        return courier;
    }

    public void setCourier(CourierDto courier) {
        this.courier = courier;
    }

    public List<CargoDto> getCargos() {
        return cargos;
    }

    public void setCargos(List<CargoDto> cargos) {
        this.cargos = cargos;
    }


}

