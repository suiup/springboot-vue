package org.myharvest.pojo;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * (Log)实体类
 *
 * @author Chuqing Jian
 * @since 2021-05-17
 */
@Entity
@Table(name = "log")
@EntityListeners({AuditingEntityListener.class})
public class Log implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    private String who;

    private Date whatTime;

    private String whatTable;

    private String whatOperation;

    private String whatTuple;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public Date getWhatTime() {
        return whatTime;
    }

    public void setWhatTime(Date whatTime) {
        this.whatTime = whatTime;
    }

    public String getWhatTable() {
        return whatTable;
    }

    public void setWhatTable(String whatTable) {
        this.whatTable = whatTable;
    }

    public String getWhatOperation() {
        return whatOperation;
    }

    public void setWhatOperation(String whatOperation) {
        this.whatOperation = whatOperation;
    }

    public String getWhatTuple() {
        return whatTuple;
    }

    public void setWhatTuple(String whatTuple) {
        this.whatTuple = whatTuple;
    }


    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", who='" + who + '\'' +
                ", whatTime='" + whatTime + '\'' +
                ", whatTable='" + whatTable + '\'' +
                ", whatOperation='" + whatOperation + '\'' +
                ", whatTuple='" + whatTuple + '\'' +
                '}';
    }

}
