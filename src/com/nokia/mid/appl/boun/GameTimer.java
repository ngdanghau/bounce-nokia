package com.nokia.mid.appl.boun;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer extends TimerTask {
    TileCanvas parent;
    
    Timer timer;
    
    private final TileCanvas b;
    
    public GameTimer(TileCanvas this$0, TileCanvas param1b1) {
      this.b = this$0;
      this.parent = param1b1;
      this.timer = new Timer();
      this.timer.schedule(this, 0L, 40L);
    }
    
    public void run() {
      this.parent.timerTrigger();
    }
    
    void stop() {
      if (this.timer == null)
        return; 
      cancel();
      this.timer.cancel();
      this.timer = null;
    }
  }

/* Location:              D:\Java Mobile\nokiabounc_jdifc8jb.jar!\com\nokia\mid\appl\boun\g.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */