package threads;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter implements Runnable {

	private String[] fileNames;
	public Sorter(String path, String[] fileNames) {
		this.fileNames = new String[fileNames.length];
		for(int i=0;i<fileNames.length;i++)
			this.fileNames[i] = path+Constants.SEPARATOR+fileNames[i];
	}
	
	@Override
	public void run() {
		for(int i=0;i<fileNames.length;i++){
			try {
				System.out.println("Reading "+fileNames[i]);
				readAndSortFile(fileNames[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void readAndSortFile(String fileName) throws IOException {
		List<Integer> numbers = new ArrayList<>(1000);
		BufferedReader fread = null;
		int i=0;
		try {
			fread = new  BufferedReader(new java.io.FileReader(fileName));
			String line = "";
			while((line=fread.readLine())!=null){
				try{
					numbers.add(Integer.parseInt(line));
				} catch(Exception e){e.printStackTrace();}
			}
			
			Collections.sort(numbers);
			writeSortedList(numbers, fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			fread.close();
		}
	}

	public static void writeSortedList(List<Integer> numbers2, String fileName) throws IOException {
		if(numbers2.size()==0)
			return;
		String token = fileName.split(".txt")[0];
		fileName = token+"_sorted.txt";
		FileWriter writer = new FileWriter(fileName);
		for(Integer n:numbers2){
			writer.write(n+"\n");
		}
		
		writer.close();
	}
}
