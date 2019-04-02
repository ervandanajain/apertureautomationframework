package com.aperture.testdata;

import org.testng.annotations.Test;

public class Test1 {

	@Test(priority=0)
	public void A1() {
		System.out.println("A1");
	}
	
	@Test(priority=1)
	public void A2() {
		System.out.println("A2");
	}
}
