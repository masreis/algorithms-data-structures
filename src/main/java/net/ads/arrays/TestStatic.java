package net.ads.arrays;

class A {
	static int i = 100;

	static {
		i = i-- - --i;
		System.out.println("First: " + i);
	}

	void test() {

	}

	{
		i = i++ + ++i;
		System.out.println("Second: " + i);
	}
}

class B extends A {
	static {
		i = --i - i--;
		System.out.println("Third: " + i);
	}
	{
		i = ++i + i++;
		System.out.println("Fourth: " + i);
	}
}

public class TestStatic {

	public static void main(String[] args) {

		B b = new B();

		System.out.println(b.i);
	}

}
