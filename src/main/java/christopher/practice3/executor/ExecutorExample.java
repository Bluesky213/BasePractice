package christopher.practice3.executor;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorExample {
    static final ExecutorService executorService = Executors.newFixedThreadPool(4);
    static long result1 = 0L;
    static long result2 = 0L;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // TODO: 2021/1/5 单线程自增
        long time1 = System.currentTimeMillis();
        result1 = selfAdd(1,10000000000L);
        System.out.println(result1);
        long time2 = System.currentTimeMillis();
        List<Future> futureList = new LinkedList<>();
        for(int i=0;i<10;i++){
//            int finalI = i;
//            Runnable task = new Runnable(){
//                @Override
//                public void run() {
//                    result2+=selfAdd(finalI *1000000000L,(finalI +1)*1000000000L);
//                }
//            };
            int finalI = i;
            Callable task = new Callable<Long>(){
                @Override
                public Long call() throws Exception {
                    return selfAdd(finalI *1000000000L,(finalI +1)*1000000000L);
                }
            };
            Future<Long> longFuture  = executorService.submit(task);
            futureList.add(longFuture);
//            executorService.execute(task);
        }
        System.out.println("1:"+(time2-time1)+":"+result1);
//        List<Long> resultList =
        for(Future<Long> future:futureList){
            result2+=future.get();
        }
        long time3 = System.currentTimeMillis();
        System.out.println("2:"+(time3-time2)+":"+result2);
//        while (!executorService.isTerminated()){
//            Thread.sleep(100);
//        }

//        System.out.println("3:"+(System.currentTimeMillis()-time3)+":"+result2);
    }

//    public static long selfAddConcurrent(int i){
//        Callable task = new Callable<Long>(){
//            @Override
//            public Long call() throws Exception {
//                return selfAdd(i *1000000000L,(i +1)*1000000000L);
//            }
//        };
//        Future<Long> longFuture = executorService.submit(task);
//        executorService.execute(task);
//    }

    public static long selfAdd(long start,long end){
        long result = 0;
        for(long i=start;i<=end;i++){
            result+=i;
        }
        return result;
    }
}
