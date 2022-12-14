- [java面试](#java面试)
  - [基础](#基础)
    - [1.JDK 和 JRE 还有jvm 有什么区别？](#1jdk-和-jre-还有jvm-有什么区别)
    - [2.跨平台特性定义和实现原理：](#2跨平台特性定义和实现原理)
    - [3.java语言的特点是：](#3java语言的特点是)
    - [4.什么是字节码？字节码的好处：](#4什么是字节码字节码的好处)
  - [集合接口](#集合接口)
    - [1.迭代器是什么：](#1迭代器是什么)
    - [2.迭代器如何使用：以及其特点：](#2迭代器如何使用以及其特点)
    - [iterator 和 listiterator的区别：](#iterator-和-listiterator的区别)
    - [3.遍历一个list的方法有？](#3遍历一个list的方法有)
    - [4.arraylist的优缺点：](#4arraylist的优缺点)
    - [5.实现randomaccess接口](#5实现randomaccess接口)
    - [6.arraylist和array进行相互转化](#6arraylist和array进行相互转化)
    - [7.arraylist和linkedlist的区别：](#7arraylist和linkedlist的区别)
    - [8.arraylist和vector的区别](#8arraylist和vector的区别)
    - [9.插入数据时arraylist，linkedlist和vector插入谁的速度更快：](#9插入数据时arraylistlinkedlist和vector插入谁的速度更快)
    - [10.多线程场景下如何使用arraylist](#10多线程场景下如何使用arraylist)
    - [11.list和set的区别：](#11list和set的区别)
    - [12.hashset的实现原理](#12hashset的实现原理)
    - [13.hashset是如何检查重复和保证唯一](#13hashset是如何检查重复和保证唯一)
    - [14.hashcode和equals方法的相关规定：](#14hashcode和equals方法的相关规定)
    - [15.==和equals方法的区别](#15和equals方法的区别)
  - [Map接口](#map接口)
    - [1.hashmap的实现原理：](#1hashmap的实现原理)
    - [2.hashtable和hashmap以及treemap的区别：](#2hashtable和hashmap以及treemap的区别)
    - [3.hashmap的数据结构：](#3hashmap的数据结构)
    - [4.hashmap的扩容因子：](#4hashmap的扩容因子)
    - [拉链法和红黑树](#拉链法和红黑树)
    - [转化为红黑树的目的：](#转化为红黑树的目的)
    - [hashmap有哪些方法来降低hash冲突](#hashmap有哪些方法来降低hash冲突)
    - [5.多线程下使用hashmap](#5多线程下使用hashmap)
    - [6.hashmap的put方法的具体流程：](#6hashmap的put方法的具体流程)
    - [7.classloader和class.forname的区别：](#7classloader和classforname的区别)
    - [8.treeset和treemap的关系：](#8treeset和treemap的关系)
    - [treemap](#treemap)
    - [hashtable](#hashtable)
    - [linkedhashmap](#linkedhashmap)
  - [流、](#流)
    - [1.流的概念：](#1流的概念)
    - [2.流的分类：](#2流的分类)
    - [3.io模型：](#3io模型)
    - [BIO,NIO,AIO 有什么区别?](#bionioaio-有什么区别)
    - [4.同步和异步的区别：](#4同步和异步的区别)
    - [5.阻塞和非阻塞区别：](#5阻塞和非阻塞区别)
    - [6.io多路复用方案：](#6io多路复用方案)
    - [7.两种模式的区别](#7两种模式的区别)
    - [8.String 编码 utf-8和GBK的区别](#8string-编码-utf-8和gbk的区别)
    - [9.什么时候使用字节流，（字符流）二者的区别是：](#9什么时候使用字节流字符流二者的区别是)
    - [集合类](#集合类)
  - [类加载器](#类加载器)
    - [1.为什么需要自定义类加载器](#1为什么需要自定义类加载器)
    - [2.双亲委派模型](#2双亲委派模型)
    - [3.双亲委派机制的好处](#3双亲委派机制的好处)
    - [4.如何自定义类加载器](#4如何自定义类加载器)
    - [5.面向对象和面向过程的区别](#5面向对象和面向过程的区别)
    - [6.java源代码到运行的三个步骤](#6java源代码到运行的三个步骤)
    - [7.java是如何进行即时编译的，好处是](#7java是如何进行即时编译的好处是)
    - [8.jvm编译字节码的三种方式](#8jvm编译字节码的三种方式)
    - [9.混合模式是如何执行的](#9混合模式是如何执行的)
  - [反射](#反射)
    - [什么是反射机制？](#什么是反射机制)
    - [静态编译和动态编译](#静态编译和动态编译)
    - [反射机制优缺点](#反射机制优缺点)
    - [反射机制的应用场景有哪些？](#反射机制的应用场景有哪些)
    - [Java获取反射的三种方法](#java获取反射的三种方法)
  - [](#)
    - [接口的方法和变量](#接口的方法和变量)
    - [1.java应用程序和小程序的区别](#1java应用程序和小程序的区别)
    - [2.String字符常量和Char字符常量的区别](#2string字符常量和char字符常量的区别)
    - [3.构造器是否可以被重写](#3构造器是否可以被重写)
    - [4.java三大特性的含义：](#4java三大特性的含义)
    - [5.String Stringbuffer Stringbuilder区别](#5string-stringbuffer-stringbuilder区别)
    - [6.使用final修饰 char value[]的好处](#6使用final修饰-char-value的好处)
    - [7.自动装箱和自动拆箱](#7自动装箱和自动拆箱)
    - [8.在一个静态方法中调用非静态方法或成员为什么时非法的](#8在一个静态方法中调用非静态方法或成员为什么时非法的)
    - [9.在java中定义无参构造方法的作用是](#9在java中定义无参构造方法的作用是)
    - [10.接口和抽象类的区别](#10接口和抽象类的区别)
    - [11.成员变量和局部变量的区别](#11成员变量和局部变量的区别)
    - [12.在调用子类构造方法之前先调用父类的无参构造方法的目的：](#12在调用子类构造方法之前先调用父类的无参构造方法的目的)
    - [13.一个类的构造方法的作用是什么：一个类的没有书写构造方法能正常执行吗](#13一个类的构造方法的作用是什么一个类的没有书写构造方法能正常执行吗)
    - [14.对象引用相等和对象相等的区别](#14对象引用相等和对象相等的区别)
    - [15.== 和equals方法的区别](#15-和equals方法的区别)
    - [16.hashcode和equals](#16hashcode和equals)
    - [17.final关键字的总结](#17final关键字的总结)
    - [java序列化时有些属性不想进行序列化，用什么修饰](#java序列化时有些属性不想进行序列化用什么修饰)
  - [java异常常见面试题：](#java异常常见面试题)
    - [error和exception的区别：](#error和exception的区别)
    - [运行时异常和受检异常的区别](#运行时异常和受检异常的区别)
    - [jvm是如何处理异常的](#jvm是如何处理异常的)
    - [java常见运行异常有哪些](#java常见运行异常有哪些)
  - [多线程](#多线程)
    - [sleep和wait方法的区别：](#sleep和wait方法的区别)
    - [为什么wait，notify以及notifyall在object类而不是在thread类](#为什么waitnotify以及notifyall在object类而不是在thread类)
    - [线程，进程以及程序的概念](#线程进程以及程序的概念)
    - [如何理解内存泄露问题，如何避免内存泄露问题，哪些情况导致内存泄露的关系，如何解决：](#如何理解内存泄露问题如何避免内存泄露问题哪些情况导致内存泄露的关系如何解决)
    - [为什么内存泄露会发生](#为什么内存泄露会发生)
    - [怎样阻止内存泄露](#怎样阻止内存泄露)
    - [线程池的原理](#线程池的原理)
    - [为什么使用线程池](#为什么使用线程池)
    - [线程池的优点：](#线程池的优点)
    - [线程池的创建：](#线程池的创建)
    - [线程池大小分配](#线程池大小分配)
    - [rejectedexecutionhandler 饱和策略](#rejectedexecutionhandler-饱和策略)
    - [策略配置方法（两种）](#策略配置方法两种)
    - [excutor的两级调度模型](#excutor的两级调度模型)
    - [executor](#executor)
    - [线程安全和线程不安全的区别](#线程安全和线程不安全的区别)
    - [线程安全举例说明：](#线程安全举例说明)
    - [线程安全问题](#线程安全问题)
    - [实现线程安全的方式](#实现线程安全的方式)
      - [互斥同步锁（悲观锁）](#互斥同步锁悲观锁)
      - [非阻塞同步锁（乐观锁）](#非阻塞同步锁乐观锁)
    - [锁膨胀](#锁膨胀)
    - [ReentrantLock 与 synchronized](#reentrantlock-与-synchronized)
        - [cas算法](#cas算法)
      - [无同步方案](#无同步方案)
    - [乐观锁和悲观锁的概念](#乐观锁和悲观锁的概念)
    - [volatile关键字的作用：](#volatile关键字的作用)
    - [threadloacl原理：](#threadloacl原理)
    - [threadlocal的作用](#threadlocal的作用)
    - [threadlocal 公有的方法：](#threadlocal-公有的方法)
    - [threadlocalmap与weakreference](#threadlocalmap与weakreference)
    - [threaklocalmap的实现](#threaklocalmap的实现)
    - [为什么要用 ThreadLocalMap 来保存线程局部对象呢？](#为什么要用-threadlocalmap-来保存线程局部对象呢)
    - [threadlocal的内存回收](#threadlocal的内存回收)
    - [threadlocalmap是threadlocal里面的一个静态内部类](#threadlocalmap是threadlocal里面的一个静态内部类)
    - [volatile的场景：](#volatile的场景)
    - [volatile变量和synchronized的区别](#volatile变量和synchronized的区别)
    - [正确使用volatile变量的条件](#正确使用volatile变量的条件)
    - [性能考虑](#性能考虑)
    - [threadlocal什么时候会出现oom的情况](#threadlocal什么时候会出现oom的情况)
    - [threadlocalmap](#threadlocalmap)
    - [synchronized、volatile区别](#synchronizedvolatile区别)
    - [保证线程安全的三大特性](#保证线程安全的三大特性)
    - [synchronized和volatile有序性的区别](#synchronized和volatile有序性的区别)
    - [指令重排](#指令重排)
    - [java中的锁的粒度](#java中的锁的粒度)
    - [jmm的内存模型定义](#jmm的内存模型定义)
    - [jmm处理过程](#jmm处理过程)
    - [提高高并发量服务器的思路](#提高高并发量服务器的思路)
    - [大型网站是怎样解决多用户高并发访问的](#大型网站是怎样解决多用户高并发访问的)
    - [负载均衡](#负载均衡)
  - [nignx注意事项](#nignx注意事项)
    - [nignx负载配置默认采用](#nignx负载配置默认采用)
    - [blockingqueue的三个添加方法和三个删除方法](#blockingqueue的三个添加方法和三个删除方法)
    - [常见blockingqueue实现队列](#常见blockingqueue实现队列)
    - [arrayblockingqueue和linkedblockingqueue](#arrayblockingqueue和linkedblockingqueue)
    - [linux之间进行通信的方式](#linux之间进行通信的方式)
    - [linux内核态和用户态](#linux内核态和用户态)
    - [并发编程的类，接口和方法](#并发编程的类接口和方法)
    - [hashmap是否线程安全](#hashmap是否线程安全)
    - [concurrenthashmap](#concurrenthashmap)
    - [终止线程 4 种方式](#终止线程-4-种方式)
  - [jvm](#jvm)
    - [jvm的组成部分](#jvm的组成部分)
    - [源代码的执行流程](#源代码的执行流程)
    - [浅拷贝和深拷贝](#浅拷贝和深拷贝)
    - [堆栈的区别](#堆栈的区别)
    - [队列和栈的区别](#队列和栈的区别)
    - [对象的创建](#对象的创建)
    - [对象内存分配的两种方式：](#对象内存分配的两种方式)
    - [虚拟机可能出现的并发问题](#虚拟机可能出现的并发问题)
    - [并发问题](#并发问题)
    - [对象的访问定位](#对象的访问定位)
    - [句柄和直接指针的优缺点](#句柄和直接指针的优缺点)
    - [简述垃圾回收机制](#简述垃圾回收机制)
    - [什么是gc，为什么进行gc？](#什么是gc为什么进行gc)
    - [垃圾回收机制的优点：](#垃圾回收机制的优点)
    - [垃圾回收器的基本原理是什么？垃圾回收器可以马上回收 内存吗？有什么办法主动通知虚拟机进行垃圾回收？](#垃圾回收器的基本原理是什么垃圾回收器可以马上回收-内存吗有什么办法主动通知虚拟机进行垃圾回收)
    - [java有哪些引用类型](#java有哪些引用类型)
    - [怎么判断对象是否可以被回收？](#怎么判断对象是否可以被回收)
    - [说一下 JVM 有哪些垃圾回收算法？](#说一下-jvm-有哪些垃圾回收算法)
    - [几种垃圾回收算法的优缺点](#几种垃圾回收算法的优缺点)
    - [新生代垃圾回收器和老年代垃圾回收器都有哪些？有什么 区别？](#新生代垃圾回收器和老年代垃圾回收器都有哪些有什么-区别)
    - [详细介绍一下 CMS 垃圾回收器？](#详细介绍一下-cms-垃圾回收器)
    - [新生代垃圾回收器和老年代垃圾回收器都有哪些？有什么 区别？](#新生代垃圾回收器和老年代垃圾回收器都有哪些有什么-区别-1)
    - [简述分代垃圾回收器是怎么工作的？](#简述分代垃圾回收器是怎么工作的)
    - [分代默认空间分配](#分代默认空间分配)
    - [简述java内存分配](#简述java内存分配)
    - [回收策略](#回收策略)
    - [Minor GC和Major GC](#minor-gc和major-gc)
    - [简述java类加载机制?](#简述java类加载机制)
    - [类装载的方式](#类装载的方式)
    - [什么是类加载器，类加载器有哪些](#什么是类加载器类加载器有哪些)
    - [线程上下文类加载器（系统类加载器）](#线程上下文类加载器系统类加载器)
    - [java类上下文加载器的作用：](#java类上下文加载器的作用)
    - [说一下类装载的执行过程？](#说一下类装载的执行过程)
    - [方法区和堆](#方法区和堆)
    - [符号引用的含义](#符号引用的含义)
    - [jvm调优的参数](#jvm调优的参数)
    - [内存模型](#内存模型)
    - [fullgc用途](#fullgc用途)
    - [fullgc的触发场景](#fullgc的触发场景)
    - [调优工具](#调优工具)
    - [如何进行调优](#如何进行调优)
    - [类文件 文件结构](#类文件-文件结构)
    - [垃圾回收算法分类](#垃圾回收算法分类)
    - [并发算法和并行算法的区别](#并发算法和并行算法的区别)
    - [何时会抛出oom](#何时会抛出oom)
    - [内存泄露和解决方法](#内存泄露和解决方法)
    - [系统崩溃前的征兆](#系统崩溃前的征兆)
    - [为什么崩溃前垃圾回收的时间越来越长？](#为什么崩溃前垃圾回收的时间越来越长)
    - [为什么Full GC的次数越来越多？](#为什么full-gc的次数越来越多)
    - [为什么年老代占用的内存越来越大？](#为什么年老代占用的内存越来越大)
    - [jvm调优主要从以下几个方面进行](#jvm调优主要从以下几个方面进行)
    - [线程池参数](#线程池参数)
    - [通过线程池如何提高系统的吞吐量](#通过线程池如何提高系统的吞吐量)
    - [web应用类加载器和web容器的关系](#web应用类加载器和web容器的关系)
    - [类加载器和osgi的关系](#类加载器和osgi的关系)
    - [jvm如何分配直接内存](#jvm如何分配直接内存)
    - [直接内存和jvm堆内存的比较](#直接内存和jvm堆内存的比较)
    - [逃逸分析](#逃逸分析)
    - [逃逸的方式](#逃逸的方式)
    - [不存在逃逸，可以通过以下手段进行优化](#不存在逃逸可以通过以下手段进行优化)
    - [同步消除](#同步消除)
    - [标量替换](#标量替换)
    - [jvm常量池的种类](#jvm常量池的种类)
    - [new出来的字符串再编译时，不是已知的字面量](#new出来的字符串再编译时不是已知的字面量)
    - [永久代对象如何gc](#永久代对象如何gc)
    - [永久代gc的原因：](#永久代gc的原因)
    - [gcroots有哪些](#gcroots有哪些)
    - [如何处理循环引用](#如何处理循环引用)
    - [如果想在gc中生存一次如何做](#如果想在gc中生存一次如何做)
    - [内存溢出和内存泄露的区别](#内存溢出和内存泄露的区别)
    - [上溢和下溢的区别](#上溢和下溢的区别)
    - [内存溢出](#内存溢出)
    - [内存溢出一般发生在哪个区](#内存溢出一般发生在哪个区)
#  java面试
## 基础

### 1.JDK 和 JRE 还有jvm 有什么区别？

### 2.跨平台特性定义和实现原理：

### 3.java语言的特点是：

### 4.什么是字节码？字节码的好处：

    java源代码 jvm 
    1.可以解决传统解释型语言执行效率低的问题
    2.保留了解释型语言可移植性，
    字节码文件一旦生产便可再不同计算机运行


## 集合接口

### 1.迭代器是什么：
    迭代器是用来遍历集合的接口 
    代替了原来的enumeration，可以用来在迭代过程中进行删除

### 2.迭代器如何使用：以及其特点：
    迭代器的特点：
        迭代器使用单向遍历，更安全，当发生修改时报concurrentmodificationexception

### iterator 和 listiterator的区别：
    单向遍历    双向遍历
                多了添加替换以及获取前面元素的索引和后面元素的索引位置
    遍历set和list  只能遍历list
### 3.遍历一个list的方法有？

    1.for循环
    2.iterator遍历
    3.foreach遍历（本质上使用iterator遍历）不用显式声明迭代器，代码简单，不易出错，不能使用迭代器方法对元素进行相应的操作

### 4.arraylist的优缺点：
    顺序添加快
    底层使用数组实现了rendomaccess接口,查找速度快

    缺点:添加删除一个元素时，需要进行整体复制，耗时长

### 5.实现randomaccess接口
    实现randomaccess接口，查找元素的平均时间复杂读为1

### 6.arraylist和array进行相互转化
    array.aslist
    arraylist.toarry()

### 7.arraylist和linkedlist的区别：
    随机访问：arraylist随机访问要快
    存取效率：不涉及首尾的插入和删除，linkedlist的效率高
    实现方式：arraylist     动态数组  linkedlist     双向链表
    内存占用：linkedelist更占内存，除了存储数据外还存储两个引用（直接前继和直接后继），一个指向前面元素，一个
    二者都没加同步锁，都是线程不安全的，

### 8.arraylist和vector的区别
    
    二者都实现了list接口
    线程安全vector是线程安全的
        vector所有方法都添加了同步锁，  
    性能上： 前者由于后者，后者加了同步锁在同步操作上会耗费大量时间
    扩容上：arraylist扩容为原来的1.5倍，vector扩容为原来的2倍

### 9.插入数据时arraylist，linkedlist和vector插入谁的速度更快：
    arraylist和vector底层使用的都是数组
    而vector由于使用了同步锁，在同步操作上会耗费大量时间

    linkedlist插入数据只需要知道当前项前后元素即可进行插入元素
    而数组插入元素需要根据索引插入后，将后面的元素依次移位，耗时长

### 10.多线程场景下如何使用arraylist
    通过collections.synchronizedlist实现

### 11.list和set的区别：
    list 有序 可重复 可以插入多个null
    set 无需 不可重复 只可以插入一个null

    list可以使用 for 循环    set不能 
        因为set是无序的，（存放顺序和取得顺序不一致）
    
    list查找效率高
    set插入删除效率高

    实现类 list arraylist vector linkedlist
        set hashset linkedhashset treeset

### 12.hashset的实现原理
    基于hashmap实现，hashset的值存在hashmap的key中，hashmap的value值存present
    对hashset的操作，一般直接调用底层hashmap的方法

### 13.hashset是如何检查重复和保证唯一

    hashset的add方法会调用hashmap的put方法，通过判断key的hash值以及equals方法来判断是否重复
    若key已经存在hashmap会用新v代替旧v

### 14.hashcode和equals方法的相关规定：
    两个对象相等那么两个对象的hashcode也一定相等
    两个对象相等，equals一定返回true
    hashcode相等equals方法的返回值不一定为true

### 15.==和equals方法的区别

    ==用来判断两个变量或实例是否指向一个内存空间，（指引用是否相同）
    equals用来判断  内存空间的值是否相同，（指的是值是否相同）

## Map接口

### 1.hashmap的实现原理：
    hashmap方法基于hash算法来实现：
        首先再插入一个元素时，先计算对象的key的hashcode hash出 当前对象的数组下标，
        存取时：
            若hash值相同，对key值进行判断，
            若key值相同，覆盖掉原来的值
            若key值不相同，将冲突的对象放到链表中
        获取时：由计算出的相应的hash值查找对应的下标，再判断key值是否相同，同取出相应的值

### 2.hashtable和hashmap以及treemap的区别：
    hashtable是线程安全的
    遍历 hashtable通过enumeration  hashmap iterator
    hashtable 不允许用空键值对    hashmap允许一个键值为null
    hashtable  默认大小为11  的扩容机制为： 2*old+1
    hashmap 默认大小为16  扩容机制为原来的2的指数次倍
    treemap保存记录根据键值进行排序，默认升序

### 3.hashmap的数据结构：
    1.8之前数组+链表
    

### 4.hashmap的扩容因子：

    0.75 当达到扩容因子，会将数组扩容为原来的1倍

### 拉链法和红黑树

    拉链法：java1.8之前，当遇到hash冲突时，将冲突值存入到链表种

    红黑树法：java1.8之后，当遇到hash冲突时，现将冲突值存入到链表中，当链表长度达到阈值时将链表转化为红黑树

### 转化为红黑树的目的：

    防止链表过长，造成查询效率降低

### hashmap有哪些方法来降低hash冲突
    1.链地址法：将hash冲突的值存到链表中
    2.hash法：通过两次扰动降低hash冲突的概率
    3.使用红黑树降低时间复杂度，提高查询效率
### 5.多线程下使用hashmap

    调用collections.synchronizedmap方法实现，使用的** 互斥锁 **，只允许一个线程访问，效率低

### 6.hashmap的put方法的具体流程：
    首先根据key的hash值，（调用hash方法）（hash方法：将取得的hashcode的值的高16bit和低16bit进行异或减少碰撞概率，得到hash值）
    使用hash值和hashmap的数组长度-1进行相与得到下标值

### 7.classloader和class.forname的区别：
    classloader 只干一件事，将class文件加载到jvm中不会加载static代码块
    class.forname 将class文件加载到jvm中，还会对类进行解释，可控制是否加载类中的static代码块
### 8.treeset和treemap的关系：
    treeset底层使用的容器为treemap，和hashset类似，在对treeset进行操作时，是调用treemap的方法进行操作
    treemap底层使用红黑树的排序二叉树，
### treemap
    使用的数据结构为红黑树的排序二叉树，按照键值进行排序，默认按照升序排序，
    实现了sortedmap接口，当使用红黑树进行排序时，必须实现comparable接口，或者引入自定义的
    comparator类，否则会报classcastexception
### hashtable

    hashtable常用方法和hashmap类似，其在任一时间只能有一个线程访问，是线程安全的
    但其并发性又不如concurrentmap，后者使用了分段锁
    因而在使用线程安全时使用con      不需线程安全时用hashmap

### linkedhashmap

    记录了插入顺序

## 流、

### 1.流的概念：
    流有输入和输出，输出是指从程序到数据源，输入是指从数据源到程序

### 2.流的分类：
    按数据流的方向分为输入流和输出流
    按使用方式：字节流和字符流
    按找处理流的方式：节点流和处理流
    节点流对特定设备进行读写数据的流，
    处理流对已经存在的流进行封装，然后通过封装后的流进行数据的读写操作

### 3.io模型：
    按网络编程分类：非阻塞io，阻塞io，信号驱动io，多路复用io，异步io

    按posix分类：异步io和同步io

    一个io操作分为两步io请求和实际io操作

    区别在于第二步时，实际io操作时，会不会将请求进程阻塞，会同步
        不会异步
### BIO,NIO,AIO 有什么区别?
    简答
    BIO：Block IO 同步阻塞式 IO，就是我们平常使用的传统 IO，它的特点是模式简单使用方便，并
    发处理能力低。
    NIO：Non IO 同步非阻塞 IO，是传统 IO 的升级，客户端和服务器端通过
    Channel（通道）通讯，实现了多路复用。
    AIO：Asynchronous IO 是 NIO 的升级，也叫 NIO2，实现了异步非堵塞 IO 
    ，异步 IO 的操作基于事件和回调机制。
### 4.同步和异步的区别：
    二者关注的是信号通信机制，在调用一个进程后，是否会立即返回一个返回值，还是等待这个返回值，等待为同步，立即返回为异步

### 5.阻塞和非阻塞区别：
    二者关注的是程序在等待方法返回值的状态，若在等待期间将线程挂起一直等待返回值即为阻塞，而非阻塞不会挂起，

### 6.io多路复用方案：
    多路复用依赖于：事件多路分离器，和事件处理器
    事件分离器负责将事件源的相应io事件分发到事件处理器进行处理

    与之相关的两个模式：reactor和preactor
    前者同步，后者异步

### 7.两种模式的区别

    相同点：都是对某个事件的通知
        demuliplextor负责查看事件提交io操作（异步），查看是否可以进行操作（同步），满足条件调用handler，
        不同点：当调用handler时，异步已经完成io操作，同步表示可以进行某个操作

### 8.String 编码 utf-8和GBK的区别

    GBK是中文编码，（支持中文简体和中文繁体）
    utf-8支持所有国家的语言：
    GBK占用空间比utf-8空间要小

### 9.什么时候使用字节流，（字符流）二者的区别是：

    字节流操作的是一个字节，
    字符流操作的是两个字节（unicode），主要来处理字符或字符串
    字符流是jvm将字节转换为两个字节的unicode字符为单位的字符

    关系到中文的使用字符流比较好

    主要区别：
        字节流在操作是不需要缓存,直接对文本进行操作
        字符流在通过缓冲区操作字符

    文本内容（图片等）存在硬盘，字符值在内存中才会形成


### 集合类

    集合类只能用来装对象，装的对象是基本类型的时候会自动装箱

## 类加载器

### 1.为什么需要自定义类加载器

    1.加密：对字节码文件加密预防反编译，其中使用了某种特定的算法，因而不能使用原生的类加载器，需要自定义classloader进行解密，在进行加载

    2.从非标准的来源加载字节码

### 2.双亲委派模型

    当一个字节码文件进行加载时首先询问当前类加载器是否已经加载了该类，直接返回已加载的类，
    若没有，则将字节码委派给父类加载器，执行同样的机制，还没有委派给父类的父类的加载器，直到
    到达启动类加载器，若还没有报classnotfoundexception然后调用findclass方法进行查找


### 3.双亲委派机制的好处

    安全性：防止自定义的类动态替换java原生的核心类

    保证java核心库的类型安全，所有类都至少引用了java.lang.object，在运行时，会加载object类，如果使用自定义的类加载器加载，可能会造成存在不同版本的object类存在，而这些类之间是不兼容的，通过代理模式，将核心类库的类加载交给引导类加载器，保证应用程序使用的类是统一个版本的，是互相兼容的
     
    防止重复加载，因为jvm区分不同的类，不仅仅是根据类名，若该类被两个不同的加载器加载就是不同的类



### 4.如何自定义类加载器

    首先继承classloader  然后重写findclass（）方法
     defaultfindclass 方法可以将二进制流文件转化为符合jvm规范的字节码文件（java.lang.class）

### 5.面向对象和面向过程的区别

    面向过程的性能要优于面向过程，因为面向对象要进行类的实例化，开销大，
        缺点没有面向对象易扩展，易复用，易维护

    面向对象：易扩展，易复用，易维护  
    因为具有封装继承多态的特点可以开发出低耦合的系统，系统更加灵活

### 6.java源代码到运行的三个步骤

    首先使用java源码级编译器将对应的java源文件（.java）进行编译，编译成相应的字节码文件，
    将字节码文件给到对应系统的虚拟机，将字节码文件转换成相应系统平台的机器码文件，进行运行

### 7.java是如何进行即时编译的，好处是

    
    将字节码文件，传入到jvm中，使用jit（运行时编译）
    当java源代码进入后，jit对其进行编译，完成第一次编译后，将其编译所得的机器码文件存存储，下次直接使用

    java即时编译的好处：提高代码运行效率

    在程序响应时间下，没有达到最大的优化，占用存储空间

### 8.jvm编译字节码的三种方式

    解释器模式，jit即时编译器模式，混合模式


### 9.混合模式是如何执行的

    以hotspot为例，该jvm采用混合模式，先解释执行字节码文件，然后使用惰性评估，评估哪些代码是热点代码，jit对这部分代码进行即时编译，
## 反射

### 什么是反射机制？

    JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个
    对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为
    java语言的反射机制。
### 静态编译和动态编译

    静态编译：在编译时确定类型，绑定对象
    动态编译：运行时确定类型，绑定对象

### 反射机制优缺点

    优点： 运行期类型的判断，动态加载类，提高代码灵活度。
    缺点： 性能瓶颈：反射相当于一系列解释操作，通知 JVM 要做的事情，性能
    比直接的java代码要慢很多。
    
### 反射机制的应用场景有哪些？

    反射是框架设计的灵魂。
    在我们平时的项目开发过程中，基本上很少会直接使用到反射机制，但这不能说明反射机制没有用，实
    际上有很多设计、开发都与反射机制有关，例如模块化的开发

### Java获取反射的三种方法

    1.通过new对象实现反射机制
    2.通过路径实现反射机制
    3.通过类名实现反射机制

## 

### 接口的方法和变量

    接口中的方法默认使用public abstract
    接口中的变量默认使用public static abstract 

### 1.java应用程序和小程序的区别

    应用程序通过主线程（主方法main）来执行
    applet小程序没有main方法，通过init（）和run方法嵌在浏览器上运行

### 2.String字符常量和Char字符常量的区别
    
    形式上:
    char常量在定义时使用’‘来定义
    String        “”
    占内存的大小：
        字符常量占两个字节
        字符串 占若干个字节（至少为一个字节）
    含义上：
        字符常量相当于一个整型常量，可以用ascII表示，可以进行运算
        字符串常量存储的是一个地址值    字符串常量的存储地址

### 3.构造器是否可以被重写

    不能被重写，因为子类不能继承父类的私有属性和构造方法，但是可以被重载

### 4.java三大特性的含义：

    封装：定义私有属性，提供公共方法来进行访问
    继承：子类可以在父类的基础上添加新的功能和数据
    多态：在编程时并不知到对象引用指向对象的具体类型，引用调用哪些方法，只有在运行时才知道

### 5.String Stringbuffer Stringbuilder区别

    String中使用final修饰字符数组来保存字符串
    Stringbuffer和Stringbuilder使用final来修饰类
   
    线程安全：

    Stringbuffer使用同步锁对其进行加锁，因而其是线程安全的
    string使用final修饰所以是线程安全的

    操作上：
        每次在string进行操作时，都会创建一个新对象，然后将指针指向新的string对象
        对stringbuffer进行操作时，都是直接操作原有对象，
    
    使用上：
        在操作少量数据时，使用String
        在单线程条件下，操作大量数据，stringbuilder
        多                          Stringbuffer

### 6.使用final修饰 char value[]的好处

    使用final修饰使其变成不可变对象

    保证安全性：
        String类型是java中最常用的类型之一，常常存储敏感信息，保证其不可变可以防止因为值改变所带来的不安全问题
    线程安全：
        同时多个线程尝试修改该String时会创建一个新的String，因而不存在线程安全问题
    节省空间：
        不可变对象存在常量池中，当添加相同值时，若该常量池中已经存在直接引用指向该对象节省空间

    性能上：

### 7.自动装箱和自动拆箱
    
    概念：
        将对应的基本类型包装为其引用类型
        将包装类型转化成基本类型

    Integer自动装箱池的范围是-128~127

    Byte,Short,Long范围是-128~127

    Character范围是0~127

    Float和Double没有自动装箱池

### 8.在一个静态方法中调用非静态方法或成员为什么时非法的

    在类加载时，优先加载静态方法，而非静态成员还未加载，找不到的话，会产生错误

### 9.在java中定义无参构造方法的作用是

    当一个子类继承该类时，在执行子类构造方法时，会先执行父类的构造方法，若子类没有使用super（）方法调用父类的构造方法，则会调用父类的无参构造方法，若父类没有无参数构造方法，会造成编译错误

### 10.接口和抽象类的区别

### 11.成员变量和局部变量的区别

### 12.在调用子类构造方法之前先调用父类的无参构造方法的目的：
    
    帮助子类初始化

### 13.一个类的构造方法的作用是什么：一个类的没有书写构造方法能正常执行吗

    构造方法的作用：用于完成类对象的初始化

    能  有默认的无参构造方法

### 14.对象引用相等和对象相等的区别

    前   内存地址相同
    后   内存存储的内容相同

### 15.== 和equals方法的区别

    == 比较的 二者的内存对象的地址是否相同
    equals 重写方法  比较的是二者的内容
            未     和==一样效果

### 16.hashcode和equals

### 17.final关键字的总结

    类  该类不能被继承，其中的方法都被隐式修饰final

    变量 基本数据类型   一旦初始化数值无法改变
         引用数据类型   引用无法改变，但其中的内容可以改变，初始化之后不能指向其他对象 

    方法：进行方法锁定，防止子类修改
        提高效率
            private修饰的方法 隐式使用final修饰方法

### java序列化时有些属性不想进行序列化，用什么修饰

    用transient修饰，
    用transient修饰的字段可以阻止其序列化
    transient修饰的字段在反序列化时，无法进行持久化和恢复，
    transient只能修饰变量不能修饰类和方法

## java异常常见面试题：
### error和exception的区别：
    error是虚拟机相关错误：可能原因有：内存溢出，
    error错误应用程序无法进行捕获处理，一旦发生通常应用程序会停止运行，无法通过应用程序进行恢复

### 运行时异常和受检异常的区别

    前者java编译器不会对其进行检查只能在运行时发现
    后者Java编译器会对其进行检查，在编译时即可发现，而且必须对其进行处理
### jvm是如何处理异常的

    当一个方法发生异常时，会首先创建一个异常对象并转交给虚拟机（里面有异常名称，异常描述，异常时应用程序的状态）抛出异常，jvm寻找是否有处理该异常的代码，有交给它，没有调用默认的异常处理器进行处理，默认异常处理器打印异常信息，终止应用程序。

### java常见运行异常有哪些
    
    indexoutofboundsexception
    arraystoreexception
    nullpointerexception
    classcastexception
## 多线程

### sleep和wait方法的区别：

    1. 对于 sleep()方法，我们首先要知道该方法是属于 Thread 类中的。而 wait()方法，则是属于Object 类中的
    2. sleep()方法导致了程序暂停执行指定的时间，让出 cpu 该其他线程，但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
    3. 在调用 sleep()方法的过程中，线程不会释放对象锁。
    4. 而当调用 wait()方法的时候，线程会放弃对象锁，进入等待此对象的等待锁定池，只有针对此
    对象调用 notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。

### 为什么wait，notify以及notifyall在object类而不是在thread类

    原因一：Java中，任何对象都可以作为锁，既然wait是放弃对象锁，当然就要把wait定义在这个对象所属的类中。更通用一些，由于所有类都继承于Object，我们完全可以把wait方法定义在Object类中，这样，当我们定义一个新类，并需要以它的一个对象作为锁时，不需要我们再重新定义wait方法的实现，而是直接调用父类的wait(也就是Object的wait)，此处，用到了Java的继承。
    原因二：使用线程定义wait方法有一个非常大的问题，一个线程完全可以持有很多锁，你一个线程放弃锁的时候，到底要放弃哪个锁？当然了，这种设计并不是不能实现，只是管理起来更加复杂。

### 线程，进程以及程序的概念

    线程是轻量级进程，是一个比进程更小的执行单位，一个进程可以产生多个线程，同类线程之间共享资源空间，
    进程是系统运行的基本单位，程序一次执行的过程
    程序是指存储在磁盘中含指令和数据的文件，即静态代码

### 如何理解内存泄露问题，如何避免内存泄露问题，哪些情况导致内存泄露的关系，如何解决：

    内存泄露问题：当内存中出现一些不被使用的对象时，jvm无法对其进行回收

### 为什么内存泄露会发生
    
    当一个对象比另一个对象生命周期长时，生命周期的对象已经不被程序使用，而生命周期长的对象还在使用，导致其无法被虚拟机回收，当这个生命周期长的对象引用多个这样的对象，这是就可能会发生内存不足的情况出现。同时，相应被引用对象还引用着大量对象，导致这些对象也不能被回收，这是就造成了大量内存资源的浪费
### 怎样阻止内存泄露

    1.在使用list和map集合以及大对象之后将其赋值为null
    2.避免使用substring方法，会导致内存泄露
    3.避免一些死循环重复创建对象或对集合添加元素撑爆内存
    4.简洁数据结构，少用静态集合
    5.即时关闭打开的文件，以及socket句柄
    6.关注监听器（listener）和回调（callbacks），当监听器不在被使用时，及时注销

### 线程池的原理

### 为什么使用线程池

    线程是稀有资源，使用线程池，可以减少线程创建和销毁的次数，使线程可以重复使用
    线程池可以根据系统的负载能力，调整线程池中工作线程的数量，从而防止服务器崩溃
### 线程池的优点：
    
    降低资源的消耗：减少线程创建和销毁的次数
    提高线程的可管理性：使用线程池可以对线程进行统一管理以及监控和调优
    提高响应速度：当任务到达时，任务可以不需要等待线程的创建直接执行
### 线程池的创建：


    几个重要参数：
        核心线程池中线程的数量
        线程池中线程最大数量
        当活跃线程超过核心线程时，空闲多余线程最大存活时间
        存活时间的单位
        存放任务的队列
        当线程池数量和任务队列已满时的处理策略

### 线程池大小分配
    分配判断依据：任务类型，cpu密集型，混合型，io密集型
    cpu密集型
    使用较小的线程池    一般线程池大小设置为cpu核心数+1

    io密集型
    使较大的线程池        方式一：cpu核心数*2
                        方式二：（线程等待时间/cpu时间之比+1）*cpu数目
                        线程等待时间越长，所需线程越多，cpu时间越长，所需线程越少
    混合型，分为前两者，依据不同的任务类型使用相应的线程池，



### rejectedexecutionhandler 饱和策略

    java提供了四种饱和策略：
        默认为abortpolicy   不处理直接抛出异常
        callerrunspolicy  调用所在线程处理任务 
        discardoldestpolicy 丢弃队列的最近一个任务，执行该任务
        discardpolicy   不处理直接丢弃

### 策略配置方法（两种）

    位置不同：相对于threadpoolexecutor

### excutor的两级调度模型

    上层：java程序将应用分解为多个任务，使用executor将任务映射成为固定数量的线程
    底层：操作系统内核将线程映射到硬件处理器上

### executor

    定义的java线程既是工作单元，又是执行机制
    在executor种将工作单元和执行机制分离开来，
    runable和callable是工作单元，executor来提供执行机制

    executor基于生产者消费者模式，工作单元提交任务的操作相当于生产者，executor执行任务的操作相当于消费者
### 线程安全和线程不安全的区别

    线程安全：线程执行过程中不会产生线程共享资源的冲突
    线程不安全：多个线程操作数据可能造成
### 线程安全举例说明：
    线程安全是指当你在多个线程运行相同的代码时，运行结果和单线程运行结果一致，其他变量的值和预期是一样的，这就是线程安全

### 线程安全问题

    线程安全问题主要由全局变量和静态变量引起
    存在竞争的线程不安全，不存在竞争的线程安全
### 实现线程安全的方式 

    1.互斥同步
        互斥量
        信号量
        临界区
    2.非阻塞同步
    3.无同步方案

####  互斥同步锁（悲观锁）

    特征：互斥 ：非你即我 
        同步：顺序访问
        java里的互斥同步锁： synchronized和reentrantlock

        互斥同步锁都是可重入锁 好处是：不会产生死锁问题，
                            缺点是：涉及到核心态和用户态的切换，消耗性能

        可重入锁优化机制：自旋锁，适应性自旋锁，轻量级锁，锁粗化和锁消除
#### 非阻塞同步锁（乐观锁）

    采用cas算法实现
    
### 锁膨胀

    锁可以从偏向锁升级到轻量级锁，再升级到重量级锁。这种升级过程叫做锁膨胀；

### ReentrantLock 与 synchronized

  1. ReentrantLock 通过方法 lock()与 unlock()来进行加锁与解锁操作，与 synchronized 会
  被 JVM 自动解锁机制不同，ReentrantLock 加锁后需要手动进行解锁。为了避免程序出
  现异常而无法正常解锁的情况，使用 ReentrantLock 必须在 finally 控制块中进行解锁操
  作。
  2. ReentrantLock 相比 synchronized 的优势是可中断、公平锁、多个锁。这种情况下需要
  使用 ReentrantLock。
##### cas算法

    CAS全称为compare and swap 是并发编程常用的算法
        可以用来实现无锁式同步机制
        CAS一共有三个值：V（实际读取位置的值），A（旧的预期值），B（线程方法的执行结果（新值））
        主要用途是用来使用不加锁的方式来实现同步
            可以满足多个线程访问同一个资源
        当一个线程访问一个位置的资源时，访问它的数据并执行自己的方法，在执行完方法后，将之前获取到的数据值和如今位置的数值进行比较，相同证明当前没有其他线程更新过该数据，将返回值写入到该位置，若不相同则证明有其他线程访问该线程，则将如今的数据取出执行上一个操作，一直循环直到数值相同为止
    
    CAS指令执行时，当且仅当V的值等于预期值A时，才会将V的值设为B，如果V和A不同，说明可能是其他线程做了更新，那么当前线程就什么都不做，最后，CAS返回的是V的真实值。
    而在多线程的情况下，当多个线程同时使用CAS操作一个变量时，只有一个会成功并更新值，其余线程均会失败，但失败的线程不会被挂起，而是不断的再次循环重试。
    
    正是基于这样的原理，CAS即时没有使用锁，也能发现其他线程对当前线程的干扰，从而进行及时的处理。
    
    CAS的应用类
        Java中提供了一系列应用CAS操作的类，这些类位于java.util.concurrent.atomic包下，其中最常用的就是AtomicInteger，该类可以看做是实现了CAS操作的Integer

    可能会出现ABA问题：
        其他线程修改数次之后的值和原来的值相同
    解决方案：
        添加版本号以予以区分
#### 无同步方案

    1.可重入代码
        任何时候都能进行中断重入操作，特点是不会依赖堆上共享的资源
    2.threadpool和volatile
        每个线程对数据进行操作时，首先从共享资源拷贝一份到内存中，单独对其进行操作
    3.线程本地存储
        一个共享资源一定要被多个线程访问，可以尽量先让一个线程完成所有操作
        例子为请求应答型web服务器

### 乐观锁和悲观锁的概念

    乐观锁：乐观锁认为，读多写少，并发的可能性比较低，
        使用乐观锁，在进行更新操作时，会先判断一下在此期间有没有更新数据
        先读取当前版本号，在加锁（将当前版本号和上次更新版本号进行比较，一样更新）
        如果不一样，更新失败，重复读比较写的操作

    悲观锁：悲观锁认为，写操作比较多，并发可能性比较大，每当一个线程操作数据时，给其加锁，其他想要操作数据的线程阻塞，直到获取到锁

### volatile关键字的作用：
    可见性：当一个线程对共享变量进行写操作时，会立即将数据存入到内存中，当其他线程访问时会读取新值
    有序性：jvm向处理器发送一个lock前缀指令，将这个变量所在缓存行的数据写入内存中

        lock前缀指令会相当于一个内存屏障（内存栅栏），会保证在其之前的指令执行完成，后面的指令在进行重排序后不会排到内存屏障之前的位置

### threadloacl原理：
    threadlocal用来维护本线程的变量，
    threadlocal是将各线程变量的副本存入到map的vlaue中，以当前threadlocal本身为key
    需要用时获取的是线程之前存入的值
    当存入的值为共享变量的值时，获取的也是共享变量的值，存在并发问题
### threadlocal的作用

    提供线程内的局部变量（维护的变量的副本），这些变量在线程的生命周期内起作用，减少一个线程内多个函数或者组件之间一些公共变量的传递的复杂度
### threadlocal 公有的方法：
    get，remove，set，initvalue

### threadlocalmap与weakreference
    
    threadloaclmap是一个经过了两层包装的threadlocal对象
    1.第一层包装是使用了weakreference<threadlocal<?>>将threadlocal对象变成一个弱引用的对象
    2.第二层包装是定义的类entry来扩展weakreference<threadlocal<?>>
### threaklocalmap的实现

    使用了一个数组 private entry[] table 来保存键值对实体，初始化大小为16
### 为什么要用 ThreadLocalMap 来保存线程局部对象呢？

    不管一个线程有多少个局部变量，都使用同一个threadlocalmap保存，entry[] table初始化大小为 16 当容量超过3/2时，进行扩容

### threadlocal的内存回收
    涉及到两个层面：
    1.在threadlocal层面
        当线程死亡时，所有保存的线程局部变量都会被回收
    2.在threadlocalmap层面
        当entry{} table占用达到3/2时，就会尝试回收entry对象，清理存活时间长的局部变量

### threadlocalmap是threadlocal里面的一个静态内部类


### volatile的场景：
    1.状态转换
        仅仅使用boelean值来指示发生了一个一次性的重要时间，例如初始化和关机，通常只有一个状态转换
    2.一次性安全发布

    3.独立观察
        主要作用是定期观察发布结果供应用程序内部使用
        一个线程对某个值每隔几秒进行读取，并更新相应的volatile变量以供其他线程进行访问
    4.volatilebean模式
        放入这个模式中的类型必须是线程安全的
        在这个模式中的所有变量必须是用volatile修饰的，并且其中的getter和setter方法必须是非常普通的，不能有任何约束
    5.开销较低的读写策略
        当读操作大于写操作时，使用synchronized（内部锁）和volatile变量结合，来减少公共代码路径的开销
        使用volatile来定义变量，使用内部锁来保证写操作是原子的，
        而读操作不加锁，可以来减少开销，优于无竞争锁获取的开销

### volatile变量和synchronized的区别

    volatile变量具有可见性，但是不具备synchronized的原子性
    可以用于线程安全：
    条件是：多个变量或一个变量修改后的值和之前的值之间不存在约束
### 正确使用volatile变量的条件

    变量没有包含在其他变量的不变式中
    变量的写操作不依赖于当前值

### 性能考虑 
    使用volatile的主要原因是其简易性，使用volatile变量比使用相应的锁简单的多
    次要原因 吸能，某些情况下，volatile变量同步机制的性能优于锁

    volatile的读操作和非volatile的读操作的开销几乎一样
    而 volatile的写操作的开销比非volatile的写操作的开销要高的高

    volatile 操作不会像锁一样造成阻塞，能够安全使用volatile的情况下，volatile可以提供一些优于锁的可伸缩性

    如果读操作的次数远超于写操作，与锁相比，volatile变量通常可以减少同步的开销

### threadlocal什么时候会出现oom的情况 

    在没有使用线程池的条件下，正常情况下不会造成内存泄露。如果使用了线程池的话，如果线程池没有销毁线程，那么可能会造成内存泄露


### threadlocalmap
    通过源代码可以看到每个线程都可以独立修改属于自己的副本而不会互相影响，从而隔离了线程和线程.
    避免了线程访问实例变量发生安全问题. 同时我们也能得出下面的结论：
    （1）ThreadLocal只是操作Thread中的ThreadLocalMap对象的集合；
    （2）ThreadLocalMap变量属于线程的内部属性，不同的线程拥有完全不同的ThreadLocalMap变量；
    （3）线程中的ThreadLocalMap变量的值是在ThreadLocal对象进行set或者get操作时创建的；
    （4）使用当前线程的ThreadLocalMap的关键在于使用当前的ThreadLocal的实例作为key来存储value
    值；
    （5） ThreadLocal模式至少从两个方面完成了数据访问隔离，即纵向隔离(线程与线程之间的
    ThreadLocalMap不同)和横向隔离(不同的ThreadLocal实例之间的互相隔离)；
    （6）一个线程中的所有的局部变量其实存储在该线程自己的同一个map属性中；
    （7）线程死亡时，线程局部变量会自动回收内存；
    （8）线程局部变量时通过一个 Entry 保存在map中，该Entry 的key是一个 WeakReference包装的
    ThreadLocal, value为线程局部变量，key 到 value 的映射是通过：
    ThreadLocal.threadLocalHashCode & (INITIAL_CAPACITY - 1) 来完成的；
    （9）当线程拥有的局部变量超过了容量的2/3(没有扩大容量时是10个)，会涉及到ThreadLocalMap中
    Entry的回收；
    对于多线程资源共享的问题，同步机制采用了“以时间换空间”的方式，而ThreadLocal采用了“以空间换
    时间”的方式。前者仅提供一份变量，让不同的线程排队访问，而后者为每一个线程都提供了一份变量，
    因此可以同时访问而互不影响。

### synchronized、volatile区别

    1.volatile 只能在变量级别使用，synchronized可以使用在类方法变量级别

        volatile不会造成线程阻塞，synchronized会有线程阻塞问题，当多个线程争抢锁时，可能会导致阻塞

    2.volatile 适用于多个线程对实例变量进行更改的场景，刷新内存中共享变量的值，使各个线程获取到最新的值
     synchronized 锁住当前变量，只有当前线程可以访问该变量，其他线程阻塞

     3.volatile 可以保证变量修改可加性， synchronized 可以保证变量原子性，因为线程获取锁之后才能进入临界区，从而保证临界区内的所有方法得到执行

     4.volatile标记的变量不会被编译优化，可以禁止指令重排，sychronized 标记的变量会被编译优化

    5.volatile不会造成线程阻塞，synchronized会造成线程阻塞



### 保证线程安全的三大特性

    原子性，可见性，有序性

    1.原子性，使用synchronized块保证
    2.可见性：使用volatile变量定义和final以及synchronized来保证
    3.有序性：使用synchronized和volatile来保证


    原子性：一个操作是不可中断的，要么全部执行完成，要么全部执行失败

    有序性：在本线程内观察，所有的操作是有序的，在其他线程内观察，所有的操作是无序的

### synchronized和volatile有序性的区别

    volatile和synchronized的有序是不同的:

    volatile关键字禁止JVM编译器已及处理器对其进行重排序,

    synchronized保证顺序性是串行化的结果，但同步块里的语句是会发生指令从排。

### 指令重排

    处理器为了提高程序运行效率，会对代码进行优化使
    原始代码执行顺序不按顺序执行，但是执行结果和顺序执行结果相同

    指令重排不会对单线程产生影响，但是可能会对并发线程产生影响

### java中的锁的粒度

    对象锁（方法锁）和类锁

### jmm的内存模型定义

    jmm内存模型，是指并发过程中，如何处理原子性，有序性以及可见性建立的模型


### jmm处理过程

    jmm通过禁止特定类型的编译器和处理器进行重排序，来为程序员提供一直的内存可见性保证

    每个线程都有一个本地线程空间-虚拟机栈，每次执行操作时先把变量从主内存中取一份数据到本地线程空间中，再对变量进行操作

    对变量进行操作后在某个时间将其刷入主存中，当a线程释放锁后将其存入主存中，当线程b获取到锁后，会同步主存中的数据（即a线程释放锁，b线程获取锁来达到线程通信的情况）

### 提高高并发量服务器的思路

    1.html静态化
    2.图片服务器分离
    3.数据库集群和库表散列
    4.缓存
    5.负载均衡
    6.镜像
    7.cdn加速技术

### 大型网站是怎样解决多用户高并发访问的

    分布式以减少单个任务的执行时间来提高效率
    集群以提高单位时间内执行任务的数量来提高效率

    集群主要分为：高可用集群，负载均衡集群，科学计算集群

    分布式将不同的业务分布到不同的服务器上
    集群将相同的业务部署到多个服务器上

    分布式每个节点都可以用做集群

### 负载均衡

    负载均衡就是将负载平摊到不同的操作单元上，用来进行性能提升以及处理单点故障和增强扩展性
## nignx注意事项

### nignx负载配置默认采用

    采用轮询机制，按时间顺序逐一分配到后端服务器上，若有一个后端服务器down掉，会自动剔除
    存在服务器session共享问题

### blockingqueue的三个添加方法和三个删除方法

    该接口继承自queue接口
    三个添加方法：
        offer 添加成功返回true 添加失败返回false
        add 添加成功返回true 若队列已满则会报illegalstatexception
        put 添加元素到队列里，若队列已满会处于阻塞状态直到队列不满

    三个删除方法
        
        remove 删除队列中对应的元素 成功 返回true 错误返回false
        poll 删除队列的第一个元素，若队列为空返回null 否则返回当前值
        take    删除队列的第一个元素，若队列为空，则会处于阻塞状态直到队列不为空

### 常见blockingqueue实现队列

    arrayblockingqueue linkedblockingqueue linkedblockingdeque proprityblockingqueue

### arrayblockingqueue和linkedblockingqueue
    arrayblockingqueue 只有一个锁，添加和删除元素只允许一个线程执行，不能并行执行
    linkedblockingqueue 两个锁 放锁和拿锁 ，添加和删除元素允许并行执行，添加数
据和删除数据的时候只能有1个线程各自执行。

### linux之间进行通信的方式
                无法介于用户态和内核态的原因
    套接字           软硬中断中无法无阻塞方式接收数据
    管道                局限于父子进程之间的通信
    信号量           无法介于内核态和用户态使用
    内存共享            依赖于信号量信号量不可用
    消息队列         软硬中断中无法无阻塞方式接收数据


### linux内核态和用户态

    内核态：运行的代码，cpu可以执行任何指令
    用户态:运行的代码受到cpu的严格审查，不能直接访问内核数据和程序

### 并发编程的类，接口和方法
    1.线程池
    2.reetrantlock
    3.volatile
    4.atomics
    5.cylicbarrier
    6.countdownlatch
    7.semaphore
    8.exchanger
    9.future和futuretask

### hashmap是否线程安全

    在进行多线程并发操作时，进行get操作可能会造成死循环，cpu使用率可能接近到100%

    解决策略：使用hashtable或者使用collections.synchronizedmap（hashmap）
            都是给一个线程加锁，一个线程在进行操作时其他线程处于阻塞状态

### concurrenthashmap

    concurrenthashmap在jdk1.7使用分段锁机制来实现

    底层采用数组+链表构成
    包括两个核心类 segment 和hashentry两个核心类

    segment继承自reentrantlock用来充当锁对象，用来维护多个散列对象映射的若干个桶，桶里存放着若干个hashentry组成的链表，
    
    concurrenthashmap在jdk1.8中的改进

    改进一：取消segments字段，直接采用transient volatile HashEntry<K,V>[] table保存数据，采用table数组元素作为锁，从而实现了对每一行数据进行加锁，进一步减少并发冲突的概率。
    改进二：将原先table数组＋单向链表的数据结构，变更为table数组＋单向链表＋红黑树的结构。对于hash表来说，最核心的能力在于将key hash之后能均匀的分布在数组中。如果hash之后散列的很均匀，那么table数组中的每个队列长度主要为0或者1。但实际情况并非总是如此理想，虽然ConcurrentHashMap类默认的加载因子为0.75，但是在数据量过大或者运气不佳的情况下，还是会存在一些队列长度过长的情况，如果还是采用单向列表方式，那么查询某个节点的时间复杂度为O(n)；因此，对于个数超过8(默认值)的列表，jdk1.8中采用了红黑树的结构，那么查询的时间复杂度可以降低到O(logN)，可以改进性能。


### 终止线程 4 种方式

    1. 正常运行结束
    程序运行结束，线程自动结束。
    2. 使用退出标志退出线程
        一般 run()方法执行完，线程就会正常结束，然而，常常有些线程是伺服线程。它们需要长时间的运行，只有在外部某些条件满足的情况下，才能关闭这些线程。使用一个变量来控制循环，例如：最直接的方法就是设一个 boolean 类型的标志，并通过设置这个标志为 true 或 false 来控制 while循环是否退出
     定义了一个退出标志 exit，当 exit 为 true 时，while 循环退出，exit 的默认值为 false.在定义 exit时，使用了一个 Java 关键字 volatile，这个关键字的目的是使 exit 同步，也就是说在同一时刻只能由一个线程来修改 exit 的值。
    3. Interrupt 方法结束线程g





















## jvm
### jvm的组成部分

### 源代码的执行流程

### 浅拷贝和深拷贝

### 堆栈的区别

    堆 物理内存地址是不连续的，性能慢的 在运行时分配内存 大小不固定
    栈 物理内存地址是连续的，先进先出，性能快  在编译时就能确定大小   大小固定

    堆存放 对象的实例和数组  关注的数据存储
    栈存放 局部变量 操作数栈 返回结果  关注的方法的执行

    堆是对于整个应用程序是共享的
    栈是线程私有的 生命周期和线程生命周期相一致

### 队列和栈的区别

    都是预存储数据的

### 对象的创建

    使用new关键字
    使用class的new instance方法
    使用constructor的new instance方法 
    前三者调用了构造方法

    使用clone方法
    使用序列化方法
    后者没有调用构造方法

### 对象内存分配的两种方式：
    

    内存规整：空闲内存在另一边，用过的内存放在另一边即为规整的
    指针碰撞：位于空闲内存和用过内存中间的指针指示器向空闲内存移动一段和对象大小一样的距离
    空闲列表：jvm维护一个列表来记录哪些空间是空闲的，在进行内存分配是，从列表中查询足够大的空间分配给对象，
        并对空闲列表进行更新操作

### 虚拟机可能出现的并发问题

    虚拟机创建对象是频繁的，当正在给A对象分配内存时，指针还未修改，而在给b对象分配内存时，又使用原来的指针进行内存分配

### 并发问题

    cas同步处理

    本地线程分配缓存

### 对象的访问定位

    主流的访问方式：直接指针和句柄

    直接指针：代表对象存储到内存中的起始地址

    句柄可以理解为：指针的指针，用来维护对象指针，
        句柄不直接指向对象而是指向指针，指针指向对象的内存地址

            (句柄不发生变化，指向固定的内存地址)

### 句柄和直接指针的优缺点

    内存中存储稳定的句柄地址，当对象发生改变时，句柄地址（引用）不需要发生改变，只需将句柄指向的指针进行改变

    直接指针：速度更快，省去了一次指针定位的过程，
    积少成多节省下的时间相当可观，hotspot就是这种定位访问方式

### 简述垃圾回收机制

    在java中，程序员不需要显式释放一个对象的内存，而是交由jvm去执行，jvm会有一个垃圾回收线程，是低优先级的，正常情况下不会执行，只有当jvm空闲时，以及堆内存满时，才会扫描那些没有任何引用的对象，添加到回收集合中对其进行回收

### 什么是gc，为什么进行gc？

    gc是垃圾回收的意思   
    内存处理一般是开发人员容易忘记，以及错误的垃圾回收会导致系统崩溃，
    java提供的gc功能可以自动监测那些对象超过了作用域对其进行回收，从而避免上述问题达到自动回收的目的

    java没有提供显式操作释放已分配内存的方法

### 垃圾回收机制的优点：
    Java中对象没有作用域的概念只有引用对象有作用域的概念
    使用垃圾回收机制有效防止了内存泄露，可以有效使用内存

### 垃圾回收器的基本原理是什么？垃圾回收器可以马上回收 内存吗？有什么办法主动通知虚拟机进行垃圾回收？

    对于gc来说，程序员创建一个对象，gc就监控该对象的地址，大小以及使用情况
    采用有向图来记录和管理堆中的所有对象，判断哪些对象是可达的，哪些对象是不可达的，
    gc有责任对不可达对象进行回收

    可以通过调用system.gc（）方法来通知gc进行回收，java语言规范并不一定保证执行

### java有哪些引用类型

    是相对回收来说的
    强引用：一定不会被gc回收
    弱引用：有用但不是必须的对象，在内存溢出前进行回收
    虚引用：有用但不是必须的对象，在下一次进行gc前进行回收
    幻引用：不会获取任何对象，只是用来在gc时返回一个通知，使用phantomreference来实现

### 怎么判断对象是否可以被回收？

### 说一下 JVM 有哪些垃圾回收算法？

### 几种垃圾回收算法的优缺点

### 新生代垃圾回收器和老年代垃圾回收器都有哪些？有什么 区别？

### 详细介绍一下 CMS 垃圾回收器？

    cms以牺牲吞吐量为代价获取最短回收停顿时间，一般适用于服务器端的应用，
    cms适用标志清除算法，会产生大量内存碎片，当剩余内存不能满足系统要求后，会产生concurrentfailure
    这时临时cms会调用serial old来继续清除，此时性能降低

### 新生代垃圾回收器和老年代垃圾回收器都有哪些？有什么 区别？

### 简述分代垃圾回收器是怎么工作的？

### 分代默认空间分配

    新生代默认占比为3/1老生代默认占比3/2 
    新生代中 eden fromsurvivor tosurvivor 默认空间占比 8:1:1

### 简述java内存分配

### 回收策略

    以下三种规则：

        优先分配到eden区
        
        大对象直接进入老生代

        长期存活对象进入老年代

        动态对象年龄判定
            如果在Survivor空间中相同年龄所有对象大小的总和大于Survivor空间的一半，年龄大于或等于该
    年龄的对象就可以直接进入老年代，无须等到 MaxTenuringThreshold 中要求的年龄。


### Minor GC和Major GC

    Minor GC 是指发生在新生代的 GC，因为 Java 对象大多都是朝生夕死，所 有 Minor GC 非常频
    繁，一般回收速度也非常快；
    Major GC/Full GC 是指发生在老年代的 GC，出现了 Major GC 通常会伴 随至少一次 Minor GC。
    Major GC 的速度通常会比 Minor GC 慢 10 倍以上。

### 简述java类加载机制?

    虚拟机将字节码里面描述类的数据加载到内存中，通过验证，准备，解析，初始化，最终形成虚拟机直接使用的类型

### 类装载的方式

    显式装载：通过反射实现，通过class.forname实现
    隐式装载：程序在运行过程当中遇到new等方式创建对象时，隐式装载

### 什么是类加载器，类加载器有哪些

    通过类的全限定名来获取类的二进制字节流的代码块叫做类加载器

    四种类加载器：
    启动类加载器：（引导类加载器）用来加载核心类加载器
    扩展类加载器：用来加载扩展类库中的类
    系统类加载器：用来根据java应用的类路径（classpath）来加载java类
    用户自定义类加载类：通过继承java.lang.classloader来实现

### 线程上下文类加载器（系统类加载器）

    java应用运行的初始线程的上下文类加载器是系统类加载器，线程中运行的代码通过该类加载器来加载类和资源
### java类上下文加载器的作用：
    java中提供了服务提供者接口 （spi）（service provider interface）

    spi允许第三方为这些接口提供实现

     用来解决spi系统类加载器和引导类加载器

     spi接口是核心库的一部分，由引导类加载器进行加载，spi的第三方实现类是由系统类加载器进行加载的，引导类加载器是无法加载系统类加载器加载的类，因为引导类加载器是系统类加载器的祖先加载器，

     线程上下文加载器解决了这个问题，java应用的默认系统上下文类加载器为线程上下文类加载器，在spi接口代码上使用这个加载器，就可以加载到第三方类加载器

### 说一下类装载的执行过程？


### 方法区和堆

    方法区和堆在逻辑上相互独立的
    方法去和堆在物理上是在堆上保存

### 符号引用的含义

    在该字节码文件中出现的类和接口

### jvm调优的参数

    xms2g：初始化堆的大小为2g
    xmx2g：堆的最大内存为2g
    xx：newratio=4 新生代和老生代的比例为1：4
    xx：survivorratio=8 新生代中eden 和survivor 比例为 8：2
    xx:+useconmarksweepgc 使用cms收集器serial old 收集器
    xx:+useparalleloldgc 发生fullgc时使用parnew+parallel old收集器 
    xx:+useparnewgc： 使用parnew回收器和serial收集器
    xx:+printgc 打印gc信息
    xx:+printgcdetails: 打印gc信息

### 内存模型

    jdk1.6之前有永久代 常量池在方法区中
    jdk1.7 逐渐去除永久代 常量池在堆中
    jdk1.8 永久代被元空间取代 常量池在元空间中

### fullgc用途

    清理新生代老年代以及永久代

### fullgc的触发场景

    1.promotionfailed （晋升失败）：
    新生代中的eden区晋升s区放不下，又晋升old区还是放不下
    2.cms的concurrent-mode-failure 报错
    3.新生代晋升的平均大小大于老生代
    使用g1和cms，fullgc触发serial 和 serial old
    指定参数为 parallelold fullgc 触发 parnew 和 parallel old 
    4.调用 system.gc


### 调优工具

### 如何进行调优

    Dump线程详细信息：查看线程内部运行情况
    死锁检查
    查看堆内类、对象信息查看：数量、类型等
    线程监控
    线程信息监控：系统线程数量。
    线程状态监控：各个线程都处在什么样的状态下
    热点分析
    CPU热点：检查系统哪些方法占用的大量CPU时间
    内存热点：检查哪些对象在系统中数量最大（一定时间内存活对象和销毁对象一起统计）

### 类文件 文件结构

    每个 class 文件 都唯一对应着一个类或者接口的定义信息

    每个类文件都是由8字节为单位的字节流文件构成的，所有16位32位64位长度的数据都被改造成为248字节的数据

### 垃圾回收算法分类

    串行算法
    并行算法
    并发算法


### 并发算法和并行算法的区别

    并发算法和并行算法都是多线程垃圾回收算法
    并行算法在进行垃圾回收期间，会暂停程序的执行
    而并发算法不会

### 何时会抛出oom
    并不是内存耗空才会报oom
    而是
    在jvm98%的时间都在进行垃圾回收
    每次回收的内存小于2%

### 内存泄露和解决方法

    1.发生系统崩溃
    2.生成dump文件
    3.分析dump文件
    4.分析内存泄露
### 系统崩溃前的征兆

    每次垃圾回收的时间变长，由之前的10ms升至50ms，fullogc由之前的0.5s升至4，5s
    fullgc的时间越来越频繁，最短时间间隔不到1分种
    年老代的内存越来越大，且每次fullgc年老代内存没有得到释放
    之后系统会无法响应请求，报oom

### 为什么崩溃前垃圾回收的时间越来越长？

    根据垃圾回收算法和内存模型，垃圾回收算法主要分为两步，标记和清除（复制）
    标记只需要知道内存的大小，标记内存的时间是不变的，变的是复制部分
    每次垃圾回收总有一部分垃圾回收不了，导致后期复制量增加，最终导致时间延长，因而可以用时间来作为判断内存泄露的依据
### 为什么Full GC的次数越来越多？

    内存的积累，逐渐耗尽了老年代的内存，导致新生成的对象无法进入老年代，fullgc次数变多

### 为什么年老代占用的内存越来越大？

    新生代的内存无法被回收，越来越多的新生对象进入老年代

### jvm调优主要从以下几个方面进行

    线程池
    连接池
    程序算法
    jvm启动参数

### 线程池参数

    workqueue参数的选择的不同有不同的效果

    synchronizedqueue：一个无容量的等待队列，
    为每个任务分配一个新的线程
    linkedblockingqueue：一个无界等待队列：使用该队列忽视参数maximumpoolsize，将任务全部交给corepoolsize的线程去执行，未执行的任务进入linkedblockingqueue等待
    arrayblockingqueue：一个有界队列，在有界队列和maximumpoolsize的共同作用下，很难进行调优
    大的queue和小的maximumpoolsize，造成cpu的低负载
    小的queue和大的池，该队列很难达到应有的效果

### 通过线程池如何提高系统的吞吐量
    提高系统吞吐量不能一味的提高maximumpoolsize

    要达到效果必须对其进行一定的封装，可以通过以下两个参数来达到
    以synchronizedqueue来使maximumpoolsize的参数生效，防止线程被无限制创建，通过提高maximumpoolsize来提高系统吞吐量

    自定义一个RejectedExecutionHandler，当线程数超过maximumPoolSize时进行处理，处理方式
    为隔一段时间检查线程池是否可以执行新Task，如果可以把拒绝的Task重新放入到线程池，检查的
    时间依赖keepAliveTime的大小。


### web应用类加载器和web容器的关系

    每个web应用都有自己的实例类加载器，其也采用代理模式，和双亲委派机制不同的是，该实例类加载器会先尝试进行加载，自己不能加载才会让父类进行加载，与一般类加载器的规范相反，这是java servlet规范所推荐的做法，其目的是将web应用自己的类优于web容器的类优先加载，
    这种代理模式的例外是，核心类库的类不在查找范围之内，确保了核心类库中类的安全性

### 类加载器和osgi的关系

    java的动态模块系统，为开发人员提供了面向服务和基于组件的运行环境，并提供标准的方式来进行软件生命周期的管理
    每个模块都有一个对应的类加载器，都有自己的java包和类，可以导入依赖的java包和类，以及导出java包和类

    当进行类加载时，每个模块加载自己的包和类，当加载核心类时，交给父类加载器去加载，当加载导入的java包和类时，交给导出该类的模块去加载，也可显式声明交给父类加载

### jvm如何分配直接内存

    直接内存不在jvm的运行数据区上，也不属于jvm规范范畴
    使用nio这种基于通道（channel）的io方式，使用native函数库直接分配堆外内存，通过存储在堆上的directbytebuffer对象作为堆外内存的引用来操作堆外内存（native堆），
    优点：提高了性能，减少了native堆和java堆的来回复制操作

    直接内存的大小不会受到java堆内存大小的影响，而是和系统内存大小有关
    在配置jvm参数时不要忽视直接内存大小参数的配置，否则可能会报oom
### 直接内存和jvm堆内存的比较

    直接内存的申请更空间加耗费性能，尤其时频繁申请时
    直接内存的io读写操作比普通堆内存的性能更优，尤其是在最频繁操作时

    从数据流上来看：
    非直接内存的数据链
    本地io --》直接内存 --》 非直接内存 --》 直接内存 --》本地io
    直接内存的数据链
    本地io --》直接内存 --》 本地io

    适用场景：
    直接内存适用于
    大量数据存储时，存储的数据生命周期长
    涉及到大量io操作时 如网络并发场景


### 逃逸分析

    逃逸分析并不是直接的优化手段，而是动态分析对象的作用域，将分析数据作为其他优化手段的依据

### 逃逸的方式

    方法逃逸：一个对象在方法中被创建之后作为另一个方法的参数传入
    线程逃逸：类变量和实例变量可能被其他线程访问

### 不存在逃逸，可以通过以下手段进行优化

    1.同步消除
    2.标量替换
    3.栈上分配

### 同步消除

    同步消除：如果一个对象不存在线程逃逸，那么证明不会被其他线程访问，不存在读写竞争，可以取消同步锁来进行调优  语句：-XX:+EliminateLocks

### 标量替换 

    标量不可分割的对象，如基本数据类型和引用数据类型
        把一个对象拆散，将成员变量恢复到基本类型的操作，标量替换
    当一个对象不在被外部方法访问时，将这个对象进行标量替换，不直接创建这个对象，
    而是将其若干个成员变量直接存储到栈上
    语句
    通过 -XX:+EliminateAllocations 可以开启标量替换， -XX:+PrintEliminateAllocations 查看标
    量替换情况。

### jvm常量池的种类

    静态常量池：class文件中的常量池，class常量池包括字符串等字面量信息，还包括方法信息以及类信息，占class文件大量空间
    运行时常量池：jvm将class文件中的常量池加载到方法区中

### new出来的字符串再编译时，不是已知的字面量

### 永久代对象如何gc

### 永久代gc的原因：

    永久代空间已满
    调用了system。gc

    是一个fullgc会对堆空间上所有内存进行一次gc
### gcroots有哪些

    类，由系统类加载器加载的类，这种类加载器加载的类一般不会被卸载，而是通过静态属性持有相应对象的引用
    java栈中的局部变量和参数
    jni（本地方法栈）中的局部变量和参数
    线程：存活的线程
    jni中的全局引用
    用作同步监控的对象

### 如何处理循环引用

    基于对象引用遍历进行垃圾回收的收集器，在不涉及到强引用的可达时，可以对循环引用对象进行回收释放内存

### 如果想在gc中生存一次如何做

    释放掉对象的引用，在finalize（）方法中重新建立引用，该方法只被调用一次，因而存活一次

### 内存溢出和内存泄露的区别

    内存溢出：（out of memory ）是指申请内存时，没有足够的内存空间供其使用
    内存泄露：（memory leak）是指申请内存时，无法释放已经使用的内存空间

    内存泄露达到一定程度最终也会造成内存溢出的出现

### 上溢和下溢的区别

    上溢：栈满后，还进栈产生空间溢出
    下溢：栈中没有任何元素，还退栈产生空间溢出

### 内存溢出

    栈内存溢出：
    堆内存溢出：
    持久带内存溢出：
'
### 内存溢出一般发生在哪个区

    一般发生在元数据区（metaspace）







