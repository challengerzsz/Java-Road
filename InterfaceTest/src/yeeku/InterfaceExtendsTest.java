package yeeku;

interface interfaceA {
    public static final int A = 5;
    public abstract void testA ();
}
interface interfaceB {
    public static final int B = 10;
    public abstract void testB ();
}
interface interfaceC extends interfaceA,interfaceB{
    public static final int C = 15;
    public abstract void testC ();
}
public class InterfaceExtendsTest {
    public static void main(String[] args) {
        System.out.println(interfaceC.A);
        System.out.println(interfaceC.B);
        System.out.println(interfaceC.C);
    }
}
