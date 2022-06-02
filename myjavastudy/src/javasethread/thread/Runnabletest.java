package javasethread.thread;


class Runnabletest3 implements Runnable {
    private int tack = 100;
//    Object obj = new Object();
    @Override
    public void run() {

        while(true){
            synchronized (this){
                if(tack>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread
                            ().getName()+"；卖票，票号"+tack);
                    tack--;

                }else{
                    break;
                }
            }

        }
    }
}

public class Runnabletest{
    public static void main(String[] args) {
        Runnabletest3 win = new Runnabletest3();

        Thread t1 = new Thread(win);
        Thread t2= new Thread(win);
        Thread t3 = new Thread(win);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
