package com.devskiller.jfairy.producer.company.locale.ka;

import com.google.inject.Inject;

import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.VATIdentificationNumberProvider;

public class KaVATIdentificationNumberProvider implements VATIdentificationNumberProvider {

	private final BaseProducer baseProducer;

	@Inject
	public KaVATIdentificationNumberProvider(BaseProducer baseProducer) {
		this.baseProducer = baseProducer;
	}

	@Override
	public String get() {
		return baseProducer.randomElement("2", "4") + baseProducer.numerify("########");
	}
}
