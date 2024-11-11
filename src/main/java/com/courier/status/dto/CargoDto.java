package com.courier.status.dto;

import java.util.List;

public record CargoDto (
        Long id,
        String gondericiAdi,
        String gondericiAdresi,
        int desi,
        String aliciAdi,
        String aliciAdresi,
        Object state
        //PackageState state bunu eklemem gerek
){
    @Override
    public Long id() {
        return id;
    }

    @Override
    public String gondericiAdi() {
        return gondericiAdi;
    }

    @Override
    public String gondericiAdresi() {
        return gondericiAdresi;
    }

    @Override
    public int desi() {
        return desi;
    }

    @Override
    public String aliciAdi() {
        return aliciAdi;
    }

    @Override
    public String aliciAdresi() {
        return aliciAdresi;
    }
    @Override
    public Object state() {
        return state;
    }
}
