package com.courier.status.controller;

import com.cargo.sdk.Cargo;
import com.courier.status.dto.CourierDto;
import com.courier.status.model.CourierEntity;
import com.courier.status.service.CourierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/deliveryy")
@Slf4j
public class CourierController {


    private final CourierService courierService;


    public CourierController(CourierService courierService) {
        this.courierService = courierService;

    }


    @PostMapping("/kuryeekle")
    public ResponseEntity<CourierDto> addCourier(@RequestBody CourierDto courierDto) {
        log.info("Courier added: " + courierDto);
        CourierEntity courierEntity = courierService.addCourier(courierDto);
        return ResponseEntity.ok(CourierDto.convert(courierEntity));
    }

    @GetMapping("/kuryegetir/{courierId}")
    public ResponseEntity<CourierDto> getCourier(@PathVariable Long courierId) {
        log.info("Courier found: " + courierId);
        try {
            CourierEntity courierEntity = courierService.getCourierById(courierId).getBody();
            //    CargoDto cargoDto =getCargoById(id);//
            if (courierEntity != null) {
                CourierDto courierDto = CourierDto.convert(courierEntity);
                return ResponseEntity.ok(courierDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.error("kurye bulunamadı : {}", courierId, e);
            throw new RuntimeException(e);
        }


    }

    @GetMapping("/cargos")
    public List<Cargo> getAllCargos() throws Exception {
        log.info("Fetching all cargos via courier service");
        return courierService.getAllCargos();
    }

    @PostMapping("/setState/{id}")
    public Cargo setState(@PathVariable Long id) throws Exception {
        log.info("Set state via courier service");
        return courierService.setState(id);
    }

    @GetMapping("/cargo/{id}")
    public Cargo getCargoById(@PathVariable Long id) throws Exception {
        log.info("Fetch cargo by id via courier service");
        return courierService.getCargoById(id);
    }
    @PostMapping("/addcargo")
    public Cargo addCargo(@RequestParam Long courierId, @RequestBody Cargo cargo) throws Exception {
        log.info("Add cargo via courier service");
        return courierService.addCargo(courierId, cargo);
    }

}
