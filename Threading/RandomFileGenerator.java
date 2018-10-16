package threads;

import java.io.IOException;

public class RandomFileGenerator {

	private int numFiles = 0;
	public RandomFileGenerator(int num) {
		this.numFiles = num;
	}
	
	public void generateFiles() throws IOException{
		for(int i=0;i<numFiles;i++){
			RandomGenerator rg = new RandomGenerator(100000, Math.abs((int)(Math.random() * 100000)));
			String directory = Constants.PATH;
			rg.writeToArray(directory, null);
		}
	}
	
	public static void main(String[] args) throws IOException {
		RandomFileGenerator rfg = new RandomFileGenerator(6);
		rfg.generateFiles();
	}

}
