package thread;

// 懒汉的单例模式 ( 解决线程安全问题 )
class SingletonLazy2 {

    private static SingletonLazy2 instance = null;

    // 作为要加锁的对象 由于是要在 static 方法中使用锁对象 对象本身也要是 static 的
    private static Object locker = new Object();

    // 懒汉模式的关键在于 把实例的创建时机推迟了 推迟到第一次使用的时候才进行创建
    public static SingletonLazy2 getInstance() {
        // 本质是 if 和 = 两个操作要打包成原子
        synchronized (locker) {
            if (instance == null) {
                instance = new SingletonLazy2();
            }
        }
        return instance;
    }

    // 单例模式最关键的要点 : 禁止构造方法被外部使用
    private SingletonLazy2() {

    }

}

public class Demo27 {

    public static void main(String[] args) {



    }

}
