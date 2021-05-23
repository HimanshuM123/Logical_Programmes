package defaults;

import java.util.List;

public interface Multiplier {
	int multiply(List<Integer> integerList);
	
	default int size(List<Integer> list) {
		System.out.println("Inside multiplier interface");
	return list.size();	
	}
	//No need to impliment in MultiplierImpl class
	
	static boolean isEmpty(List<Integer> integerList) {
		return integerList!=null && integerList.size()>0;
	}
}
