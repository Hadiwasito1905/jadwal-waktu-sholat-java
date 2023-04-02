package io.jadwal.JadwalWaktuSholat.controller;

import com.google.gson.Gson;
import io.jadwal.JadwalWaktuSholat.dto.ResponseJadwal;
import io.jadwal.JadwalWaktuSholat.service.JadwalSholatClient;
import io.jadwal.JadwalWaktuSholat.service.LokasiKotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author "Noverry Ambo"
 * @start 4/2/2023
 */
@RestController
@RequestMapping("/api/jadwal")
public class JadwalSholatController {
    Gson gson = new Gson();

    @Autowired
    JadwalSholatClient jadwalSholatClient;

    @Autowired
    LokasiKotaService lokasiKotaService;

    @GetMapping("/sholat")
    public ResponseEntity<?> getAllData(@RequestParam String kodeWilayah){
        Object jadwal = jadwalSholatClient.getDataJadwalSholat(kodeWilayah);
        return new ResponseEntity<>(jadwal, HttpStatus.OK);
    }

    @GetMapping("/list/sholat")
    public ResponseEntity<?> getData(@RequestParam String namaWilayah){
        List<ResponseJadwal> jadwal = jadwalSholatClient.getByInjectWilayah(namaWilayah);
        return new ResponseEntity<>(jadwal, HttpStatus.OK);
    }

    @GetMapping("/kota")
    public ResponseEntity<?> getAllDataKota(@RequestParam String namaWilayah){
        Object wilayah = lokasiKotaService.getListKota(namaWilayah);
        return new ResponseEntity<>(wilayah, HttpStatus.OK);
    }
}
