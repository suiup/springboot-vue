package org.myharvest.service.impl;

import org.myharvest.pojo.Contact;
import org.myharvest.dao.ContactDao;
import org.myharvest.service.ContactService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Contact)表服务实现类
 *
 * @author Chuqing Jian
 * @since 2021-04-08
 */
@Service("contactService")
@Transactional(rollbackFor = Exception.class)
public class ContactServiceImpl implements ContactService {
    @Resource
    private ContactDao contactDao;

    @Override
    public void add(Contact contact) {
        contactDao.save(contact);
    }

    @Override
    public void deleteById(Long id) {
        contactDao.deleteByContactId(id);
    }

    @Override
    public void edit(Contact contact) {
        contactDao.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return contactDao.findAll();
    }

    @Override
    public Contact findContactById(Long id) {
        Contact contact = contactDao.findContactByContactId(id);
        if(contact == null){
            return null;
        }
        System.out.println(contact);
        String contactName = contact.getContactName();
        System.out.println(contactName);
        return contact;
    }

    /**
     * 新增数据
     *
     * @param contact 实例对象
     * @return 实例对象
     */
    /*
    @Override
    public Contact insert(Contact contact) {
        this.contactDao.insert(contact);
        return contact;
    }

     */

    /**
     * 修改数据
     *
     * @param contact 实例对象
     * @return 实例对象
     */
    /*
    @Override
    public Contact update(Contact contact) {
        this.contactDao.update(contact);
        return this.findContactById(contact.getContactId());
    }

     */

    /**
     * 通过主键删除数据
     *
     * @param contactid 主键
     * @return 是否成功
     */
    /*
    @Override
    public boolean delete(Long contactid) {
        return this.contactDao.deleteByContactId(contactid) > 0;
    }

     */

}
