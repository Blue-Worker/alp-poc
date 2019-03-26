package com.alp.poc.tms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alp.poc.tms.Application;
import com.alp.poc.tms.data.DeliveryOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DeliveryOrdedrController {
	
	private static final Logger logger = LoggerFactory.getLogger( Application.class );
	
	
	@PostMapping("/api/delivery_orders")
	@ResponseBody
	public DeliveryOrder newOrder( @RequestBody DeliveryOrder order ) {

		printValueAsString( order );
		
		order.setDelNum( "DEL-" + order.getOrderNum() );

		logger.info( "Created: " + order.getDelNum() );
		
        return order ;
    }
	
	@PutMapping("/api/delivery_orders/{delNum}")
	@ResponseBody
	public DeliveryOrder updateOrder( @RequestBody DeliveryOrder order, @PathVariable String delNum) {
		
		logger.debug( "Delibvery Num: " + delNum );

		printValueAsString( order );

		logger.info( "Updated: " + order.getDelNum() );
    	
        return order ;
    }
	
	@DeleteMapping("/api/delivery_orders/{delNum}")
	@ResponseBody
	public DeliveryOrder deteleOrder( @PathVariable String delNum ) {
		
		logger.info( "Deleted: " + delNum );
		
		DeliveryOrder order = new DeliveryOrder();
    	order.setDelNum( delNum );

    	printValueAsString( order );
    	return order ;
    }
	
	@GetMapping("/api/delivery_orders/{delNum}")
	@ResponseBody
    public DeliveryOrder retriveOrder( @PathVariable String delNum ) {
    	assert( delNum != null );
    	logger.info( "deliveryNumber: " + delNum );
    	
    	DeliveryOrder order = new DeliveryOrder();
    	order.setDelNum( delNum );
    	order.setAddr( "ADDR-" + delNum );
    	
    	printValueAsString( order );
        return order ;
    }
	
	
	private ObjectMapper objMapper = new ObjectMapper();
	
	private void printValueAsString( Object obj ) {
    	try {
			logger.debug( "Order: " + objMapper.writeValueAsString( obj ) );
		
    	} catch (JsonProcessingException e) {
			logger.error( "", e );
			
		}		
	}	
}