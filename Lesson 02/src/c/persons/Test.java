package c.persons;

public class Test {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();

		p1.name = "David";
		p2.name = "Lea";
		p1.age = 40;
		p2.age = 30;

		System.out.println(p1.name);
		System.out.println(p1.age);
		System.out.println(p2.name);
		System.out.println(p1.age);
		System.out.println(p3.name);
		System.out.println(p3.age);

		System.out.println("================");

		p1.printName();
		p2.printName();
		p3.printName();

		Person.WhatIsAperson();
		p1.WhatIsAperson();
	}
}
