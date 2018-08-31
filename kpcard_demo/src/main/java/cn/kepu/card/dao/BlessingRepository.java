package cn.kepu.card.dao;

import cn.kepu.card.bean.Blessing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlessingRepository extends JpaRepository<Blessing, Integer> {
    Blessing findByBid(Integer bid);
    Integer deleteByBid(Integer bid);
}
