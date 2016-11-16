import java.lang.Runnable;

class Foo implements Runnable
{
    public void run()
    {
        System.out.println("I'm running");
    }
}

public class ThreadTest
{
    public static void main(String[] args)
    {
        Foo tt = new Foo();
        Thread t = new Thread(tt);
        t.start();
    }
}