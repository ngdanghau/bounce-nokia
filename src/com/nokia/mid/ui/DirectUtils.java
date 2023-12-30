/*    */ package com.nokia.mid.ui;
/*    */ 
/*    */ import javax.microedition.lcdui.Graphics;
/*    */ import javax.microedition.lcdui.Image;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DirectUtils
/*    */ {
/*    */   public static DirectGraphics getDirectGraphics(Graphics g) {
/* 37 */     return new DirectGraphicsImp(g);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Image createImage(byte[] imageData, int imageOffset, int imageLength) {
/* 50 */     Image source = Image.createImage(imageData, imageOffset, imageLength);
/* 51 */     Image target = Image.createImage(source.getWidth(), source.getHeight());
/* 52 */     target.getGraphics().drawImage(source, 0, 0, 0);
/* 53 */     return target;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Image createImage(int width, int height, int argb) {
/* 65 */     Image img = Image.createImage(width, height);
/* 66 */     Graphics g = img.getGraphics();
/* 67 */     g.setColor(argb);
/* 68 */     g.fillRect(0, 0, width, height);
/* 69 */     g.setColor(0);
/* 70 */     return img;
/*    */   }
/*    */ }


/* Location:              C:\Users\ngdanghau\Downloads\Compressed\jar_files_2\microemu-nokiaui-2.0.1.jar!\com\nokia\mi\\ui\DirectUtils.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */