package cn.kepu.card.bean;

import javax.persistence.*;

@Entity
@Table(name="tb_contact")
public class Contact {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private Integer cuser;
    @Column
    private String contname;
    @Column
    private String callname;
    @Column
    private String contemail;
    @Column
    private String phone;
    @Column
    private String groups;

    // Constructors

    /** default constructor */
    public Contact() {
    }

    /** minimal constructor */
    public Contact(Integer cuser, String contname, String contemail) {
        this.cuser = cuser;
        this.contname = contname;
        this.contemail = contemail;
    }

    /** full constructor */
    public Contact(Integer cuser, String contname, String callname,
                   String contemail, String phone, String groups) {
        this.cuser = cuser;
        this.contname = contname;
        this.callname = callname;
        this.contemail = contemail;
        this.phone = phone;
        this.groups = groups;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCuser() {
        return this.cuser;
    }

    public void setCuser(Integer cuser) {
        this.cuser = cuser;
    }

    public String getContname() {
        return this.contname;
    }

    public void setContname(String contname) {
        this.contname = contname;
    }

    public String getCallname() {
        return this.callname;
    }

    public void setCallname(String callname) {
        this.callname = callname;
    }

    public String getContemail() {
        return this.contemail;
    }

    public void setContemail(String contemail) {
        this.contemail = contemail;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroups() {
        return this.groups;
    }

    public String getWebGroups() {
        String webGroups = this.groups.replace("$$", ",");
        return webGroups.replace("$", "");
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }
}
