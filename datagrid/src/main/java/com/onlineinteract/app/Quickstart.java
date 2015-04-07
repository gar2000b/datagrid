package com.onlineinteract.app;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

public class Quickstart {

	private Cache<Object, Object> cache;

	public Quickstart() {
		cache = new DefaultCacheManager().getCache();
	}

	public void demoInsertAndRemoveFromCache() {
		System.out.println("*** Inserting key, value");
		cache.put("key", "value");
		
		System.out.println("*** assertions");
		assertEquals(1, cache.size());
		assertTrue(cache.containsKey("key"));
		
		System.out.println("Removing entry from cache");
		Object v = cache.remove("key");
		
		System.out.println("Further assertions that item is removed and cache is empty");
		assertEquals("value", v);
		assertTrue(cache.isEmpty());
	}
	
	public void demoAdjustDataLifeSpan() throws InterruptedException {
		System.out.println("Adjusting the lifespan of the data value to last for 2 secs...");
		cache.put("key", "value", 2, TimeUnit.SECONDS);
		assertTrue(cache.containsKey("key"));
		Thread.sleep(3000);
		assertFalse(cache.containsKey("key"));
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("**Starting cache**");
		Quickstart quickstart = new Quickstart();
		quickstart.demoInsertAndRemoveFromCache();
		quickstart.demoAdjustDataLifeSpan();
		System.out.println("**Finish cache**");

	}
}
