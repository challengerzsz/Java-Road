public class Singleton {

    private Singleton singleton = null;

    public Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}



class Father {

    public synchronized void doSomething() {

    }
}

class Son extends Father{

    @Override
    public synchronized void doSomething() {
        System.out.println(toString());
        super.doSomething();
    }
}

