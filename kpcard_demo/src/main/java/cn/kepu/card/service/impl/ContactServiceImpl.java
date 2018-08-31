package cn.kepu.card.service.impl;

import cn.kepu.card.bean.Contact;
import cn.kepu.card.dao.ContactRepository;
import cn.kepu.card.service.ContactGroupService;
import cn.kepu.card.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional //没有会报错 JPA No EntityManager with actual transaction available for current thread
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;
    @Resource
    ContactGroupService contactGroupService;

    @Override
    public List<Contact> getContactList(){ return contactRepository.findAll();}

    @Override
    public Contact findContactById(Integer id) {return contactRepository.findById(id);}

    @Override
    public void save(Contact contact){ contactRepository.save(contact);}

    @Override
    public void edit(Contact contact,Integer id){
        contactRepository.updateContact(contact.getContname(),contact.getContemail(),contact.getCallname(),contact.getPhone(),id);
    }

    @Override
    public void delete(Contact contact){contactRepository.delete(contact);}

    @Override
    public Page<Contact> getContactCriteria(Integer page, Integer size){
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC,"rid");
        return contactRepository.findAll(pageable);
    }

    @Override
    public List<Contact> getContactsOnIdAndName(Integer userId, String groupName){
        Contact contact = new Contact();
        contact.setCuser(userId);
        contact.setGroups(groupName);
        ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("groups", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Contact> example =Example.of(contact,matcher);
        List<Contact> list = contactRepository.findAll(example);
        return list;
    }

    @Override
    public Page<Contact> getContactOnGroupAndKeyWords(Integer userId, String keyWords,Integer groupId, Integer page, Integer size){
        //需要重写
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC,"id");
        String group=null;
        if(groupId<-1){group="";}//全部分组
        else if(groupId==-1){group="默认分组";}
        else if(groupId>0){
            group = contactGroupService.getUserGroup(groupId).getGname();
            if(groupId==null){group="默认分组";}
        }
        Page<Contact> pages=contactRepository.getContactOnGroupAndKeyWords(userId,keyWords,group, pageable);
        return pages;
    }

    @Override
    public List<Contact> getContactOnGroupAndKeyWordsList(Integer userId, String keyWords,Integer groupId){
        return contactRepository.getContactOnGroupAndKeyWordsList(userId,keyWords,contactGroupService.getUserGroup(groupId).getGname());
    }

}
