package threads;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

	public static String path = "/home/jim/Documents/misc/pit/java/files";
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

	private void readFile(String filePath) throws IOException {
		BufferedReader fread = null;
		try {
			fread = new  BufferedReader(new java.io.FileReader(path+"/"+filePath));
			String line = "";
			while((line=fread.readLine())!=null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			fread.close();
		}
	}
}