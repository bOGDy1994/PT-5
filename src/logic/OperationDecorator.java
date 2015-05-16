package logic;

import java.util.Map.Entry;
import java.util.TreeMap;

import model.Dictionary;

public abstract class OperationDecorator {

	protected Dictionary dic;
	
	public OperationDecorator(Dictionary inDic)
	{
		dic = inDic;
	}
	
	/**
	 * 
	 * @pre (word=="" and definition =="") OR (word!="" and definition !="")
	 * @post for(Entry<String, String> entry : dic.getDic())
	 * 			entry.getValue != NULL
	 * @invariant isWellFormed()
	 */
	
	protected boolean isWellFormed()
	{
		for(Entry<String,String> entry : dic.getDic().entrySet())
		{
			if((entry.getValue().equals(""))||(entry.getValue()==null))
				return false;
			if(entry.getKey().toString().matches(entry.getValue().toString()))
				return false;
		}
		return true;
	}
	
	public abstract TreeMap<String, String> Operation(String word, String definition);
	
}
