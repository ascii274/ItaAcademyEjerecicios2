package com.ascii274.view;

import com.ascii274.domain.Tag;

public class TagView {
	
	public void printTagsView(Tag tag) {
		System.out.println("    Tag[#" + tag.getTagName() + "]");
	}

}
