package generics.interfaces;
//generic interface i implemente eden class da generic olmak zorundadır.
public class GenericInterfaceImpl<T> implements GenericInterface<T>{


    @Override
    public void printValue(T object) {
        System.out.println("Bu methodda istedigimiz data tipini parametre olarak alabiliriz");
    }

    @Override
    public T getValue() {
        return null;
    }
}
