package com.nokia.mid.appl.boun;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class c {
  private static c a = null;
  
  private static DataInputStream c = null;
  
  public static final String b = System.getProperty("microedition.locale");
  
  private static String a(String paramString1, String paramString2, String paramString3) {
    int i = paramString1.indexOf(paramString2);
    return (i >= 0) ? (paramString1.substring(0, i) + paramString3 + paramString1.substring(i + paramString2.length())) : paramString1;
  }
  
  public static synchronized String a(int paramInt) {
    return a(paramInt, null);
  }
  
  public static synchronized String a(int paramInt, String[] paramArrayOfString) {
    try {
      if (a == null)
        a = new c(); 
      if (c == null) {
        InputStream inputStream = a.getClass().getResourceAsStream("/lang." + b);
        if (inputStream == null)
          inputStream = a.getClass().getResourceAsStream("/lang.xx"); 
        if (inputStream == null)
          return "NoLang"; 
        c = new DataInputStream(inputStream);
        c.mark(512);
      } 
      c.skipBytes(paramInt * 2);
      short s = c.readShort();
      c.skipBytes(s - paramInt * 2 - 2);
      String str = c.readUTF();
      try {
        c.reset();
      } catch (IOException iOException) {
        c.close();
        c = null;
      } 
      if (paramArrayOfString != null)
        if (paramArrayOfString.length == 1) {
          str = a(str, "%U", paramArrayOfString[0]);
        } else {
          for (byte b = 0; b < paramArrayOfString.length; b++)
            str = a(str, "%" + b + "U", paramArrayOfString[b]); 
        }  
      return str;
    } catch (IOException iOException) {
      return "Err";
    } 
  }
}


/* Location:              D:\Java Mobile\nokiabounc_jdifc8jb.jar!\com\nokia\mid\appl\boun\c.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */