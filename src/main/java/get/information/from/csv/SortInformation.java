import java.io.*;
import java.util.*;

public class SortInformation {
	public static void main(String[] args) {

		String[][] category = new String[50][20];
		double[][] csVal = new double[50][20];

		try {
			File csv = new File("D:\\Crime.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String line = "";
			int row = 0;
			int col = 0;

			while ((line = br.readLine()) != null) {
				String[] token = line.split(",");
				for (col = 0; col < 15; col++) {
					category[row][col] = (token[col]);
					String str = category[row][col];
					str = str.replaceAll("\\-", "0");
					category[row][col] = str;
								
				}
				row++;
			}
			// csv파일로 변환한 값들을 integer 형태로 변환
			for (int selectRow = 1; selectRow < 39; selectRow++) {
				for (int column = 2; column < 4; column++) {
					int value = Integer.parseInt(category[selectRow][column]);
					csVal[selectRow][column] = value;
				}
			}
			Map<String, Integer> map = new HashMap<>();

			double result;
			for (int calRow = 1; calRow < 39; calRow++) {
				result = csVal[calRow][3] / csVal[calRow][2] * 100;
				map.put(category[calRow][1], (int) result);
			}
			// value 내림차순으로 정렬하고, value가 같으면 key 오름차순으로 정렬
			List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
				@Override
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					int comparision = (o1.getValue() - o2.getValue()) * -1;
					return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
				}
			});
			System.out.println(list);

			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
