import java.util.concurrent.ExecutionException;

public class threads
{
    private static void print_doc()
    {
        System.out.println("Started printing documents");
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }
        System.out.println("Finished printing documents");
    }
    public static void main(String[] args) {
        long start_time=System.currentTimeMillis();
        for(int i=0;i<10;i++)
        {
            print_doc();
        }
        long end_time=System.currentTimeMillis();
        System.out.println("it took "+String.valueOf((end_time-start_time)/1000)+" seconds to finish");
    }
}

