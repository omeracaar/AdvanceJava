package threads;
//synchronized : method veya bloklar icin kullanilir
//bloga erisen thread hangi obje ile erisirse bu objeyi monitor etmek icin this kullanilir

//ONEMLİ: Threadlarin 1-10 priorityleri vardir. Default degeri:5.
public class SynchronizedKeyword02 {

    public static void main(String[] args) {

        Long start=System.currentTimeMillis();
        Brackets2 brackets=new Brackets2();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 9; i++) {
                    brackets.generateBrackets();
                }
            }
        });
        thread1.start();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 9; i++) {
                    brackets.generateBrackets();
                }
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Long finish=System.currentTimeMillis();

        System.out.println("Gecen sure: "+(finish-start));

        //synchronized metodu ile geçen süre:5585
        //synchronized bloğu ile geçen süre: 2803

    }

}
//ayni anda ulasilan method icerisinde asenkron calismasinda problem olmayacak kodlar varsa
class Brackets2 {
    //synchronized ile metoda ulasan threadin objeyi monitor(kilitlemek) etmesini sagladik
    public  void generateBrackets() {
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                if (i <= 5) {
                    System.out.print("[ ");
                } else {
                    System.out.print("] ");
                }
            }
        }
        System.out.println();

        //baska kodlar var, sira onemli degil
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }

}

