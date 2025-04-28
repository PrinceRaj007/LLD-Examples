package com.examples.booking.models;

import java.util.List;

public class Theater {
	String id;
	String name;
	List<Screen> screens;
	public Theater(String id, String name, List<Screen> screens) {
		super();
		this.id = id;
		this.name = name;
		this.screens = screens;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Screen> getScreens() {
		return screens;
	}
	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}
	

}
