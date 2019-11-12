import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

class AnimalTest {

	@Test
	@DisplayName("Test comparable implementation for Animal class")
	void comparableTest() {
		ArrayList<Animal> listOfAnimals = new ArrayList<Animal>();
		
		Wolf wolf1 = new Wolf();
		Parrot parrot1 = new Parrot("Feathers", 5);
		Wolf wolf2 = new Wolf("Fuzzy", 3);
		Parrot parrot2 = new Parrot("Polly", 7);
		
		listOfAnimals.add(wolf1);
		listOfAnimals.add(parrot1);
		listOfAnimals.add(wolf2);
		listOfAnimals.add(parrot2);

		ArrayList<Integer> orderedAges = new ArrayList<Integer> (Arrays.asList(0,3,5,7));
		ArrayList<Integer> ages = new ArrayList<Integer>();
		
		Collections.sort(listOfAnimals);
		
		for(Animal animal : listOfAnimals) {
			ages.add(animal.getAge());
		}
		
		assertEquals(orderedAges, ages, "Testing that comparable sorts by age correctly");
		
	}
		
	@Test
	@DisplayName("Test comparable implementation for Animal class")
	void implementsComparableTest() {

		boolean comparable = false;
		Class<?>[] interfaces = Animal.class.getInterfaces();
		for(Class<?> i: interfaces)
		{
			if(i.getTypeName().equals("java.lang.Comparable"))
				comparable = true;
		}
		
		assertTrue(comparable, "Testing that Animal implements comparable");
	}
	
	@Test
	@DisplayName("Test contains compareTo method Animal class")
	void containsCompareToTest() {
		Method[] methods = Animal.class.getDeclaredMethods();
		
		Boolean containsCompareTo = false;
		
		for(int i=0;i<methods.length;i++) {
			String methodName = methods[i].toString();
			if(methodName.contains("Animal.compareTo(")) {
				containsCompareTo = true;
			}
		}

		assertTrue(containsCompareTo, "Testing that Animal contains the compare to method");
	}
}