package christopher.system.job;

import christopher.system.util.ResultUitl;

import java.util.Map;

public interface DynamicTaskJobService {
    /**
     * 按照id获取配置信息
     * @param id
     * @return
     */
    public Map getJobInfo(String id);

    public Map getActiveJobInfo(String id);

    /**
     * 启动任务
     * @param map
     */
    public void startJob(Map map);

    /**
     * 停止任务
     * @param id
     */
    public void stopJob(String id);

    /**
     * 执行任务
     * @param map
     * @return
     */
    public ResultUitl runJob(Map map);
}
