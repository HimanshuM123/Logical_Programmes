package com.example.demo.scope2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.DI.SpellChecker;

@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClassA {
	String msg;
	@Autowired
	private ClassB classB;

	// SpellChecker spellChecker1 = new SpellChecker(); // without DI

	// a setter method to inject the dependency.
	public void setSpellChecker(ClassB classB) {
		System.out.println("Inside setSpellChecker.");
		this.classB = classB;
	}

	// a getter method to return spellChecker
	public ClassB getSpellChecker() {
		return classB;
	}

	public void spellCheck() {
		// spellChecker1.checkSpelling();// without DI
		// System.out.println("testing scope...."+msg);
		classB.classBMethod(msg);
	}

	public void setMessage(String msg) {
		this.msg = msg;
		classB.classBMethod(msg);

	}

	public String getMessage() {
		return msg;

	}

}
