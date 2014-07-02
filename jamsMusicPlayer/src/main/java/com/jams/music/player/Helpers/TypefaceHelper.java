package com.jams.music.player.Helpers;

import java.util.Hashtable;

import android.content.Context;
import android.graphics.Typeface;

//Caches the custom fonts in memory to improve rendering performance.
public class TypefaceHelper {

public static final String TYPEFACE_FOLDER = "fonts";
public static final String TYPEFACE_EXTENSION = ".ttf";

private static Hashtable<String, Typeface> sTypeFaces = new Hashtable<String, Typeface>(4);

	public static Typeface getTypeface(Context context, String fileName) {
		Typeface tempTypeface = sTypeFaces.get(fileName);
		
		if (tempTypeface==null) {
		    String fontPath = new StringBuilder(TYPEFACE_FOLDER).append('/')
		    													.append(fileName)
		    													.append(TYPEFACE_EXTENSION)
		    													.toString();
		    
		    tempTypeface = Typeface.createFromAsset(context.getAssets(), fontPath);
		    sTypeFaces.put(fileName, tempTypeface);
		}
		
		return tempTypeface;
	}
	
}
