package cn.kepu.card.service;

import cn.kepu.card.bean.Contact;
import cn.kepu.card.bean.ContactGroup;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContactService {
    public List<Contact> getContactList();
    public Contact findContactById(Integer id);
    public void save(Contact contact);
    public void edit(Contact contact,Integer id);
    public void delete(Contact contact);
    public Page<Contact> getContactCriteria(Integer page, Integer size);

    //根据用户ID和用户组名称查询
    public List<Contact> getContactsOnIdAndName(Integer userId, String groupName);

    public Page<Contact> getContactOnGroupAndKeyWords(Integer userId, String keyWords,Integer groupId, Integer page, Integer size);

    public List<Contact> getContactOnGroupAndKeyWordsList(Integer userId, String keyWords,Integer groupId);




}
