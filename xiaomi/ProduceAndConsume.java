/**
 * 使用synchronized实现1A2B3C4D交替打印
 */
public class ProduceAndConsume {
    public static void main(String[] args) {
        Object o=new Object();

        new Thread(new Runnable() {
            // 打印1、2、3、4、5
            @Override
            public void run() {
                synchronized (o){
                    // 先拿锁
                    for (int i=1;i<=26;i++){
                        // 先打印
                        System.out.print(i+" ");
                        // 释放锁
                        try {
                            // 释放锁
                            o.wait();
                            // 唤醒
                            o.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            // 打印a、b、c、d、e
            @Override
            public void run() {
                synchronized (o){
                    for(int i=0;i<26;i++){
                        // 先唤醒
                        o.notifyAll();
                        System.out.println((char)('a'+i));
                        // 释放锁
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
