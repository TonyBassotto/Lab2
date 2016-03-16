package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.ItalianDictionary;
import it.polito.tdp.spellchecker.model.EnglishDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SpellCheckerController {
	String text;
	String type;
	Dictionary d;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> boxLanguage;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtOutput;

    @FXML
    private Text txtStateERR;

    @FXML
    private Button btnClearText;

    @FXML
    private Text txtTimeState;

    @FXML
    void doClearText(ActionEvent event) {
    	txtInput.setText("");
    	txtOutput.setText("");

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	if(txtInput.getText()==null){} else{
    	text=txtInput.getText();
    	if(boxLanguage.getValue()==null){} else {
    	type=boxLanguage.getValue();
    	List<String>inputList=new LinkedList<String>();
    	String[] s=text.split(" ");
    	
    	for(int i=0;i<s.length;i++){
    		String ss=s[i];
    		inputList.add(i, ss);
    	}
    	if(type=="Italian"){
    		d=new ItalianDictionary() ;
    		d.loadDictionary();
    		//a.addAll(id.getDicIT());
    		d.spellCheckText(inputList);
    	}
    	else
    		{d=new EnglishDictionary();
    		d.loadDictionary();
    		//a.addAll(ed.getDicENG());
    		d.spellCheckText(inputList);
    		}
    	}
    	}
    }

    @FXML
    void initialize() {
        assert boxLanguage != null : "fx:id=\"boxLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtStateERR != null : "fx:id=\"txtStateERR\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTimeState != null : "fx:id=\"txtTimeState\" was not injected: check your FXML file 'SpellChecker.fxml'.";

        boxLanguage.getItems().addAll("English","Italian");
    }
}
