package com.parkingspace.park;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest
class ParkApplicationTests {
 HelloWorld helloWorld = new HelloWorld();
	@Test
	void contextLoads() {
		int result =helloWorld.add(30, 30);
		assertThat(result).isEqualTo(60);
	}

}

 class HelloWorld{
	 public int add (int a , int b ){
		return  a+b;
	}
}
