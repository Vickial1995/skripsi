package id.ac.budiluhur.absensi;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AbsensiApplicationTests {

	@Test
	void contextLoads() {
		String coegHashing = ArgonHashing.hash("coeg");
		System.out.println(coegHashing);
		boolean stat = ArgonHashing.verify("coegx",coegHashing);
		System.out.println(stat);
	}

}
