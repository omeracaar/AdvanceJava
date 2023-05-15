package serialization;
//User objelerinin serilestirebilmesi icin
//Serializable i implemente ederek bu objeler serilestirebilir.
import java.io.*;

public class Serialization_Deserialization implements Serializable {

    public static void main(String[] args) {

        //writeObjects();
        readObjects();
    }

    public static void writeObjects(){
        System.out.println("Objeler olusturuluyor...");
        User user1=new User(1,"Yavuz",32);
        User user2=new User(2,"Hakan",28);
        User user3=new User(3,"Yusuf",28);
        User user4=new User(4,"Bahadir",27);

        //nesnelerin yazildigi dosyayi olusturmak icin
        try {
            //FOS,Javada dosyaya veri yazabilmemizi saglar
            //nesnelerin yazildigi dosyayi olusturmak icin
            FileOutputStream fos=new FileOutputStream("user.ser");
            //objeleri yazdirmak icin
            //objelerin yazilabilmesi icin serilestirilmesi gerekir
            ObjectOutputStream output=new ObjectOutputStream(fos);
            output.writeObject(user1);
            output.writeObject(user2);
            output.writeObject(user3);
            output.writeObject(user4);

            output.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void readObjects(){
        //Javada dosyadakileri okuma islemlerinde ise FIS kullanilir
        try {
            FileInputStream fis=new FileInputStream("user.ser");
            //objelerin de-serialization okunmasi icin de OIS
            ObjectInputStream input=new ObjectInputStream(fis);

            User user1=(User)input.readObject();
            User user2=(User)input.readObject();
            User user3=(User)input.readObject();
            User user4=(User)input.readObject();
            //readobject dosyanin sonuna geldiginde EOFExecption firlatir.

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);

            input.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }





}
