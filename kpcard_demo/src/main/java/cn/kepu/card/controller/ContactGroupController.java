package cn.kepu.card.controller;

import cn.kepu.card.bean.ContactGroup;
import cn.kepu.card.service.ContactGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ContactGroupController {
    @Resource
    ContactGroupService contactGroupService;
    @RequestMapping("/contactgroup/list")
    public String contactGroupList(Model model) {
        System.out.println("jump into!");
        //要从session中获得用户UID
        Integer uId = 1;
        List<ContactGroup> list = contactGroupService.getUserGroups(uId);
        System.out.println(list.size());
        return "sss";
    }

    @RequestMapping("/contactgroup/test1")
    public  String test1(Model model){
        System.out.println("test1");
        Integer groupId=2;
        ContactGroup contactGroup=contactGroupService.getUserGroup(groupId);
        System.out.println(contactGroup.getGname());
        return "dddd";
    }

    @RequestMapping("/contactgroup/test2")
    public  String test2(Model model){
        System.out.println("test2");
        Integer uId = 1;
        Integer groupId=2;
        boolean contactGroup=contactGroupService.removeUserGroup(uId,groupId);
        System.out.println(contactGroup);
        return "dddd";
    }

    @RequestMapping("/contactgroup/test3")
    public  String test3(Model model){
        System.out.println("test3");
        Integer uId = 14;
        String groupId="w";
        boolean contactGroup=contactGroupService.addGroup2Contact(uId,groupId);
        System.out.println(contactGroup);
        groupId=groupId+"ddf";
        contactGroup=contactGroupService.changeGroupOfContact(uId,groupId);
        return "dddd";
    }
}
