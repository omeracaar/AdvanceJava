package generics.interfaces.example;
//tum repolar bu standarda uymali
public interface Repository <T>{

    void save(T object);
    T get();


}
