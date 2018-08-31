package cn.kepu.card.service.impl;

import cn.kepu.card.bean.Blessing;
import cn.kepu.card.dao.BlessingRepository;
import cn.kepu.card.service.BlessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlessingServiceImpl implements BlessingService {

    @Autowired
    private BlessingRepository blessingRepository;

    @Override
    public List<Blessing> getBlessingList() {
        return blessingRepository.findAll();
    }

    @Override
    public Blessing findBlessingByBid(Integer bid) {
        return blessingRepository.findByBid(bid);
    }

    @Override
    public void save(Blessing blessing) {
        blessingRepository.save(blessing);
    }

    @Override
    public void edit(Blessing blessing) {
        blessingRepository.save(blessing);
    }

    @Transactional
    @Override
    public void delete(Integer bid) {
        blessingRepository.deleteByBid(bid);
    }
}
