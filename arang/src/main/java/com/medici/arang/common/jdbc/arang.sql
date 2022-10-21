!DROP TABLE Artist;
!DELETE FROM Artist WHERE aid=16;
!ALTER TABLE Artist MODIFY genre VARCHAR(100);

CREATE TABLE Artist(
  aid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
  email			VARCHAR(30)		NOT NULL,
  passwd		VARCHAR(20)		NOT NULL,
  name_kor		VARCHAR(20)		NOT NULL,
  name_eng		VARCHAR(20)		NOT NULL,
  ssn			VARCHAR(20)		NOT NULL,
  phone			VARCHAR(13)		NOT NULL,
  genre			VARCHAR(100)	NOT NULL,
  career		VARCHAR(100)	NOT NULL,
  imgPath		VARCHAR(300)	NOT NULL,
  regDate		TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1;

SELECT * FROM Artist;

--아티스트 회원가입(샘플)
INSERT INTO Artist (email, passwd, name_kor, name_eng, ssn, phone, genre, career, imgPath)
VALUES ('seohee@naver.com', '123', '안서희', 'An Seo hee', '950121-2569456', '010-5894-1212', 'Sculptor', '부산 리오갤러리 "흐름"전', '/upload_img/artist/AnSeoHee/profile.jpg');
INSERT INTO Artist (email, passwd, name_kor, name_eng, ssn, phone, genre, career, imgPath)
VALUES ('hyein@naver.com', '123', '추혜인', 'Choo Hye in', '900121-2569456', '010-3365-0121', 'Painter', '대구 수창아트센터"power-pack"전', '/upload_img/artist/ChooHyeIn/profile.jpg');
INSERT INTO Artist (email, passwd, name_kor, name_eng, ssn, phone, genre, career, imgPath)
VALUES ('bohei@naver.com', '123', '김보희', 'Kim Bo hei', '950121-2569456', '010-5689-0121', 'Painter', '서울 아라리오갤러리 "쉼에 대하여" 단체전', '/upload_img/artist/KimBoHei/profile.jpg');
INSERT INTO Artist (email, passwd, name_kor, name_eng, ssn, phone, genre, career, imgPath)
VALUES ('guiyeon@naver.com', '123', '김귀연', 'Kim Gui yeon', '880121-2569456', '010-1789-0121', 'Painter', '서울 아트페어 입상', '/upload_img/artist/KimGuiYeon/profile.jpg');
INSERT INTO Artist (email, passwd, name_kor, name_eng, ssn, phone, genre, career, imgPath)
VALUES ('hyowon@naver.com', '123', '김효원', 'Kim Hyo won', '890121-1569456', '010-1569-0121', 'DigitalArtist', '대전 바오갤러리 "lonly"전', '/upload_img/artist/KimHyoWon/profile.jpg');
INSERT INTO Artist (email, passwd, name_kor, name_eng, ssn, phone, genre, career, imgPath)
VALUES ('ranhee@naver.com', '123', '김란희', 'Kim Ran hee', '910121-2569456', '010-1569-0121', 'Painter', '서울 아트페어 입상', '/upload_img/artist/KimRanHee/profile.jpg');
INSERT INTO Artist (email, passwd, name_kor, name_eng, ssn, phone, genre, career, imgPath)
VALUES ('kimsun@naver.com', '123', '김선', 'Kim Sun', '900121-2869456', '010-3789-0121', 'Painter', '서울 도리아트센터 "우아하게" 단체전', '/upload_img/artist/KimSun/profile.jpg');
INSERT INTO Artist (email, passwd, name_kor, name_eng, ssn, phone, genre, career, imgPath)
VALUES ('woojoon@naver.com', '123', '이우준', 'Lee Woo joon', '930121-1569456', '010-3389-0121', 'Photographer', '서울 아라리오갤러리 "지금우리" 사진전', '/upload_img/artist/LeeWooJoon/profile.jpg');
INSERT INTO Artist (email, passwd, name_kor, name_eng, ssn, phone, genre, career, imgPath)
VALUES ('heesu@naver.com', '123', '서희수', 'Suh Hee su', '900121-2569456', '010-4569-0121', 'Painter', '서울 아트페어 입상', '/upload_img/artist/SuhHeeSu/profile.jpg');
INSERT INTO Artist (email, passwd, name_kor, name_eng, ssn, phone, genre, career, imgPath)
VALUES ('rahee@naver.com', '123', '윤라희', 'Yoon Ra hee', '890121-2569456', '010-8969-0121', 'Sculptor', '서울 썬갤러리 "공간의 미학" 단체전', '/upload_img/artist/YoonRaHee/profile.jpg');
INSERT INTO Artist (email, passwd, name_kor, name_eng, ssn, phone, genre, career, imgPath)
VALUES ('geonwoo@naver.com', '123', '이건우', 'Lee Geon woo', '880121-1569456', '010-1169-0121', 'Painter', '대구 수창갤러리 "Joy&Joy" 단체전', '/upload_img/artist/LeeGeonWoo/profile.jpg');
INSERT INTO Artist (email, passwd, name_kor, name_eng, ssn, phone, genre, career, imgPath)
VALUES ('changmok@naver.com', '123', '유창목', 'Yoo Chang mok', '861221-1469456', '010-8933-0121', 'Sculptor;OrientalPainter;', '부산 타우갤러리 "내 안에" 단체전', '/upload_img/artist/YooChoongMok/profile.jpg');


UPDATE Artist SET imgPath = "/upload_img/artist/KimHyoWon/profile.jpg" WHERE aid = 48;

CREATE TABLE ArtistInfo (
	bid 				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	artistId			BIGINT			NOT NULL,
	title				VARCHAR(200)	NOT NULL,
	description			VARCHAR(1000)	NOT NULL,
	infoImgPath			VARCHAR(400)	NOT NULL,
	regDate				TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT ArtistInfo_artistId_FK
		FOREIGN KEY(artistId) REFERENCES Artist(aid)
)AUTO_INCREMENT = 2001;

SELECT * FROM Artist;
SELECT * FROM ArtistInfo;

!DROP TABLE ArtistInfo;
!DELETE FROM ArtistInfo WHERE artistId=16;

--아티스트 상세(샘플)
--Yoon Ra hee
INSERT INTO ArtistInfo (artistId, title, description, infoImgPath)
VALUES (26, '날 것 그대로의 본질에 우연적 효과를 불어넣다', 
'윤라희 작가는 서울에서 활동하는 디자이너이자 아티스트이다. 금속, 섬유, 도자, 목공을 아우르는 넓은 영역의 
공예를 전공한 뒤, 2017년에 스튜디오를 열어 본격적인 작품 활동을 시작하였다. 그녀는 특유의 섬세함으로 
작품에 고유한 성격을 부여한다. 재료, 날 것 그대로의 본질에 우연적 효과를 불어 넣어 불규칙하면서 솔직한 
방식으로 결과를 드러낸다. 주 소재로 몰두하고 있는 ‘아크릴’이라는 소재를 다루는 시간 속에서 작가는 소재의 
역사, 특정 이미지로 인식되어진 명사로서의 ‘아크릴’은 잊어버린 상태이다. ‘진하게 스며들게 하다’, ‘미묘하
게 굴절시키다’, ‘단순하게 중첩하다.’ 등처럼 재료를 다루면서 느껴지는 형용사와 행동되는 동사의 조합에 집중
하고, 그 안에 담긴 은유와 이미지를 자신만의 방식으로 해석하는 작업을 선보이고 있다. 윤라희 작가의 모든 작업
은 작가의 손으로부터 한국의 소규모 공방 및 특별한 엔지니어들과의 긴밀한 협업을 거쳐, 심도 깊은 아름다움
을 지닌 오브제로 완성되고 있다. 다양한 분야의 경계를 넘나드는 작품은 전시 뿐만 아니라 국내외 기업, 스튜디
오들과의 다채로운 협업을 이어가고 있다.', 
'/upload_img/artist/YoonRaHee/artist_detail.jpg');

--Kim Hyo won
INSERT INTO ArtistInfo (artistId, title, description, infoImgPath)
VALUES (48, '도시정원', 
'김효원 작가는 성신여대 국문과를 졸업, 한국외대 정치행정언론대학원을 수료하고 30년 가까이 언론계에 종사했다. 오요나라는 필명으로 에세이 ‘내방에는 돌고래가 산다’ 등을 펴냈고, 어릴 적 꿈인 그림을 꾸준히 그려 개인전 ‘도시정원’(키스갤러리, 2014) 등 3회 개인전을 비롯해 ‘매혹전’(갤러리소머리국밥,2009) 등 다수의 단체전에 참가했다. 일상의 소소한 풍경들을 단순화한 구도로 진솔하게 그려내는 것이 특징이다. 어린 시절 고향을 떠나 도시에서 살아가는 자신이 마치 도시 곳곳, 자그마한 화분에서 옹색하게 자라고 있는 식물같다고 생각하는 그는 다양한 식물의 모습을 통해 현대인의 모습을 발견해 그림으로 옮긴다. 무심코 지나친 것들에 사랑, 생명의 소중함을 느끼게 해주는 그림들이다. 2009년부터는 물감과 붓 대신 아이패드로 작업해 보다 자유롭고 현대적인 그림을 선보이고 있다.', 
'/upload_img/artist/KimHyoWon/artist_detail.jpg');


SELECT a.name_kor, a.ssn, a.imgPath, b.title, b.description, b.infoImgPath 
FROM ArtistInfo b LEFT JOIN Artist a ON a.aid = b.artistId WHERE a.aid = 1;



UPDATE Artwork SET name = 'BLOCK (Falling Blue Brown)' WHERE artistId = '2';

!DROP TABLE Artwork;
CREATE TABLE Artwork (
	wid 				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	artistId			BIGINT			NOT NULL,
	name				VARCHAR(60)		NOT NULL,
	genre				VARCHAR(20)		NOT NULL,
	technique			VARCHAR(60)		NOT NULL,
	size				VARCHAR(40)		NOT NULL,
	publicationDate		VARCHAR(40)		NOT NULL,
	description			VARCHAR(500)	NOT NULL,
	artworkImgPath		VARCHAR(300)	NOT NULL,
	regDate				TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Artwork_artistId_FK
		FOREIGN KEY(artistId) REFERENCES Artist(aid)
)AUTO_INCREMENT = 1001;

--Yoon Ra hee
INSERT INTO Artwork (artistId, name, genre, technique, size, publicationDate, description, artworkImgPath)
VALUES (53, 'BLOCK (Falling Blue Brown)', 'Sculptor', '아크릴(Acrylic)', '21x11cm', '2019',
'‘아크릴’이라는 소재를 다루는 시간 속에서 나는 소재의 역사, 특정 이미지로 인식되어진 명사로서의 ‘아크릴’은 잊어버린 상태이다.
‘진하게 스며들게 하다’, ‘미묘하게 굴절시키다’, ‘단순하게 중첩하다.’ 등처럼 재료를 다루면서 느껴지는 형용사와 행동되
는 동사의 조합에 집중하고, 그 안에 담긴 은유와 이미지를 나만의 방식으로 해석하는 작업을 한다.',
'/upload_img/artist/YoonRaHee/artwork1.jpg');
INSERT INTO Artwork (artistId, name, genre, technique, size, publicationDate, description, artworkImgPath)
VALUES (53, 'BLOCK (Blue and Earthy Brown)', 'Sculptor', '아크릴(Acrylic)', '29x21cm', '2019',
'‘아크릴’이라는 소재를 다루는 시간 속에서 나는 소재의 역사, 특정 이미지로 인식되어진 명사로서의 ‘아크릴’은 잊어버린 상태이다.
‘진하게 스며들게 하다’, ‘미묘하게 굴절시키다’, ‘단순하게 중첩하다.’ 등처럼 재료를 다루면서 느껴지는 형용사와 행동되
는 동사의 조합에 집중하고, 그 안에 담긴 은유와 이미지를 나만의 방식으로 해석하는 작업을 한다.',
'/upload_img/artist/YoonRaHee/artwork2.jpg');
INSERT INTO Artwork (artistId, name, genre, technique, size, publicationDate, description, artworkImgPath)
VALUES (53, 'Block (Shades of Blue)', 'Sculptor', '아크릴(Acrylic)', '18x20cm', '2019',
'‘아크릴’이라는 소재를 다루는 시간 속에서 나는 소재의 역사, 특정 이미지로 인식되어진 명사로서의 ‘아크릴’은 잊어버린 상태이다.
‘진하게 스며들게 하다’, ‘미묘하게 굴절시키다’, ‘단순하게 중첩하다.’ 등처럼 재료를 다루면서 느껴지는 형용사와 행동되
는 동사의 조합에 집중하고, 그 안에 담긴 은유와 이미지를 나만의 방식으로 해석하는 작업을 한다.',
'/upload_img/artist/YoonRaHee/artwork3.jpg');
INSERT INTO Artwork (artistId, name, genre, technique, size, publicationDate, description, artworkImgPath)
VALUES (53, 'BLOCK (Horizontal Black)', 'Sculptor', '아크릴(Acrylic)', '11.5x17cm', '2020',
'‘아크릴’이라는 소재를 다루는 시간 속에서 나는 소재의 역사, 특정 이미지로 인식되어진 명사로서의 ‘아크릴’은 잊어버린 상태이다.
‘진하게 스며들게 하다’, ‘미묘하게 굴절시키다’, ‘단순하게 중첩하다.’ 등처럼 재료를 다루면서 느껴지는 형용사와 행동되
는 동사의 조합에 집중하고, 그 안에 담긴 은유와 이미지를 나만의 방식으로 해석하는 작업을 한다.',
'/upload_img/artist/YoonRaHee/artwork4.jpg');

--Kim Hyo won
INSERT INTO Artwork (artistId, name, genre, technique, size, publicationDate, description, artworkImgPath)
VALUES (48, '빨간 의자가 있는 풍경', 'DigitalArtist', '아카이벌(Archival)', '48x49cm', '2019',
'일상의 소소한 풍경들을 단순화한 구도로 진솔하게 그려내는 것이 특징이다. 어린 시절 고향을 떠나 도시에서 살아가는 내가 마치 도시 곳곳, 자그마한 화분에서 옹색하게 자라고 있는 식물같다고 생각하는 나는 다양한 식물의 모습을 통해 현대인의 모습을 발견해 그림으로 옮긴다.',
'/upload_img/artist/KimHyoWon/artwork1.jpg');
INSERT INTO Artwork (artistId, name, genre, technique, size, publicationDate, description, artworkImgPath)
VALUES (48, '참새의 지저귐', 'DigitalArtist', '아카이벌(Archival)', '46x63cm', '2019',
'일상의 소소한 풍경들을 단순화한 구도로 진솔하게 그려내는 것이 특징이다. 어린 시절 고향을 떠나 도시에서 살아가는 내가 마치 도시 곳곳, 자그마한 화분에서 옹색하게 자라고 있는 식물같다고 생각하는 나는 다양한 식물의 모습을 통해 현대인의 모습을 발견해 그림으로 옮긴다.',
'/upload_img/artist/KimHyoWon/artwork2.jpg');
INSERT INTO Artwork (artistId, name, genre, technique, size, publicationDate, description, artworkImgPath)
VALUES (48, '파란 화병이 있는 방', 'DigitalArtist', '아카이벌(Archival)', '46x63cm', '2019',
'일상의 소소한 풍경들을 단순화한 구도로 진솔하게 그려내는 것이 특징이다. 어린 시절 고향을 떠나 도시에서 살아가는 내가 마치 도시 곳곳, 자그마한 화분에서 옹색하게 자라고 있는 식물같다고 생각하는 나는 다양한 식물의 모습을 통해 현대인의 모습을 발견해 그림으로 옮긴다.',
'/upload_img/artist/KimHyoWon/artwork3.jpg');
INSERT INTO Artwork (artistId, name, genre, technique, size, publicationDate, description, artworkImgPath)
VALUES (48, '빛 나무', 'DigitalArtist', '아카이벌(Archival)', '46x53cm', '2020',
'일상의 소소한 풍경들을 단순화한 구도로 진솔하게 그려내는 것이 특징이다. 어린 시절 고향을 떠나 도시에서 살아가는 내가 마치 도시 곳곳, 자그마한 화분에서 옹색하게 자라고 있는 식물같다고 생각하는 나는 다양한 식물의 모습을 통해 현대인의 모습을 발견해 그림으로 옮긴다.',
'/upload_img/artist/KimHyoWon/artwork4.jpg');


UPDATE Artwork SET artworkImgPath = '/upload_img/artist/KimHyoWon/artwork4.jpg' WHERE wid = 1019;

SELECT * FROM Artwork GROUP BY artistId;

SELECT * FROM Artwork;

!DELETE FROM Artwork WHERE wid <= 1019;

SELECT a.name, a.genre, a.technique, a.size, a.publicationDate, a.description, 
a.artworkImgPath, b.mainTitle, b.subTitle, b.workInfoImgPath 
FROM Artwork a INNER JOIN ArtworkInfo b ON a.wid = b.artworkId 
WHERE a.wid = 1001;

UPDATE Artwork SET genre = 'Paint' WHERE genre = 'paint';

SELECT DISTINCT FROM Artwork WHERE artistId = 1;

SELECT a.name_kor, a.name_eng, a.genre, a.imgPath, b.artworkImgPath, a.aid, 
b.wid, c.title FROM Artist a INNER JOIN artwork b 
ON b.artistId = a.aid JOIN ArtistInfo c ON a.aid = c.artistId
WHERE a.genre = 'DrawingArtist' GROUP BY b.artistId;

INSERT INTO Artwork (artistId, name, genre, technique, size, publicationDate, 
description, imgPath) VALUES (1001, '조조의 그림', 'painter', '심혈을 기울인 기법', 
'500cm * 500cm', '2022', '조조가 그린 그림입니다.', 'chochoArt.jpg');	


CREATE TABLE ArtworkInfo (
	cid 				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	artworkId			BIGINT			NOT NULL,
	mainTitle			VARCHAR(40)		NOT NULL,
	subTitle			VARCHAR(50)		NOT NULL,
	workInfoImgPath		VARCHAR(200)	NOT NULL,
	regDate				TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT ArtworkInfo_artworkId_FK
		FOREIGN KEY(artworkId) REFERENCES Artwork(wid)
)AUTO_INCREMENT = 3001;

--Yoon Ra hee
INSERT INTO ArtworkInfo (artworkId, mainTitle, subTitle, workInfoImgPath)
VALUES (1012, '물성을 살려 단순함을 끌어내는 것','날 것 그대로의 본질에 우연적 효과를 불어넣다',
'/upload_img/artist/YoonRaHee/artwork1_detail.jpg;
/upload_img/artist/YoonRaHee/artwork1_detail2.jpg;
/upload_img/artist/YoonRaHee/artwork1_detail3.jpg;');
INSERT INTO ArtworkInfo (artworkId, mainTitle, subTitle, workInfoImgPath)
VALUES (1013, '물성을 살려 단순함을 끌어내는 것','날 것 그대로의 본질에 우연적 효과를 불어넣다',
'/upload_img/artist/YoonRaHee/artwork2_detail.jpg;
/upload_img/artist/YoonRaHee/artwork2_detail2.jpg;
/upload_img/artist/YoonRaHee/artwork2_detail3.jpg;');
INSERT INTO ArtworkInfo (artworkId, mainTitle, subTitle, workInfoImgPath)
VALUES (1014, '물성을 살려 단순함을 끌어내는 것','날 것 그대로의 본질에 우연적 효과를 불어넣다',
'/upload_img/artist/YoonRaHee/artwork3_detail.jpg;
/upload_img/artist/YoonRaHee/artwork3_detail2.jpg;
/upload_img/artist/YoonRaHee/artwork3_detail3.jpg;');
INSERT INTO ArtworkInfo (artworkId, mainTitle, subTitle, workInfoImgPath)
VALUES (1015, '물성을 살려 단순함을 끌어내는 것','날 것 그대로의 본질에 우연적 효과를 불어넣다',
'/upload_img/artist/YoonRaHee/artwork4_detail.jpg;
/upload_img/artist/YoonRaHee/artwork4_detail2.jpg;
/upload_img/artist/YoonRaHee/artwork4_detail3.jpg;');



SELECT * FROM ArtworkInfo;

!DROP TABLE ArtworkInfo;
!DELETE FROM ArtworkInfo WHERE cid = 3005;

INSERT INTO Artist (email, passwd) VALUES ('test@naver.com', '1234');
SELECT * FROM Artist;

INSERT INTO Artwork (artistId, artworkName, artworkImg, description, artworkCategory) 
VALUES (101, '조조의 그림', 'chochoArt.jpg', '조조가 그린 그림입니다.', '전통판화');
SELECT * FROM Artwork;
DELETE FROM Artwork WHERE wid=1022;
SELECT * FROM Artwork JOIN Artist ON Artwork.artistId = Artist.aid WHERE mid = ?

UPDATE Artwork SET artistId = 101, artworkName = '조조가 훔친 유비의 그림', 
artworkImg = 'bbart.png', description = '조조가 홈친 유비의 그림이다.', 
artworkCategory = '동양화' WHERE wid = 1001;


!DROP TABLE Gallerist;
!DELETE FROM Gallerist WHERE cid = 1;

CREATE TABLE Gallerist(
	email		VARCHAR(30)		PRIMARY KEY,
	passwd		VARCHAR(20)		NOT NULL,
	name		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(20)		NOT NULL,
	phone		VARCHAR(13)		NOT NULL,
	imgPath		VARCHAR(300),
	regDate		TIMESTAMP		DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM Gallerist;

!DROP TABLE Gallery;
CREATE TABLE Gallery(
	code 					BIGINT		 	PRIMARY KEY  AUTO_INCREMENT,
	galleristEmail			VARCHAR(30)		NOT NULL,
	galleryName_kor 		VARCHAR(20)		NOT NULL,	
	galleryName_eng			VARCHAR(40)		NOT NULL,
	address					VARCHAR(40)		NOT NULL,
	galleryEmail			VARCHAR(40)		NOT NULL,
	galleryPhone			VARCHAR(15)		NOT NULL,
	since					VARCHAR(10)		NOT NULL,
	area					VARCHAR(20)		NOT NULL,
	openClose				VARCHAR(30)		NOT NULL,
	galleryImgPath			VARCHAR(50)		NOT NULL,
	representer				VARCHAR(30)		NOT NULL,
	representerNum			VARCHAR(40)		NOT NULL,
	regDate					TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Gallery_galleristEmail 
		FOREIGN KEY (galleristEmail) REFERENCES Gallerist(email)
) AUTO_INCREMENT = 1;

!ALTER TABLE Gallery MODIFY openClose VARCHAR(200);

SELECT * FROM Gallery;

!DELETE FROM Gallery WHERE code=10;
!DELETE FROM GalleryInfo WHERE galleryCode=10;

!DROP TABLE GalleryInfo;
CREATE TABLE GalleryInfo(
	galleryCode 	BIGINT			NOT NULL,
	description		VARCHAR(1000)	NOT NULL,
	infoImgPath		VARCHAR(300),
	CONSTRAINT GalleryInfo_galleryCode
		FOREIGN KEY (galleryCode) REFERENCES Gallery(code)
);

SELECT * FROM GalleryInfo;

SELECT a.galleristEmail, a.galleryName_kor, a.galleryName_eng, a.address,
a.galleryEmail, a.galleryPhone, a.since, a.area, a.openClose, a.galleryImgPath,
b.description, b.infoImgPath FROM GalleryInfo b LEFT JOIN Gallery a 
ON a.code = b.galleryCode;

!DROP TABLE Contact;
!DELETE FROM Contact WHERE contactId = 101;
CREATE TABLE Contact(
	contactId			BIGINT			PRIMARY KEY  AUTO_INCREMENT,
	galleryCode			BIGINT			NOT NULL,
	artistId			BIGINT			NOT NULL,
	comment				VARCHAR(100)	NULL,
	exhibitionTitle		VARCHAR(20)		NULL,
	startDate			VARCHAR(20)		NULL,
	endDate				VARCHAR(20)		NULL,
	accept				VARCHAR(3)		NULL DEFAULT 'U',
	sendingType			VARCHAR(3)		NOT NULL,
	regDate				TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Contact_galleryCode 
		FOREIGN KEY (galleryCode) REFERENCES Gallery(code),
	CONSTRAINT Contact_artistId 
		FOREIGN KEY (artistId) REFERENCES Artist(aid)
)AUTO_INCREMENT = 101;

SELECT * FROM Contact;


SELECT a.accept, a.regDate, d.imgPath, d.name_kor, d.name_eng, a.exhibitionTitle, 
a.startDate, a.endDate, a.sendingType, a.comment 
FROM Contact a LEFT JOIN Gallery b 
ON b.code = a.galleryCode JOIN Gallerist c 
ON b.galleristEmail = c.email JOIN Artist d 
ON d.aid = a.artistId WHERE c.email = 'test1@naver.com' AND a.sendingType = 'G';


INSERT INTO Contact (galleryCode, artistId) VALUES (3, 11);

SELECT * FROM Contact WHERE galleryCode = 1;

SELECT a.contactId, a.accept, a.regDate, FROM Contact a LEFT JOIN Gallery b 
ON b.code = a.galleryCode WHERE a.artistId = 1 GROUP BY a.contactId;


SELECT exhibitionTitle, startDate, endDate, artworkImgPath FROM Contact a 
INNER JOIN Artwork b ON a.artistId = b.artistId WHERE a.sendingType = 'G' 
AND a.accept = 'Y' GROUP BY a.contactId;



SELECT a.accept, a.regDate, d.imgPath, d.name_kor, d.name_eng, d.genre, 
b.galleryName_eng, b.galleryImgPath
FROM Contact a  
LEFT JOIN Gallery b ON b.code = a.galleryCode
JOIN Gallerist c ON b.galleristEmail = c.email
JOIN Artist d ON d.aid = a.artistId
WHERE c.email = 'test1@naver.com' AND a.sendingType = 'A';




SELECT a.contactId, a.accept, a.regDate, a.startDate, a.endDate, a.exhibitionTitle,
a.comment, b.galleryName_eng, b.galleryImgPath FROM Contact a LEFT JOIN Gallery b 
ON b.code = a.galleryCode WHERE a.artistId = 1 GROUP BY a.contactId;

SELECT a.contactId, a.accept, a.regDate, b.galleryName_eng, b.galleryImgPath, 
a.startDate, a.endDate, a.exhibitionTitle, a.comment, a.galleryCode, 
a.sendingType FROM Contact a LEFT JOIN Gallery b ON b.code = a.galleryCode 
WHERE a.artistId = 1 AND a.sendingType = 'A' GROUP BY a.contactId;

CREATE TABLE Storage (
   sid					BIGINT			PRIMARY KEY AUTO_INCREMENT,
   artistId             VARCHAR(40)     DEFAULT NULL,
   myAddress            VARCHAR(70)     DEFAULT NULL,
   storagePeriodStart  	VARCHAR(20)     DEFAULT NULL,
   storagePeriodEnd     VARCHAR(20)     DEFAULT NULL,
   artworkType          VARCHAR(20)     DEFAULT NULL,
   artworkSize          VARCHAR(30)     DEFAULT NULL,
   artworkWeight        VARCHAR(30)     DEFAULT NULL,
   locationArea         VARCHAR(70)     DEFAULT NULL,
   charge               INT             DEFAULT NULL,
   transport            BOOLEAN         DEFAULT 0,
   approvalStatus       VARCHAR(20)     DEFAULT NULL,
   regDate              TIMESTAMP       DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1;

CREATE TABLE LikeTable(
   lid         		BIGINT           PRIMARY KEY AUTO_INCREMENT,     
   userId    		VARCHAR(50)      DEFAULT NULL,
   targetValue  	VARCHAR(50)      DEFAULT NULL,
   likeNum     		INT(10)         DEFAULT 0,
   regDate      	TIMESTAMP      DEFAULT CURRENT_TIMESTAMP   
)AUTO_INCREMENT = 1;

SELECT * FROM LikeTable;
!DROP TABLE LikeTable;

SELECT exhibitionTitle, startDate, endDate, artworkImgPath FROM Contact a 
INNER JOIN Artwork b ON a.artistId = b.artistId WHERE a.sendingType = 'G' 
AND a.accept = 'Y' GROUP BY a.contactId;

SELECT a.name_kor, a.name_eng, a.genre, a.imgPath,
b.artworkImgPath, a.aid, b.wid, c.title, d.userId
 FROM Artist a INNER JOIN artwork b
 ON b.artistId = a.aid JOIN ArtistInfo c ON a.aid = c.artistId
JOIN LikeTable d ON b.wid = d.targetValue WHERE d.userId='test1@naver.com';

SELECT a.name_kor, a.name_eng, a.genre, a.imgPath,
b.artworkImgPath, a.aid, b.wid, c.title, d.userID
FROM Artist a LEFT JOIN artwork b ON b.artistId = a.aid JOIN ArtistInfo c 
ON c.artistId = b.artistId JOIN LikeTable d ON d.targetValue = c.artistId
WHERE d.userId = 'test1@naver.com'
GROUP BY a.aid;

CREATE TABLE notice(
	num				BIGINT				PRIMARY KEY  AUTO_INCREMENT,
	title			VARCHAR(100)		NOT NULL,
	writer			VARCHAR(50),
	content			VARCHAR(1000)		NOT NULL,
	readCnt			INT,
	regDate			TIMESTAMP			DEFAULT CURRENT_TIMESTAMP
)auto_increment = 1;

SELECT * FROM notice;

CREATE TABLE ShopCategory (
   cateName      VARCHAR(20)      DEFAULT NULL,
   cateCode      VARCHAR(20)      PRIMARY KEY,
   cateCodeRef      VARCHAR(20)      DEFAULT NULL,
   FOREIGN KEY (cateCodeRef) REFERENCES ShopCategory(cateCode)
);

CREATE TABLE ShopItem (
   sid            BIGINT         PRIMARY KEY AUTO_INCREMENT,
   cateCodeRef      VARCHAR(20)      DEFAULT NULL,
   cateCode      VARCHAR(20)      DEFAULT NULL,
   itemName      VARCHAR(100)   DEFAULT NULL,
   itemPrice      DOUBLE         DEFAULT NULL,
   itemNum         INT            DEFAULT NULL,
   itemStock      INT            DEFAULT NULL,
   itemInfo      VARCHAR(500)   DEFAULT NULL,
   itemImg         VARCHAR(200)   NOT NULL,
   regDate         TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
   FOREIGN KEY (cateCode) REFERENCES ShopCategory(cateCode),
   FOREIGN KEY (cateCodeRef) REFERENCES ShopCategory(cateCode)
)AUTO_INCREMENT 1;

SELECT * FROM ShopItem;

CREATE TABLE Cart (
   cid            BIGINT         PRIMARY KEY AUTO_INCREMENT,
   itemImg         VARCHAR(200)   NOT NULL,
   itemName      VARCHAR(100)   DEFAULT NULL,
   itemStock      INT            DEFAULT NULL,
   itemPrice      DOUBLE         DEFAULT NULL
)AUTO_INCREMENT 1001;