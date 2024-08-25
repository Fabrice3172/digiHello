package fr.diginamic.digiHello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import fr.diginamic.digiHello.dto.VilleDto;
import fr.diginamic.digiHello.model.Ville;
import fr.diginamic.digiHello.service.VilleService;
import jakarta.validation.constraints.AssertTrue;

@ActiveProfiles("test")
@SpringBootTest
public class VilleServiceTest {
	
	@Autowired
	VilleService villeService;
	
	@Test
	public void testExtractVille() {
		Iterable<VilleDto> villes = villeService.extractVilles();
		assertTrue(villes.iterator().hasNext());
	}
}
