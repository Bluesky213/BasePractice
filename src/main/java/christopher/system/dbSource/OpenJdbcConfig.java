package christopher.system.dbSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static christopher.system.dbSource.OpenJdbcUtil.jts;

/**
 * 初始化job
 */
/**
 * 初始化job
 */
//@Component
public class OpenJdbcConfig {
    @Value("${open.ds.active:false}")
    private boolean active ;
    @Value("${open.ds.name}")
    private String name ;
    @Value("${open.ds.url}")
    private String url ;
    @Value("${open.ds.username}")
    private String username ;
    @Value("${open.ds.password}")
    private String password ;
    @Value("${open.ds.type}")
    private String type ;
    @Value("${open.ds.driver-class-name}")
    private String driver ;

    @PostConstruct
    public void init(){
        if(active) {
            long start = System.currentTimeMillis();
            DataSourceModel dm = new DataSourceModel();
            dm.setDriver(driver);
            dm.setName(name);
            dm.setPassword(password);
            dm.setUsername(username);
            dm.setUrl(url);
            dm.setType(type);
            JdbcTemplate jt = OpenJdbcUtil.getJt(dm);
            long end = System.currentTimeMillis();
            System.out.println(end-start+"ms");
            jts.put(name,jt);
            long start1  = System.currentTimeMillis();
            int s = jt.queryForObject("select count(*) from s_user ",Integer.class) ;
            long end1 = System.currentTimeMillis();
            System.out.println(end1-start1+"ms");
        }
    }
}