package logic;

import java.util.TreeMap;

import model.Dictionary;

public class AddWord extends OperationDecorator {

	public AddWord(Dictionary inDic) {
		super(inDic);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TreeMap<String, String> Operation(String word, String definition) {
		TreeMap<String, String> temp = dic.getDic();
		temp.put(word, definition);
		dic.setDic(temp);
		return null;
	}

}
