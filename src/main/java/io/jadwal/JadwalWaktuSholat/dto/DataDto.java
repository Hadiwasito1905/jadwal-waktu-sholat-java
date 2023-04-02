package io.jadwal.JadwalWaktuSholat.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author "Noverry Ambo"
 * @start 4/2/2023
 */
@Data
@Getter
@Setter
@NoArgsConstructor
public class DataDto {
    private String ashar;
    private String dhuha;
    private String dzuhur;
    private String imsak;
    private String isya;
    private String maghrib;
    private String subuh;
    private String tanggal;
    private String terbit;
}