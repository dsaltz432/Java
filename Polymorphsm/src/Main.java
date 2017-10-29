
public class Main {

	public static void main(String[] args) {

		Animal animal = new Animal();
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		System.out.println();
		animal.sleep();
		animal.eat();
		
		System.out.println();
		dog.sleep();
		dog.eat();
		
		System.out.println();
		cat.sleep();
		cat.eat();
		
		System.out.println();
		Animal animal1 = new Animal();
		Animal dog1 = new Dog();
		animal1.sleep();
		dog1.sleep();
		
		System.out.println();
		Turtle turtle = new Turtle();
		turtle.eat();
		turtle.sleep();
		
	}

}
