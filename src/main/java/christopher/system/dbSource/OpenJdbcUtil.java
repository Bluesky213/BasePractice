package christopher.system.dbSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class OpenJdbcUtil {

    public static Map<String, JdbcTemplate> jts = new HashMap<>();//存放已经创建的jdbcTemplate

    /**
     * 通过已经创建的连接获取
     * @param name
     * @return
     */
    public static JdbcTemplate getJt(String name) {
        if(jts.containsKey(name)) {
            return jts.get(name) ;
        }
        return  null ;
    }

    /**
     * 获取默认的第三方连接
     * @return
     */
    public static JdbcTemplate getJt() {
        return  getJt("opends") ;
    }

    /**
     * 通过配置对象获取
     * @param dm
     * @return
     */
    public static JdbcTemplate getJt(DataSourceModel dm) {
        String name = dm.getName();
        if(jts.containsKey(name)) {
            return jts.get(name) ;
        }else{
            try {
                DataSource ds = dm.getDataSource() ;
                JdbcTemplate jt = new JdbcTemplate(ds) ;
                jts.put(name,jt) ;
                return jt ;
            } catch (Exception e) {
                log.error("创建连接出错",e);
                return null ;
            }
        }
    }

}
