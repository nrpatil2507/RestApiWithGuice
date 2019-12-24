package com.axelor.module;

import com.axelor.service.ContactService;
import com.axelor.service.ContactServiceImpl;
import com.axelor.service.PersonService;
import com.axelor.service.PersonServiceImpl;
import com.axelor.service.PhoneService;
import com.axelor.service.PhoneServiceImpl;
import com.axelor.web.PersonController;
import com.google.inject.Binder;
import com.google.inject.Module;

public class ContactModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(PersonController.class);
		binder.bind(PersonService.class).to(PersonServiceImpl.class);
		binder.bind(ContactService.class).to(ContactServiceImpl.class);
		binder.bind(PhoneService.class).to(PhoneServiceImpl.class);
	}

}
