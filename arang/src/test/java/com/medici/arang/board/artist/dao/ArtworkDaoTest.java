package com.medici.arang.board.artist.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.medici.arang.board.artist.command.ArtworkCommand;

@SpringJUnitConfig(classes = {
		com.medici.arang.common.jdbc.DataSourceConfig.class
})
@EnableTransactionManagement
@WebAppConfiguration
public class ArtworkDaoTest {
	
	@Autowired
	private ArtworkDao artworkDao;
//	
//	@Test
//	@Transactional
//	public void addArtwork() {
//		ArtworkCommand a = new ArtworkCommand();
//		a.setArtistId(1001);
//		a.setArtworkName("조조");
//		a.setArtworkImg("2rfdsf3.png");
//		a.setDescription("설명하는 ~~~ 구간 ~~");
//		a.genre("서양화");
//		
//		artworkDao.addArtwork(a);
//		System.out.println("-inserted");
//	}
}
