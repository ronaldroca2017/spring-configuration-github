package org.configuration.spring.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.configuration.spring.web.model.Category;
import org.configuration.spring.web.model.Product;
import org.configuration.spring.web.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Ronald Roca
 * 
	 * Podemos obtener los parametros enviados desde el JSP en el controller podemos usar:
	 * 
	 * - HttpServletRequest request					--> public ModelAndView buscarProducto(HttpServletRequest request){...}
	 * - @RequestParam("name") String parametro   	--> @RequestMapping(value = "/buscarProducto.htm" ,  method= RequestMethod.POST)
	 * - @PathVariable("idProf") String id   		--> @RequestMapping(value = "/detalleProfesor/{idProf}", method = RequestMethod.GET)
	 * - @ModelAttribute("objeto") Objeto objeto	..> public ModelAndView buscarProducto(@ModelAttribute("objeto") Objeto objeto){...}
 */

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
	
	@RequestMapping(value = "/buscarProducto.htm" ,  method= RequestMethod.POST)
	public ModelAndView buscarProducto(@RequestParam("name") String parametro){
		logger.info("ProductoController -->  buscarProducto() ");
		List<Product>  lstProduct = productoService.findAllFirstName(parametro);
		
		ModelAndView mav = new ModelAndView();	
		mav.addObject("lstProduct", lstProduct);
		mav.setViewName("producto_listado");	
		return mav;
	}
	
	@RequestMapping("/insertProducto.htm")
	public ModelAndView insertProducto(@ModelAttribute("product") Product product){
		logger.info("ProductoController -->  insertProducto(@ModelAttribute(product) Product product) ");
		
		ModelAndView mav = new ModelAndView();
		product.setDistribution("Interior");
		mav.addObject("product", product);
		mav.setViewName("producto_insertar");
		return mav;
	}
	
	@RequestMapping("/saveProducto.htm")
	public String saveProducto(@ModelAttribute("product") Product product){
		logger.info("ProductoController -->  saveProducto(@ModelAttribute(product) Product product) ");
		product.setActive((product.isCheckBoxActive())?"A":"I");
		productoService.saveProducto(product);
		return "redirect:listaProducto.htm";
	}
	
	
	@RequestMapping("/eliminarProducto.htm")
	public String eliminarProducto(@RequestParam(value = "id", required = true) Integer idProducto ){
		logger.info("El id del producto a eliminar es : " + idProducto);
		Product product = productoService.getProductById(idProducto);
		product.setActive("I");
		productoService.deleteProducto(product);
		
		return "redirect:listaProducto.htm";
	}
					  

	@RequestMapping(value = "/actualizarProductoPopup.htm", method = RequestMethod.GET)
	public ModelAndView actualizarProductoPopup(
							@RequestParam("id") Integer idProducto){
		logger.info("ProductoController -->  actualizarProductoPopup(@ModelAttribute(product) Product product),@RequestParam(value = 'id', required = true) Integer idProducto) ");
		logger.info("El id del producto a actualizar  es : " + idProducto);
		Product product = productoService.getProductById(idProducto);
		logger.info("Producto obtenido -> " + product.toString());
		ModelAndView mav = new ModelAndView();
		mav.addObject("product",product);
		mav.setViewName("producto_actualizar");
		return mav;
	}
	
	@RequestMapping("/updateProducto.htm")
	public String updateProducto(@ModelAttribute("product") Product product){
		logger.info("ProductoController -->  updateProducto(@ModelAttribute(product) Product product) ");
		
		logger.info("" + product.isCheckBoxActive());
		logger.info("" + product.toString());
		
		if(product.isCheckBoxActive()){
			product.setActive("A");
		}else{
			product.setActive("I");
		}
		
		productoService.updateProducto(product);
		return "redirect:listaProducto.htm";
	}
	
	@ModelAttribute("categoriesTypes")
	public List<Category> getCategories(){
		return productoService.getCategories();
	}
	
	@ModelAttribute("nivelProduct")
	 public List<String> populateNivelProduct() {
	   
	  //Data referencing for number radiobuttons
	  List<String> numberList = new ArrayList<String>();
	  numberList.add("Malo");
	  numberList.add("Regular");
	  numberList.add("Bueno");
	  numberList.add("Excelente");

	   
	  return numberList;
	 }
	

}
