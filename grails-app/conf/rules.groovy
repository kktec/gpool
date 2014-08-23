ruleset {
	ruleset('rulesets/braces.xml')
	ruleset('rulesets/concurrency.xml')
	ruleset('rulesets/convention.xml')
	ruleset('rulesets/design.xml') {
//		PrivateFieldCouldBeFinal(enabled: false)
//		AbstractClassWithoutAbstractMethod(enabled: false)
	}
	ruleset('rulesets/dry.xml') {
		DuplicateNumberLiteral(enabled: false)
		DuplicateStringLiteral(enabled: false)
		DuplicateListLiteral(enabled: false)
		DuplicateMapLiteral(enabled: false)
	}
	ruleset('rulesets/enhanced.xml')
	ruleset('rulesets/exceptions.xml') {
//		CatchException(enabled: false)
//		ReturnNullFromCatchBlock(enabled: false)
	}
	ruleset('rulesets/formatting.xml') {
		ClassJavadoc(enabled: false)
		ConsecutiveBlankLines(enabled: false)
		SpaceAroundMapEntryColon(characterAfterColonRegex: /\s/) 
		LineLength(length: 140)
		TrailingWhitespace(enabled: false)
	}
	ruleset('rulesets/generic.xml')
	ruleset('rulesets/grails.xml') {
		GrailsDomainHasEquals(enabled: false)
		GrailsStatelessService(enabled: false)
		GrailsDomainHasToString(enabled: false)
//		GrailsMassAssignment(enabled: false)
	}
	ruleset('rulesets/groovyism.xml') {
//		GStringExpressionWithinString(enabled: false)
	}
	ruleset('rulesets/imports.xml') {
//		NoWildcardImports(enabled: false)
	}
	ruleset('rulesets/jdbc.xml')
	ruleset('rulesets/junit.xml')
	ruleset('rulesets/logging.xml')
	ruleset('rulesets/naming.xml') {
		MethodName { // necessary for Spock
			regex = /[a-zA-Z#][#\w\s'\(\)]*/
		}
		
		PropertyName { // allow non first char _
			regex = /[a-z][a-zA-Z0-9_]*/
		}

		// this should be named BuilderMethodName IMO (kkrebs)
		FactoryMethodName {
			regex = /(build.*)/
		}
		
		ConfusingMethodName(enabled: false)
	}
	ruleset('rulesets/security.xml') {
//		FileCreateTempFile(enabled: false)
	}
	ruleset('rulesets/serialization.xml') {
//		SerializableClassMustDefineSerialVersionUID(enabled: false)
	}
	ruleset('rulesets/size.xml') {
//		CyclomaticComplexity(maxMethodComplexity: 40, ignoreMethodNames: 'can generate data*')
//		MethodCount(maxMethods: 40)
	}
	ruleset('rulesets/unnecessary.xml') {
		UnnecessaryBooleanExpression(enabled: false) // codenarc confused by || in spock where: 
//		UnnecessarySubstring(enabled: false)
//		UnnecessaryObjectReferences(enabled: false)
//		UnnecessaryOverridingMethod(enabled: false)
	}
	ruleset('rulesets/unused.xml') {
//		UnusedMethodParameter(enabled: false)
	}
}