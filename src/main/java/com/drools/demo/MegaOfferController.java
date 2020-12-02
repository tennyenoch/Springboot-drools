/**
 * 
 */
package com.drools.demo;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tenny
 *
 */
@RestController
public class MegaOfferController {
	
	@Autowired
	private KieSession session;
	
	@PostMapping("/order")
	public Order orderNow(@RequestBody Order order1)
	{
		session.insert(order1);
		session.fireAllRules();
		return order1;
	}

}
