package GreenHand.first_folder;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;





abstract class abstract_parent_class
{
    public abstract void get_element(int a);
}

class concrete_child_class extends abstract_parent_class
{
    public void get_element(int a) // 必须有继承后的实现，不然会直接报错
    {
        System.out.println("test");
    }
}

class parent_class
{
    private int age;
    parent_class(int age)
    {
        this.age=age;
        System.out.println("parent initiation with parameters");
    }
    parent_class()
    {
        System.out.println("parent initiation without parameters");
    }
    public void move()
    {
        System.out.println("Moving");
    }
}
class child_class extends parent_class
{
    child_class() // 父类必须有无参构造函数才能用这个
    {
        System.out.println("initiation without parameters");
    }
    child_class(int age)
    {
        super(age);
        System.out.println("initiation with parameters");
    }
    public void move() //这个可以
    {
        System.out.println("running");
    }
    public void move(int a,double b)
    {
        System.out.println("int first");
    }
    public void move(double b,int a )
    {
        System.out.println("double first");
    }
    // public double move(int a ) 这个不行，因为会和底下那个move(int a )重复
    // {
    //     double b=a+1.0;
    //     return b;
    // }
    
    public double move(double a) 
    {
        super.move();
        return a;
    }

    public void move(int a)
    {
        System.out.println("running"+a);
    }
    
    public void code()
    {
        System.out.println("start coding");
    }

    // protected void move() 这个不行，因为降低了父类函数的可见程度
    // {
    //     System.out.println("running");
    // }

}
public class hello_two
 {
     public int should_be_shown_to_all;
     protected int should_be_shown_to_this_file;
     private int shown_to_this_file_only;
    
     public static void main(String[] args) {
        //int a =1;
        //String name="test_s";
        //boolean test_result=name instanceof String;
        //boolean test_result1= a instanceof int; gives an error
        //System.out.println(a+=1); //we can use +=
        //System.out.println(a++); // we can also use ++
        //hello_two test_hello_two=new hello_two();
       // System.out.println(test_hello_two.shown_to_this_file_only);
        //System.out.println(test_hello_two.should_be_shown_to_this_file+test_hello_two.should_be_shown_to_all);\




        hello_two test_h=new hello_two();
        //test_h.test_switch_case();
        //test_h.diff_between_integer_and_int();
        //test_h.test_String();
        //test_h.test_bulks();
        //test_h.test_date();
        // test_h.test_calender();
        // test_h.test_console_stream();
        test_h.test_inheritage();
    }   
    public void test_all_loop()
    {
        Integer counter=0;
        while(counter<10)
        {
            counter+=1;
        }
        counter=0;
        do
        {
            counter+=1;
        }while(counter<10);
        for (counter=0;counter<10;counter++)
        {
            System.out.println("current counter is "+counter);
        }
        int [] test_array={1,2,3,4,5};
        for (int number: test_array)
        {
            System.out.println(number);
        }
    }
    public void test_switch_case()
    {
        int criteria=10;
        switch(criteria)
        {
            case 11:
                System.out.println("eleven");
                System.out.println("test1");
                break;
            case 12:
                System.out.println("twelve");
                System.out.println("test2");
                break;
            case 10:
                System.out.println("ten");
                System.out.println("test3");
                break; //w/o this line of code, everything under this will also be implemented
            case 13:
                System.out.println("thirteen");
                System.out.println("test5");
                break;
            default:
                System.out.println("unknown");
                System.out.println("test4");
        }
    }
    public void diff_between_integer_and_int()
    {
        int a=2;
        Integer b=1;
        var test_b=b.doubleValue();

        //System.out.println(a.toString()); gives an error
        System.out.println(b.toString());
        //System.out.println(toString(a)); gives and error
        System.out.println(test_b);
        //System.out.println(a.getClass().getName());
        //System.out.println(test_b.getClass().getName()); both these two lines are wrong, bc int and double are 'primitive type ' and can't be using getclass() method
    }
    public void test_String()
    {
        String test_s="this is a test string !@#$%^&";
        System.out.println(test_s.length());
        // StringBuffer test_sb="this is a test string buffer"; wrong!
        StringBuffer test_sb=new StringBuffer("this is a test string buffer ");
        test_sb.append("Initiation");
        System.out.println(test_sb);
        System.out.println(test_sb.reverse());
        System.out.println(test_sb);
        test_sb.reverse();
        test_sb.insert(2, "wasabi");
        System.out.println(test_sb);
    }
    
    public void test_bulks()
    {
        String[] test_array1=new String[10];
        String[] test_array2={"123","1234"};
        String[][] strs=new String[2][2];
        strs[1]=new String[2];
        strs[1][1]="good shit";
        System.out.println(strs[0][1]);
        System.out.println(test_array1.length);
        for(String s: test_array1)
        {
            System.out.println(s); // will give us a bunch of nulls
        }
        for (String s:test_array2)
        {
            System.out.println(s);
        }
    }
    public void test_date()
    {
        Date test_d1=new Date(10000);
        Date test_d2=new Date(2020, 7, 22); 
        System.out.println(test_d2); //3920-08-22 bc the previous statement means 1970+years,1+month,days
        System.out.println(test_d1);
        if(test_d1.compareTo(test_d2)<0)
        {
            System.out.println("test_d1 is earlier than test_d2");
        }
        else if(test_d1.compareTo(test_d2)==0)
        {
            System.out.println("Two dates are the same");
        }
        else
        {
            System.out.println("Test_d1 is later than test_d2");
        }
        //if(test_d1>test_d2) wrong!
        if(test_d1.getTime()>test_d2.getTime())
        {
            System.out.print("test_d1 is later ");
            System.out.print("waefasedfa");
            System.out.println("asdfgasdf"); // this test is to show why we don't use print and use println instead
            System.out.println("zxcvzxcvzx");
        }

        ////////////////////当前时间////////////////////////////////
        Date current_time=new Date();
        System.out.println(current_time);

        /////////////////////////////formatter的用法//////////////////////////////////
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        var formatted_current_time=format.format(current_time);
        System.out.println(formatted_current_time);
        String time_s="2020-07-22 10:50:41";
        Date t;
        boolean flag=false;
        try{
            t=format.parse(time_s);
            flag=true;
        }
        catch(ParseException e){
            System.out.println("An error occured during parsing the string format time:"+e.toString());
        }
        // if(flag)
        // {
        //     System.out.println(t)；会报错，因为JVM还是认为t有可能没有被初始化
        // }
        

        ////////////////////////////////////////////时间间隔///////////////////////////////////////
        try{ 
            long start=System.currentTimeMillis(); 
            Thread.sleep(3000); //必须用try/catch结构，不然会报错
            long end=System.currentTimeMillis();
            System.out.println("The difference is: "+(end-start)+" milliseconds");
        }
        catch (Exception e)
        {
            System.out.println("An error occured"+e.toString());
        }

    }
    public void test_calender()
    {
        
        Calendar test_c1=new GregorianCalendar();
        System.out.println(test_c1.getTimeZone());
        System.out.println(test_c1.get(Calendar.DAY_OF_WEEK));
        System.out.println(test_c1.get(Calendar.DATE));
        System.out.println(test_c1.get(Calendar.MONTH));
        System.out.println(test_c1.get(Calendar.YEAR));
        Date current_date=test_c1.getTime();
        System.out.println(current_date); // THIS CLASS IS THE LEAST INTUIATIVE SHIT I'VE EVER SEEN, LIKE WTF, MONTH=6 means JULY??? and day of week=4 means WED???


        test_c1.add(Calendar.DATE, 3);
        System.out.println(test_c1.get(Calendar.DAY_OF_WEEK));
        test_c1.add(Calendar.DATE, 1);
        System.out.println(test_c1.get(Calendar.DAY_OF_WEEK));
        //System.out.println(test_c1.toString());
        // System.out.println(c1.YEAR); WRONG!
        test_c1.set(Calendar.YEAR, 2022);
        System.out.println(test_c1.get(Calendar.HOUR));
        System.out.println(test_c1.get(Calendar.HOUR_OF_DAY));
        test_c1.add(Calendar.DAY_OF_WEEK, 4);
        System.out.println(test_c1.get(Calendar.DATE));
        test_c1.add(Calendar.DATE, 10);
        System.out.println(test_c1.get(Calendar.MONTH));
        System.out.println(test_c1.getActualMaximum(Calendar.DATE));
    }
    public void test_console_stream()
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char c;
        try{
            c=(char) br.read();
            System.out.println(c);
        }
        catch(IOException e ){
            System.out.println("encountered a problem"+e);
        }
        //System.out.println("Input a string");
        String s=null;
        while(true)
        {
            try{
                s=br.readLine();
                System.out.println(s);
                if(s.equals("quit")){
                    break;
                }
            }
            catch(IOException e){
                System.out.println("encountered a problem"+e);
            }
        }
        
    }
    public void test_file_stream()
    {
        String test_dir="C:\\Users\\Barry Zhang\\Desktop\\scratch paper.txt";
        File f= new File(test_dir);
        try{
            OutputStream out=new FileOutputStream(f);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("encountered an error"+e);
        }
    }

    public void test_inheritage()
    {
        child_class test_child_class=new child_class();
        test_child_class.code();
        parent_class test_child_class2=new child_class();
        // test_child_class2.code() 这个是不行的，编译会报错
        test_child_class2.move(); //使用的是child_class 的 move 方法
        // test_child_class2.move(10); 这个也不行？？？？
        test_child_class.move();
        test_child_class.move(0.01);

     }

 }
//protected can be seen in the same package, but private can only be see in the class.