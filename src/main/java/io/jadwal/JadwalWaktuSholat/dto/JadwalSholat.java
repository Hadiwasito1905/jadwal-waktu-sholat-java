package io.jadwal.JadwalWaktuSholat.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class JadwalSholat {
    private String status;
    private QueryDto query;
    private JadwalDto jadwal;

//        @JsonCreator
//        public DataDto(@JsonProperty("subuh") String subuh,
//                       @JsonProperty("terbit") String terbit,
//                       @JsonProperty("dhuha") String dhuha,
//                       @JsonProperty("dzuhur") String dzuhur,
//                       @JsonProperty("ashar") String ashar,
//                       @JsonProperty("maghrib") String maghrib,
//                       @JsonProperty("isya") String isya,
//                       @JsonProperty("imsak") String imsak,
//                       @JsonProperty("tanggal") String tanggal) {
//            this.subuh = subuh;
//            this.terbit = terbit;
//            this.dhuha = dhuha;
//            this.dzuhur = dzuhur;
//            this.ashar = ashar;
//            this.maghrib = maghrib;
//            this.isya = isya;
//            this.imsak = imsak;
//            this.tanggal = tanggal;
//        }

        // getter dan setter untuk setiap properti
    }
