package logic;

import java.util.TreeMap;

import model.Dictionary;

public abstract class OperationDecorator {

	protected Dictionary dic;
	
	public OperationDecorator(Dictionary inDic)
	{
		dic = inDic;
	}
	
	public abstract TreeMap<String, String> Operation(String word, String definition);
	
}
