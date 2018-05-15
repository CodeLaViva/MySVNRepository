package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercise implements Runnable {
    private int num;
    private String info;
    private SimpleDateFormat df = new SimpleDateFormat("ss");//设置日期格式

    Exercise(int num, String info) {
        this.num = num;
        this.info = info;
    }

    public synchronized void doit(){
        for (int i = num; i > 0; i--) {
            synchronized ("") {
                System.out.println(info + " 我的编号：" + i + "当前时间： " + df.format(new Date()));

                switch (info) {
                    case "threadA":
                        if(num == 2){
                            Thread.interrupted();
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "threadB":
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "threadC":
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "threadD":
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void run() {
        doit();
    }
}

class thread_Test {
    private Thread threadA, threadB, threadC, threadD;

    thread_Test() {
        threadA = new Thread(new Exercise(15, "threadA"));
        threadB = new Thread(new Exercise(5, "threadB"));
        threadC = new Thread(new Exercise(5, "threadC"));
        threadD = new Thread(new Exercise(5, "threadD"));

        threadA.setPriority(Thread.MIN_PRIORITY);
        threadB.setPriority(Thread.NORM_PRIORITY);
        threadC.setPriority(Thread.NORM_PRIORITY + 1);
        threadD.setPriority(Thread.MAX_PRIORITY);
        threadA.start();
        threadD.start();
        threadB.start();
        threadC.start();
    }

    public static void main(String[] args) {
        thread_Test test = new thread_Test();
    }

}
