package io.jadwal.JadwalWaktuSholat.dto;

import lombok.*;

import java.util.List;

/**
 * @author "Noverry Ambo"
 * @start 4/2/2023
 */
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

public class LokasiKota {
    private String status;
    private QueryKota query;
    private List<Kota> kota;

    @Data
    @Setter
    @Getter
    @NoArgsConstructor
    public static class QueryKota{
        private String format;
        private String nama;
    }

    @Data
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Kota{
        private String id;
        private String nama;

    }


}
