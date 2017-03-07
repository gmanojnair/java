package java8functional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalProgramming {

	public static void main(String... arg) {

		/* Lambda */

		// Collections

		List<String> names = Arrays.asList("manoj", "ashok", "mofi", "jacob",
				"stefan", "decaprio", "manas");

		// Print List
		names.forEach(x -> System.out.println(x));

		// Find names with "man"
		List<String> manList = names.stream()
				.filter(name -> name.startsWith("man"))
				.collect(Collectors.toList());

		System.out.println("Find names with man");

		// Print List
		manList.forEach(x -> System.out.println(x));

		// Change all to uppercase
		List<String> uppperCaseList = names.stream().map(x -> x.toUpperCase())
				.collect(Collectors.toList());

		System.out.println("Print names with uppercase");

		// Print List
		uppperCaseList.forEach(x -> System.out.println(x));

		System.out.println("Print names with  sorted");

		List<String> sortedList = names.stream().sorted()
				.collect(Collectors.toList());

		// Print List
		sortedList.forEach(x -> System.out.println(x));

		// Combine all to single sentence with delimter as comma
		String demileterList = names.stream().reduce((x, y) -> x + "," + y)
				.get();

		System.out.println("Print names with single line " + demileterList);

		Optional<Object> emptyList = Arrays.asList().stream()
				.reduce((x, y) -> x + "," + y);

		System.out.println("Print empty names list with single line "
				+ emptyList);

		System.out
				.println("Print empty names list with single line if nothign then 0 :  "
						+ emptyList.orElse(0));

		Optional<? extends Object> nonEmptyStringList = Arrays
				.asList("manoj", "nair").stream().reduce((x, y) -> x + "," + y);

		System.out.println("Print  names list with single line "
				+ nonEmptyStringList);

		Optional<? extends Object> nonEmptyIntegerList = Arrays
				.asList(1, 2, 3, 4).stream().reduce((x, y) -> x + y);

		System.out.println("Print  integer list with single line "
				+ nonEmptyIntegerList);

		System.out
				.println("Print empty  list with single line if nothign then null :  "
						+ nonEmptyIntegerList.orElse(null));

		Optional<Integer> nonEmptyIntList = Arrays.asList(1, 2, 3).stream()
				.reduce((x, y) -> x + y);

		System.out.println("Print empty names list with single line "
				+ nonEmptyIntList);
		
		System.out.println("Print single list from List of List elements "
				);
		
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)) // Stream of List<Integer>
	            .flatMap(List::stream) // first map then flat to single stream
	            .collect(Collectors.toList());
		
		// Print List
		together.forEach(x -> System.out.println(x));


		// Predicate

		filter(names, x -> x.equals("manoj"));
		
		Predicate<String> startsWith = (x) -> x.startsWith("m");
		Predicate<String> endsWith = (x) -> x.endsWith("j");
		
		System.out.println("Print  names list having names starts with 'm' and ends with 'j' using predicate combination");
		names.stream().filter(startsWith.and(endsWith)).collect(Collectors.toList()).forEach(x -> System.out.println(x));;
		
		// functions
		
		Function<Integer,Integer> multiplybytwo = (x) -> {
			System.out.println("multiplybytwo Run"); 
			return x*2 ;
		};
		Function<Integer,Integer> square = (x) -> {
			System.out.println("square Run"); 
			return x*x ;
		};
		// accepts one parameter x and fabricates another anonymous function that, in turn, accepts one parameter y
		// curry
		Function<Integer, Function<Integer,Integer>> currying = x -> y -> { 
			System.out.println("currying Run"); 
			return x + y ; 
		};
		
		
		// x^2 + 2x
		Arrays.asList(1).forEach(x -> System.out.println(currying.apply(square.apply(x)).apply(multiplybytwo.apply(x))));
		
		

	}

	private static void filter(List<String> names, Predicate functionExpression) {
		// TODO Auto-generated method stub
		names.forEach(x -> {
			if (functionExpression.test(x)) {
				System.out.println("Name - " + x);
			}
		});

	}

	
}
