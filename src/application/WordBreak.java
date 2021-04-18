package application;

import java.util.ArrayList;

public class WordBreak {

	
	
	static void print (int i,int j,int [][] a, String s,String out)
	{      
		if (j==s.length() || i==s.length() )
		{				
		System.out.println(out);
			return;	
		} 
			if (a[i][j]==0 ) {

			print(i,j+1,a,s,out);

		}
		// true
		else {


		print (j+1,j+1,a,s,out+" "+s.substring(i, j+1) );

	print (i,j+1,a,s,out);

		}
		
	}     
	
	
//	return 2D array (table) 1 /0
	static int  [] []   table(String s,ArrayList<?> a) {
		int n= s.length();
		int array [][] = new int [n][n];
	
		  for(int l = 1; l <= n; l++){
	            for(int i=0; i < n -l + 1 ; i++){
	                int j = i + l-1;
	                String str = s.substring(i,j+1);
	                if(dictionaryContains( str,a)){
	                    array[i][j] = 1;
	                    continue;
	                }
		
	}

		  }
  		return array;

	}
	
	
	
	
	
	// if the prefix in dic return true else return false
	private static boolean dictionaryContains(String prefix,ArrayList a) {

		if(a.contains(prefix))
			return true;
	return false;
}
}
