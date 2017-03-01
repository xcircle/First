import java.util.HashSet;
import java.util.Iterator;


public class MyTest implements Runnable{

	/**
	 * @param args
	 */
	
	public void run(){
		while(true){
			System.out.println("thread is running");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new Thread(new MyTest()).start();
//		while(true){
//			System.out.println("main is running");
//		}
//		MyTest test = new MyTest();
//		HashSet set = new HashSet();
//		Student stu = new Student("123","sa");
//		set.add(stu);
//		set.add(new Student("23","fo"));
//		set.add(new Student("23","my"));
//		
//		Iterator<Student> it = set.iterator();
//		for( ;it.hasNext() ;){
//			Student std = it.next();
//			System.out.println("id =" + std.getId() + "\nname=" + std.getName());
//		}
		
//		Class<?> clz = null;
//		try {
//			clz = Class.forName("Student");
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			Class<?> cc = null;
//			try {
//				cc = (Class<?>) clz.getClassLoader().loadClass("Student");
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Student stu = (Student) clz.newInstance();
//			System.out.println(stu);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Student a =new Student("1","2");
		try {
			Student b = (Student) a.clone();
			System.out.println("name=" + b.getName() + "id=" + b.id);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
