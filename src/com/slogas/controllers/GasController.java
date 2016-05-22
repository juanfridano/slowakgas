package com.slogas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.slogas.model.GasEntity;
import com.slogas.service.GasService;

@Controller
public class GasController {

private GasService gasService;
	
	@Autowired
	public void setGasService(GasService gasService) {
		this.gasService = gasService;
	}
	
	@RequestMapping(value="/getOne", method=RequestMethod.POST)
	public String showData(Model model, String date) throws InterruptedException {
		
		GasEntity importedBean = gasService.getCurrent(date);
		
		String caption = gasService.getCaption();
	
		model.addAttribute("importedBean", importedBean);
		model.addAttribute("caption", caption);
		
		return "one";
	}
	
	@RequestMapping(value="/getPeriod", method=RequestMethod.POST)
	public String showPeriod(Model model, String startDate, String endDate) throws InterruptedException {
		
		List<GasEntity> beanSet = gasService.getList(startDate, endDate);
		
		String caption = gasService.getCaption();
	
		model.addAttribute("beanSet", beanSet);
		model.addAttribute("caption", caption);
		
		return "many";
	}
	
	@RequestMapping(value="/getTen", method=RequestMethod.POST)
	public String showTen(Model model) throws InterruptedException {
		
		List<GasEntity> beanSet = gasService.getTen();
				
		String caption = gasService.getCaption();
	
		model.addAttribute("beanSet", beanSet);
		model.addAttribute("caption", caption);
		
		return "many";
	}
	
	@RequestMapping(value="/retriever", method=RequestMethod.POST)
	public String showRet(Model model, String startDate, String endDate) throws InterruptedException {
		
		List<GasEntity> beanSet = gasService.getRet(startDate, endDate);
		model.addAttribute("beanSet", beanSet);
		
		return "retrieve";
	}
	
}
