package com.ascii274.view;

import com.ascii274.domain.Video;
import com.ascii274.domain.VideoEstatEnum;

public class VideoView {
	
	public VideoView() {		
	}
	
	public void printVideoView(Video video, VideoEstatEnum videoEstatEnum) {
		// damos forma a la fecha
		System.out.println("  Video[Estat:" + videoEstatEnum+ ", Titol:" + video.getTitol() + 
				", Url:" + video.getUrl() + ", Duracio: " + video.getDuracio() + "]");
	}

}
