package generics.interfaces;
//orn:repository-> customer,account,user
public interface GenericInterface<T> {

    void printValue(T object);
    T getValue();

}
