package thread;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

// 通过这个类封装一下 DataSource 使 DateSource 变成单例
class DBUtil {

    private static volatile DataSource dataSource = null;

    public static DataSource getInstance() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    MysqlDataSource ds = new MysqlDataSource();
                    ds.setUrl("jdbc:mysql://127.0.0.1:3306/temp?characterEncoding=utf8&useSSL=false");
                    ds.setUser("root");
                    ds.setPassword("123456");
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }

}

public class Demo29 {

    public static void main(String[] args) {



    }

}
