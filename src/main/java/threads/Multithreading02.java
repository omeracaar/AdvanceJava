package threads;

public class Multithreading02 {

    public static int counter=0;

    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" calismaya basladi");
                Counter.count();//1000
                System.out.println("Burada baska kodlar var.");
            }
        });
        thread1.setName("Tom");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                //thread1.join();---tum islemlerin bitmesini beklemeye gerek yok.
                System.out.println(Thread.currentThread().getName()+" calismaya basladi");
                Counter.count();//1000
                System.out.println("Burada ortak dataya erismeyen kodlar var.");
            }
        });
        thread2.setName("Jerry");
        thread2.start();


    }

}

class Counter{
    //counter degiskeninin degerini 1000 kez artirip yazdiralim
    //synchrozized ile methoda erisen threadlari siraya koymus oluruz
    //yani ayni anda bu methoda bir thread erisebilsin
    public synchronized static void count(){
        for (int i = 1; i <= 1000; i++) {
            Multithreading02.counter++;
            System.out.println(Thread.currentThread().getName()+" --Counter: "+Multithreading02.counter);//beklenen deger 1000+1000=2000
        }

    }

}
