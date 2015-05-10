package model;

import java.util.TreeMap;

public class Dictionary {

	private TreeMap<String,String> dic;
	
	public Dictionary()
	{
		dic = new TreeMap<String, String>();
	}
	
	public Dictionary(TreeMap<String,String> inDic)
	{
		if(inDic != null)
			dic = inDic;
		else
			dic = new TreeMap<String,String>();
	}
	
	public TreeMap<String, String> getDic()
	{
		return dic;
	}
	
	public void setDic(TreeMap<String, String> inMap)
	{
		dic = inMap;
	}
	
}
