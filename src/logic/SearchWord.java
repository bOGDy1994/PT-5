package logic;

import java.util.TreeMap;

import model.Dictionary;

public class SearchWord extends OperationDecorator {

	public SearchWord(Dictionary inDic) {
		super(inDic);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TreeMap<String, String> Operation(String word, String definition) {
		TreeMap<String, String>temp;
		if(dic.getDic().get(word)!=null)
		{
			temp = new TreeMap<String,String>();
			temp.put(word, dic.getDic().get(word));
			return temp;
		}
		return null;
	}

}
