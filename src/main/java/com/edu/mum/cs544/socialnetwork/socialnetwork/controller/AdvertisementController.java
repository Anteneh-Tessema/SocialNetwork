package com.edu.mum.cs544.socialnetwork.socialnetwork.controller;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Advertisement;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl.AdvertisementService;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AdvertisementController {

    @Autowired
  AdvertisementService advertisementService;

    @Autowired

     RoleService roleService;

    @GetMapping(value = {"/adv/list"})
    public ModelAndView list() {
        ModelAndView mav= new ModelAndView();
        mav.addObject("advertisement",advertisementService.getAllAdvertisementList());
        mav.setViewName("adv/list");
        return mav;
    }

    @GetMapping(value = {"/adv/new"})
    public String displayNewAdvertForm(Model model) {
        Advertisement advertisement= new Advertisement();
       model.addAttribute("advertisement",advertisement);
        return "adv/new";
    }

    @PostMapping(value = "/adv/new")
    public String addNewAdvert(@Valid @ModelAttribute("advertisement") Advertisement advertisement,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "adv/new";
        }
        advertisement = advertisementService.saveAdvertisement(advertisement);
        return "redirect:/adv/list";
    }


    //###########################################################################################################
    @GetMapping(value = {"/adv/edit/{id}"})
    public String editAdvert(@PathVariable Long id, Model model) {
        Advertisement advertisement = advertisementService.getAdvertisementById(id);
        if (advertisement != null) {
            model.addAttribute("advertisement", advertisement);
            return "adv/edit";
        }
        return "adv/list";
    }

    @PostMapping(value = {"/adv/edit"})
    public String UpdateAdvert(@Valid @ModelAttribute("advert") Advertisement advert,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "adv/edit";
        }
        advert = advertisementService.saveAdvertisement(advert);
        return "redirect:/adv/list";
    }



    @GetMapping(value = {"/adv/delete/{id}"})
    public String deleteAdvert(@PathVariable Long id, Model model) {
        advertisementService.deleteAdvertisementById(id);
        return "redirect:/adv/list";
    }


}
