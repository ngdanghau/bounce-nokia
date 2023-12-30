/*    */ package com.nokia.mid.sound;
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
/*    */ public class Sound
/*    */ {
/*    */   public static final int SOUND_PLAYING = 0;
/*    */   public static final int SOUND_STOPPED = 1;
/*    */   public static final int SOUND_UNINITIALIZED = 3;
/*    */   public static final int FORMAT_TONE = 1;
/*    */   public static final int FORMAT_WAV = 5;
/*    */   
/*    */   public Sound(byte[] data, int type) {}
/*    */   
/*    */   public Sound(int freq, long duration) {}
/*    */   
/*    */   public static int getConcurrentSoundCount(int type) {
/* 46 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getGain() {
/* 52 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setGain(int gain) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public int getState() {
/* 63 */     return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static int[] getSupportedFormats() {
/* 69 */     return new int[0];
/*    */   }
/*    */   
/*    */   public void init(byte[] data, int type) {}
/*    */   
/*    */   public void init(int freq, long duration) {}
/*    */   
/*    */   public synchronized void play(int loop) {}
/*    */   
/*    */   public void stop() {}
/*    */   
/*    */   public void release() {}
/*    */   
/*    */   public void resume() {}
/*    */   
/*    */   public void setSoundListener(SoundListener listener) {}
/*    */ }


/* Location:              C:\Users\ngdanghau\Downloads\Compressed\jar_files_2\microemu-nokiaui-2.0.1.jar!\com\nokia\mid\sound\Sound.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */