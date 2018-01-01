package com.et.main;

import java.util.Timer;

public class GenernateIndex {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(), 1000,5000);
	}

}
