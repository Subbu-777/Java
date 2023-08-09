package CountDownLatch;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class WorkerThreadCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> messageList = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(10);
        List<Thread> workers = Stream.generate(() -> new Thread(new Worker(countDownLatch, messageList)))
                .limit(10).collect(Collectors.toList());
        workers.forEach(Thread::start);
        countDownLatch.await();
        System.out.println(messageList);
        Predicate<String> stringContains=value->value.contains("Thread");
        Assertions.assertThat(messageList).matches(strings -> stringContains.test(strings.get(0)));
    }

}
