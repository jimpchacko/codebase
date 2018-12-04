package threads;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ThreadDispatcher {

	private int maxThreads = 2; //8- //2 thread per core * 4 cores
	private String inputDir;
	public ThreadDispatcher(String path) {
		this.inputDir = path;
	}

	public ThreadDispatcher(String path, int numThreads) {
		this.inputDir = path;
		this.maxThreads = numThreads;
	}

	public void doSort() throws InterruptedException{
		long start = System.currentTimeMillis();
		List<Thread> threads = new ArrayList<>();
		System.out.println("\nStarting sort - "+start);
		File dir = new File(inputDir);
		File[] files = dir.listFiles();
		
		int filesPerThread = files.length / maxThreads;
		int i=0;
		while(i<files.length){
			String[] fileNames = new String[filesPerThread];
			
			for(int j=0;j<filesPerThread;j++){
				fileNames[j] = files[i].getName();
				i++;
			}
			Thread sorter = new Thread(new Sorter(inputDir, fileNames));
			sorter.start();
			threads.add(sorter);
		}
		for(Thread t:threads){
			t.join();
		}
		long end = System.currentTimeMillis();
		System.out.println("\nFinished sort - "+end);
		System.out.println("\n\nTIME - "+(end-start));
	}
	
	public static void main(String[] args) throws InterruptedException {
		new ThreadDispatcher(Constants.PATH).doSort();
		new SerialSorter(Constants.PATH2).sortFiles();
	}

}
