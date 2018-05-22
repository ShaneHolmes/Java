# Java面试题
Author@ [ShaneHolmes](https://github.com/ShaneHolmes)

* * *	
<!-- markdown-toc start - Don't edit this section. Run M-x markdown-toc-refresh-toc -->
- [1 面对对象编程开发的优点](#面对对象编程开发的优点)
- [2 对封装的理解](#对封装的理解)
- [3 对继承的理解](#对继承的理解)
- [4 对多态的理解](#对多态的理解)
- [5 抽象与抽象类抽象方法](#抽象与抽象类抽象方法)
- [6 Java虚拟机](#Java虚拟机)
- [7 jdk和jre的区别是什么](#jdk和jre的区别是什么)
- [8 static关键字](#static关键字)
- [9 java支持的数据类型](#java支持的数据类型)
- [10 什么是自动拆-装箱](#什么是自动拆-装箱)
- [11 构造函数-析构函数](#构造函数-析构函数)
- [12 值传递-引用传递](#值传递-引用传递)
- [13 java线程-进程](#java线程-进程)
- [14 泛型](#泛型)
- [15 比较equal与双等于](#比较equal与双等于)
- [16 垃圾回收机制](#垃圾回收机制)
- [17 java异常处理](#java异常处理)
- [18 java小应用程序](#java小应用程序)
- [19 序列化](#序列化)


<!-- markdown-toc end -->
## 面对对象编程开发的优点
- [ ] 代码开发模块化，更易于维护和修改 
- [ ] 代码复用性高
- [ ] 增加代码的可靠性和灵活性
- [ ] 代码更容易理解

## 对封装的理解
- [ ] 封装隐藏了对象内部的**属性**和**行为**，并对外界提供一些能被其他对象访问的方法来改变它内部的数据。
- [ ] 封装有三个等级的访问限定符：private，protect和public。
-   **private：只能在类的内部被访问，子类，类外均不能访问**
-   **protect：外部包不能访问**
-   **public：没有访问限制**
- [ ] 封装的**好处**：
-   通过隐藏内部的属性来保护对象内部的状态
-   对象可以单独地被扩展，代码具有良好的可用性和可维护性
-   提高模块化，防止对象的不良交互

## 对继承的理解
- [ ] 一个对象继承它的父类，那么他就拥有了父类**非private**的属性和方法
- [ ] 有一些类具有相同的属性和方法，把他们提取出来，再通过继承获得这些属性和方法，这样可以减少代码的重复，而抽取出来的代码就是它们的父类
- [ ] 子类可以用自己的方式**重写**父类的方法，也可以**直接继承**，还可以进行属性和方法的**扩充**
- [ ] Java的继承是单继承，就是说一个子类只能有一个父类。但是Java支持多重继承，例如A继承B，B继承C，那么B是A的父类，C是B的父类
- [ ] **super关键字**：通过super关键字实现对父类成员的访问
- [ ] **this关键字**：指向自己的引用
- [ ] **final关键字**：final关键字修饰类时，该类不能被继承，即最终类，它的方法自动地声明为final类；修饰类中的成员变量或方法时，不能被子类修改重写。
- [ ] 构造器：如果父类的构造器是**无参数**的，那么在子类中会**自动调用父类的无参构造器**；如果父类的构造器是有参数的，那么子类要想继承父类的构造器，则必须显示地通过**super**关键字，而且要**匹配参数**
- [ ] 不实现多继承的原因：
```Java
有四个类A，B1,B2,C.其中B1，B2均继承A中的eat()方法而且有了自己的实现，如果支持多继承，C在继承B1，B2后，同时继承了B1，B2中的eat()方法，
当C没有实现自己的eat()方法，而调用了父类的eat()方法，那么编译器就不知道该调用哪个eat()方法，即所谓的菱形继承。
```
- [ ] 为什么接口之间可以多继承：
```Java
接口只是定义了某个行为的名称，并没有具体的实现细节。而一个类实现了具有相同名称的方法的两个接口，在该类中也只会有它自己的实现逻辑，并不会
想类的多继承一样产生不知道调用父类的哪个方法的情况
```

## 对多态的理解
- [ ] 多态同一个行为具有多种不同表现形式的能力
- [ ] 多态就是同一个接口，使用不同的实例而执行不同的操作
- [ ] 优点
-    接口性
-    灵活性
-    简化性
-    可扩充性，可替换性
-    消除类型之间的耦合关系
- [ ] 当使用多态的方式调用方法时，首先**检查父类中是否有该方法**，如果没有则编译错误；如果有，再去调用子类的同名方法
```Java
Test.java
abstract class Animal{
	abstract void eat();
}
class Cat extends Animal{
	public void eat("猫吃鱼");
}
class Dog extends Animal{
	public void eat("狗吃骨头");
}
public class Test{
	Animal a1=new Cat();
    a1.eat();//打印结果：猫吃鱼
    Animal a2=new Dog();
    a2.eat();//打印结果：够吃骨头
}
```
- [ ] 要想调用父类中被重写的方法，必须使用super关键字


## 抽象与抽象类抽象方法
- [ ] 抽象是把想法从实例中分离出来的步骤，因此，要根据他们的**功能**而不是具体的实现细节来创建类。
- [ ] 这种抽象技术的主要目的是把类的**行为和实现细节**分离开
- [ ] 抽象类不能被实例化
```Java
abstract class Animal{
	abstract void eat();
}
Animal a=new Animal();//不能被实例化
```
- [ ] 抽象类必须**被继承之后才能被使用**
- [ ] 一个类只能继承一个抽象类，但是能够实现多个接口
- [ ] 抽象方法使用**abstract**关键字来声明，抽象方法只包含一个方法名，没有方法体，方法名后面直接跟一个分号，没有花括号
- [ ] 如果**一个类中包含抽象方法，那么这个类一定是抽象类**；但抽象类中可以有非抽象的方法
- [ ] 继承抽象类的子类**必须重写**抽象类中**所有抽象方法**，否则，该子类也是一个抽象类，不能被实例化
- [ ] **构造方法，类方法**（用static关键字来声明的方法）不能声明为抽象方法

## Java虚拟机
- [ ] Java虚拟机屏蔽了与具体操作系统平台的相关信息，是的Java程序只需生成再Java虚拟机上运行的目标代码（[字节码](http://http://www.importnew.com/24088.html)），就可以不加修改的在安装有Java虚拟机的不同平台上运行，即一次编译到处运行

## jdk和jre的区别是什么
- [ ] JDK：Java Development Kit，Java语言的软件开发工具包；JRE：Java Running Environment，Java运行环境
- [ ] JDK是完整的Java软件开发包，包含JRE，编译器和其他的工具，可以让开发者开发，编译，调试Java程序
- [ ] JRE是将要执行Java程序的虚拟机，它也包含执行applet需要的浏览器插件

## static关键字
- [ ] static意思是**静态的**，就是说类中的声明为**static**的**成员变量或方法**在没有被初始化的情况下可以被访问，访问方式为：
```Java
class A{
	public static int i=0;
    public static void f(){};
}
A.i;
A.f();
```
- [ ] static没有依附于任何对象，用不上**this**关键字
- [ ] 在**静态方法**中不能访问**非静态的成员变量和非静态的成员方法**，如：
```Java
class Test{
int i=1;
public static void main(String []args){
	static int sum=i;//错误，静态方法中不能使用非静态的成员属性
}
}
当Test被Java虚拟机载入的时候，静态sum的就已经被加载了。而没有实例化的对象，就不能访问非静态的成员变量。在没有实例化的情况下， 
sum+=i对非静态成员变量i进行了访问，出错
```
- [ ] static的静态变量，无论实例化多少份对象，它的**静态对象只有一份拷贝**。静态变量也称为**类变量**，局部变量不能被声明为static变量
- [ ] **静态方法**：static方法不能被覆盖
```
方法覆盖是运行时动态绑定的，static方法是编译时静态绑定的。static方法跟任何实例都不相关，所以概念上不适用
```

## java支持的数据类型
- [ ] Java支持8中基本数据类型
-    byte
-    short
-    int
-    long
-    float
-    double
-    boolean
-    char

## 什么是自动拆-装箱
- [ ] 自动装箱是编译器在基本数据类型和对应对象包装类型之间做的一个**转换**，如`int-->integer,double-->double`,反之就是自动拆箱

## 构造函数-析构函数
- [ ] 每个类都有构造函数，如果没有显示的声明，Java编译器会提供一个默认的**无参**构造方法，这个方法并没有执行任何代码
- [ ] 构造方法与类**同名**，没有返回类型。
- [ ] 一个类中可以有多个构造函数，即构造函数的**重载**，以参数的**个数，类型和顺序**来声明不同的重载类型
- [ ] 如果显式声明了任何的一个构造函数，那么编译器就不会生成公有的默认构造函数
- [ ] 构造函数的继承问题
```Java
在创建对象时，先调用父类的构造函数进行初始化，然后调用子类自身的构造器。子类会自动的调用父类无参的构造器，要想调用有参的构造器，
必须使用关键字super，并且参数列表要匹配。子类必须要调用父类的构造函数，可以通过系统自动调用父类默认的构造函数，如果父类没有构造函数，
则子类构造函数必须通过关键字super显式地调用父类的构造函数。
```
- [ ] Java中不存在析构函数，取而代之的时[GC（Garbage Collection）](https://baike.baidu.com/item/GC/66426?fr=aladdin)垃圾回收机制

## 值传递-引用传递
- [ ] 值传递意味着传递了对象的一个副本，就算是改变了副本的值也不会影响到原对象的值
- [ ] 引用传递传递的是对对象的引用，外部引用对对象做的所有操作均会反应到该对象上
- [ ] 值传递在内存中会有不同的对象，而引用传递只有一个对象

## java线程-进程
### 进程
- [ ] 进程是执行着的应用程序，有一定的独立能力。三个特性：
- **独立性**：进程是系统中独立存在的实体，它可以独立拥有资源，每一个进程都有自己独立的地址空间，没有进程本身的运行，用户进程不可以直接访问其他进程的地址空间。
- **动态性**：进程和程序的区别在于进程是动态的，进程中有时间的概念，进程具有自己的生命周期和各种不同的状态。
- **并发性**：多个进程可以在单个处理器上并发执行，互不影响
```
并发性和并行性是不同的概念：并行是指同一时刻，多个命令在多个处理器上同时执行；并发是指在同一时刻，只有一条命令是在处理器上执行的，
但多个进程命令被快速轮换执行，使得在宏观上具有多个进程同时执行的效果
```
- [ ] 进程是一个实体。每一个进程都有它自己的**地址空间**，包括：文本区域（text region）、数据区域（data region）和堆栈（stack region）等

### 线程
- [ ] 线程是进程的组成部分，一个进程可以拥有**多个**线程，而一个线程必须拥有一个父进程
- [ ] 线程可以拥有自己的**堆栈**，自己的**程序计数器**和自己的**局部变量**，但不能拥有**系统资源**。它与父进程的其他线程++共享该进程的所有资源++
- [ ] 线程是**独立运行**的，其不知道进程中是否还有其他线程存在
- [ ] 线程的执行是**抢占式**的，也就是说，当前执行的线程随时可能被挂起，以便运行另一个线程
- [ ] 一个线程可以**创建或撤销**另一个线程，一个进程中的多个线程可以并发执行
- [ ] 线程**没有**单独的地址空间，一个线程死掉相当于整个进程死掉
- [ ] 线程之间的切换要比在进程之间的切换**效率高**
```
多进程的程 序要比多线程的程序健壮，但在进程切换时，耗费资源较大，效率要差一些。但对于一些要求同时进行并且又要共享某些变量的并发操作，只能用线程，
不能用进 程
```
- [ ] 创建线程：通过实现**Runnable** 接口；通过继承**Thread** 类本身；通过 **Callable 和 Future** 创建线程
- [ ] **就绪状态**:当线程对象调用了start()方法之后，该线程就进入就绪状态。就绪状态的线程处于就绪队列中，要等待JVM里线程调度器的调度
- [ ] **运行状态**:如果就绪状态的线程获取 CPU 资源，就可以执行 run()，此时线程便处于运行状态。处于运行状态的线程最为复杂，它可以变为阻塞状态、就绪状态和死亡状态
- [ ] **阻塞状态**: 如果一个线程执行了sleep（睡眠）、suspend（挂起）等方法，失去所占用资源之后，该线程就从运行状态进入阻塞状态。在睡眠时间已到或获得设备资源后可以重新进入就绪状态。可以分为三种：
- 等待阻塞：运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态。
- 同步阻塞：线程在获取 synchronized 同步锁失败(因为同步锁被其他线程占用)。
- 其他阻塞：通过调用线程的 sleep() 或 join() 发出了 I/O 请求时，线程就会进入到阻塞状态。当sleep() 状态超时，join() 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态。
- [ ] 线程的**优先级**：1~10，默认 NORM_PRIORITY（5）

### 死锁
- [ ] 两个进程都在等待对方执行完毕才能继续往下执行的时候就发生了死锁。死锁的四个条件：
- **互斥**：一个资源每次只能被一个进程使用
- **请求和保持**：一个进程因请求资源而阻塞时，对已获得的资源保持不放
- **不可抢占**:进程已获得的资源，在末使用完之前，不能强行剥夺，只能在进程使用完时由自己释放
- **循环等待**:若干进程之间形成一种头尾相接的循环等待资源关系
- [ ] **避免死锁的方法：**
- **破坏“请求和保持”条件**:
```
方法一：所有进程在运行之前，必须一次性地申请在整个运行过程中所需的全部资源。这样，该进程在整个运行期间，便不会再提出资源请求，
从而破坏了“请求”条件。系统在分配资源时，只要有一种资源不能满足进程的要求，即使其它所需的各资源都空闲也不分配给该进程，而让该
进程等待。由于该进程在等待期间未占有任何资源，于是破坏了“保持”条件。该方法优点：简单、易行且安全。缺点：a.资源被严重浪费，严
重恶化了资源的利用率。 b.使进程经常会发生饥饿现象。方法二：要求每个进程提出新的资源申请前，释放它所占有的资源。这样，一个进程
在需要资源S时，须先把它先前占有的资源R释放掉，然后才能提出对S的申请，即使它可能很快又要用到资源R。
```
- **破坏“不可抢占”条件**:
```
方法一：如果占有某些资源的一个进程进行进一步资源请求被拒绝，则该进程必须释放它最初占有的资源，如果有必要，可再次请求这些资源
和另外的资源。
方法二：如果一个进程请求当前被另一个进程占有的一个资源，则操作系统可以抢占另一个进程，要求它释放资源。只有在任意两个进程的优
先级都不相同的条件下，该方法才能预防死锁。
```
- **破坏“循环等待”条件**:
```
将系统中的所有资源统一编号，进程可在任何时刻提出资源申请，但所有申请必须按照资源的编号顺序（升序）提出。这样做就能保证系统不
出现死锁。
```

- [ ] **死锁的解除**
- **抢占资源**：从一个或多个进程中抢占足够数量的资源，分配给死锁进程，以解除死锁状态
- **终止（或撤销）进程**：终止（或撤销）系统中的一个或多个死锁进程，直至打破循环环路，使系统从死锁状态解脱出来

### 线程同步
[测试实例代码](https://github.com/ShaneHolmes/Java/blob/master/LinkResources/com.threadTest/SynchronizedThread.java)

[好文阅读](https://www.cnblogs.com/xyhuangjinfu/p/6505329.html)
- [ ] 进行线程同步有两种方法：
- **同步代码块**
```Java
synchronized(要同步的对象){
    要同步的操作；
}
```
- **同步方法**
```Java
   public synchronized void method(){
    要同步的操作
}
```

## 泛型
### 术语
```
ArrayList<E> -- 泛型类型
ArrayList -- 原始类型
E -- 类型参数
<> -- 读作"typeof"
ArrayList<Integer> -- 参数化的类型
Integer -- 实际类型参数
```
#### 通配符
- [ ] **?**通配符:
    "?"表示任意类型，使用"?"通配符可以引用各种参数化的类型，可以调用与参数化无关的方法(如size()方法)，不能调用与参数化有关的方法(如add()方法)
- [ ] 通配符的**扩展**
- 限定通配符的**上边界**
```Java
ArrayList<? extends Number > collection1= new ArrayList<Integer >();//编译通过
ArrayList<? extends Number > collection2= new ArrayList<String>();//编译不通过
```
- 限定通配符的**下边界**
```Java
ArrayList<? super Integer > collection3= new ArrayList<Number >();//编译通过
ArrayList<? super Integer > collection4= new ArrayList<String>();//编译不通过
```
#### 参数类型
- [ ] 只有**引用类型**才能作为泛型方法的实际参数
注：**如Integer是引用类型而int不是，int为基本类型**
```Java
public class GenericTest {
    public static void main(String[] args) {
        swap(new String[]{"111","222"},0,1);//编译通过
        //swap(new int[]{1,2},0,1);
        //编译不通过,因为int不是引用类型
        swap(new Integer[]{1,2},0,1);//编译通过
    }
    /*交换数组a 的第i个和第j个元素*/
    public static <T> void swap(T[]a,int i,int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
```
- [ ] **当实参不一致时，T取交集，即第一个共同的父类**
```Java
public class GenericTest {
    public static void main(String[] args) {
        new GenericTest().testType();
        int a = biggerOne(3,5);
        //int 和 double,取交为Number
        Number b = biggerOne(3,5.5);
        //String和int 取交为Object
        Object c = biggerOne("1",2);
    }
    //从x,y中返回y
    public static <T> T biggerOne(T x,T y){
        return y;
    }
}
```
如果用Number b = biggerOne(3,5.5);改为String c = biggerOne(3,5.5);则编译报错:
Error:(17, 29) java: 不兼容的类型: 推断类型不符合上限
    推断: java.lang.Number&java.lang.Comparable<? extends java.lang.Number&java.lang.Comparable<?>>
    上限: java.lang.String,java.lang.Object

- [ ] **泛型变量，泛型方法**
- **当一个变量被声明为泛型时，只能被实例变量和方法调用(还有内嵌类型)，而不能被静态变量和静态方法调用**。因为静态成员是被所参数化的类所共享的，所以静态成员不应该有类级别的类型参数。静态变量和静态方法是类所共有的，是属于类级别的，而泛型在不同的对象里可能对应不同的类型状态，同一个类级别的静态变量或变量方法在各个对象中应该是一样的，这也是静态的含义，所以矛盾。

### 比较equal与双等于
[博文地址](https://www.cnblogs.com/pop822/p/6215040.html)
- [ ] 简单来说，**==比较的是2个对象的地址，而equals比较的是2个对象的内容。当equals为true时，==不一定为true，反之成立。**
```Java
一、String中的equals和==
   1、
    public class TestString {
    public static void main(String[] args) {
    String s1 = "Monday";
    String s2 = "Monday";
    }
    }
    上面这段程序中，到底有几个对象呢？
    来检测一下吧，稍微改动一下程序
    public class TestString {
    public static void main(String[] args) {
    String s1 = "Monday";
    String s2 = "Monday";
    if (s1 == s2)
    System.out.println("s1 == s2");
    else
    System.out.println("s1 != s2");
    }
    }
    编译并运行程序，输出：s1 == s2说明：s1 与 s2 引用同一个 String 对象 -- "Monday"!
    2.再稍微改动一下程序，会有更奇怪的发现：
    public class TestString {
    public static void main(String[] args) {
    String s1 = "Monday";
    String s2 = new String("Monday");
    if (s1 == s2)
    System.out.println("s1 == s2");
    else
    System.out.println("s1 != s2");
    if (s1.equals(s2)) System.out.println("s1 equals s2");
    else
    System.out.println("s1 not equals s2");
    }
    }
我们将s2用new操作符创建
    程序输出：
    s1 != s2
    s1 equals s2
    说明：s1 s2分别引用了两个"Monday"String对象
    3. 字符串缓冲池
    原来，程序在运行的时候会创建一个字符串缓冲池当使用 s2 = "Monday" 这样的表达是创建字符串的时候，程序首先会在这个String缓冲池
    中寻找相同值的对象，在第一个程序中，s1先被放到了池中，所以在s2被创建的时候，程序找到了具有相同值的 s1
    将s2引用s1所引用的对象"Monday"
    第二段程序中，使用了 new 操作符，他明白的告诉程序："我要一个新的！不要旧的！"于是一个新的"Monday"Sting对象被创建在内存中。
    他们的值相同，但是位置不同，一个在池中游泳一个在岸边休息。哎呀，真是资源浪费，明明是一样的非要分开做什么呢？
    4.
    再次更改程序：
    public class TestString {
    public static void main(String[] args) {
    String s1 = "Monday";
    String s2 = new String("Monday");
    s2 = s2.intern();
    if (s1 == s2)
    System.out.println("s1 == s2");
    else
    system.out.println("s1 != s2");
    if (s1.equals(s2)) System.out.println("s1 equals s2");
    else
    System.out.println("s1 not equals s2");
    }
    }
    这次加入：s2 = s2.intern();
    程序输出：
    s1 == s2
    s1 equals s2
    原来，（Java.lang.String的intern()方法"abc".intern()方法的返回值还是字符串"abc"，表面上看起来好像这个方法没什么用处。
    但实际上，它做了个小动作：检查字符串池里是否存在"abc"这么一个字符串，如果存在，就返回池里的字符串；如果不存在，该方法会把
    "abc"添加到字符串池中，然后再返回它的引用。）
    更好的办法： 把所有的String都intern()到缓冲池去吧。最好在用到new的时候就进行这个操作
    String s2 = new String("Monday").intern();
    然后就可以用==比较两个字符串的值了
```


## 垃圾回收机制
GC（Garbage Collection）[博文链接](https://blog.csdn.net/plgy_Y/article/details/72791483)
- [ ] **Java自动内存管理**归结为自动化的解决了两个问题：**给对象分配内存和回收给对象分配的内存**
- [ ] GC要考虑的三个问题：
- **哪些内存需要回收？**（对象是否可以被回收的两种经典算法：引用记数法和可达性分析法 ）
- **什么时候回收？**（堆的新生代、老年代、永久代的垃圾回收时机，MinorGC 和 FullGC）
- **如何回收？**(三种经典垃圾回收算法(标记清除算法、复制算法、标记整理算法)及分代收集算法 和 七种垃圾收集器)


## java异常处理

- [ ] Java有两种异常类型：**受检查的**(checked)和**不受检查的**(unchecked)的异常。受检查的异常必须throws声明；不受检查的异常不需要在方法或者是构造函数上声明，就算方法或者是构造函数的执行可能会抛出这样的异常，并且不受检查的异常可以传播到方法或者是构造函数的外面
- [ ] **Exception**和**Error**有什么区别
- 都是**Throwable**的子类
- Exception用于用户程序**可以捕获**的异常情况，且能恢复。Exception又分为**运行时异常(Runtime Exception)**和**受检查的异常**。编译能通过，但一运行就终止了，程序不会处理运行时异常，出现这类异常程序会终止。而受检查的异常，要么使用try/catch捕获，要么使用throws将异常抛给它的父类来处理，否则编译不能通过

- [ ] **抛出异常**的三种方式
- **系统自动抛异常**
当程序语句出现一些逻辑错误、主义错误或类型转换错误时，系统会自动抛出异常：
```Java
public static void main(String[] args) { 
    int a = 5, b =0; 
    System.out.println(5/b); 
    //function(); 
}//系统会自动抛出ArithmeticException异常
public static void main(String[] args) {   
    String s = "abc";   
    System.out.println(Double.parseDouble(s));   
    //function();   
}  //系统会自动抛出NumberFormatException异常
```
- **throw**
throw是语句抛出一个异常，一般是在**代码块的内部**，当程序出现某种逻辑错误时由程序员主动抛出某种特定类型的异常
```Java
public static void main(String[] args) {   
    String s = "abc";   
    if(s.equals("abc")) {   
      throw new NumberFormatException();   
    } else {   
      System.out.println(s);   
    }   
    //function();   
}  
//运行时，系统会抛出异常：
Exception in thread "main" java.lang.NumberFormatException at......
```
- **throws**
throws是**方法可能抛出异常**的声明。(用在声明方法时，表示该方法可能要抛出异常)
`public void function() throws Exception{......}`
当某个方法可能会抛出某种异常时用于throws 声明可能抛出的异常，然后**交给上层调用它的方法程序处理**
```Java
public class testThrows(){  
public static void function() throws NumberFormatException{   
String s = "abc";   
System.out.println(Double.parseDouble(s));   
}   
public static void main(String[] args) {   
try {   
function();   
} catch (NumberFormatException e) {   
System.err.println("非数据类型不能强制类型转换。");   //e.printStackTrace();   
}   
}  
//运行结果：
非数据类型不能强制类型转换。
```
- **throw与throws的比较**
1、**throws出现在方法函数头；而throw出现在函数体**。
2、throws表示出现异常的一种可能性，并**不一定会发生**这些异常；throw则是抛出了异常，**执行throw则一定抛出了某种异常对象**。
3、两者都是消极处理异常的方式（这里的消极并不是说这种方式不好），只是抛出或者可能抛出异常，但是不会由函数去处理异常，真正的处理异常由函数的上层调用处理。
```
编程习惯：
1.在写程序时，对可能会出现异常的部分通常要用try{...}catch{...}去捕捉它并对它进行处理；
2.用try{...}catch{...}捕捉了异常之后一定要对在catch{...}中对其进行处理，那怕是最简单的一句输出语句，或栈输入
e.printStackTrace();
3.如果是捕捉IO输入输出流中的异常，一定要在try{...}catch{...}后加finally{...}把输入输出流关闭；
4.如果在函数体内用throw抛出了某种异常，最好要在函数名中加throws抛异常声明，然后交给调用它的上层函数进行处理。
```
- [ ] **finally**代码块的重要性
**无论是否抛出异常，finally代码块总是会被执行**。就算是没有catch语句同时又抛出异常的情况下，finally代码块仍然会被执行。最后要说的是，**finally代码块主要用来释放资源，比如：I/O缓冲区，数据库连接**
- [ ] **异常处理完成以后，Exception e 对象会在下一个垃圾回收过程中被回收掉**
- [ ] finally代码块和finalize()方法有什么区别
无论是否抛出异常，finally代码块都会执行，它主要是用来释放应用占用的资源。finalize()方法是Object类的一个protected方法，它是**在对象被垃圾回收之前由Java虚拟机来调用的**

## java小应用程序
[菜鸟教程](http://www.runoob.com/java/java-applet-basics.html)
- [ ] Java应用程序与applet程序比较
- Java中Applet类继承了**Java.applet.Applet**类
- Applet中没有main()
- Applet嵌入在一个HTML页面中，当用户浏览包含Applet的HTML页面，Applet的代码就会被下载到用户的机器上
- 要查看一个Applet需要有JVM，JVM可以是**浏览器的一个插件**或者是**一个独立的运行环境**
- 都需要有JVM
- [ ] Applet的条件限制
- applet不能够载入类库或定义本地方法
- applet不能在宿主主机上读写文件
- applet不能够读取特定的系统属性
- applet不能够发起网络连接，除非是跟宿主机
- applet不能够开启宿主机上其他任何程序

## 序列化
- [ ] 简单介绍：
- **Java序列化**是把Java对象转化为字节序列的过程；**Java反序列化**是把Java字节序列恢复成Java对象的过程
- Java序列化好处：
1.实现**数据的持久化**--把数据永久地保存到硬盘上（通常是放到文件里面temp.ser）
2.实现**远程通信**，在网络上传送对象的字节序列（发送方将Java对象转化为字节序列，然后在网络上传送；接收方通过反序列化将字节序列恢复成Java对象）
- [ ] 如何实现Java序列化和反序列化
- 一个类要想被序列化成功，必须满足两个条件：
  1.**实现`java.io.Serializable`接口**
  2.该类的**所有属性必须都是可序列化**的，如果有一个属性不是可序列化的，则该属性必须注明是短暂的（**transient**关键字）
  ```Java
  public class Employee implements java.io.Serializable//类必须实现 java.io.Serializable 对象
  { 
   public String name;
   public String address;
   public transient int SSN;//有一个属性不是可序列化的，则该属性必须注明是短暂的
   public int number;
   public void mailCheck()
   {
      System.out.println("Mailing a check to " + name
                           + " " + address);
   }
  }
  ```

- JDK类库中序列化API
  **`java.io.ObjectOutputStream`:表示对象输出流
  它的`writeObject(Object obj)`方法可以对指定的obj参数进行序列化，把得到的字节序列写到一个目标输出流中**
```Java
import java.io.*;
public class SerializeDemo
{
   public static void main(String [] args)
   {
      Employee e = new Employee();
      e.name = "Reyan Ali";
      e.address = "Phokka Kuan, Ambehta Peer";
      e.SSN = 11122333;
      e.number = 101;//例子实例化了一个 Employee 对象
      try
      {
         FileOutputStream fileOut =
         new FileOutputStream("/tmp/employee.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);//将该对象序列化到一个文件
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /tmp/employee.ser");
      }catch(IOException i)
      {
          i.printStackTrace();
      }
   }
}
```

- 反序列化：
  **`java.io.ObjectInputStream`:表示对象输入流
  它的`readObject(Object obj)`方法从源输入流中读取字节序列，再把字节序列反序列成为一个对象，并将对象返回**

```Java
import java.io.*;
public class DeserializeDemo
{
   public static void main(String [] args)
   {
      Employee e = null;
      try
      {
         FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Employee) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }
      System.out.println("Deserialized Employee...");
      System.out.println("Name: " + e.name);
      System.out.println("Address: " + e.address);
      System.out.println("SSN: " + e.SSN);
      System.out.println("Number: " + e.number);
    }//当对象被序列化时，属性 SSN 的值为 111222333，但是因为该属性是短暂的，该值没有被发送到输出流。所以反序列化后 
    Employee 对象的 SSN 属性为 0
```

















