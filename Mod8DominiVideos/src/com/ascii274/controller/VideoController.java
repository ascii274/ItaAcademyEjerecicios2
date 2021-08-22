package com.ascii274.controller;

import java.util.List;

import com.ascii274.domain.Tag;
import com.ascii274.domain.Video;
import com.ascii274.view.TagView;

public class VideoController {
	private Video video ;
	
	public VideoController(Video video) throws Exception {
		 if(video == null) throw new Exception("Error el video es null");
		 this.video = video;		 
	}
	
	
	// recogemos todos los tags y lo mostramos a traves de la clase TagView
	public void mostraTotsElsTags() {
		List<Tag> tags = video.getTags();
		TagView tagView = new TagView();
		for(Tag t:tags) {
			tagView.printTagsView(t);
		}		
	}
	
	public void altaTag(String tagName) throws Exception{
		try {
			Tag tag = new Tag(tagName);
			video.addTag(tag);
		} catch (Exception e) {
			System.out.println("Error al registrar el tag.");
		}
	}
	
	public Video getVideo() {
		return video;		
	}
	
	public void actualitzarEstatPujada(Video video) {
		
		
	}
	

}
