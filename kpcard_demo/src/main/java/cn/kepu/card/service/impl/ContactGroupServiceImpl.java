package cn.kepu.card.service.impl;

import cn.kepu.card.bean.Contact;
import cn.kepu.card.bean.ContactGroup;
import cn.kepu.card.dao.ContactGroupRepository;
import cn.kepu.card.service.ContactGroupService;
import cn.kepu.card.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ContactGroupServiceImpl implements ContactGroupService {

    @Autowired
    ContactGroupRepository contactGroupRepository;
    @Resource
    ContactService contactService;

    @Override
    public List<ContactGroup> getUserGroups(Integer userId){
        ContactGroup contactGroup = new ContactGroup();
        contactGroup.setGuser(userId);
        Example<ContactGroup> example= Example.of(contactGroup);
        List<ContactGroup> list = contactGroupRepository.findAll(example);
        return list;
    }

    @Override
    public ContactGroup getUserGroup(Integer groupId){return contactGroupRepository.findByGid(groupId);}
    @Override
    public boolean removeUserGroup(Integer userId, Integer groupId){
        ContactGroup contactGroup = getUserGroup(groupId);
        if(contactGroup != null && contactGroup.getGuser().equals(userId)){
            List<Contact> list=contactService.getContactsOnIdAndName(userId,contactGroup.getGname());
            if(list!=null&&!list.isEmpty()){
                System.out.println("get");
            }
        }
        System.out.println("none");
        return false;
    }
    public boolean addGroup2Contact(Integer contactId, String groupName){
        Contact contact = contactService.findContactById(contactId);
        if(contact==null) {return false;}
        //contact.getGroups()必须不为零才可以
        if(contact.getGroups().indexOf("$"+groupName+"$")>=0) {return true;}
        contact.setGroups(contact.getGroups()+"$"+groupName+"$");
        contactService.save(contact);
        return true;
    }
    public boolean changeGroupOfContact(Integer contactId, String groupName){
        Contact contact = contactService.findContactById(contactId);
        if(contact==null) {return false;}
        contact.setGroups("$"+groupName+"$");
        contactService.save(contact);
        return true;
    }
}
