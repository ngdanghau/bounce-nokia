/*     */ package com.nokia.mid.ui;
/*     */ 
/*     */ import javax.microedition.lcdui.Command;
/*     */ import javax.microedition.lcdui.CommandListener;
/*     */ import javax.microedition.lcdui.Displayable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class NokiaCommandListener
/*     */   implements CommandListener
/*     */ {
/*     */   FullCanvas fc;
/*     */   
/*     */   NokiaCommandListener(FullCanvas f) {
/* 103 */     this.fc = f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commandAction(Command c, Displayable d) {
/* 109 */     this.fc.press(((NokiaCommand)c).getKey());
/*     */   }
/*     */ }


/* Location:              C:\Users\ngdanghau\Downloads\Compressed\jar_files_2\microemu-nokiaui-2.0.1.jar!\com\nokia\mi\\ui\NokiaCommandListener.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */