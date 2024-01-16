package driver;

import java.util.ArrayList;
import java.util.List;

import dao.ProductCrud;
import dto.Product;

public class ProductDriver {
	public static void main(String[] args) {
		Product product1=new Product();
		product1.setCost(200000);
		product1.setBrand("LENOVO");
		product1.setType("electronic");
		product1.setId(14);
		product1.setName("LAPTOP");
		
		Product product2=new Product();
		product2.setCost(10000);
		product2.setBrand("DELL");
		product2.setType("electronic");
		product2.setId(13);
		product2.setName("LAPTOP");
		
		Product product3=new Product();
		product3.setCost(30000);
		product3.setBrand("HP");
		product3.setType("electronic");
		product3.setId(12);
		product3.setName("LAPTOP");
		ProductCrud productCrud=new ProductCrud();
		//productCrud.saveProduct(product);
		//productCrud.getAllProduct() ;
		//productCrud.getProductById(11);
		//productCrud.deleteProductById(2);
		//productCrud.update(product);
		List<Product> list=new ArrayList();
		list.add(product1);
		list.add(product2);
		list.add(product3);
		productCrud.batchOfProduct(list);
	}	

}
