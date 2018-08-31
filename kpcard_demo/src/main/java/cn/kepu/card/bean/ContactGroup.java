package cn.kepu.card.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_contactgroup")
public class ContactGroup {

    @Id
    @GeneratedValue
    private Integer gid;
    @Column
    private Integer guser;
    @Column
    private String gname;
    @Column
    private String discribe;
    @Transient
    private List<Contact> contacts;

    // Constructors

    /** default constructor */
    public ContactGroup() {
    }

    /** minimal constructor */
    public ContactGroup(Integer guser, String gname) {
        this.guser = guser;
        this.gname = gname;
    }

    /** full constructor */
    public ContactGroup(Integer guser, String gname, String discribe) {
        this.guser = guser;
        this.gname = gname;
        this.discribe = discribe;
    }

    // Property accessors

    public Integer getGid() {
        return this.gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getGuser() {
        return this.guser;
    }

    public void setGuser(Integer guser) {
        this.guser = guser;
    }

    public String getGname() {
        return this.gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getDiscribe() {
        return this.discribe;
    }

    public void setDiscribe(String discribe) {
        this.discribe = discribe;
    }

    public List<Contact> getContacts() {
        //if (this.contacts == null) return new ArrayList<Contact> ();
        return this.contacts;
    }
    public void setContacts(List<Contact> contacts) {
        this.contacts = new ArrayList<Contact>();
        if (contacts == null) return;

        for (Contact contact : contacts) {
            if (contact.getGroups()!=null&&!"".equals(contact.getGroups().trim())
                    && contact.getGroups().contains("$"+this.gname+"$")) {
                this.contacts.add(contact);
            }
        }
    }
}
