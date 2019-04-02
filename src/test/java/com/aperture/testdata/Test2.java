package com.aperture.testdata;

import org.testng.annotations.Test;

public class Test2 {

	@Test(priority=0)
	public void B1() {
		System.out.println("B1");
	}
	
	@Test(priority=1)
	public void B2() {
		System.out.println("B2");
	}
}
