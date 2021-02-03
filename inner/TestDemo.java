package inner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-02-03
 * Time: 10:44
 */

/**
 * 内部类：比较简单  外部类有一个什么.....    外部类由什么什么组成的
 *
 *    实例内部类： 定义在类的内部的一个类。
 *       1、如何实例化内部类对象？
 *          OuterClass.InnerClass innerClass2 = out.new InnerClass();
 *          外部类名.内部类名  变量 = 外部类对象的引用.new 内部类();
 *
 *      2、只要是内部类，那么生成的字节码文件格式：外部类$内部类.class
 *      3、在实例内部类当中，不能定义静态的成员变量！！
 *        如果非要定义，那么一定要是在编译时期确定的值    public static final
 *      4、this实际上是一个静态的成员
 *         System.out.println(OuterClass.this.data1);
 *      5、实例内部类实际上拥有2个this。一个是实例内部类自己的，一个是外部类的
 *         所以这里有个面试题：同学，实例内部类，是否有额外的内存开销？？
 *
 *    静态内部类：定义在类的内部的一个类。但是由static来修饰的.
 *      1、静态内部类对象如何拿到？
 *         OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
 *                                          = new 外部类.静态内部类();
 *     2、字节码文件和上面试一样的
 *     3、在静态内部类当中，是不可以访问外部类的非静态数据成员的！！！！
 *       因为，外部类的非静态数据成员 是依赖于外部类对象的
 *       但是：如果面试官非让你访问呢？？？？？
 *      思路：能不能给个外部类对象的引用？？？
 *
 *    匿名内部类：
 *           在匿名内部类当中，使用的变量，或者是常量 或者是在整个过程当中 没有发生改变的量
 *
 *    本地内部类：方法里面定义的类 没有意义。
 *
 *
 */
/*class OuterClass {
    public int data1 = 1;
    public static int data2 = 2;
    class InnerClass {
        public int data3 = 3;
        public int data1 = 11;
        public static final int data4 = 4;
        public InnerClass() {
        }
        public void test() {
            System.out.println("InnerClass::test()");
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(this.data1);
            System.out.println(OuterClass.this.data1);
        }
    }
}*/
/*class OuterClass {
    public int data1 = 1;
    public static int data2 = 2;
    //静态内部类
    static class InnerClass {
        public int data3 = 3;
        public static int data4 = 4;
        public OuterClass out;
        public InnerClass(OuterClass out) {
            this.out = out;
        }
        public void test() {
            System.out.println("InnerClass::test()");
            //System.out.println(OuterClass.this.data1);不对的
            System.out.println(out.data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
        }
    }
}*/
//匿名内部类
class OuterClass {

    public void sayHello() {
        System.out.println("hello");
    }

}
public class TestDemo {

    public void func() {
        class  A {
            //本地内部类
        }
    }

    public static void main(String[] args) {
        int data1 = 10;
        new OuterClass(){
            @Override
            public void sayHello() {
                //data1 = 10;
                //super.sayHello();
                System.out.println("hhhhhh，匿内部类终于学完了！！！");
                System.out.println(data1);
            }
        }.sayHello();

    }

    /**
     * 静态内部类：
     *
     * @param args
     */
    /*public static void main2(String[] args) {
        OuterClass out = new OuterClass();
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass(out);
        innerClass.test();
    }*/
    /*实例内部类
    public static void main(String[] args) {
        //InnerClass innerClass = new InnerClass();
        OuterClass out = new OuterClass();
        OuterClass.InnerClass innerClass2 = out.new InnerClass();
        innerClass2.test();
    }*/
}
