package logic;

import java.util.Map.Entry;
import java.util.TreeMap;

import model.Dictionary;

public class WordMatcher extends OperationDecorator {

	public WordMatcher(Dictionary inDic) {
		super(inDic);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TreeMap<String, String> Operation(String word, String definition) {
		// TODO Auto-generated method stub
		TreeMap<String, String> res = new TreeMap<String, String>();
		TreeMap<String, String> temp = dic.getDic();
		for(Entry<String, String> entry : temp.entrySet())
			if(entry.getKey().matches(word))
				res.put(entry.getKey(), entry.getValue());
		return res;
	}

}
