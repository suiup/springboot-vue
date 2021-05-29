package org.myharvest.service.impl;

import org.myharvest.pojo.Log;
import org.myharvest.dao.LogDao;
import org.myharvest.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Log)表服务实现类
 *
 * @author Chuqing Jian
 * @since 2021-05-17
 */
@Service("logService")
@Transactional(rollbackFor = Exception.class)
public class LogServiceImpl implements LogService {
    @Resource
    private LogDao logDao;

    @Override
    public void add(Log log) {
        logDao.save(log);
    }

    @Override
    public void deleteById(Long id) {
        logDao.deleteById(id);
    }

    @Override
    public void edit(Log log) {
        logDao.save(log);
    }

    @Override
    public List<Log> findAll() {
        return logDao.findAll();
    }

    @Override
    public Log findLogById(Long id) {
        Log log = logDao.findLogByLogId(id);
        if(log == null){
            return null;
        }
        System.out.println(log);
        Long logId = log.getLogId();
        System.out.println(logId);
        return log;
    }
}
