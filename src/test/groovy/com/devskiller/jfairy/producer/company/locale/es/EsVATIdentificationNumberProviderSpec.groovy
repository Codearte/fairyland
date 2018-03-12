package com.devskiller.jfairy.producer.company.locale.es

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author graux
 * @since 24/06/2015
 */
class EsVATIdentificationNumberProviderSpec extends Specification {

	private EsVATIdentificationNumberProvider generator = new EsVATIdentificationNumberProvider()

	@Unroll
	def "Should validate #vatIdentificationNumber as #valid"() {

		expect:
			generator.isValid(vatIdentificationNumber) == valid

		where:
			vatIdentificationNumber | valid
			"L17761800"             | true
			"31231231X"             | false
			"G2301257H"             | true
			"AB023023C"             | false
	}

	def "Should always generate proper nip"() {
		expect:
			generator.isValid(generator.get())
		where:
			i << (1..100)
	}

}
