package net.ads.java;

public class JavaStaticInitialization {

	public static void main(String[] args) {

		A a = new A();
		a.display();

		System.out.println("=============");

		B b = new B();
		b.display();

	}

}

class A {
	static int i = 1;

	static {
		System.out.println("Static A: " + i);
	}

	{
		System.out.println("Code A");
	}

	void display() {
		System.out.println("Method A");
	}

}

class B extends A {

	static int j = 2;

	static {
		System.out.println("Static B: " + j);
	}

	{
		System.out.println("Code B");
	}

	{
		System.out.println("Code B 2");
	}

	void display() {
		System.out.println("Method B");
	}

}