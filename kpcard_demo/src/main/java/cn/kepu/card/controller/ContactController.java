package cn.kepu.card.controller;


import cn.kepu.card.bean.Contact;
import cn.kepu.card.service.ContactService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Resource
    ContactService contactService;

    @RequestMapping("/list")
    public String contactList(Model model){
        System.out.println("jump into!");
        List<Contact> contacts=contactService.getContactList();
        model.addAttribute("contacts",contacts);
//        System.out.println(contacts.toString());
        return "contact/list";
    }

//    @RequestMapping("/contact/listPage")
//    public String contactListPage(Model model,
//                                  @RequestParam("page") Integer page){
//        Page<Contact> contacts=contactService
//    }

    @RequestMapping("/toAdd")
    public String addContact(){
        return "contact/contactAdd";
    }
    @RequestMapping("/add")
    public String addContact(Contact contact, Model model){
        //假设能够获取session中当前用户的UID
        Integer userId=1;
        contact.setCuser(userId);
        contact.setGroups("$默认分组$");
        contactService.save(contact);
        Page<Contact> contacts = contactService.getContactOnGroupAndKeyWords(userId, "",-1,0,10);
        model.addAttribute("contacts",contacts);
        model.addAttribute("group",-1);
        model.addAttribute("page",0);
        //System.out.println(contacts);
        return "contact/listPage";
    }
    @RequestMapping("/toEdit")
    public String editContact(Model model,
                              @RequestParam("id")Integer id){
        Contact contact=contactService.findContactById(id);
        model.addAttribute("contacts",contact);
        return "contact/contactEdit";
    }
    @RequestMapping("/edit")
    public String editContact(Contact contact, Integer id,Model model){
        //from session
        Integer userId=1;
        Contact dbcontact=contactService.findContactById(id);
        contact.setId(dbcontact.getId());
        contact.setCuser(dbcontact.getCuser());
        contact.setGroups(dbcontact.getGroups());
        if(contact!=null && userId.equals(contact.getCuser())) {
            contactService.edit(contact, id);
        }
        Page<Contact> contacts = contactService.getContactOnGroupAndKeyWords(userId, "",-1,0,10);
        model.addAttribute("contacts",contacts);
        model.addAttribute("group",-1);
        model.addAttribute("page",0);
        //System.out.println(contacts);
        return "contact/listPage";
    }
    @RequestMapping("/sortPage")
    public String sortedPage(Model model,
                             @RequestParam("group") Integer groupId,
                             @RequestParam("keyWords") String keyWords,
                             @RequestParam("page") Integer page){
        //假装得到userId
        Integer userId=1;
        Page<Contact> contacts = contactService.getContactOnGroupAndKeyWords(userId, keyWords,groupId,page,10);
        model.addAttribute("contacts",contacts);
        model.addAttribute("group",groupId);
        model.addAttribute("keyWords", keyWords);
        model.addAttribute("page",page);
        return "contact/listPage";
    }

    @RequestMapping("/dele")
    public String delContact(Model model,
                             @RequestParam("group") Integer groupId,
                             @RequestParam("keyWords") String keyWords,
                             @RequestParam("page") Integer page,
                             @RequestParam("contactId") Integer cId){
        //假装得到userId
        Integer userId=1;
        Contact contact=contactService.findContactById(cId);
        if(contact!=null && userId.equals(contact.getCuser())){
            contactService.delete(contact);
        }
        Page<Contact> contacts = contactService.getContactOnGroupAndKeyWords(userId, keyWords,groupId,page,10);
        model.addAttribute("contacts",contacts);
        model.addAttribute("group",groupId);
        model.addAttribute("keyWords", keyWords);
        model.addAttribute("page",page);
        return "contact/listPage";
    }
}
