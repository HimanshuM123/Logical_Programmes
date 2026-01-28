package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice4 {

	public static void main(String[] args) {

		int num = 12345;
		int rev = 0;

		while (num > 0) {

			rev = rev*10 + num % 10;
			num = num / 10;

		}
		System.out.println(rev);

	}

}
