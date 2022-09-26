package concurrency;

import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;
    private final Semaphore foo;
    private final Semaphore bar;

    public FooBar(int n) {
        this.n = n;
        this.foo = new Semaphore(1);
        this.bar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }

    public static void main(String[] args) {
        FooBar app = new FooBar(10);
        Runnable printFoo = new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        Runnable printBar = new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };

        Thread t2 = new Thread(() -> {
            try {
                app.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        Thread t1 = new Thread(() -> {
            try {
                app.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
    }


}
