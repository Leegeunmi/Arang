package com.medici.arang.common.jdbc;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.medici.arang.board.artist.dao.ArtistInfoDao;
import com.medici.arang.board.artist.dao.ArtworkDao;
import com.medici.arang.board.artist.dao.ArtworkInfoDao;
import com.medici.arang.board.artist.service.ArtistInfoServiceImpl;
import com.medici.arang.board.artist.service.ArtworkInfoServiceImpl;
import com.medici.arang.board.artist.service.ArtworkServiceImpl;
import com.medici.arang.board.contact.dao.ContactDao;
import com.medici.arang.board.contact.service.ContactServiceImpl;
import com.medici.arang.board.exhibitions.dao.ExhibitionDao;
import com.medici.arang.board.exhibitions.service.ExhibitionServiceImpl;
import com.medici.arang.board.gallery.dao.GalleryDao;
import com.medici.arang.board.gallery.dao.GalleryInfoDao;
import com.medici.arang.board.gallery.service.GalleryInfoServiceImpl;
import com.medici.arang.board.gallery.service.GalleryServiceImpl;
import com.medici.arang.board.notice.dao.NoticeDao;
import com.medici.arang.board.notice.service.NoticeServiceImpl;
import com.medici.arang.like.dao.LikeDao;
import com.medici.arang.like.service.LikeServiceImpl;
import com.medici.arang.shop.dao.ShopCategoryDao;
import com.medici.arang.shop.dao.ShopItemDao;
import com.medici.arang.shop.service.ShopCategoryServiceImpl;
import com.medici.arang.shop.service.ShopItemServiceImpl;
import com.medici.arang.storage.dao.StorageDao;
import com.medici.arang.storage.service.StorageServiceImpl;
import com.medici.arang.user.dao.ArtistDao;
import com.medici.arang.user.dao.GalleristDao;
import com.medici.arang.user.service.ArtistServiceImpl;
import com.medici.arang.user.service.GalleristServiceImpl;



@Configuration
public class DataSourceConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/arang?serverTimezone=Asia/Seoul");
		ds.setUsername("arang");
		ds.setPassword("arang");
		ds.setInitialSize(2);	// 커넥션 풀 초기화시 생설할 초기 커넥션 갯수(기본값 10)
		ds.setMaxActive(10);	//풀에서 가져올 수 있는 최대 커넥션 갯수(기본값 100)
		ds.setMaxIdle(10);		//풀에 유지할 수 있는 최대 커넥션 수(기본값은 maxActive와 동일)
		return ds;
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource());
		return txManager;
	}
	
	@Bean
	public ArtworkDao artworkDao() {
		return new ArtworkDao(dataSource());
	}
	
	@Bean
	public ArtworkServiceImpl artworkServiceImpl() {
		return new ArtworkServiceImpl();
	}
	
	@Bean
	public ArtistDao artistDao() {
		return new ArtistDao(dataSource());
	}
	
	@Bean
	public ArtistServiceImpl artistService() {
		return new ArtistServiceImpl();
	}
	
	@Bean
	public ArtistInfoDao artistInfoDao() {
		return new ArtistInfoDao(dataSource());
	}
	
	@Bean
	public ArtistInfoServiceImpl artistInfoService() {
		return new ArtistInfoServiceImpl();
	}
	
	@Bean
	public ArtworkInfoDao artworkInfoDao() {
		return new ArtworkInfoDao(dataSource());
	}
	
	@Bean
	public ArtworkInfoServiceImpl artworkInfoService() {
		return new ArtworkInfoServiceImpl();
	}
	
	@Bean
	public GalleristDao galleristDao() {
		return new GalleristDao(dataSource());
	}
	
	@Bean
	public GalleristServiceImpl galleristService() {
		return new GalleristServiceImpl();
	}
	
	@Bean
	public GalleryDao galleryDao() {
		return new GalleryDao(dataSource());
	}

	@Bean
	public GalleryServiceImpl galleryServiceImpl() {
		return new GalleryServiceImpl();
	}
	
	@Bean
	public GalleryInfoDao galleryInfoDao() {
		return new GalleryInfoDao(dataSource());
	}
	
	@Bean
	public GalleryInfoServiceImpl galleryInfoServiceImpl() {
		return new GalleryInfoServiceImpl();
	}
	
	@Bean
	public ContactDao contactDao() {
		return new ContactDao(dataSource());
	}
	
	@Bean
	public ContactServiceImpl contactServiceImpl() {
		return new ContactServiceImpl();
	}
	
	@Bean
	public ExhibitionDao exhibitionDao() {
		return new ExhibitionDao(dataSource());
	}
	
	@Bean
	public ExhibitionServiceImpl exhibitionServiceImpl() {
		return new ExhibitionServiceImpl();
	}
	
	
	@Bean
	public StorageDao storageDao() {
	   return new StorageDao(dataSource());
	}
	   
	@Bean
	public StorageServiceImpl storageServiceImpl() {
	   return new StorageServiceImpl();
	}
	
	
	@Bean
	public LikeDao likeDao() {
	   return new LikeDao(dataSource());
	}
	   
	@Bean
	public LikeServiceImpl likeService() {
	   return new LikeServiceImpl();
	}
	
	@Bean
	public NoticeDao noticeDao() {
	   return new NoticeDao(dataSource());
	}
	
	@Bean
	public NoticeServiceImpl noticeService() {
	   return new NoticeServiceImpl();
	}
	
	@Bean
	public ShopItemDao shopItemDao() {
		return new ShopItemDao(dataSource());
	}
	
	@Bean
	public ShopCategoryDao shopCategoryDao() {
		return new ShopCategoryDao(dataSource());
	}
	
	@Bean
	public ShopItemServiceImpl shopItemService() {
		return new ShopItemServiceImpl();
	}
	
	@Bean
	public ShopCategoryServiceImpl shopCategoryService() {
		return new ShopCategoryServiceImpl();
	}
}
