package threads;

public class Multithreading01 {
    public static void main(String[] args) {

        //TASK: 1 den 10 a kadar 2 defa console'a yazdirma


        Long start=System.currentTimeMillis();
        CounterWithoutMultiThread counter1=new CounterWithoutMultiThread("Yavuz");
        counter1.countMe();
        System.out.println("-----------------------------------------------");
        CounterWithoutMultiThread counter2=new CounterWithoutMultiThread("Bahadir");
        counter2.countMe();
        System.out.println("-----------------------------------------------");
        Long finish=System.currentTimeMillis();
        System.out.println("CounterWithoutMultiThread ile gecen sure: "+(finish-start));

        System.out.println("-----------------------------------------------");

        Long startTime=System.currentTimeMillis();
        CounterWithMultiThread counter3=new CounterWithMultiThread("Muhammed Emin");
        counter3.start();
        //counter3.join();
        CounterWithMultiThread counter4=new CounterWithMultiThread("Enes");
        counter4.start();

        try {
            counter3.join();//icinde bulundugu threadi(main) counter3 threadinin isi bitine kadar bekletir
            counter4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //sleep gecen sureyi dogru gostermedi
 //       try {
 //           Thread.sleep(1000);
 //       } catch (InterruptedException e) {
 //           throw new RuntimeException(e);
 //       }

        Long finishTime=System.currentTimeMillis();
        System.out.println("CounterWithMultiThread ile gecen sure : "+(finishTime-startTime));


    }


}


class CounterWithoutMultiThread{

    public String name;

    //constructor
    public CounterWithoutMultiThread(String name) {
        this.name = name;
    }

    //thread kullanmadan 1 den 10 a kadar sayilari yazdiran method
    public void countMe(){
        for (int i = 0; i <=10; i++) {
            try {
                Thread.sleep(500);//0.5 sn bekle
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : "+i+" - "+this.name);
        }
    }
}

//multithreading ile ayni gorevleri yapalim
class CounterWithMultiThread extends Thread{

    public String name;

    public CounterWithMultiThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        countMe();
    }

    //1 den 10 a kadar sayilari yazdiran method
    public void countMe(){
        for (int i = 0; i <=10; i++) {
            try {
                Thread.sleep(500);//0.5 sn bekle
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : "+i+" - "+this.name);
        }
    }

}

