package com.example.demo.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {
	@Autowired
	   private SpellChecker spellChecker;
	
	//SpellChecker spellChecker1 = new SpellChecker(); // without DI
	   
	   // a setter method to inject the dependency.
	   public void setSpellChecker(SpellChecker spellChecker) {
	      System.out.println("Inside setSpellChecker." );
	      this.spellChecker = spellChecker;
	   }
	   
	   // a getter method to return spellChecker
	   public SpellChecker getSpellChecker() {
	      return spellChecker;
	   }
	   public void spellCheck() {
		//   spellChecker1.checkSpelling();// without DI
	      spellChecker.checkSpelling();
	   }
	}