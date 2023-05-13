package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunnerGenericType {
    public static void main(String[] args) {

        //GenericClass<String> obj1=new GenericClass<String>();
        GenericClass<String> obj1=new GenericClass<>();//Java 7 il ebirlikte sag tarafta kullanmak opsiyonel oldu
        obj1.setType("Generic Type");

        String str=obj1.getType();//CASTING e gerek kalmadi

        GenericClass<Integer> obj2=new GenericClass<>();
        obj2.setType(12);

        Integer num=obj2.getType();

//        GenericClass<String> obj3=new GenericClass();
//        obj3.setType(12);//CTE, tur guvenligi. ---->ClassCastExc. onler

        //List list=new ArrayList<>(); --raw kullanimi --Java 5 den once
        List <String>list=new ArrayList<>();
        list.add("Advanced");
        list.add("Java");
        //list.add(12);//CTE, tur guvenligi. ---->ClassCastExc. onler

        Map <String,Integer> map=new HashMap<>();
        map.put("generic",2);
        //map.put(1,1);//CTE, tur guvenligi. ---->ClassCastExc. onler


        //=========================COKLU PARAMETRELI CLASS=========================

        GenericClassTwoParam<String,Integer> mymap=new GenericClassTwoParam<>();
        mymap.setField("java");
        mymap.setType(12);

        System.out.println(mymap.getField()+"-------"+mymap.getType());




    }
}
