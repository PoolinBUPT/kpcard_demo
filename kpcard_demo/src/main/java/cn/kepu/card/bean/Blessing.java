package cn.kepu.card.bean;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tb_blessing")
@Entity
public class Blessing {

    @Id
    @GeneratedValue
    @Column(name = "bid", unique = true, nullable = false, length = 8)
    private Integer bid;

    @Column(name = "buser", unique = true, length = 8)
    private Integer buser;

    @Column(name = "btype", length = 4)
    private Integer btype;

    @Column(name = "sysflag", length = 4)
    private Integer sysflag;

    @Column(name = "createtime", length = 19)
    private Date createtime;

    @Column(name = "blessing", length = 500)
    private String blessing;

    public Blessing(){}

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getBuser() {
        return buser;
    }

    public void setBuser(Integer buser) {
        this.buser = buser;
    }

    public Integer getBtype() {
        return btype;
    }

    public void setBtype(Integer btype) {
        this.btype = btype;
    }

    public Integer getSysflag() {
        return sysflag;
    }

    public void setSysflag(Integer sysflag) {
        this.sysflag = sysflag;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getBlessing() {
        return blessing;
    }

    public void setBlessing(String blessing) {
        this.blessing = blessing;
    }
}
