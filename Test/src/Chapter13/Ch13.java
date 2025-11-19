package Chapter13;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Ch13 {

    static void printHello(Lock myLock) {
        try {
            myLock.lock();
            System.out.println("Hello");
        }finally {
            myLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable printInventory =
                () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++)
                System.out.println("Printing record: " + i);
        };
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            System.out.println("begin");
            service.execute(printInventory);
            service.execute(printRecords);
            service.execute(printInventory);
            System.out.println("end");
        }

        System.out.println();
        try (var service = Executors.newSingleThreadScheduledExecutor()) {
            Runnable task1 = () -> System.out.println("Hello Zoo");
            Callable<String> task2 = () -> "Monkey";
            ScheduledFuture<?> r1 = service.schedule(task1, 2, TimeUnit.SECONDS);
            // ScheduledFuture<?> r2 = service.schedule(task2, 1, TimeUnit.MINUTES);
        }
        System.out.println();

        var myLock = new ReentrantLock();
        Thread.ofPlatform().start(() -> printHello(myLock));
        if (myLock.tryLock()) {
            try {
                System.out.println("Lock obtained, entering protected code");
            } finally {
                myLock.unlock();
            }
        } else {
            System.out.println("Unable to acquire lock, doing something else");
        }
        System.out.println();


       // IntStream.range(1,100).parallel().sorted().forEach(System.out::println);


        var data = List.of(List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6));
        data.parallelStream()  // p1
                .flatMap(s -> s.stream())
                .findFirst()  // p2
                .ifPresent(System.out::print);
    }
}
