/*    */ package com.nokia.mid.ui;
/*    */ 
/*    */ import javax.microedition.lcdui.Canvas;
/*    */ import javax.microedition.lcdui.Command;
/*    */ import javax.microedition.lcdui.CommandListener;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class FullCanvas
/*    */   extends Canvas
/*    */ {
/*    */   public static final int KEY_SOFTKEY1 = -6;
/*    */   public static final int KEY_SOFTKEY2 = -7;
/*    */   public static final int KEY_SEND = -10;
/*    */   public static final int KEY_END = -11;
/*    */   public static final int KEY_SOFTKEY3 = -5;
/*    */   public static final int KEY_UP_ARROW = -1;
/*    */   public static final int KEY_DOWN_ARROW = -2;
/*    */   public static final int KEY_LEFT_ARROW = -3;
/*    */   public static final int KEY_RIGHT_ARROW = -4;
/*    */   
/*    */   protected FullCanvas() {
/* 53 */     setFullScreenMode(true);
/* 54 */     super.addCommand(new NokiaCommand(-6, 4));
/* 55 */     super.addCommand(new NokiaCommand(-7, 2));
/* 56 */     super.setCommandListener(new NokiaCommandListener(this));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addCommand(Command cmd) {
/* 64 */     throw new IllegalStateException();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getWidth() {
/* 70 */     return super.getWidth();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 76 */     return super.getHeight();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCommandListener(CommandListener l) {
/* 84 */     throw new IllegalStateException();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void press(int i) {
/* 90 */     keyPressed(i);
/* 91 */     keyReleased(i);
/*    */   }
/*    */ }


/* Location:              C:\Users\ngdanghau\Downloads\Compressed\jar_files_2\microemu-nokiaui-2.0.1.jar!\com\nokia\mi\\ui\FullCanvas.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */