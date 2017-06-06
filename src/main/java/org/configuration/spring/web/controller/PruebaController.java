package org.configuration.spring.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.configuration.spring.web.model.Category;
import org.configuration.spring.web.service.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PruebaController {
	final static Logger logger = Logger.getLogger(PruebaController.class);
	
	@Autowired
	PruebaService pruebaService;
	
	@RequestMapping("/inicio.htm")
	public void inicio() {
		logger.info("Estamos en inicio.htm");
	}
	
	@RequestMapping("/inicio2.htm")
	public ModelAndView inicio2(){
		logger.info("Estamos en inicio2.htm");

		return new ModelAndView("inicio");
	}
	
	@RequestMapping("/inicio3.htm")
	public ModelAndView inicio3(){
		logger.info("Estamos en inicio3.htm");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inicio");
		return mav;
	}

	@RequestMapping("/listaProducto.htm")
	public ModelAndView listarProducto(){
		logger.info("Estamos en listarProducto.htm");
		ModelAndView mav = new ModelAndView();
		
		
		List<Category>  lstCategory = pruebaService.findAllCategory();
		mav.addObject("parametro", "parametro enviado desde el controller");
		mav.addObject("categories", lstCategory);
		mav.setViewName("producto");
		logger.info("categorias size : " + lstCategory);
		for(Category c : lstCategory){
			logger.info("Lascategorias enviadas a la vista son : "+ c.getId_Category() + " - " + c.getName());
		}
		
		return mav;
	}

}
