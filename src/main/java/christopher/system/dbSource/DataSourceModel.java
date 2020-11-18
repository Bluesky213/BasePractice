package christopher.system.dbSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.Data;

import javax.sql.DataSource;
import java.util.Properties;

@Data
public class DataSourceModel {
    /**
     * 连接名称
     */
    private String name ;
    /**
     * 连接url，如：
     * jdbc:mysql://39.108.183.232:3306/hbeunews?useSSL=false&useUnicode=true&characterEncoding=UTF8
     */
    private String url ;
    /**
     * 连接用户名
     */
    private String username ;
    /**
     * 连接密码
     */
    private String password ;
    /**
     * 连接池类型。默认druid
     */
    private String type = "com.alibaba.druid.pool.DruidDataSource" ;
    /**
     * 驱动。如：
     * com.mysql.jdbc.Driver
     */
    private String driver ;

    public DataSource getDataSource() throws Exception {
        Properties p = new Properties();
        p.put("initialSize", "1");
        p.put("minIdle", "1");
        p.put("maxActive", "10");
        p.put("maxWait", "60000");
        p.put("timeBetweenEvictionRunsMillis", "60000");
        p.put("minEvictableIdleTimeMillis", "300000");
        p.put("validationQuery", "SELECT 'x' from dual");
        p.put("testWhileIdle", "true");
        p.put("testOnBorrow", "false");
        p.put("testOnReturn", "false");
        p.put("poolPreparedStatements", "true");
        p.put("maxPoolPreparedStatementPerConnectionSize", "20");
        p.put("filters", "stat");

        p.put("name", name);
        p.put("url", url);
        p.put("username", username);
        p.put("password", password);
        p.put("driver-class-name", driver);

        return DruidDataSourceFactory.createDataSource(p) ;
    }
}
