package io.jadwal.JadwalWaktuSholat.service;

import io.jadwal.JadwalWaktuSholat.dto.LokasiKota;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author "Noverry Ambo"
 * @start 4/2/2023
 */
@Service
@Slf4j
public class LokasiKotaService {

    private RestTemplate restTemplate = new RestTemplate();
    String baseUrl = "https://api.banghasan.com/sholat/format/json/kota/nama/";

    public LokasiKota getKota(String kota){
        String url = baseUrl + kota;
        LokasiKota locs = restTemplate.getForObject(url, LokasiKota.class);
        return locs;
    }

    public List<LokasiKota.Kota> getListKota(String kota){
        LokasiKota allData = getKota(kota);
        List<LokasiKota.Kota> dataKota = new ArrayList<>();

        for (LokasiKota.Kota record : allData.getKota()){
            LokasiKota.Kota model = new LokasiKota.Kota();
            model.setId(record.getId());
            model.setNama(record.getNama());
            dataKota.add(model);
        }

        return dataKota;
    }
}
