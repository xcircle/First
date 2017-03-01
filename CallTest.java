import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class CallTest implements Callable<String>{

	/**
	 * @param args
	 */
	
	public String call() {
		return "get you";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		FutureTask<String> task = new FutureTask<String>(new Callable<String>(){
//
//			@Override
//			public String call() throws Exception {
//				// TODO Auto-generated method stub
//				return "nimahai";
//			}
//		});
//		new Thread(task).start();
//		try {
//			System.out.println(task.get());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Map<String , Future<String>> map = new HashMap<String,Future<String>>();
		ExecutorService service = Executors.newFixedThreadPool(5);
		for(int i=1 ;i<10;i++){
			final int j = i;
			Future f = service.submit(new Callable<String>(){
				public String call(){
					return j+5 + "";
				}
			});
			map.put("s" + i, f);
		}
		Map<String ,String> result = new HashMap<String ,String>();
		for( String  t: map.keySet()){
			try {
				result.put(t, map.get(t).get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for( String t : result.keySet()){
			System.out.println(t + ":" + result.get(t));
		}
		service.shutdown();
	}

}
