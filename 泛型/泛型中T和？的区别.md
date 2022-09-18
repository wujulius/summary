## 泛型T和？的区别：
    T代表一种类型
    ？通配符，泛指所有类型，是所有类型的父类
    定义泛型类
    Class super<T>{}
    定义泛型方法：
    public <T> void testMethod(T[] a, Collection<T> c)
    修饰泛型了的属性成员:
    class Sub<T>{
	T temp;
    }
    在实际使用中都需要指明具体的泛型类型，才可以使用，而？是通配符，代表的是不确定的类，是一群类的父类看，不能使用？代替T
    