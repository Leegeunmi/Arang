CREATE TABLE Artworks (
	aid					BIGINT			PRIMARY KEY AUTO_INCREMENT,
	artworkNum			VARCHAR(11)		NOT NULL,	  		-- 111-11-1111
	storage				VARCHAR(50)		NOT NULL,
	storagePeriod		VARCHAR(10)		NOT NULL,
	deliveryService		CHAR(1)			NOT NULL	DEFAULT 'N',
	regDate				TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001;

SELECT * FROM Artworks;

DELETE TABLE Artworks;

INSERT INTO Artworks (ArtworkNum, storageAddr, storagePeriod, deliveryService) VALUES ('107-99-1234', '서울시 강남구 압구정로 407', '2023-07-12', 'Y');

UPDATE Artworks SET ssn='901212-1234567', phone='010-3434-4444' WHERE cid=1001;

CREATE TABLE Wallet (
	wid			BIGINT		PRIMARY KEY AUTO_INCREMENT,
	balance		INT
)
