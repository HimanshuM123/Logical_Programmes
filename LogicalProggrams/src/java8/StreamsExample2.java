package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import dates.ComparingDatesPeriodExample;

public class StreamsExample2 {
	public static void main(String[] args) {
		 Function<Dish, String> function = (name) -> name.getName();
		Dish dish1 = new Dish(500,"Eggs");
		Dish dish2 = new Dish(800,"Meat");
		Dish dish3 = new Dish(400,"Butter");
		Dish dish4 = new Dish(200,"Vegetables");
		Dish dish5 = new Dish(450,"Fish");
		List<Dish> menu = new ArrayList<>();
		menu.add(dish1);
		menu.add(dish2);
		menu.add(dish3);
		menu.add(dish4);
		menu.add(dish5);
		/* 1*/
		List<String> threeHighestCaloriesDishes =menu.stream().filter(d -> d.getCalories()>300)
				//.sorted(comparing(Dish::getName))
				//.map(Dish::getName)
				//.map(obj -> obj.getName())
				.map(function) // function equivalent to MethodReference::method_name
				.limit(3)
				.collect(Collectors.toList());
		System.out.println(threeHighestCaloriesDishes);
		/* 2*/
		menu.stream().filter(d -> d.getCalories()>300)
		.map(Dish::getName)
		.limit(3)
		.collect(Collectors.toList()).forEach(System.out::println);
	}
}
