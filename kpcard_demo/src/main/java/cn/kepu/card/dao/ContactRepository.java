package cn.kepu.card.dao;

import cn.kepu.card.bean.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    Contact findById(Integer id);
    Long deleteById(Integer id);

    //@Query(value = "SELECT * FROM kpcard.tb_contact where cuser = ?1 and concat(contemail,contemail) like '%?2%'",nativeQuery = true)
    @Query(value = "SELECT c FROM Contact as c where c.cuser = ?1 and concat(c.contemail,c.contemail,c.callname) like %?2% and c.groups like %?3%")
    Page<Contact> getContactOnGroupAndKeyWords(Integer userId, String keyWords, String group, Pageable pageable);

    @Query(value = "SELECT c FROM Contact as c where c.cuser = ?1 and concat(c.contemail,c.contemail,c.callname) like %?2% and c.groups like %?3%")
    List<Contact> getContactOnGroupAndKeyWordsList(Integer userId, String keyWords, String group);

    @Modifying
    @Query(value = "UPDATE Contact c set c.contname=?1,c.contemail=?2,c.callname=?3, c.phone=?4 where c.id=?5")
    void updateContact(String contname,String contemail,String callname,String phone,Integer id);
}
