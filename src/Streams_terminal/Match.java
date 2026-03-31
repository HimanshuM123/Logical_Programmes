package Streams_terminal;

import java.util.stream.Stream;

public class Match {
public static void main(String[] args) {
	Stream<String> stream1 = Stream.of("Java", "Python", "Hadoop", "C#", "C++", "Kotlin");  
	boolean match1 = stream1.anyMatch(s -> s.contains("Python"));  
	System.out.println(match1); 
	Stream<String> stream2 = Stream.of("Java", "Python", "Hadoop", "C#", "C++", "Kotlin"); 
	boolean match2 = stream2.noneMatch(s -> s.contains("2"));  
	System.out.println(match2);
	Stream<String> stream3 = Stream.of("Java2", "Python2", "Hadoop2", "C#2", "C++2", "Kotlin2"); 
	boolean match3 = stream3.allMatch(s -> s.contains("2"));  
	System.out.println(match3);
}
}
