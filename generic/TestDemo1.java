package generic;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-02-03
 * Time: 9:03
 */


import java.util.ArrayList;

/**
 * Object:是所有类的父类
 * 泛型：
 * 1、class MyStack<T> 此时的<T>代表是一个占位符 表示当前类是一个泛型类
 * 2、 this.elem = new T[10]; 不能实例化泛型类型的数组对象
 * 3、 MyStack<Integer> myStack = new MyStack<>();
 *    MyStack<Integer> 这里指定当前类可以存放是数据类型
 *    new MyStack<Integer>();
 * 4、泛型的意义：
 *     a:可以自动进行类型的检查
 *     b:可以自动进行类型的转换
 * 5、 MyStack<int> myStack = new MyStack<>();
 *    简单类型 不能做泛型类型的参数  包装类型-》引用类型
 * 6、泛型到底是怎么编译的？  擦除机制。
 *    擦除为Object的意义 就是可以放任意类型的数据。
 *    运行java程序的时候 是没有泛型的概念的
 * 7、MyStack<Integer> stack : 泛型类型的参数  不参与类型的组成
 *
 * 8、泛型的上界：
 *   class Algorithm<T extends Comparable<T> > {}
 *   T：T类型 一定要实现Comparable 接口
 *
 *   class Algorithm<E extends Animal> {}
 *   E:可以是Animal的子类 或者 是Animal自己类本身
 *
 * 9、泛型没有下界。
 *
 * 10、泛型方法
 *    public static<T> T findMaxVal(T[] array) {
 *
 *   public static<T extends Comparable<T>> T findMaxVal(T[] array) {
 *
 * 11、
 * * 通配符：通配符实际上也是一种泛型。一般用在源码当中居多一点。
 *  * 泛型一般用于读取和写入
 *  * 通配符一般用于读取
 *  *
 *  * 上界： ? extends E 示 传入的参数?  是下界E 的子类或者E自己本身
 *  * 下界：<? super E> 表示 传入的参数?  是下界E 的父类或者E自己本身
 *
 * 12、
 *         ArrayList<Integer> list   ArrayList<Number> list2
 *         他们直接是否构成父子类关系？？？
 *        不是这样子：之前已经说过了
 */
class MyStack<T> {
    public T[] elem;
    public int top;
    public MyStack() {
        this.elem = (T[])new Object[10];
        //this.elem = new T[10];
    }
    public void push(T val) {
        this.elem[top] = val;
        top++;
    }
    public T getTop() {
        return this.elem[top-1];
    }
}

/**
 * 写一个泛型类，找到数组当中的最大值
 */
class Algorithm<T extends Comparable<T> > {
    public T findMaxVal(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i].compareTo(max) >= 0) {
                max = array[i];
            }
        }
        return max;
    }
}

class Person {

}
/**
 * 泛型方法
 */
class Algorithm2 {
    public static<T extends Comparable<T>> T findMaxVal(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i].compareTo(max) >= 0) {
                max = array[i];
            }
        }
        return max;
    }
}

/**
 *写一个方法 打印一个list当中的所有的数据
 */
class Test {
    public static<T> void print2(ArrayList<T> list) {
        for (T x:list) {
            System.out.println(x);
        }
    }

    public static void print(ArrayList<?> list) {
        for (Object x:list) {
            System.out.println(x);
        }
    }
}

public class TestDemo1 {

    public static void main(String[] args) {
        //Integer extends Number
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Number> list2 = new ArrayList<>();
        list2.addAll(list);



    }

    public static void main5(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        Test.print(list1);

        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(1.0);
        list2.add(2.0);
        list2.add(3.0);
        Test.print(list2);

    }

    public static void main4(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7};
        System.out.println(Algorithm2.<Integer>findMaxVal(array));
        System.out.println(Algorithm2.findMaxVal(array));
    }

    public static void main3(String[] args) {
        Algorithm<Integer> algorithm = new Algorithm<>();
        Integer[] array = {1,2,3,4,5,6,7};
        System.out.println(algorithm.findMaxVal(array));

        //Algorithm<Person> algorithm2 = new Algorithm<>();
    }

    public static void main2(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        System.out.println(myStack);
    }

    public static void main1(String[] args) {
       /* Stack<Integer> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        Stack<Double> stack3 = new Stack<>();*/
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(19);
        myStack.push(80);
        int a = myStack.getTop();
        System.out.println(a);


        MyStack<String> myStack2 = new MyStack<>();
        myStack2.push("hello");


        //假设不指定泛型的类型参数
        @SuppressWarnings("unchecked")
        MyStack<String> myStack3 = new MyStack();
        myStack3.push("fsafsasa");
    }
}
