package threads;

import java.util.concurrent.CountDownLatch;

/*
bazi threadlerin once calismasini ve
bu arada diger threadlerin ve main threadin beklemesini
istedigimizde COuntDownLatch ile bir sayac olusturulur. Oncelike verdigimiz
threadler isini tamamladikca sayac 0 olana kadar azaltilir.
0 oldugunda ise diger threadlerin calismaya devam etmesine izin verilir.

 */
public class CountDownLatch01 {

   /* ozetle;
1- ilk olarak CountDawnLatch objesi olusturulur
2- önce calismasini istedigimiz thread'lere countDown() methodu cagrilir, bu method sayesinde her bir isini bitiren thread icin sayac geriye saymaya baslar
            3- beklemesini istedigim thread'ler icin ise await() methodunu cagrilir, bu sayede oncelikli olan threadlerin isini bitirmesi beklenir
            4- son olarak cuntDown() methodu 0'a ulastiginda await() methodu bloke olur ve
    bekleyen thread'ler de calismaya baslar.
   */ public static void main(String[] args) {

        CountDownLatch latch=new CountDownLatch(4);
       Thread thread1=new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("Thread-1 basladi");
               try {
                   latch.await();//worker threadleri bekle
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("Thread1 calisiyor");
           }
       });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread2 calisiyor");
            }
        });

        WorkersThreads worker1=new WorkersThreads("worker-1",latch,7000);
        WorkersThreads worker2=new WorkersThreads("worker-2",latch,8000);
        WorkersThreads worker3=new WorkersThreads("worker-3",latch,5000);
        //WorkersThreads worker4=new WorkersThreads("worker-4",latch,9000);
        Thread thread4=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("worker4 basladi");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("worker4 bitirdi");
                latch.countDown();
            }
        });

        thread1.start();
        thread2.start();
        worker1.start();
        worker2.start();
        worker3.start();
        thread4.start();

        try {
            latch.await();//bu satirdan sonra workerlerin isini bitirmesini bekle
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread calisiyor");



    }
}

class WorkersThreads extends Thread{

    private int duration;
    private CountDownLatch latch;

    public WorkersThreads(String name,CountDownLatch latch,int duration) {
        super(name);
        this.latch = latch;
        this.duration=duration;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" basladi");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+" bitirdi");
        latch.countDown();//4->3->2->1->0
    }


}