package threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.tools.FileObject;

public class RandomGenerator {

	private int[] numbers;
	private static final String separator = "/";
	private static int counter = 0;
	
	public RandomGenerator(int num, long seed) {
		numbers = new int[num];
		generateNumbers((int)seed);
	}
	
	private void generateNumbers(int seed){
		Random random = new Random(seed);
		for(int i=0;i<numbers.length;i++){
			numbers[i] = random.nextInt(seed);
		}
	}
	
	private void printArray(){
		for(Integer n:numbers){
			System.out.println(n);
		}
	}
	
	public void writeToArray(String dir, String fName) throws IOException{
		FileWriter writer = null;
		if(fName == null)
			fName = "rn"+ ++counter+ ".txt";
		String fileName = dir+separator+fName;
		
		File fdir = new File(dir);
		if(!fdir.exists())
			fdir.mkdirs();
		try {
			writer = new FileWriter(fileName);
			for(Integer n:numbers)
				writer.write(n+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
/*	public static void main(String[] args) throws IOException {
		RandomGenerator rg = new RandomGenerator(1000, (long)Math.random());
		rg.printArray();
		String directory = "/home/jim/Documents/rand/";
		rg.writeToArray(directory, null);
	}
*/
}
