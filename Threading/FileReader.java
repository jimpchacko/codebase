package threads;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReader {

	public static String path;// = "/home/jim/Documents/misc/pit/java/files";
	public FileReader(String path) {
		this.path = path;
	}
	public static void main(String[] args) {
		String[] fileNames = {"a1.txt","b1.txt","c1.txt"};
		Thread reader1 = new Thread(new ReaderThread(fileNames, path));
		reader1.start();
		
		String[] fileNames2 = {"a2.txt","b2.txt","c2.txt"};
		Thread reader2 = new Thread(new ReaderThread(fileNames2, path));
		reader2.start();
	}

}

class ReaderThread implements Runnable{
	String[] fileNames;
	String path;
	int[] numbers;
	public ReaderThread(String[] fileNames, String path) {
		int i=0;
		this.fileNames = new String[fileNames.length];
		for(String fileName:fileNames){
			this.fileNames[i] = fileName;
			i++;
		}
		this.path = path;
	}
	
	@Override
	public void run() {
		for(int i=0;i<fileNames.length;i++){
			try {
				System.out.println("Reading "+fileNames[i]);
				readFile(fileNames[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void readFile(String fileName) throws IOException {
		List<Integer> numbers = new ArrayList<>(1000);
		BufferedReader fread = null;
		int i=0;
		try {
			fread = new  BufferedReader(new java.io.FileReader(path+Constants.SEPARATOR+fileName));
			String line = "";
			while((line=fread.readLine())!=null){
				System.out.println(line);
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

	private void writeSortedList(List<Integer> numbers2, String fileName) throws IOException {
		if(numbers2.size()==0)
			return;
		String token = fileName.split(".txt")[0];
		fileName = path+Constants.SEPARATOR+token+"_sorted.txt";
		FileWriter writer = new FileWriter(fileName);
		for(Integer n:numbers2){
			writer.write(n+"\n");
		}
		
		writer.close();
	}
}