package org.myharvest.service;

import org.myharvest.pojo.Contact;

import java.util.List;

/**
 * (Contact)表服务接口
 *
 * @author Chuqing Jian
 * @since 2021-04-08
 */
public interface ContactService {

    void add(Contact contact);

    void deleteById(Long id);

    void edit(Contact contact);

    List<Contact> findAll();

    Contact findContactById(Long id);

    /**
     * 新增数据
     *
     * @param contact 实例对象
     * @return 实例对象
     */
    // Contact insert(Contact contact);

    /**
     * 修改数据
     *
     * @param contact 实例对象
     * @return 实例对象
     */
    // Contact update(Contact contact);

    /**
     * 通过主键删除数据
     *
     * @param contactid 主键
     * @return 是否成功
     */
    //  boolean delete(Long contactid);

}
