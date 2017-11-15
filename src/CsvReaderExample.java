import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class CsvReaderExample {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(new File("D:\\image.csv"));
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader in = new BufferedReader(isr);
			FileInputStream fis1 = new FileInputStream(new File("D:\\image1.csv"));
			InputStreamReader isr1 = new InputStreamReader(fis1, "UTF-8");
			BufferedReader in1 = new BufferedReader(isr1);
		
			String line;
			String line1;

			File source = null;
			File dest = null;
			
			List<String> array = new ArrayList<>();
			List<String> array1 = new ArrayList<>();

			while((line = in.readLine()) != null) {                         
			    //System.out.println(line);
			    //System.out.println(in1.readLine());
			    //FileUtils.copyFile(in.readLine(), in1.readLine());
	    
				//source = new File(in.readLine());
				//dest = new File(in1.readLine());
				//copyFileUsingApacheCommonsIO(source, dest);
			    array.add(line);
			}
			
			while((line1 = in1.readLine()) != null) {                         
			    array1.add(line1);
			}

			in.close();
			in1.close();
			
			for (int i = 0 ; i < array.size() ; i++){
				source = new File(array.get(i));
				dest = new File(array1.get(i));
				copyFileUsingApacheCommonsIO(source, dest);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}
	
	private static void copyFileUsingApacheCommonsIO(File source, File dest)
			throws IOException {
		FileUtils.copyFile(source, dest);
	}
}