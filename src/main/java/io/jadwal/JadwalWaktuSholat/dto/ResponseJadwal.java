package io.jadwal.JadwalWaktuSholat.dto;

import lombok.*;

/**
 * @author "Noverry Ambo"
 * @start 4/2/2023
 */
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseJadwal {

    private String tanggal;
    private String kota;
    private DataJadwal dataJadwal;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DataJadwal{
        private String subuh;
        private String terbit;
        private String dhuha;
        private String dzuhur;
        private String ashar;
        private String maghrib;
        private String isya;
        private String imsak;
    }
}
