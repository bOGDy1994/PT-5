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
		assert((word.equals("")&&definition.equals(""))||(!word.equals("")&&(!definition.equals(""))));
		if(isWellFormed())
		{
			TreeMap<String, String> temp = dic.getDic();
			TreeMap<String, String> temp2 = temp;
			String test = temp.get(word);
			if(test != null)
				temp.remove(word);
			dic.setDic(temp);
			if(!isWellFormed())
				dic.setDic(temp2);
		}
		return null;
	}

}
