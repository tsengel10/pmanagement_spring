package com.example.mvc;

public class HitCounter {
	
	private int hits;
	
	public HitCounter(){
		System.out.println("Hit counter initialized!");
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	
}
