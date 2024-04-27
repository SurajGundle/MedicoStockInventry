package com.medical.RESTFUL.resources;

public interface ProductResource {
	
	public static final String RESOURCE_PATH = "/product";
	
	public static final String ADD_PRODUCT = "/addProduct";
	public static final String GET_PRODUCT_BY_ID = "/getProduct/{productId}";
	public static final String GET_ALL_PRODUCTS = "/getAllProducts";
	public static final String UPDATE_PRODUCT_BY_ID = "/updateProduct/{productId}";
	public static final String DELETE_PRODUCT_BY_ID = "/deleteProduct/{productId}";


}
