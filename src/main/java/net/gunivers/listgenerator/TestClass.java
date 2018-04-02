package net.gunivers.listgenerator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import net.gunivers.listgenerator.functionality.Functionality;
import net.gunivers.listgenerator.functionality.increment.Increment;
import net.gunivers.listgenerator.functionality.other.Duplication;
import net.gunivers.listgenerator.util.Tag;

public class TestClass {

	public static void main(String... args) {
		new Increment();
		test();
		
		System.out.print("\n\n\n");
	
		new Duplication();
		test2();
	}

	@SuppressWarnings("unchecked")
	public static void test() {
		Tag<Integer> test = new Tag<Integer>(Functionality.getFunctionalities().get("Increment"), 10);

		ArrayList<String> output = new ArrayList<String>();

		try {
			output = (ArrayList<String>) test.getType().getMethod().invoke(test.getType(), 0, 10, 10);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		for (String s : output)
			System.out.println(s);
	}
	
	@SuppressWarnings("unchecked")
	public static void test2() {
		Tag<Integer> test = new Tag<Integer>(Functionality.getFunctionalities().get("Interpolation"), 10);

		ArrayList<String> output = new ArrayList<String>();

		try {
			output = (ArrayList<String>) test.getType().getMethod().invoke(test.getType(), "@", -1, 11, 10);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		for (String s : output)
			System.out.println(s);
	}
}
