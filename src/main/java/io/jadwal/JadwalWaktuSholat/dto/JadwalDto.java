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
public class JadwalDto {

    private String status;
    private DataDto data;

    // getters and setters
}
