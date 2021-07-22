package com.roncoo.eshop.price.mapper;

import org.apache.ibatis.annotations.*;

import com.roncoo.eshop.price.model.ProductPrice;

@Mapper
public interface ProductPriceMapper {
	
	@Insert("INSERT INTO product_price(value,product_id) VALUES(#{value},#{productId})")  
	public void add(ProductPrice productPrice);
	
	@Update("UPDATE product_price SET value=#{value},product_id=#{productId} WHERE id=#{id}")  
	public void update(ProductPrice productPrice);
	
	@Delete("DELETE FROM product_price WHERE id=#{id}")  
	public void delete(Long id);
	
	@Select("SELECT * FROM product_price WHERE id=#{id}")
	@Results({
			@Result(column = "product_id", property = "productId")
	})
	public ProductPrice findById(Long id);
	
	@Select("SELECT * FROM product_price WHERE product_id=#{productId}")
	@Results({
			@Result(column = "product_id", property = "productId")
	})
	public ProductPrice findByProductId(Long productId);
	
}
