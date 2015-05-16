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
		if(isWellFormed())
		{
			assert((word.equals("")&&definition.equals(""))||(!word.equals("")&&(!definition.equals(""))));
			TreeMap<String, String> temp = dic.getDic();
			TreeMap<String,String> temp2 = temp;
			temp.put(word, definition);
			dic.setDic(temp);
			if(!isWellFormed())
			dic.setDic(temp2);
		}
		return null;
	}

}
