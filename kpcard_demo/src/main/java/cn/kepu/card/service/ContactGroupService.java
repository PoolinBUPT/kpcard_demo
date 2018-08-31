package cn.kepu.card.service;

import cn.kepu.card.bean.ContactGroup;

import java.util.List;

public interface ContactGroupService {
    public List<ContactGroup> getUserGroups(Integer userId);
    public ContactGroup getUserGroup(Integer groupId);
    public boolean removeUserGroup(Integer userId, Integer groupId);
    public boolean addGroup2Contact(Integer contactId, String groupName);
    public boolean changeGroupOfContact(Integer contactId, String groupName);
}
