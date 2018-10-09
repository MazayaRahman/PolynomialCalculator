package poly;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class testPoly {
	public static void main(String [] args) {
		/*String test = "a-(b+A[B[2]])*d+3";
		String [] arr = test.split("\\+|-|/|\\*|[|]");
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		*/
		
		StringTokenizer st = new StringTokenizer("a-(b+A[B[2]])*d+3", "+-*/()[]");
	    /*while (st.hasMoreTokens()) {
	        System.out.println(st.nextToken());
	    }*/
	    
	    String x = st.nextToken();
	    System.out.println(x.charAt(0));
	    String y = st.nextToken();
	    System.out.println(y.charAt(0));
	    
	   
	    
	    
	    
	}
	
	

	
	

}
