package uz.sanjar.a4pics1word.mainCache;

public class Singleton {
    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {

    }

    public static void init() {
        if (instance == null) {
            instance = new Singleton1();
        }
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
