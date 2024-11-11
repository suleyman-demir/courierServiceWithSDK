package com.courier.status.client;

import com.courier.status.dto.CargoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "cargo", url = "http://127.0.0.1:8080/v1/api/delivery")
public interface CargoServiceClient {


//
//    @GetMapping("/cargos")
//    ResponseEntity<List<CargoDto>> getAllCargos();
//
//    @GetMapping("/cargo/{id}")
//   CargoDto getCargoById(@PathVariable("id") Long id);
//
//    @PostMapping("/setState/{id}")
//    ResponseEntity<CargoDto> setState(@PathVariable("id") Long id);
//
    @PostMapping("/byIds")
    ResponseEntity<List<CargoDto>> findByIds(@RequestBody List<Long> ids);
}
