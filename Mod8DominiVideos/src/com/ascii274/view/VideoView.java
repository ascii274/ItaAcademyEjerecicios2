package com.ascii274.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.ascii274.domain.Video;
import com.ascii274.domain.VideoEstat;

public class VideoView {
	
	public VideoView() {		
	}
	
	public void printVideoView(Video video, VideoEstat videoEstat) {
		// damos forma a la fecha
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTimeString = video.getDataPujada().format(formatter);		
		System.out.println("  Video[Estat:" + videoEstat+ ", Titol:" + video.getTitol() + ", Url:" + video.getUrl()+ "]");
	}

}
