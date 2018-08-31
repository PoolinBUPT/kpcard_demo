package cn.kepu.card.dao;

import cn.kepu.card.bean.ContactGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactGroupRepository extends JpaRepository<ContactGroup,Long> {
    ContactGroup findByGid(Integer gid);
}
