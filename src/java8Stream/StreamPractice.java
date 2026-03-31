package java8Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 class Product {
    private int id;
    private String name;
    private float price;
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}

public class StreamPractice {
public static void main(String[] args) {
	Stream<String> stream = Stream.of("a","b","c","aa","b");
	//count
	long count = stream.count();
	System.out.println("The number of elements is "+count);
	//distinct
	Stream<String> stream1 = Stream.of("a","b","c","aa","b");
	List<String> al= stream1.distinct().collect(Collectors.toList());
	System.out.println("===========================");
	al.forEach(obj -> System.out.print(obj+" "));
	//filter
	Stream<String> stream2 = Stream.of("a","b","c","aa","b");
	System.out.println();
	System.out.println("===========================");
	List<String> al1=stream2.filter((s)-> !s.contains("a")).collect(Collectors.toList());
	System.out.println(al1);
	
	
	List < Product > productsList = new ArrayList < Product > ();
    //Adding Products  
    productsList.add(new Product(1, "HP Laptop", 25000f));
    productsList.add(new Product(2, "Dell Laptop", 30000f));
    productsList.add(new Product(3, "Lenevo Laptop", 28000f));
    
    List<String> productList = productsList.stream()
    		.filter((p)-> p.getPrice()>25000)
    		.map(obj -> obj.getName())
    		.collect(Collectors.toList());
    productList.forEach(p -> System.out.print(p+" "));
    
}
}
