package threads;

import java.util.ArrayList;

public class ThreadPicks{

	private int number=0;

	public boolean isOdd(){
		if(getNumber() % 2 == 0){
			return false;
		} else{
			return true;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadPicks tp = new ThreadPicks();
		int max = 20;
		Thread t1 = new Thread(new EvenThread(tp, max));
		Thread t2 = new Thread(new OddThread(tp, max));
		System.out.println(Thread.currentThread().getName());
//		t1.start();
//		t2.start();
		ArrayList l = new ArrayList<>(20);
		l.add(2);l.add(4);l.add(1);
		System.out.println(l+"\n"+l.size());
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}

class EvenThread implements Runnable{
	private ThreadPicks tp;
	private int max=0;
	public EvenThread(ThreadPicks tp, int max) {
		this.tp = tp;
		this.max = max;
	}
	@Override
	public void run() {
		int i = 0;
		while(i<max){
			synchronized (tp) {

				if(!tp.isOdd()){
					System.out.print("\nPrinting Even "+ tp.getNumber());
					tp.setNumber(tp.getNumber() + 1);
					tp.notify();
				} else{
					while(tp.isOdd()){
						try {
//							Thread.sleep(1000);
							tp.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			i++;
		}
	}
}

class OddThread implements Runnable{
	private ThreadPicks tp;
	private int max=0;
	public OddThread(ThreadPicks tp, int max) {
		this.tp = tp;
		this.max = max;
	}
	@Override
	public void run() {
		int i = 0;
		while(i<max){
			synchronized (tp) {

				if(tp.isOdd()){
					System.out.print("\nPrinting Odd " + tp.getNumber());
					tp.setNumber(tp.getNumber() + 1);
					tp.notify();
				} else{
					while(!tp.isOdd()){
						try {
//							Thread.sleep(1000);
							tp.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			i++;
		}
	}
}


