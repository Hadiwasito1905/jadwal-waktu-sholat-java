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
@Setter
@Getter
@NoArgsConstructor
public class QueryDto {
    private String format;
    private String kota;
    private String tanggal;
}
