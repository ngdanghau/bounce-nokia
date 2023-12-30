package com.nokia.mid.ui;

import javax.microedition.lcdui.Image;

public interface DirectGraphics {
  public static final int FLIP_HORIZONTAL = 8192;
  
  public static final int FLIP_VERTICAL = 16384;
  
  public static final int ROTATE_90 = 90;
  
  public static final int ROTATE_180 = 180;
  
  public static final int ROTATE_270 = 270;
  
  public static final int TYPE_BYTE_1_GRAY = 1;
  
  public static final int TYPE_BYTE_1_GRAY_VERTICAL = -1;
  
  public static final int TYPE_BYTE_2_GRAY = 2;
  
  public static final int TYPE_BYTE_4_GRAY = 4;
  
  public static final int TYPE_BYTE_8_GRAY = 8;
  
  public static final int TYPE_BYTE_332_RGB = 332;
  
  public static final int TYPE_USHORT_4444_ARGB = 4444;
  
  public static final int TYPE_USHORT_444_RGB = 444;
  
  public static final int TYPE_USHORT_555_RGB = 555;
  
  public static final int TYPE_USHORT_1555_ARGB = 1555;
  
  public static final int TYPE_USHORT_565_RGB = 565;
  
  public static final int TYPE_INT_888_RGB = 888;
  
  public static final int TYPE_INT_8888_ARGB = 8888;
  
  void drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  void drawPixels(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  void drawPixels(int[] paramArrayOfint, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  void drawPixels(short[] paramArrayOfshort, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  void drawPolygon(int[] paramArrayOfint1, int paramInt1, int[] paramArrayOfint2, int paramInt2, int paramInt3, int paramInt4);
  
  void drawTriangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  void fillPolygon(int[] paramArrayOfint1, int paramInt1, int[] paramArrayOfint2, int paramInt2, int paramInt3, int paramInt4);
  
  void fillTriangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  int getAlphaComponent();
  
  int getNativePixelFormat();
  
  void getPixels(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  void getPixels(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  void getPixels(short[] paramArrayOfshort, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  void setARGBColor(int paramInt);
}


/* Location:              C:\Users\ngdanghau\Downloads\Compressed\jar_files_2\microemu-nokiaui-2.0.1.jar!\com\nokia\mi\\ui\DirectGraphics.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */