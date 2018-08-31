package cn.kepu.card.controller;

import cn.kepu.card.bean.Blessing;
import cn.kepu.card.dao.BlessingRepository;
import cn.kepu.card.service.BlessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AdminBlessingController {

    @Resource
    BlessingService blessingService;

    @Autowired
    BlessingRepository blessingRepository;

    @RequestMapping("/")
    public String index(){
        return "redirect:/list";
    }

    @RequestMapping(value = "/list")
    public String list(Model model){
        List<Blessing> blessingList = blessingService.getBlessingList();
        model.addAttribute("blessings", blessingList);
        return "blessing/list";
    }

    @GetMapping(value = "/listByPage")
    public String listByPage(Model model,
                             @RequestParam(value = "start", defaultValue = "0")int start,
                             @RequestParam(value = "size", defaultValue = "5")int size) throws Exception{
        start = start < 0 ? 0: start;
        Sort sort = new Sort(Sort.Direction.DESC, "bid");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Blessing> page = blessingRepository.findAll(pageable);
        model.addAttribute("page", page);
        return "blessing/listByPage";
    }

//    @RequestMapping("/addBlessing")
//    public String addBlessing(){
//        return "blessing/addBlessing";
//    }
//
//    @RequestMapping("/add")
//    public String add(Blessing blessing){
//        blessingService.save(blessing);
//        return "redirect:/list";
//    }

    @GetMapping("/addBlessing")
    public String addBlessingForm(Model model){
        model.addAttribute("blessing", new Blessing());
        return "blessing/addBlessing";
    }

    /**
     * 添加祝福语
     * @param blessing
     * @param bindingResult 如果不写，必须按照数据库保存的顺序来存，非常的坑，找了4小时的bug
     * @return
     */
    @PostMapping("/addBlessing")
    public String addBlessingSubmit(@ModelAttribute Blessing blessing, BindingResult bindingResult){
        Blessing newBlessing = new Blessing();
        newBlessing.setBid(blessing.getBid());
        newBlessing.setBuser(blessing.getBuser());
        newBlessing.setBtype(blessing.getBtype());
        newBlessing.setSysflag(blessing.getSysflag());
        newBlessing.setBlessing(blessing.getBlessing());
        newBlessing.setCreatetime(blessing.getCreatetime());
        blessingService.save(newBlessing);

        return "redirect:/list";
    }

    @RequestMapping("/editBlessing")
    public String editBlessing(Model model, Integer bid){
        Blessing blessing = blessingService.findBlessingByBid(bid);
        model.addAttribute("blessing", blessing);
        return "blessing/editBlessing";
    }

    @RequestMapping("/edit")
    public String edit(Blessing blessing, BindingResult bindingResult){
        blessingService.edit(blessing);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(Integer bid){
        blessingService.delete(bid);
        return "redirect:/list";
    }
}
