package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class HasMap {

	public static void main(String[] args) {
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		
		map.put(01, "gracy");
		map.put(02, "bijal");
		map.put(03, "ronak");
		map.put(04,"darshti");
		
		
		Set<Map.Entry<Integer,String>> v=map.entrySet();
		for(Map.Entry<Integer,String> e:v) {
			
			System.out.println(e.getKey()+""+e.getValue());
			
		}
	}

}
