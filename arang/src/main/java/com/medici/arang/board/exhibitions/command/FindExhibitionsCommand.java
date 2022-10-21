package com.medici.arang.board.exhibitions.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FindExhibitionsCommand {
	private String exhibitionTitle;
	private String startDate;
	private String endDate;
	private String artworkImgPath;
}
