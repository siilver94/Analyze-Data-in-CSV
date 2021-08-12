import java.io.*;

public class TotalCrime {
 
	  public static void main(String[] args) {
		  int result = 0;
	        String[][] indat = new String[26][7]; 
	        
	        try {
	           
	            File csv = new File(“***");  	//directory
	            BufferedReader br = new BufferedReader(new FileReader(csv));
	            String line = "";
	            int row =0 ,i;
	 
	            while ((line = br.readLine()) != null) {
	               
	                String[] token = line.split(",", -1);
	                for(i=0;i<7;i++) {
	                 indat[row][i] = (token[i]);
	                }
	            	          
	                for(i=0;i<7;i++) {
	                 System.out.print(indat[row][i] + ",");
	                }
	               System.out.println("");
	               row++;
	            }
              
              //총 건수 출력
	            for(int a = 2; a<6;a++) {
	            	int s = Integer.parseInt(indat[1][a]);
	            	result += s;             
		               }
	            System.out.println("발생건수 총합 : " + result);
	            br.close();
	 
	        } 
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	   }    
}
	
