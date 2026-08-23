package thread;

// 此处要求 Singleton 类只能有一个实例
// 饿汉模式 会在类加载的时候创建实例
class Singleton {

    private final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    // 单例模式最关键的要点 : 禁止构造方法被外部使用
    private Singleton() {

    }
}

public class Demo25 {

    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);

    }

}
