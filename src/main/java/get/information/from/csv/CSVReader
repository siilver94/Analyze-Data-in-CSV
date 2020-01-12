import java.io.*;
public class csvReader {
 
	  public static void main(String[] args) {
		  int result = 0;
	        String[][] indat = new String[26][7]; //CSV 파일을 읽고 저장할 배열 선언 , arraylist나 벡터 등의 다른 곳에 저장해도 상관없음
	        
	        try {
	            // csv 데이터 파일
	            File csv = new File("");
	            BufferedReader br = new BufferedReader(new FileReader(csv));
	            String line = "";
	            int row =0 ,i;
	 
	            while ((line = br.readLine()) != null) {
	                // -1 옵션은 마지막 "," 이후 빈 공백도 읽기 위한 옵션
	                String[] token = line.split(",", -1);
	                for(i=0;i<7;i++) {
	                 indat[row][i] = (token[i]);
	                }
	            	
	                // CSV에서 읽어 배열에 옮긴 자료 확인하기 위한 출력
	                for(i=0;i<7;i++) {
	                 System.out.print(indat[row][i] + ",");
	                }
	               System.out.println("");
	               row++;
	            }
	            
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
	 


