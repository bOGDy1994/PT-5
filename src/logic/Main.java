package logic;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import model.Dictionary;

public class Main {

	public static void main(String argv[])
	{
		Dictionary dic = new Dictionary();
		AddWord a = new AddWord(dic);
		a.Operation("water", "element of life");
		a.Operation("ice", "water frozen");
		a.Operation("fire", "oposite of ice");
		SaveDictionary s = new SaveDictionary(dic);
		s.Operation("", "");
		for(Entry<String,String> entry : dic.getDic().entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue());
		System.out.println();
		RemoveWord r = new RemoveWord(dic);
		r.Operation("fire", "");
		for(Entry<String,String> entry : dic.getDic().entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue());
		System.out.println();
		LoadDictionary l = new LoadDictionary(dic);
		l.Operation("","");
		for(Entry<String,String> entry : dic.getDic().entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue());
	}
	
}
