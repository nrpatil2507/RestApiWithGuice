package com.axelor.service;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.axelor.module.ContactModule;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class ServiceContextListener extends GuiceResteasyBootstrapServletContextListener {

	@Override
	protected List<Module> getModules(ServletContext context) {
		return Arrays.asList((Module) new JpaPersistModule("pu"), new ContactModule());
	}

	@Override
	public void withInjector(Injector injector) {
		injector.getInstance(PersistService.class).start();
	}
}
