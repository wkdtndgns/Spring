package net.skhu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.City;
import net.skhu.dto.District;
import net.skhu.mapper.CityMapper;
import net.skhu.mapper.DistrictMapper;

@Controller
@RequestMapping("/city")
public class CityController {

	static int save=0;
	static String[] orderBy = { "name ASC", "districtName ASC", "population DESC" };

    @Autowired CityMapper cityMapper;
    @Autowired DistrictMapper districtMapper;


    @RequestMapping("list")

    public String list(Model model , @RequestParam(value="order", defaultValue="0") int order) {
    	String s=orderBy[0];
    	if(order==0) {
    		save=0;
    	}
    	else if(order==1) {
    		save=1;
    	}
    	else if(order==2) {
    		save=2;
    	}
    	else {
    		save=save;
    	}
    	s=orderBy[save];

        List<City> citys = cityMapper.findAllOrderBy(s);
        model.addAttribute("citys", citys);
        return "city/list";
    }

    @RequestMapping(value="saveList", method=RequestMethod.GET)
    public String saveList(Model model) {
    	String s=orderBy[0];
    	s=orderBy[save];

        List<City> citys = cityMapper.findAllOrderBy(s);
        model.addAttribute("citys", citys);
        return "city/list";
    }



    @RequestMapping(value="create", method=RequestMethod.GET)
    public String create(Model model) {
        City city = new City();
        List<District> districts = districtMapper.findAll();
        model.addAttribute("city", city);
        model.addAttribute("districts", districts);
        return "city/edit";
    }

    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(Model model, City city) {
        cityMapper.insert(city);
        return "redirect:saveList";
    }

    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(Model model, @RequestParam("id") int id) {
        City city = cityMapper.findOne(id);
        List<District> districts = districtMapper.findAll();
        model.addAttribute("city", city);
        model.addAttribute("districts", districts);
        return "city/edit";
    }

    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(Model model,City city) {
        cityMapper.update(city);
        return "redirect:saveList";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
    	 cityMapper.delete(id);
        return "redirect:saveList";
    }

    @RequestMapping("list3")
    public String List2(Model model) {
        List<District> districts = districtMapper.findAll();
        for (District district : districts) {
            List<City> citys = cityMapper.findByDistrictId(district.getId());
            district.setCitys(citys);
        }
        model.addAttribute("districts", districts);

        return "city/list2";
    }

    @RequestMapping("list2")
    public String List3(Model model) {
        model.addAttribute("districts", districtMapper.findAllWithCitys());
        return "city/list2";
    }

}

