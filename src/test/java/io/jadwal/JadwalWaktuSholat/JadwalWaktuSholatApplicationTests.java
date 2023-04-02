package io.jadwal.JadwalWaktuSholat;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.jadwal.JadwalWaktuSholat.service.JadwalSholatClient;
import io.jadwal.JadwalWaktuSholat.service.LokasiKotaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JadwalWaktuSholatApplicationTests {

	Gson gson = new Gson();
	@Autowired
	JadwalSholatClient jadwalSholatClient;
	@Autowired
	LokasiKotaService lokasiKotaService;

	@Test
	void contextLoads() {
		String json = gson.toJson(lokasiKotaService.getKota("Yogyakarta"));


		System.out.println("=========================");
		System.out.println(jadwalSholatClient.getjadwalSholat("703"));
		System.out.println(json);

	}

}
