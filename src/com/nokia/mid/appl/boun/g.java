package com.nokia.mid.appl.boun;

import java.util.Timer;
import java.util.TimerTask;

public class g extends TimerTask {
  TileCanvas a;
  
  Timer c;
  
  private final TileCanvas b;
  
  public g(TileCanvas paramb1, TileCanvas paramb2) {
    this.b = paramb1;
    this.a = paramb2;
    this.c = new Timer();
    this.c.schedule(this, 0L, 40L);
  }
  
  public void run() {
    this.a.n();
  }
  
  void a() {
    if (this.c == null)
      return; 
    cancel();
    this.c.cancel();
    this.c = null;
  }
}


/* Location:              D:\Java Mobile\nokiabounc_jdifc8jb.jar!\com\nokia\mid\appl\boun\g.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */