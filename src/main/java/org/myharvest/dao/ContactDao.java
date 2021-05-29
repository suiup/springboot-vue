package org.myharvest.dao;

import org.myharvest.pojo.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * (Contact)表数据库访问层
 *
 * @author Chuqing Jian
 * @since 2021-04-08
 */
@Repository
public interface ContactDao extends JpaRepository<Contact,Long> {

    List<Contact> findAll();

    Contact findContactByContactId(Long contactId);

    Contact findContactByContactName(String contactName);

    void deleteByContactId(Long contactId);

}

