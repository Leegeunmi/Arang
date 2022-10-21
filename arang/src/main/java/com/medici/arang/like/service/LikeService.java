package com.medici.arang.like.service;

import java.util.List;

import com.medici.arang.board.artist.command.ArtworkCommand;
import com.medici.arang.board.artist.command.FindArtistInfoCommand;
import com.medici.arang.board.gallery.command.GalleryPageCommand;
import com.medici.arang.like.domain.LikeVo;
import com.medici.arang.user.command.ArtistPageCommand;

public interface LikeService {
	void updateLike(LikeVo likeVo, String userId, String targetValue);
	int getLike(String userId, String targetValue);
	void likeUp(LikeVo likeVo);
	void likeDown(String userId, String targetValue);
	LikeVo findLike(String userId, String targetValue);
	List<LikeVo> findLike();
	List<LikeVo> findLike(String userId);
	LikeVo findLikeByTargetId(long targetValue);
	List<ArtistPageCommand> findArtistJoinLike(String email);
	List<ArtworkCommand> findArtworkJoinLike(String email);
	List<GalleryPageCommand> findGalleryJoinLike(String email);
	long getLikeArtistCount(String email);
	LikeVo findLike(String userId, long targetValue);
}
