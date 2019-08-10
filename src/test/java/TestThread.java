import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThread {

    @Test
    public void test1() throws Exception{
//        线程池数量
        int taskSize = 20;
//        创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
//        创建多个有返回值的任务，用于接收返回值
        List<Future> list = new ArrayList<Future>();

        for (int i = 0; i < taskSize; i++) {
            MyCallable1 callable1 = new MyCallable1(i + " ");
            MyCallable2 callable2 = new MyCallable2(i + " ");
//            执行任务并获取Futrue对象
            Future future1 = pool.submit(callable1);
            Future future2 = pool.submit(callable2);
            list.add(future1);
            list.add(future2);
        }
//        关闭线程池
        pool.shutdown();
//        获取每个线程的返回值
        for (Future future : list) {
            System.out.println(">>>>>>" + future.get().toString());
        }
    }
}
class MyCallable1 implements Callable {
    private String taskNum;
    public MyCallable1(String taskNum) {
        this.taskNum = taskNum;
    }
    public Object call() throws Exception {
        System.out.println("aaa");
        System.out.println(System.currentTimeMillis());
        return taskNum;
    }
}
class MyCallable2 implements Callable {
    private String taskNum;
    public MyCallable2(String taskNum) {
        this.taskNum = taskNum;
    }
    public Object call() throws Exception {
        System.out.println("bbb");
        System.out.println(System.currentTimeMillis());
        return taskNum;
    }
}