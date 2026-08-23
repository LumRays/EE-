package thread;

// 懒汉的单例模式
// 只有在实例化之前存在线程安全问题 一旦实例化完毕之后 线程安全问题就消失了
class SingletonLazy1 {

    private static SingletonLazy1 instance = null;

    // 懒汉模式的关键在于 把实例的创建时机推迟了 推迟到第一次使用的时候才进行创建
    public static SingletonLazy1 getInstance() {
        if (instance == null) {
            instance = new SingletonLazy1();
        }
        return instance;
    }

    // 单例模式最关键的要点 : 禁止构造方法被外部使用
    private SingletonLazy1() {

    }

}

public class Demo26 {

    public static void main(String[] args) {

        SingletonLazy1 s1 = SingletonLazy1.getInstance();
        SingletonLazy1 s2 = SingletonLazy1.getInstance();
        System.out.println(s1 == s2);

    }

}
