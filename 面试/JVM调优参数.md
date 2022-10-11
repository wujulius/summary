# JVM调优参数

## 堆内存参数配置

    -Xms10g ：JVM启动时申请的初始堆内存值
    -Xmx20G ：JVM可申请的最大Heap值
    -Xmn3g ： 新生代大小，一般设置为堆空间的1/3 1/4左右，新生代大则老年代小
    -Xss ：Java每个线程的Stack大小
    -XX:PermSize ：持久代（方法区）的初始内存大小
    -XX:MaxPermSize ： 持久代（方法区）的最大内存大小
    -XX:SurvivorRatio ： 设置新生代eden空间和from/to空间的比例关系，关系(eden/from=eden/to)
    -XX:NewRatio ： 设置新生代和老年代的比例老年代/新生代

## 调试跟踪参数配置

    -XX:+PrintGC ：打印GC日志
    -XX:+PrintGCDetailsGC ：时的详细堆信息
    -XX:+PrintHeapAtGC ：打印GC前后的堆信息
    -XX:+PrintGCTimeStamps ：输出GC发生时间，输出的时间为虚拟机启动的偏移量
    -XX:+PrintGCApplicationConcurrentTime ：输出应用程序执行时间
    -XX:+PrintGCApplicationStoppedTime ：输出应用程序由于GC产生停顿的时间
    -XX:+PrintRefrenceGC ：输出软引用、弱引用、虚引用和Finalize队列
    -XX:+HeapDumpOnOutOfMemoryError ：产生OOM时可以在内存溢出时导出整个堆信息
    -XX:HeapDumpPath ：导出堆文件存放路径
    -XX:+TraceClassLoading ：跟踪类加载信息
    -XX:+TraceClassUnloading ：跟：踪类卸载信息
    -XX:PrintClassHitogram ：查看系统中的类的分布情况（占用空间最多、实例数量空间大小）
    -XX:+PrintVMOptions ：打印虚拟机接收到的命令行显示参数
    -XX:+PrintCommandLineFlags ：打印虚拟机的显式和隐式参数
    -XX:+PrintFlagsFinal ：打印虚拟机的所有系统参数

## GC参数设置

### 串行收集器相关的参数

    -XX:+UseSerialGC ：新生代、老年代使用串行收集器
    -XX:SurvivorRatio ：设置eden区和survivor区大小的比例
    -XX:PretenureSizeThreshold,：当对象大小超过此值时，直接分配到老年代
    -XX:MaxTenuringThreshold ：设置对象进入老年代的最大年龄

### 并行相关的参数

    -XX:+UseParNewGC ：新生代使用并行收集器
    -XX:+UseParallelOldGC ：老年代使用并行回收收集器
    -XX:+ParallelGCThreads ：设置垃圾回收线程数，一般最好与CPU数量相当，默认情况下，当CPU数量小于8个时，ParallelGCThreads的值相当于CPU数量，当CPU数量大于8个时，ParallelGCThreads的值等于3+((5*CPU_COUNT)/8
    -XX:MaxGCPauseMillis ：设置最大垃圾收集停顿时间
    -XX:GCTimeRatio ：设置吞吐量大小，它的值是一个0~100之间的整数，假设值为n,那么系统将花费不超过1/(1+n)的时间用于垃圾收集
    -XX:+UseAdaptiveSizePolicy ：打开自适应GC策略，JVM对新生代的大小、eden和survivior的比例、晋升老年代对象年龄等参数自动调整

### CMS回收器相关的参数

    -XX:+UseConcMarkSweepGC ：启用CMS
    -XX:ParallelCMSThreads ：设置CMS线程数量
    -XX:CMSInitiatingOccupancyFraction ：默认68当老年代的空间超过68%时会执行一次CMS回收
    -XX:UseCMSCompactAtFullCollection ：设置CMS结束后是否需要进行一次内存空间整理
    -XX:CMSFullGCsBeforeCompaction ：进行多少次CMS后进行内存空间压缩
    -XX:+CMSClassUnloadingEnabled ：允许对类元数据区进行回收
    -XX:CMSInitiatingPermOccupancyFraction ：当永久区占用率达到此值时进行CMS回收（须激活CMSClassUnloadingEnabled）
    -XX:UseCMSInitiatingOccupancyOnly：只要达到阈值时进行CMS回收‘

### G1回收器相关的参数

    -XX:+UseG1GC ：使用G1
    -XX:MaxGCPauseMillis ：最大垃圾收集停顿时间
    -XX:GCPauseIntervalMillis ：最大停顿间隔时间


