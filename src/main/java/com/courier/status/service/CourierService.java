package com.courier.status.service;

import com.cargo.sdk.Cargo;
import com.courier.status.dto.CourierDto;
import com.courier.status.model.CourierEntity;
import com.courier.status.repository.CourierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cargo.sdk.CargoServiceSDK;

import java.util.List;

@Slf4j
@Service
public class CourierService {



    private final CargoServiceSDK cargoServiceSDK;

    private final CourierRepository courierRepository;



    public CourierService( CourierRepository courierRepository) {
        this.cargoServiceSDK = new CargoServiceSDK();
        this.courierRepository = courierRepository;
    }

    public CourierEntity addCourier(CourierDto courierDto) {
        log.info("Adding Courier: {}", courierDto.courierId() + courierDto.courierName());
        CourierEntity courierEntity = CourierDto.convert(courierDto);
        return courierRepository.save(courierEntity);

    }

    public ResponseEntity<CourierEntity> getCourierById(Long courierId) throws Exception {


        log.info("Getting Courier: {}", courierId);
        CourierEntity courierEntity = courierRepository.findByCourierId(courierId)
                .orElseThrow(() -> new Exception("No courier with id: {}" + courierId));
        return ResponseEntity.ok(courierEntity);
    }



    public void addCargoOnCourierIds(Long courierId, List<Long> id) throws Exception {
        log.info("Adding Cargo :{}  On Courier: {}", id.toString() , courierId);
        CourierEntity courierEntity =courierRepository.findByCourierId(courierId)
                .orElseThrow(() -> new Exception("No courier with id: {}" + courierId));
         courierEntity.setCouriersCargosIds(id);
        courierRepository.save(courierEntity);
        log.info("Cargo {} added on Courier: {}",id ,courierId);


    }


    public List<Cargo> getAllCargos() throws Exception {
        return cargoServiceSDK.executeGetAllCargos();
    }

    public Cargo getCargoById(Long cargoId) throws Exception {
        return cargoServiceSDK.executeGetCargoById(cargoId);
    }

    public Cargo addCargo(Long courierId, Cargo cargo) throws Exception {
        return cargoServiceSDK.executeAddCargo(cargo);
    }

    public Cargo setState(Long cargoId) throws Exception {
        return cargoServiceSDK.executeSetState(cargoId);
    }







}

