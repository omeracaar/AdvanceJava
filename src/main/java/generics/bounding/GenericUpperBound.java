package generics.bounding;

import java.lang.reflect.GenericSignatureFormatError;

//parametre olarak aldigimiz data tipini sinirlandirabiliriz
//T:Integer,Double,Float,Long
//Sadece number ve child'lari kullanilsin diyerek USTTEN sinirlandirabiliriz
public class GenericUpperBound<T extends Number> {

    private T[] numberArray;//field,ozellik

    //param const.
    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }
    //array icindeki degerlerin ortalamasini bulan method
    public double getAverage(){
        double sum=0;

        for (T t: numberArray){
            sum+=t.doubleValue();//t yi double tipine dondur ve sum'a ekle
        }

        double avg=sum/this.numberArray.length;
        return avg;
    }


    public static void main(String[] args) {

        Integer[] intArr={3,5,10,8,9};
        GenericUpperBound<Integer> obj1=new GenericUpperBound<>(intArr);
        System.out.println(obj1.getAverage());

        Double[] doubles={3.0,0.5,1.5,2.5};
        GenericUpperBound<Double> obj2=new GenericUpperBound<>(doubles);
        System.out.println(obj2.getAverage());

//        String[] strings={"Java","generics","üstten","sınırlandırılabilir."};
//        GenericUpperBound<String> obj3=new GenericUpperBound<>(strings);
//        //T data tipini Number ile sınırlandırdık, String olmaz.


    }



}
