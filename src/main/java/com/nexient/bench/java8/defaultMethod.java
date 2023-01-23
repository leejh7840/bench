package com.nexient.bench.java8;

public interface defaultMethod {
	void act();
	void speak();
	default void comedy() {
		System.out.println("I can make people laugh");
	}
}
