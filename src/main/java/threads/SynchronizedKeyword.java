package threads;

public class SynchronizedKeyword {

    public static void main(String[] args) {

        Brackets brackets=new Brackets();

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
    }

}

//[[[[[]]]]] seklini yazdirma
class Brackets {
//synchronized ile metoda ulasan threadin objeyi monitor(kilitlemek) etmesini sagladik
    public synchronized void generateBrackets() {
        for (int i = 1; i <= 10; i++) {
            if (i<=5){
                System.out.print("[ ");
            }else {
                System.out.print("] ");
            }
        }
        System.out.println();

    }

}