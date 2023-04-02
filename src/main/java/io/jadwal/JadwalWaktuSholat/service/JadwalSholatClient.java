package io.jadwal.JadwalWaktuSholat.service;

import io.jadwal.JadwalWaktuSholat.dto.JadwalSholat;
import io.jadwal.JadwalWaktuSholat.dto.LokasiKota;
import io.jadwal.JadwalWaktuSholat.dto.ResponseJadwal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author "Noverry Ambo"
 * @start 4/2/2023
 */
@Service
@Slf4j
public class JadwalSholatClient {
    @Autowired
    LokasiKotaService lokasiKotaService;

    private RestTemplate restTemplate = new RestTemplate();

    public String formatedDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String sdf = date.format(formater);
        return sdf;
    }

    public JadwalSholat getjadwalSholat(String kodeWilayah){
        String baseUrl = "https://api.banghasan.com/sholat/format/json/jadwal";
        String kota = "/kota/" + kodeWilayah;
        String tanggal = "/tanggal/" + formatedDate();
        String url = baseUrl + kota + tanggal;
        JadwalSholat jadwalSholat = restTemplate.getForObject(url, JadwalSholat.class);
        return jadwalSholat;
    }

    public ResponseJadwal getDataJadwalSholat(String kodeWilayah){

        JadwalSholat jadwalSholat = getjadwalSholat(kodeWilayah);
        ResponseJadwal responseJadwal = new ResponseJadwal();
        ResponseJadwal.DataJadwal dataJadwal = new ResponseJadwal.DataJadwal();

        dataJadwal.setSubuh(jadwalSholat.getJadwal().getData().getSubuh());
        dataJadwal.setTerbit(jadwalSholat.getJadwal().getData().getTerbit());
        dataJadwal.setDhuha(jadwalSholat.getJadwal().getData().getDhuha());
        dataJadwal.setDzuhur(jadwalSholat.getJadwal().getData().getDzuhur());
        dataJadwal.setAshar(jadwalSholat.getJadwal().getData().getAshar());
        dataJadwal.setMaghrib(jadwalSholat.getJadwal().getData().getMaghrib());
        dataJadwal.setIsya(jadwalSholat.getJadwal().getData().getIsya());
        dataJadwal.setImsak(jadwalSholat.getJadwal().getData().getImsak());

        responseJadwal.setTanggal(jadwalSholat.getQuery().getTanggal());
        responseJadwal.setKota(jadwalSholat.getQuery().getKota());
        responseJadwal.setDataJadwal(dataJadwal);

        return responseJadwal;
    }

    public List<ResponseJadwal> getByInjectWilayah(String namaWilayah){
        List<LokasiKota.Kota> locs = lokasiKotaService.getListKota(namaWilayah);
        List<ResponseJadwal> data = new ArrayList<>();
        for (LokasiKota.Kota record : locs){
            JadwalSholat jadwalSholat = getjadwalSholat(record.getId());
            ResponseJadwal responseJadwal = new ResponseJadwal();
            ResponseJadwal.DataJadwal dataJadwal = new ResponseJadwal.DataJadwal();

            dataJadwal.setSubuh(jadwalSholat.getJadwal().getData().getSubuh());
            dataJadwal.setTerbit(jadwalSholat.getJadwal().getData().getTerbit());
            dataJadwal.setDhuha(jadwalSholat.getJadwal().getData().getDhuha());
            dataJadwal.setDzuhur(jadwalSholat.getJadwal().getData().getDzuhur());
            dataJadwal.setAshar(jadwalSholat.getJadwal().getData().getAshar());
            dataJadwal.setMaghrib(jadwalSholat.getJadwal().getData().getMaghrib());
            dataJadwal.setIsya(jadwalSholat.getJadwal().getData().getIsya());
            dataJadwal.setImsak(jadwalSholat.getJadwal().getData().getImsak());

            responseJadwal.setTanggal(jadwalSholat.getQuery().getTanggal());
            responseJadwal.setKota(record.getNama());
            responseJadwal.setDataJadwal(dataJadwal);

            data.add(responseJadwal);
        }

        return data;

    }




}
