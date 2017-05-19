import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.Scanner;
	
public class Reliability {
	
		/*static double get_max(double arr[]){
			double n = arr.length;
			double max = 0.0;
			for(int i=0;i<n;i++){
				if(max > arr[i]){
					max = arr[i];
				}
			}
			return max;*/

		
		 static double [][] B = new double [20][75001];
		 static double [][] B1 = new double [20][75001];
	      int loc =0;
		
		 double Reliability(int b, double r[],int c[],int i){
			// int loc =0;
			    if(B[i][b] != -1)
			        return B[i][b];
			    loc++;
			if (b<0)
				return 0.0;
			else if (b==0 && i>0)
				return 0.0;
			else if (b>=0 && i==0)
			{     
				double temp =0;
			
				double max1=0;
	            double n =  Math.floor(b/c[i]);
	            //System.out.println(n);
				for(int m=1;m <=n;m++){
				double rel = (1-Math.pow((1-r[i]), m));
				//System.out.println(rel);
				if (max1 < rel){
					max1 = rel;
				    temp = m;
				//System.out.println(max);
				}}
			double a = max1;
			B[i][b]= a;
			B1[i][b]= temp;
			return a;

				}
			else
			{
				double max = 0;
	            double temp2 =0;
	            double n =  Math.floor(b/c[i]);
	            //System.out.println(n);
				for(int m=1;m <=n;m++){
				double rel = Reliability(b-(m*c[i]),r,c,i-1)*(1-Math.pow((1-r[i]), m));
				//System.out.println(rel);
				if (max < rel){
					max = rel;
					temp2 = m;
				}
				//System.out.println(max);
				}
			double  m2 = max;
			B[i][b]= m2;
			B1[i][b]=temp2;
			
		return m2;
			}
			
			}
		 void Printcost(int n,int b,int c[]){
		
			 for(int i=n-1 ;i>=0;i--){
				 System.out.println(B1[i][b]+" copies of machine " + (i+1) + " Of cost " + c[i]);
				 b=(int) (b-B1[i][b]*c[i]);
				 
				 
	}
		 }
		 void memory_stats(int n, int b){
			double d = n*b;
			System.out.println("Total locations " +  d);
			System.out.println("Memory used " + loc);
			double per = (loc/d)*100;
			System.out.println("Percentage Used:" + per);
	      	
	      		 
		 }
		 static double [][] BN = new double [20][75001];
		 static double [][] B2 = new double [20][75001];

		 double Reliability_iter(int B, double r[],int c[]){
		int  len =c.length-1;

			 for(int i=0;i<c.length;i++){
				 for (int b=1;b<=B;b++){
					 //if(BN[i][b] != -1)
					       // return BN[i][b];
					    //loc++;
					if (b<0)
						return 0.0;
					else if (b==0 && i>0)
						return 0.0;
					else if (b>0 && i==0)
					{     
						double temp =0;
					
						double max1=0;
			            double n =  Math.floor(b/c[i]);
			            //System.out.println(n);
						for(int m=1;m <=n;m++){
						double rel = (1-Math.pow((1-r[i]), m));
						//System.out.println(rel);
						if (max1 < rel){
							max1 = rel;
						    temp = m;
						//System.out.println(max);
						}}
					double a = max1;
					BN[i][b]= a;
					B2[i][b]= temp;
					//return a;

						}
					else
					{
						double max = 0;
			            double temp2 =0;
			            double n =  Math.floor(b/c[i]);
			            //System.out.println(n);
						for(int m=1;m <=n;m++){
						double rel_temp = (1-Math.pow((1-r[i]), m));
						double rel_prev = BN[i-1][b-m*c[i]];
						double rel = rel_temp* rel_prev;
						//System.out.println(rel);
						if (max < rel){
							max = rel;
							temp2 = m;
						}
						//System.out.println(max);
						}
					double  m2 = max;
					BN[i][b]= m2;
					B2[i][b]=temp2;
					
				//return m2;
					}
					

				 }
			 
			// int loc =0;
			   		
			}
			return BN[len][B];
		 }
		 void Printcost_iter(int n,int b,int c[]){
				
			 for(int i=n-1 ;i>=0;i--){
				 System.out.println(B2[i][b]+" copies of machine " + (i+1) + " Of cost " + c[i]);
				 b=(int)(b-B2[i][b]*c[i]);
			 }				 
				 
	}

		 
			//return m2;
			
		 
		 
	    
	public static void main(String[] args) throws FileNotFoundException {
	    Reliability mac = new Reliability();
	    Scanner scan = new Scanner(new File(args[0]));
	    //System.out.println("Enter the Budget");
	    int b = scan.nextInt();
	    //System.out.println("Enter number of machines");
	    int n = scan.nextInt();
	    //int b= 7500;
	    double[][] data = new double[n][2];
	   // System.out.println("Enter cost and reliability :");
	    while(scan.hasNextDouble()){
	    for(int row = 0; row< data.length; row++){
	        for(int col = 0 ;col< data[row].length; col++){
	            //System.out.println("enter the elements for the Matrix");
	            data[row][col] = scan.nextDouble();
	        }
	        }}
	    double r[] = new double[n];
	    int c[] = new int[n];
	   for (int i=0;i<=data.length-1;i++){
	       r[i] = data[i][1];
	   }
	   
	   for (int i=0;i<=data.length-1;i++){
	       c[i] = (int)(data[i][0]);
	   }
	   
	   for (int i=0;i<=data.length-1;i++){
	      // System.out.println(c[i]);
	   }

	 
	   for(int j = 0; j <= n-1; j++)
	        for(int w = 0; w <= b; w++ )
	            B[j][w] = -1;
        System.out.println("Memoized Output:");
	    System.out.println("Maximum reliability:" + mac.Reliability(b, r, c, n-1));
	    mac.Printcost(n, b, c);
	    mac.memory_stats(n, b);
	    System.out.println("Iterative version:");
	    System.out.println("Maximum reliability" + mac.Reliability_iter(b, r, c));
	    mac.Printcost_iter(n, b, c);
	    
	    
		}

		 
	    }




