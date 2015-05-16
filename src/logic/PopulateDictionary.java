package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;
import model.Dictionary;

public class PopulateDictionary extends OperationDecorator {

	public PopulateDictionary(Dictionary inDic) {
		super(inDic);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TreeMap<String, String> Operation(String word, String definition) {
		// TODO Auto-generated method stub
		assert((word.equals("")&&definition.equals(""))||(!word.equals("")&&(!definition.equals(""))));
		if(isWellFormed())
		{
			String temp;
			Set<String> names;
			TreeMap<String, String> InitialList = new TreeMap<String, String>();
			try{
				BufferedReader b = new BufferedReader(new FileReader("dicinit.json"));
				temp = b.readLine();
				JSONObject obj = new JSONObject(temp);
				names = obj.keySet();
				for(String it : names)
					InitialList.put(it.toString(), obj.getString(it.toString()));
				dic.setDic(InitialList);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

}
