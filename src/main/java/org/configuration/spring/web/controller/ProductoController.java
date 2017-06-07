package org.configuration.spring.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.configuration.spring.web.model.Product;
import org.configuration.spring.web.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductoController {

	final static Logger logger = Logger.getLogger(ProductoController.class);
	
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("/listaProducto2.htm")
	public ModelAndView listarProducto2(){
		logger.info("Estamos en listarProducto.htm");
		ModelAndView mav = new ModelAndView();
		
		
		List<Product>  lstProduct = productoService.findAllProducts();
		mav.addObject("parametro", "parametro enviado desde el controller");
		mav.addObject("lstProduct", lstProduct);
		mav.setViewName("producto2");
		logger.info("Producto size : " + lstProduct.size());
		for(Product c : lstProduct){
			logger.info("Los productos enviadas a la vista son : "+ c.getId_product() + " - " + c.getName());
		}
		
		return mav;
	}
	
}
