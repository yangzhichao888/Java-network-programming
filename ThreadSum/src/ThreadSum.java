
public class ThreadSum extends Thread{

	static int[] num = new int[400];//累加的数组
	
	static int[] sum = {0,0,0,0,0};//第一位保存累加的和，后四位保存个分组的值
	
	private int digest;
	public ThreadSum(int digest) {
		this.digest = digest;
	}
	
	
	public void run(){
		//线程要执行的东西,在本程序中是进行累加操作
		synchronized(sum){
			for(int i = digest; i < (digest + 100);i++){ //I的值能否像一个参数传进来?
				
				sum[digest/100 + 1] += num[i];
			}
				sum[0] += sum[digest/100 + 1]; 
	
		//	System.out.println(digest/1000 + 1);//1.2.3.4	
			
		}
		System.out.println("累加之后的值为:" + sum[0]);
	}

	public static void main(String[] args){
		int a = 1;
		for(int k = 0;k < num.length;k++){
			num[k] = a;
		//	num[k] = (int)(Math.random()*100);
			System.out.println(num[k] + " ");
			a++;
		
		}
		System.out.println();
		Thread t1 = new ThreadSum(0);//1-999
		Thread t2 = new ThreadSum(100);
		Thread t3 = new ThreadSum(200);
		Thread t4 = new ThreadSum(300);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
///////////////////////////////////////////////////////这块有问题	计算的太快了 所以加上了延迟。我想加上同步/异步加载或许更好
//		try {
//			sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
		
		
	}
	
	
	
}
