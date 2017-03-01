import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class BufferQueue {
	
	static final int size = 10;
	static Lock lock = new ReentrantLock();
	static Condition notEmpty = lock.newCondition();
	static Condition notFull = lock.newCondition();
	static int[] queue = new int[size];
	static int num = 0;
	static int now = 0;
	static int get = 0;
	
	public static void producer(){
		try{
			lock.lock();
			while(num >= size){
				try {
					notFull.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				int p = new Random().nextInt(100);
				System.out.println(Thread.currentThread().getName() + "/produce num is " + p);
				queue[now++] = p;
				num++;
				if(now >= size){
					now = 0;
				}
				
			notEmpty.signalAll();
		}
		finally{
			lock.unlock();
		}
	}
	
	public static void comsumer(){
		try{
			lock.lock();
			while(num == 0){
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int p = queue[get++];
			System.out.println(Thread.currentThread().getName() + "/get " + p);
			num--;
			if(get >= size){
				get = 0;
			}
		
			notFull.signalAll();
		}
		finally{
			lock.unlock();
		}
	}
	
	public static void main(String args[]){
		for ( int i = 0 ;i < 1  ;i++){
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int j =0;j<30;j++){
						BufferQueue.producer();	
					}
				}
				
			}).start();
			
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int j=0;j<30;j++){
						BufferQueue.comsumer();
					}
				}
				
			}).start();
			
		}
	}

}
