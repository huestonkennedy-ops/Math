package util;

public class Tuple<Type1, Type2> {
    public Type1 first;
    public Type2 second;
    public Tuple(Type1 first, Type2 second) {
        this.first = first;
        this.second = second;
    }
    public Type1 getFirst() {
        return first;
    }
    public Type2 getSecond() {
        return second;
    }
}
