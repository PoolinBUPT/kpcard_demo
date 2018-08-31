package cn.kepu.card.service;

import cn.kepu.card.bean.Blessing;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface BlessingService {
    public List<Blessing> getBlessingList();

    public Blessing findBlessingByBid(Integer bid);

    public void save(Blessing blessing);

    public void edit(Blessing blessing);

    @Transactional
    public void delete(Integer bid);
}
