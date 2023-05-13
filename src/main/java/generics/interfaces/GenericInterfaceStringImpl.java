package generics.interfaces;
//interface'in data tipine karar verilirse class'in generic olmasina gerek yok
public class GenericInterfaceStringImpl implements GenericInterface<String> {
    @Override
    public void printValue(String object) {

    }


    @Override
    public String getValue() {
        return null;
    }

}
