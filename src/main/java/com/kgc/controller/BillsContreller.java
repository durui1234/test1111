package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.BillType;
import com.kgc.entity.Bills;
import com.kgc.service.BillTypeService;
import com.kgc.service.BillsService;
import com.kgc.utils.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class BillsContreller {
    @Autowired
    private BillsService billsService;
    @Autowired
    private BillTypeService billTypeService;

    @RequestMapping(value = "/index")
    public String index(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                        Param param, Model model) {
        PageInfo<Bills> page = billsService.getBillsByPage(pageIndex, pageSize, param);
        List<BillType> list = billTypeService.getBillTypeList();
        model.addAttribute("page", page);
        model.addAttribute("list", list);
        model.addAttribute("param", param);
        return "index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String delete(@PathVariable("id") Integer id) {
        if (billsService.delete(id)) {
            return "<script>alert('删除成功');location.href='/index'</script>";
        } else {
            return "<script>alert('删除成功')history.go(-1)</script>";
        }
    }
    @RequestMapping(value ="/get/{id}",method = RequestMethod.GET,produces ="text/html;charset=UTF-8" )
    public String get(@PathVariable("id") Integer id,Model model){
        Bills bill = billsService.getBillsById(id);
        model.addAttribute("bill",bill);
        return "get";
    }
}
