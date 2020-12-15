package tk.mybatis.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.sample.model.SysDict;
import tk.mybatis.sample.service.DictService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/dicts")
public class DictController {

    @Autowired
    DictService dictService;

    // 显示数据字典列表
    @RequestMapping
    public ModelAndView dicts(SysDict sysDict, Integer offset, Integer limit) {
        ModelAndView mv = new ModelAndView("dicts");
        List<SysDict> dictList = dictService.findBySysDict(sysDict, offset, limit);
        mv.addObject("dicts", dictList);
        return mv;
    }

    // 调转到新增或修改表单
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(Long id) {

        ModelAndView mv = new ModelAndView("dict_add");
        SysDict sysDict;
        if (id == null) {
            sysDict = new SysDict();
        } else {
            sysDict = dictService.findById(id);
        }
        mv.addObject("model", sysDict);
        return mv;
    }

    // 提交更细或新增表单数据
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView save(SysDict sysDict) {
        ModelAndView mv = new ModelAndView();
        try {
            dictService.saveOrUpdate(sysDict);
            mv.setViewName("redirect:/dicts");
        } catch (Exception e) {
            mv.setViewName("dict_add");
            mv.addObject("msg", e.getMessage());
            mv.addObject("model", sysDict);
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelMap delete(@RequestParam Long id) {
        ModelMap modelMap = new ModelMap();
        try {
            boolean success = dictService.deleteById(id);
            modelMap.put("success", success);
        } catch(Exception e){
            modelMap.put("success",false);
            modelMap.put("msg",e.getMessage());
        }
        return modelMap;
    }
}
