package threads;

import java.io.File;
import java.io.IOException;

public class SerialSorter {

	private String[] fileNames;
	public SerialSorter(String path) {
		File dir = new File(path);
		this.fileNames = new String[dir.listFiles().length];
		int i = 0;
		for(File file : dir.listFiles()){
			this.fileNames[i] = file.getAbsolutePath();
			i++;
		}
	}
	
	public void sortFiles(){
		long start = System.currentTimeMillis();
		System.out.println("\nStarting time using serial sorter - "+start);
		for(String fileName:fileNames){
			try {
				Sorter.readAndSortFile(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("\nEnd time - "+end);
		System.out.println("\nTime taken = "+(end-start));
	}
}
