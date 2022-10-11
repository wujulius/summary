# java调优工具

## 一、监控工具

	1、jps
		jps 查看机器中的全部java进程。
		jps命令详解：
		jps -q 只显示进程号
		jps -m 显示传递给main方法的参数
		jps -l 显示应用main class的完整包名应用的jar文件完整路径名
		jps -v 显示传递给jvm的参数
		jps -V 禁止输出类名、jar文件名和传递给main方法的参数，仅显示本地jvm标识符列表

		这些命令可以混合使用：  
		示例：
		jps -l -v		-m -l -v 使用的比较多
		和jps功能类似的有
		ps -ef | grep java
		ps aux | grep java

		jps还可以去监控远程的主机

	2、jstat

		jstat 监控指定的进程

		stat -<option> -[t] [-h<lines>] <vmid>	[<interval> [<count>]]

		<option> 	指定参数，取值可以用 jstat -options 查看
				class	显示类加载器的统计信息
				compiler	显示有关 Java HotSpot VM 即使编译器行为的统计信息
				gc	显示有关垃圾收集堆行为的统计信息
				gccapacity	统计各个分代(新生代、老年代、持久代)的容量情况
				gccause	显示引起垃圾收集事件的原因
				gcmetacapacity	显示元空间的容量
				gcnew	显示有关新生代行为的统计信息
				gcnewcapacity 显示新生代的容量
				gcold	显示老年代、元空间的统计信息
				gcoldcapacity 显示老年代的容量
				gcutil 显示有关垃圾收集统计信息的摘要
				printcompilation	显示Java Hotspot编辑方法统计信息
				
		-t		每次采样所花费的时间
		-h     	每抽样几次就列一个标题，默认是0，显示数据第一列的标题	-h3  表示每监控三次以后，就输出一次列标题
		<vmid>	进程的唯一标识，本地的进程的话，就是进程号，远程的进程的话，格式是    <lvmid>[@<hostname>[:<port>]]
		<interval>	指定每隔多久去监控一次，单位是毫秒
		<count>	指定监控几次以后，就退出工具


	输出信息：
	class：
	loaded 当前加载的类的数量
	bytes 当前加载类的空间(单位是kb)
	unloaded 卸载的类的数量 Number of classes unloaded
	bytes 当前卸载的空间(单位是kb)
	time 执行类加载/卸载操作所花费的时间
	compiler：
	compiled 执行了多少次编译任务
	timestamp
	failed 多少次编译任务执行失败
	invalid 无效的编译任务数
	time 执行编译任务所花费的时间
	示例：
	jstat -class -t -h3 53939 1000 10 // class 显示类加载信息，-t 展示每次采样所花费的时间 -h3 表示每采样3次以后，就输出一次列标题，53939是进程唯一标识， 1000 表示每1000毫秒就监控一次， 10 表示 监控10次以后就退出工具 。

## 二、故障排查工具

	1、jinfo
		jinfo 主要用于查看jvm参数和调整jvm参数。
		jinfo

		<option>	用 jinfo -h 来查看
			flag <name>	打印指定参数的值
			flag [+|-]<name>	启用/关闭指定参数
			flag <name>=<value>	将指定的参数设置为指定的值
			flags		打印jvm参数
			sysprops	打印系统属性(笔者注：系统属性打印的是System.getProperties()的结果)
			<no option> 打印jvm参数以及系统属性
			h | -help	打印系统帮助信息

		jinfo 53939 打印的结果有两部分，系统属性和jvm参数
		jinfo -sysprops 53939 只打印系统属性
		jinfo -flags 53939 只打印jvm参数
		jinfo -flag UseG1GC 53939 打印这个 UseG1GC 属性的值
		jinfo -flag ThreadStackSize 53939

		jinfo的修改能力：可以动态的修改jvm的参数，而不用重启应用
		jinfo的修改能力是有限的，并不是所有的参数都能修改的， 只有下面命令执行的结果中的参数，才能动态修改
		java -XX:+PrintFlagsInitial | grep manageable

		jinfo -flag +HeapDumpAfterFullGC 53939 // 如果是 true、false的形式的话，HeapDumpAfterFullGC + 代表开， -代表关
		jinfo -flag MinHeapFreeRatio=90 53939 // 如果是 数值的话， 就用 k=v 的形式，将其大小改变

	2、jmap
		jmap 展示对象内存的映射或者堆内存的详细信息(堆内存的 dump)
		jmap [options] pid

		options的可选项如下：
		-clstats	连接到正在运行的进程，并打印java堆的类加载器统计信息
		-finalizerinfo	连接到正在运行的进程，并打印等待finalizerinfo的对象信息
		-histo[:live]	连接到正在运行的进程，并打印Java堆的直方图，如果指定了live选项，则仅统计活动对象
		-dump:dump_options 连接到正在运行的进程，并转储java堆，其中 dump_options的取值为：
			live	指定时，仅Dump活动对象，如果未指定，则转储堆中的所有对象
			format=b	以hprof格式dump堆
			file=filename	将堆dump到filename
			转储java堆是说把java堆的对象做一个快照存储到一个文件里面去，这个文件也叫堆dump(堆转储文件)


		示例：
		jmap -clstats 53939 展示这个53939进程的类加载统计信息
		jmap -finalizerinfo 53939 打印正在等待finalizerinfo的对象信息
		jmap -histo 53939 对象的直方图
		jmap -histo:live 53939 还存活的对象的直方图
		jmap -dump:live,format=b,file=mydump.hprof 53939 // dump:live 代表只转储存活的文件，format表示用hprof格式，将内容存储到mydump.hprof这个文件中 就在当前目录下，找到一个 mydump的文件

	3、jstack
		jstack 是用来打印当前虚拟机的线程快照(线程快照也叫 Thread Dump 或者 javacore文件)
		jstack [-l][-e]

		options:
			-l	显示有关锁的额外信息
			-e	显示有关线程的额外信息(比如分配了多少内存，定义了多少个类等)
			-? -h --help 打印帮助信息

		例：
		jstack 53939 打印53939这个线程的 基本线程栈
		jstack -l 53939 > jstack.txt 打印53939这个线程的 基本线程栈、有关锁的线程栈并写进当前目录下的 jstack.txt 文件中去

	4、jcmd
	看当前服务器内的全部的java应用，将诊断命令请求发送到正在运行的Java虚拟机

	5、jhat
	用来分析jmap生成的dump文件（jhat的能力比较弱，有一大堆的替代品：VisualVM、Eclipse Memory Analyzer、 推荐使用jhat的替代品，因为它们的功能更强。并且jhat在jdk11中已经消失）

	6、jhsdb
	基于服务性代理实现的进程外调试工具

## 三、可视化工具

	1、jhsdb
	2、jconsole
	3、VisualVM
	4、Java Mission Control