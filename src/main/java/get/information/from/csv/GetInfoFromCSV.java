import java.io.*;
import java.util.*;

public class GetInfoFromCSV {

	public static void main(String[] args) {

		String[][] dataArray = new String[50][20];
		double[][] csvVal = new double[50][20];

		try {
			File csv = new File("D:\\Crime2014.csv");
			BufferedReader bReader = new BufferedReader(new FileReader(csv));
			String line = "";
			int row = 0;
			int column = 0;

			while ((line = bReader.readLine()) != null) {
				String[] token = line.split(",");
				for (column = 0; column < 15; column++) {
					dataArray[row][column] = (token[column]);
					String strForBlank = dataArray[row][column];
					strForBlank = strForBlank.replaceAll("\\-", "0");
					dataArray[row][column] = strForBlank;			
				}
				row++;
			}

			for (int selectRow = 1; selectRow < 39; selectRow++) {
				for (int selectColumn = 2; selectColumn < 4; selectColumn++) {
					int value = Integer.parseInt(dataArray[selectRow][selectColumn]);
					csvVal[selectRow][selectColumn] = value;
				}
			}
			Map<String, Integer> hashMap = new HashMap<>();

			double result;
			for (int numberOfCase = 1; numberOfCase < 39; numberOfCase++) {
				int crimeName = 1;
				int totalCrimes = 2;
				int firstOffender = 3;
				result = csvVal[numberOfCase][firstOffender] / csvVal[numberOfCase][totalCrimes] * 100;
				hashMap.put(dataArray[numberOfCase][crimeName], (int) result);
			}
			
			List<Map.Entry<String, Integer>> linkedList = new LinkedList<>(hashMap.entrySet());

			Collections.sort(linkedList, new Comparator<Map.Entry<String, Integer>>() {
				@Override
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					int comparision = (o1.getValue() - o2.getValue()) * -1;
					return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
				}
			});
			System.out.println(linkedList);

			bReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
