package org.myharvest.pojo;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "auth")
@EntityListeners({AuditingEntityListener.class})
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authId;

    private String authName;

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "authId=" + authId +
                ", authName='" + authName + '\'' +
                '}';
    }
}
