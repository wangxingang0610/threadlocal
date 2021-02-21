package com.tl.demo2.synch;

/**
 *  加锁确实可以解决这个问题，但是在这里我们强调的是线程数据隔离的问题，
 *  并不是多线程共享数据的问题, 在这个案例中使用synchronized关键字是不合适的
 */
public class MyDemo {
    private String content;

    private String getContent() {
        return content;
    }

    private void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        MyDemo demo = new MyDemo();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (MyDemo.class) {
                        demo.setContent(Thread.currentThread().getName() + "的数据");
                        System.out.println("-----------------------");
                        System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
                    }
                }
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}
