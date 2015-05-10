package logic;

import java.util.TreeMap;

import model.Dictionary;

public class RemoveWord extends OperationDecorator {

	public RemoveWord(Dictionary inDic) {
		super(inDic);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TreeMap<String, String> Operation(String word, String definition) {
		TreeMap<String, String> temp = dic.getDic();
		String test = temp.get(word);
		if(test != null)
			temp.remove(word);
		dic.setDic(temp);
		return null;
	}

}
