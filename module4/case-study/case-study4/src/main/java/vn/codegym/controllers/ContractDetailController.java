package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Contract;
import vn.codegym.model.ContractDetail;
import vn.codegym.service.*;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    AttachServiceService attachServiceService;
    @Autowired
    ContractService contractService;
    @Autowired
    ContractDetailService contractDetailService;

    @GetMapping
    public String pageContract(Model model, @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contractDetailList", contractDetailService.getAll(pageable));
        model.addAttribute("contracts", contractService.findAll());
        model.addAttribute("attachServices", attachServiceService.findAll());
        return "contract/contract_detail/list-contractDetail";
    }

    @PostMapping("/")
    public String addNewContract(ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        return "redirect:/contractDetail";
    }

    @PostMapping("/addNew")
    public String addNewContractDetail(@Validated @ModelAttribute("contractDetail")ContractDetail contractDetail, BindingResult bindingResult, @PageableDefault(value = 5) Pageable pageable, Model model){
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("contractDetailList", contractDetailService.getAll(pageable));
            model.addAttribute("contracts", contractService.findAll());
            model.addAttribute("attachServices", attachServiceService.findAll());
            return "contract/contract_detail/list-contractDetail";
        }if(!contractDetailService.checkId(contractDetail.getContractDetailId())){
            model.addAttribute("contractDetail_id","duplicate contract Detail codes");
            model.addAttribute("contractDetailList", contractDetailService.getAll(pageable));
            model.addAttribute("contracts", contractService.findAll());
            model.addAttribute("attachServices", attachServiceService.findAll());
            return "contract/contract_detail/list-contractDetail";
        } else {
            contractDetailService.save(contractDetail);
            return "redirect:/contractDetail";
        }
    }


    @GetMapping("/deleteConfirm/{id}")
    public String deleteConfirm(@PathVariable String id) {
        contractService.delete(id);
        return "redirect:/contractDetail";
    }
}
