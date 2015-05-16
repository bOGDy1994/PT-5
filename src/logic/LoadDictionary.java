package logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.TreeMap;

import model.Dictionary;

public class LoadDictionary extends OperationDecorator {

	public LoadDictionary(Dictionary inDic) {
		super(inDic);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TreeMap<String, String> Operation(String word, String definition) {
		if(isWellFormed())
		{
			assert((word.equals("")&&definition.equals(""))||(!word.equals("")&&(!definition.equals(""))));
			TreeMap<String, String> temp;
			try{
				FileInputStream fileIn = new FileInputStream("dicstate.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				temp = (TreeMap<String,String>)in.readObject();
				dic.setDic(temp);
				in.close();
				fileIn.close();
			}
			catch(IOException e)
			{
			}
			catch(ClassNotFoundException e)
			{	
			}
		}
		return null;
	}

}
