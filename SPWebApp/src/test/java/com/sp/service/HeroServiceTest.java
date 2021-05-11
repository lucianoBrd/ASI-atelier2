package com.sp.service;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sp.model.Hero;
import com.sp.repository.HeroRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HeroService.class)
public class HeroServiceTest {

	@Autowired
	private HeroService hService;

	@MockBean
	private HeroRepository hRepo;
	
	Hero tmpHero=new Hero(1, "jdoe", "strong", 100, "https//url.com");
	
	@Test
	public void getHero() {
		Mockito.when(
				hRepo.findById(Mockito.any())
				).thenReturn(Optional.ofNullable(tmpHero));
		Hero heroInfo=hService.getHero(45);
		assertTrue(heroInfo.toString().equals(tmpHero.toString()));
	}
}

