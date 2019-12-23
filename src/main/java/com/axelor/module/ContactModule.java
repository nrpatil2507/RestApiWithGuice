package com.axelor.module;

import com.axelor.service.PersonImpl;
import com.axelor.service.PersonService;
import com.axelor.serviceconfig.MyWebService;
import com.google.inject.Binder;
import com.google.inject.Module;

public class ContactModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(MyWebService.class);
		binder.bind(PersonService.class).to(PersonImpl.class);
	}

}
