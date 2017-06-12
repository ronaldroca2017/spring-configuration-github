package org.configuration.spring.web.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping("/listaProducto.htm")
	public ModelAndView listarProducto(){
		logger.info("ProductoController -->  listarProducto() ");
		
		List<Product>  lstProduct = productoService.findAllProducts();
		
		ModelAndView mav = new ModelAndView();	
		mav.addObject("parametro", "parametro enviado desde el controller");
		mav.addObject("lstProduct", lstProduct);
		mav.setViewName("producto_listado");
		
		return mav;
	}
	
	
	@RequestMapping("/buscarProducto.htm")
	public ModelAndView buscarProducto(HttpServletRequest request){
		logger.info("ProductoController -->  buscarProducto() ");
		
		String parametroBusqueda = request.getParameter("name");
		logger.info("parametro obtenido :  " + parametroBusqueda);
		List<Product>  lstProduct = productoService.findAllFirstName(parametroBusqueda);
		
		ModelAndView mav = new ModelAndView();	
		mav.addObject("lstProduct", lstProduct);
		mav.setViewName("producto_listado");
		
		return mav;
	}
	
}
