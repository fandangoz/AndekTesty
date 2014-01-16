package MyCase;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.R;
import android.R.anim;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.widget.Toast;

public class CaseUtil {

	private String stream;
	
	public static void initialise(XmlResourceParser xrp) throws XmlPullParserException, IOException {
		
		int eventType = xrp.getEventType();
		caseList = new ArrayList<Case>();
		String key = null;
		String value = null;
		String tagName;
		while (eventType != XmlPullParser.END_DOCUMENT){
			tagName = xrp.getName();
			
			switch (eventType) {
			case XmlPullParser.START_DOCUMENT:
				
				break;

			case XmlPullParser.START_TAG:
				if(tagName.equals("key")){
					key = xrp.nextText().toString();
				}
				if(tagName.equals("value")){
					value = xrp.nextText().toString();
				}
				break;
				
			case XmlPullParser.END_TAG:
				if(tagName.equals("case")){
					caseList.add(new Case(key, value));
				}
				break;
			}
			eventType =  xrp.next();
		}
	}
	
	
	private static List<Case> caseList = new ArrayList<Case>();

	public static List<Case> getCaseList() {
		return caseList;
	}	
	
	public static String getValue(String key){
		for(Case c : caseList){
			if(c.getKey().equals(key)){
				return c.getValue();
			}
		}
		return null;
	}
	
	public static String getKey(String value){
		for(Case c : caseList){
			if(c.getValue().equals(value)){
				return c.getKey();
			}
		}
		return null;
	}
}
