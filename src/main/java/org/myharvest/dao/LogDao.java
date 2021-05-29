package org.myharvest.dao;

import org.myharvest.pojo.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * (Log)表数据库访问层
 *
 * @author Chuqing Jian
 * @since 2021-05-017
 */
@Repository
public interface LogDao extends JpaRepository<Log,Long> {

    List<Log> findAll();

    Log findLogByLogId(Long logId);

    void deleteLogByLogId(Long logId);
}

