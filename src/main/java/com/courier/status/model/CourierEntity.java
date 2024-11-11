package com.courier.status.model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Setter
@Getter
@Document
public class CourierEntity {

    @Id
    private Long courierId;
    private String courierName;
    private String courierPhone;

    private List<Long> couriersCargosIds; //KARGO İDLERİ



    public CourierEntity(Long courierId, String courierName, String courierPhone, List<Long> couriersCargosIds) {
        this.courierId = courierId;
        this.courierName = courierName;
        this.courierPhone = courierPhone;
        this.couriersCargosIds = new ArrayList<>();
    }

    public CourierEntity(String courierPhone, String courierName) {
        this.courierPhone = courierPhone;
        this.courierName = courierName;
    }



    public CourierEntity() {

    }

}
