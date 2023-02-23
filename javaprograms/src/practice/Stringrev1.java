package practice;

public class Stringrev1 {
	 static void StringRev(char a1[]) {
		 
		 int i=0;
			int j=a1.length-1;
			
			
			while(i<j) {
				
				if(!Character.isAlphabetic(a1[i])) {
					
					i++;}
				else if(!Character.isAlphabetic(a1[j])) { j--; }
				else {
					
					
					char temp=a1[i];
					a1[i]=a1[j];
					a1[j]=temp;
					i++;
					j--;
					
					
				}
				
			}
			
				
			}
		 

	public static void main(String[] args) {
    String Str="hi@ hello how are you";
		char a2[]=Str.toCharArray();
		System.out.println(Str);
		StringRev(a2);
		
		
		 String Str1=new String(a2);
		 
		 System.out.println(Str1);
		 
		
		
		
	}
}
	

