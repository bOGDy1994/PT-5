package logic;

import java.util.TreeMap;

import model.Dictionary;

public class CopyDictionary extends OperationDecorator {

	public CopyDictionary(Dictionary inDic) {
		super(inDic);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TreeMap<String, String> Operation(String word, String definition) {
		return null;
	}
	
	public Dictionary Copy()
	{
		return dic;
	}

}
