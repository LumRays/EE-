package thread;

// 在 getInstance() 方法中 即使把 instance 实例化之后 此处的代码仍然要加锁 => 阻塞 => 影响效率
// 虽然加锁内部的执行逻辑看似很快 实际上背后线程调度的成本是非常高的( 父亲带儿子去商场的游戏厅 排队玩项目 玩完了去买游戏币 即使速度很快 可能回来就要等了 )
// 懒汉的单例模式 ( 解决线程安全问题 Plus )
// 引入双重 if 让程序需要加锁的时候进行加锁 同时保证线程安全 保证单例实现唯一实例
class SingletonLazy3 {

    private static SingletonLazy3 instance = null;

    // 作为要加锁的对象 由于是要在 static 方法中使用锁对象 对象本身也要是 static 的
    private static Object locker = new Object();

    // 懒汉模式的关键在于 把实例的创建时机推迟了 推迟到第一次使用的时候才进行创建
    public static SingletonLazy3 getInstance() {
        // 本质是 if 和 = 两个操作要打包成原子
        // 这个条件判断是否需要加锁
        if (instance == null) {
            synchronized (locker) {
                // 判定是否需要创建实例
                if (instance == null) {
                    instance = new SingletonLazy3();
                }
            }
        }
        return instance;
    }

    // 单例模式最关键的要点 : 禁止构造方法被外部使用
    private SingletonLazy3() {

    }

}

public class Demo28 {

    public static void main(String[] args) {



    }

}
