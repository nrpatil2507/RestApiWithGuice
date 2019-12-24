package com.axelor.module;

import com.axelor.service.PersonServiceImpl;
import com.axelor.web.PersonController;
import com.axelor.service.PersonService;
import com.google.inject.Binder;
import com.google.inject.Module;

public class ContactModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(PersonController.class);
		binder.bind(PersonService.class).to(PersonServiceImpl.class);
	}

}
