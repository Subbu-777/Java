package CountDownLatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

    private CountDownLatch countDownLatch;

    private List<String> messageList;

    public Worker(CountDownLatch countDownLatch, List<String> messageList) {
        this.countDownLatch = countDownLatch;
        this.messageList = messageList;
    }


    @Override
    public void run() {
        doSomeWork();
        messageList.add("ThreadName::" + Thread.currentThread().getName());
        countDownLatch.countDown();
    }

    private void doSomeWork() {
        System.out.println("Having Fun Enjoying");
    }
}


