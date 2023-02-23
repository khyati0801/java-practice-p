package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hasmap1 {

	public static void main(String[] args) {
HashMap<String,String> map=new HashMap<String,String>();
		
		map.put("01s","gracy");
		map.put("02s","bijal");
		map.put("03s","ronak");
		map.put("04s","darshti");
		
		
		Set<Map.Entry<String,String>> v=map.entrySet();
		for(Map.Entry<String,String> e:v) {
			
			System.out.println(e.getKey()+""+e.getValue());
			
		}
	}

}
