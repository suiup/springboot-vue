package org.myharvest.service;

import org.myharvest.pojo.Log;

import java.util.List;

/**
 * (Log)表服务接口
 *
 * @author Chuqing Jian
 * @since 2021-05-17
 */
public interface LogService {

    void add(Log log);

    void deleteById(Long id);

    void edit(Log log);

    List<Log> findAll();

    Log findLogById(Long id);

}
