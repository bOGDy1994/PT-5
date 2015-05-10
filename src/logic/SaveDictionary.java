package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import model.Dictionary;

public class SaveDictionary extends OperationDecorator {

	public SaveDictionary(Dictionary inDic) {
		super(inDic);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TreeMap<String, String> Operation(String word, String definition) {
		 try
         {
            FileOutputStream fileOut =
            new FileOutputStream("dicstate.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(dic.getDic());
            out.close();
            fileOut.close();
         }catch(IOException i)
         {
             i.printStackTrace();
         }
		return null;
	}

}
