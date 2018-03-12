package com.devskiller.jfairy.producer.person.locale;

import javax.inject.Inject;
import java.time.LocalDate;

import com.google.inject.assistedinject.Assisted;

import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.devskiller.jfairy.producer.person.NationalIdentificationNumber;
import com.devskiller.jfairy.producer.person.NationalIdentificationNumberFactory;
import com.devskiller.jfairy.producer.person.NationalIdentificationNumberProperties;
import com.devskiller.jfairy.producer.person.NationalIdentificationNumberProvider;
import com.devskiller.jfairy.producer.person.Person;

public class NoNationalIdentificationNumberFactory implements NationalIdentificationNumberFactory {

	@Inject
	public NoNationalIdentificationNumberFactory(BaseProducer baseProducer, DateProducer dateProducer) {
	}

	@Override
	public NoNationalIdentificationNumberProvider produceNationalIdentificationNumberProvider(NationalIdentificationNumberProperties.Property... properties) {
		return new NoNationalIdentificationNumberProvider(null, null, properties);
	}

	public static class NoNationalIdentificationNumberProvider implements NationalIdentificationNumberProvider {


		@Inject
		public NoNationalIdentificationNumberProvider(DateProducer dateProducer, BaseProducer baseProducer,
													  @Assisted NationalIdentificationNumberProperties.Property... properties) {
		}

		@Override
		public NationalIdentificationNumber get() {
			return new NationalIdentificationNumber("");
		}

		@Override
		public void setIssueDate(LocalDate dateOfBirth) {
		}

		@Override
		public void setSex(Person.Sex sex) {
		}

	}

}
