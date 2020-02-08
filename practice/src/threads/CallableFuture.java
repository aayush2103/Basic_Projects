package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class UploadResult2 implements Callable<Boolean>{
	private String taskName;
	public UploadResult2(String name) {
		this.taskName = name;
	}
	@Override
	public Boolean call() throws Exception{
		System.out.println(Thread.currentThread().getName()+" start() "+this.taskName);
		Boolean retVal = null;
		try {
			Thread.sleep(2000);
			//code
			retVal = Boolean.TRUE;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			retVal = Boolean.FALSE;
		}
		System.out.println(Thread.currentThread().getName()+" end() "+this.taskName);
		return retVal;
	}
}

public class CallableFuture {
	public static void main(String[] args) {
		ExecutorService exSer = Executors.newSingleThreadExecutor();
		
		/*single thread*/
		UploadResult2 uploadCallable = new UploadResult2("Batch 1");
		Future<Boolean> future = exSer.submit(uploadCallable);
		try {
			System.out.println("Upload complete : "+future.get());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		exSer.shutdown();
		
		/*Multiple thread*/
//		UploadResult2 cal1 = new UploadResult2("Batch 1");
//		UploadResult2 cal2 = new UploadResult2("Batch 2");
//		List<UploadResult2> tasks = new ArrayList<>();
//		tasks.add(cal1);
//		tasks.add(cal2);
//		try {
//			exSer.invokeAll(tasks);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		exSer.shutdown();
	}
}
