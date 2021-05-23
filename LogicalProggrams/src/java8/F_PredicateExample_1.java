package java8;

import java.util.function.Predicate;

public class F_PredicateExample_1 {
	static Predicate<Integer> p = (i) -> {
		return i % 2 == 0;
	};

	static Predicate<Integer> p1 = (i) -> i % 2 == 0;
	static Predicate<Integer> p2 = (i) -> i % 5 == 0;

	public static void PredicateAnd() {
		System.out.println("Predicate And1 "+p1.and(p2).test(10));
		System.out.println("Predicate And2 "+p1.and(p2).test(12));
	}
	
	public static void PredicateOr() {
		System.out.println("Predicate Or1 "+p1.or(p2).test(12));
		System.out.println("Predicate Or2 "+p1.or(p2).test(13));
	}
	
	public static void PredicateNegate() {
		System.out.println("Predicate negate "+p1.or(p2).negate().test(12));
	}

	public static void main(String[] args) {

		System.out.println(p.test(4));

		PredicateAnd();
		PredicateOr();
		PredicateNegate();
	}
}
