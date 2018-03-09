package io.codearte.jfairy.producer.payment

import io.codearte.jfairy.Fairy
import io.codearte.jfairy.producer.BaseProducer
import io.codearte.jfairy.producer.RandomGenerator
import org.iban4j.IbanUtil
import spock.lang.Specification

class IBANSpec extends Specification {

	private baseProducer

	def setup() {
		baseProducer = new BaseProducer(new RandomGenerator())
	}

	/**
	 * Austria	20	16n
	 * ATkk bbbb bccc cccc cccc
	 *
	 * b = National bank code
	 c = Account number
	 */
	def "should return valid iban"() {
		when:
			IBANProvider iban = new DefaultIBANProvider(baseProducer,
				IBANProperties.accountNumber("00234573201"),
				IBANProperties.country("AT")
			);

		then:
			IbanUtil.validate(iban.get().ibanNumber);
	}

	/**
	 * Poland	28	24n	PLkk bbbs sssx cccc cccc cccc cccc	b = National bank code
	 s = Branch code
	 x = National check digit
	 c = Account number,

	 PLkk bbbssssx cccccccccccccccc
	 PL60 11401010 1111000234573201
	 */

	def "should return valid polish iban"() {
		when:
			IBANProvider iban = new DefaultIBANProvider(baseProducer)
		then:
			IbanUtil.validate(iban.get().ibanNumber);
	}

	def "should be usable directly from Fairy"() {
		when:
			String number = Fairy.create().iban(IBANProperties.country("PL")).ibanNumber
		then:
			number.startsWith('PL')
	}
}
