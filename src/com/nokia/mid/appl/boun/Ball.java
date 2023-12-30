package com.nokia.mid.appl.boun;

import com.nokia.mid.sound.Sound;
import javax.microedition.lcdui.Image;

public class Ball {
  private boolean mDebugCD = true;
  
  public int xPos;
  
  public int yPos;
  
  public int xSpeed;
  
  public int ySpeed;
  
  // tọa độ x của player
  public int x;
  
  public int mBallSize;
  
  public int mHalfBallSize;
  
  public int respawnX;
  
  public int respawnY;
  
  public int respawnSize;
  
  public int ballState;
  
  public int t;
  
  public int speedBonusCntr;
  
  public int gravBonusCntr;
  
  public int jumpBonusCntr;
  
  public boolean m;
  
  public boolean v;
  
  public boolean u;
  
  public int C;
  
  public static final byte[][] f = new byte[][] { 
      { 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 1 }, { 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        1, 1 }, { 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 
        1, 1 }, { 
        0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 
        1, 1 }, { 
        0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 
        1, 1 }, { 
        0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 
        1, 1 }, { 
        0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 
        1, 1 }, { 
        0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 
        1, 1 }, { 
        0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 
        1, 1 }, { 
        0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1 }, 
      { 
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1 }, { 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1 } };
  
  public static final byte[][] e = new byte[][] { 
      { 
        0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 
        0, 0 }, { 
        0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 
        0, 0 }, { 
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 0 }, { 
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 0 }, { 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1 }, { 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1 }, { 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1 }, { 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1 }, { 
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 0 }, { 
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 0 }, 
      { 
        0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 
        0, 0 }, { 
        0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 
        0, 0 } };
  
  public static final byte[][] xByte = new byte[][] { 
      { 
        0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 
        1, 0, 0, 0, 0, 0 }, { 
        0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 0, 0, 0 }, { 
        0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 0, 0 }, { 
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 0 }, { 
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 0 }, { 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1 }, { 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1 }, { 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1 }, { 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1 }, { 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1 }, 
      { 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1 }, { 
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 0 }, { 
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 0 }, { 
        0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 0, 0 }, { 
        0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 0, 0, 0 }, { 
        0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 
        1, 0, 0, 0, 0, 0 } };
  
  public BounceCanvas mCanvas;
  
  public Image mBallImage;
  
  public Image k;
  
  public Image B;
  
  public Image smallBallImage;
  
  private int q;
  
  public Ball(int paramInt1, int paramInt2, int paramInt3, BounceCanvas parame) {
    this.xPos = paramInt1;
    this.yPos = paramInt2;
    this.xSpeed = 0;
    this.ySpeed = 0;
    this.mCanvas = parame;
    this.t = 0;
    this.m = false;
    this.v = false;
    this.u = false;
    this.q = 0;
    this.speedBonusCntr = 0;
    this.gravBonusCntr = 0;
    this.jumpBonusCntr = 0;
    this.C = 0;
    this.ballState = 0;
    this.x = 0;
    this.mCanvas.setBallImages(this);
    if (paramInt3 == 12) {
      c();
    } else {
      f();
    } 
  }
  
  public void setRespawn(int paramInt1, int paramInt2) {
    this.respawnX = paramInt1;
    this.respawnY = paramInt2;
    this.respawnSize = this.mBallSize;
  }
  
  public void move(int paramInt) {
    if (paramInt == 8 || paramInt == 4 || paramInt == 2 || paramInt == 1)
      this.x |= paramInt; 
  }
  
  public void releaseDirection(int paramInt) {
    if (paramInt == 8 || paramInt == 4 || paramInt == 2 || paramInt == 1)
      this.x &= paramInt ^ 0xFFFFFFFF; 
  }
  
  public void a() {
    this.x &= 0xFFFFFFF0;
  }
  
  public boolean b(int paramInt1, int paramInt2) {
    int i = (paramInt1 - this.mHalfBallSize) / 12;
    int j = (paramInt2 - this.mHalfBallSize) / 12;
    int k = (paramInt1 - 1 + this.mHalfBallSize) / 12 + 1;
    int m = (paramInt2 - 1 + this.mHalfBallSize) / 12 + 1;
    for (int n = i; n < k; n++) {
      for (int i1 = j; i1 < m; i1++) {
        if (!OnCollisionEnter(paramInt1, paramInt2, i1, n))
          return false; 
      } 
    } 
    return true;
  }
  
  public void f() {
    this.mBallSize = 16;
    this.mHalfBallSize = 8;
    this.mBallImage = this.B;
    boolean bool = false;
    for (byte b = 1; !bool; b++) {
      bool = true;
      if (b(this.xPos, this.yPos - b)) {
        this.yPos -= b;
        continue;
      } 
      if (b(this.xPos - b, this.yPos - b)) {
        this.xPos -= b;
        this.yPos -= b;
        continue;
      } 
      if (b(this.xPos + b, this.yPos - b)) {
        this.xPos += b;
        this.yPos -= b;
        continue;
      } 
      if (b(this.xPos, this.yPos + b)) {
        this.yPos += b;
        continue;
      } 
      if (b(this.xPos - b, this.yPos + b)) {
        this.xPos -= b;
        this.yPos += b;
        continue;
      } 
      if (b(this.xPos + b, this.yPos + b)) {
        this.xPos += b;
        this.yPos += b;
        continue;
      } 
      bool = false;
    } 
  }
  
  public void c() {
    this.mBallSize = 12;
    this.mHalfBallSize = 6;
    this.mBallImage = this.smallBallImage;
  }
  
  public void e() {
    if (!this.mCanvas.mInvincible) {
      this.q = 7;
      this.ballState = 2;
      this.mCanvas.numLives--;
      this.speedBonusCntr = 0;
      this.gravBonusCntr = 0;
      this.jumpBonusCntr = 0;
      this.mCanvas.mPaintUIFlag = true;
      this.mCanvas.mSoundPop.play(1);
    } 
  }
  
  
  // chạm ring
  public void addRing() {
    this.mCanvas.add2Score(500);
    this.mCanvas.numRings++;
    this.mCanvas.mPaintUIFlag = true;
  }
  
  public void redirectBall(int paramInt) {
    int i = this.xSpeed;
    switch (paramInt) {
      case 35:
        this.xSpeed = (this.xSpeed > -this.ySpeed) ? this.xSpeed : this.ySpeed;
        this.ySpeed = i;
        break;
      case 37:
        this.xSpeed = (-this.xSpeed > this.ySpeed) ? this.xSpeed : this.ySpeed;
        this.ySpeed = i;
        break;
      case 34:
        this.xSpeed = (this.xSpeed < this.ySpeed) ? this.xSpeed : -this.ySpeed;
        this.ySpeed = -i;
        break;
      case 36:
        this.xSpeed = (this.xSpeed > this.ySpeed) ? this.xSpeed : -this.ySpeed;
        this.ySpeed = -i;
        break;
      case 31:
        this.xSpeed = (this.xSpeed > -this.ySpeed) ? this.xSpeed : (this.ySpeed >> 1);
        this.ySpeed = i;
        break;
      case 33:
        this.xSpeed = (-this.xSpeed > this.ySpeed) ? this.xSpeed : (this.ySpeed >> 1);
        this.ySpeed = i;
        break;
      case 30:
        this.xSpeed = (this.xSpeed < this.ySpeed) ? this.xSpeed : -(this.ySpeed >> 1);
        this.ySpeed = -i;
        break;
      case 32:
        this.xSpeed = (this.xSpeed > this.ySpeed) ? this.xSpeed : -(this.ySpeed >> 1);
        this.ySpeed = -i;
        break;
    } 
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b1;
    int n;
    byte b2;
    int i1;
    byte[][] arrayOfByte;
    int i = paramInt4 * 12;
    int j = paramInt3 * 12;
    int k = paramInt1 - this.mHalfBallSize - i;
    int m = paramInt2 - this.mHalfBallSize - j;
    if (k >= 0) {
      b1 = (byte) k;
      n = 12;
    } else {
      b1 = 0;
      n = this.mBallSize + k;
    } 
    if (m >= 0) {
      b2 = (byte) m;
      i1 = 12;
    } else {
      b2 = 0;
      i1 = this.mBallSize + m;
    } 
    if (this.mBallSize == 16) {
      arrayOfByte = xByte;
    } else {
      arrayOfByte = e;
    } 
    if (n > 12)
      n = 12; 
    if (i1 > 12)
      i1 = 12; 
    for (byte b3 = b1; b3 < n; b3++) {
      for (byte b = b2; b < i1; b++) {
        if (arrayOfByte[b - m][b3 - k] != 0)
          return true; 
      } 
    } 
    return false;
  }
  
  public boolean c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    byte b3;
    int n;
    byte b4;
    int i1;
    byte[][] arrayOfByte;
    int i = paramInt4 * 12;
    int j = paramInt3 * 12;
    int k = paramInt1 - this.mHalfBallSize - i;
    int m = paramInt2 - this.mHalfBallSize - j;
    byte b1 = 0;
    byte b2 = 0;
    switch (paramInt5) {
      case 30:
      case 34:
        b2 = 11;
        b1 = 11;
        break;
      case 31:
      case 35:
        b2 = 11;
        break;
      case 33:
      case 37:
        b1 = 11;
        break;
    } 
    if (k >= 0) {
      b3 = (byte) k;
      n = 12;
    } else {
      b3 = 0;
      n = this.mBallSize + k;
    } 
    if (m >= 0) {
      b4 = (byte) m;
      i1 = 12;
    } else {
      b4 = 0;
      i1 = this.mBallSize + m;
    } 
    if (this.mBallSize == 16) {
      arrayOfByte = xByte;
    } else {
      arrayOfByte = e;
    } 
    if (n > 12)
      n = 12; 
    if (i1 > 12)
      i1 = 12; 
    for (byte b5 = b3; b5 < n; b5++) {
      for (byte b = b4; b < i1; b++) {
        if ((f[Math.abs(b - b2)][Math.abs(b5 - b1)] & arrayOfByte[b - m][b5 - k]) != 0) {
          if (!this.m)
            redirectBall(paramInt5); 
          return true;
        } 
      } 
    } 
    return false;
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    int i = paramInt4 * 12;
    int j = paramInt3 * 12;
    int k = i + 12;
    int m = j + 12;
    switch (paramInt5) {
      case 3:
      case 5:
      case 9:
      case 13:
      case 14:
      case 17:
      case 18:
      case 21:
      case 22:
      case 43:
      case 45:
        i += 4;
        k -= 4;
        break;
      case 4:
      case 6:
      case 15:
      case 16:
      case 19:
      case 20:
      case 23:
      case 24:
      case 44:
      case 46:
        j += 4;
        m -= 4;
        break;
    } 
    return a(paramInt1 - this.mHalfBallSize, paramInt2 - this.mHalfBallSize, paramInt1 + this.mHalfBallSize - 1, paramInt2 + this.mHalfBallSize - 1, i, j, k - 1, m - 1);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    int i = paramInt4 * 12;
    int j = paramInt3 * 12;
    int k = i + 12;
    int m = j + 12;
    switch (paramInt5) {
      case 15:
      case 19:
      case 23:
      case 27:
        j += 6;
        m -= 6;
        k -= 11;
        break;
      case 16:
      case 20:
      case 24:
      case 28:
        j += 6;
        m -= 6;
        i += 11;
        break;
      case 13:
      case 17:
        i += 6;
        k -= 6;
        m -= 11;
        break;
      case 21:
      case 25:
        m = j;
        j--;
        i += 6;
        k -= 6;
        break;
      case 14:
      case 18:
      case 22:
      case 26:
        i += 6;
        k -= 6;
        j += 11;
        break;
    } 
    return a(paramInt1 - this.mHalfBallSize, paramInt2 - this.mHalfBallSize, paramInt1 + this.mHalfBallSize, paramInt2 + this.mHalfBallSize, i, j, k, m);
  }
  
  public boolean OnCollisionEnter(int paramInt1, int paramInt2, int yPos, int xPos) {
    int k;
    if (yPos >= this.mCanvas.mTileMapHeight || yPos < 0 || xPos >= this.mCanvas.mTileMapWidth || xPos < 0)
      return false; 
    if (this.ballState == 2)
      return false; 
    boolean paramBoolean = true;
    int i = this.mCanvas.tileMap[yPos][xPos] & 0x40;
    int j = this.mCanvas.tileMap[yPos][xPos] & 0xFFFFFFBF & 0xFFFFFF7F;
    Sound sound = null;
    switch (j) {
      case 1:
    	  // nền đất đỏ
        if (b(paramInt1, paramInt2, yPos, xPos)) {
        	paramBoolean = false;
          this.u = true;
          break;
        } 
        this.u = true;
        break;
      case 2:
    	  // nền đất xanh full
        if (b(paramInt1, paramInt2, yPos, xPos)) {
          this.v = true;
          paramBoolean = false;
          break;
        } 
        this.u = true;
        break;
      case 34:
    	// nền đất xanh Top Left
      case 35:
    	// nền đất xanh Top Right
      case 36:
    	// nền đất xanh Bottom Right
      case 37:
    	// nền đất xanh Bottom Left
        if (c(paramInt1, paramInt2, yPos, xPos, j)) {
          this.v = true;
          paramBoolean = false;
          this.u = true;
        } 
        break;
      case 30:
    	// nền đất đỏ Top Left
      case 31:
    	// nền đất đỏ Top Right
      case 32:
    	// nền đất đỏ Bottom Right
      case 33:
    	// nền đất đỏ Bottom Left
        if (c(paramInt1, paramInt2, yPos, xPos, j)) {
        	paramBoolean = false;
          this.u = true;
        } 
        break;
      case 10:
    	  // Dyn Thorn Axis
        k = this.mCanvas.b(xPos, yPos);
        if (k != -1) {
          int m = this.mCanvas.P[k][0] * 12 + this.mCanvas.mMOOffset[k][0];
          int n = this.mCanvas.P[k][1] * 12 + this.mCanvas.mMOOffset[k][1];
          if (a(paramInt1 - this.mHalfBallSize + 1, paramInt2 - this.mHalfBallSize + 1, paramInt1 + this.mHalfBallSize - 1, paramInt2 + this.mHalfBallSize - 1, m + 1, n + 1, m + 24 - 1, n + 24 - 1)) {
        	  paramBoolean = false;
            e();
          } 
        } 
        break;
      case 3:
    	  // Thorn 0 độ
      case 4:
    	  // Thorn 270 độ
      case 5:
    	  // Thorn 180
      case 6:
    	  // Thorn 90
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
        	paramBoolean = false;
          e();
        } 
        break;
      case 7:
    	 // checkpoint item
        this.mCanvas.add2Score(200);
        this.mCanvas.tileMap[this.respawnY][this.respawnX] = 128;
        setRespawn(xPos, yPos);
        this.mCanvas.tileMap[yPos][xPos] = 136;
        sound = this.mCanvas.mSoundPop;
        break;
      case 23:
    	  // Left Big Ring
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (a(paramInt1, paramInt2, yPos, xPos, j)) {
        	  paramBoolean = false;
            break;
          } 
          addRing();
          this.mCanvas.tileMap[yPos][xPos] = (short)(0x9B | i);
          this.mCanvas.tileMap[yPos][xPos + 1] = (short)(0x9C | i);
          sound = this.mCanvas.mSoundHoop;
        } 
        break;
      case 15:
    	// Left Small Ring 
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (this.mBallSize == 16) {
        	  paramBoolean = false;
            break;
          } 
          if (a(paramInt1, paramInt2, yPos, xPos, j))
        	  paramBoolean = false; 
          addRing();
          this.mCanvas.tileMap[yPos][xPos] = (short)(0x93 | i);
          this.mCanvas.tileMap[yPos][xPos + 1] = (short)(0x94 | i);
          sound = this.mCanvas.mSoundHoop;
        } 
        break;
      case 24:
    	// Right Big Ring
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (a(paramInt1, paramInt2, yPos, xPos, j))
        	  paramBoolean = false; 
          addRing();
          this.mCanvas.tileMap[yPos][xPos] = (short)(0x9C | i);
          this.mCanvas.tileMap[yPos][xPos - 1] = (short)(0x9B | i);
          sound = this.mCanvas.mSoundHoop;
        } 
        break;
      case 16:
    	// Right Small Ring 
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (this.mBallSize == 16) {
        	  paramBoolean = false;
            break;
          } 
          if (a(paramInt1, paramInt2, yPos, xPos, j))
        	  paramBoolean = false; 
          addRing();
          this.mCanvas.tileMap[yPos][xPos] = (short)(0x94 | i);
          this.mCanvas.tileMap[yPos][xPos - 1] = (short)(0x93 | i);
          sound = this.mCanvas.mSoundHoop;
        } 
        break;
      case 21:
    	// Top Big Ring
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (a(paramInt1, paramInt2, yPos, xPos, j))
        	  paramBoolean = false; 
          addRing();
          this.mCanvas.tileMap[yPos][xPos] = (short)(0x99 | i);
          this.mCanvas.tileMap[yPos + 1][xPos] = (short)(0x9A | i);
          sound = this.mCanvas.mSoundHoop;
        } 
        break;
      case 13:
    	// Top Small Ring
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (this.mBallSize == 16) {
        	  paramBoolean = false;
            break;
          } 
          if (a(paramInt1, paramInt2, yPos, xPos, j))
        	  paramBoolean = false; 
          addRing();
          this.mCanvas.tileMap[yPos][xPos] = (short)(0x91 | i);
          this.mCanvas.tileMap[yPos + 1][xPos] = (short)(0x92 | i);
          sound = this.mCanvas.mSoundHoop;
        } 
        break;
      case 22:
    	// Bottom Big Ring
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
        	addRing();
          this.mCanvas.tileMap[yPos][xPos] = (short)(0x9A | i);
          this.mCanvas.tileMap[yPos - 1][xPos] = (short)(0x99 | i);
          sound = this.mCanvas.mSoundHoop;
        } 
        break;
      case 14:
    	// Bottom Small Ring
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (this.mBallSize == 16) {
        	  paramBoolean = false;
            break;
          } 
          addRing();
          this.mCanvas.tileMap[yPos][xPos] = (short)(0x92 | i);
          this.mCanvas.tileMap[yPos - 1][xPos] = (short)(0x91 | i);
          sound = this.mCanvas.mSoundHoop;
        } 
        break;
      case 17:
      case 19:
      case 20:
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (this.mBallSize == 16) {
        	  paramBoolean = false;
            break;
          } 
          if (a(paramInt1, paramInt2, yPos, xPos, j))
        	  paramBoolean = false; 
        } 
        break;
      case 25:
      case 27:
      case 28:
        if (a(paramInt1, paramInt2, yPos, xPos, j))
        	paramBoolean = false; 
        break;
      case 18:
        if (b(paramInt1, paramInt2, yPos, xPos, j) && this.mBallSize == 16)
        	paramBoolean = false; 
        break;
      case 9:
    	  // cổng
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (this.mCanvas.mOpenFlag) {
            this.mCanvas.mLeaveGame = true;
            sound = this.mCanvas.mSoundPop;
            break;
          } 
          paramBoolean = false;
        } 
        break;
      case 29:
    	  // life item
        this.mCanvas.add2Score(1000);
        if (this.mCanvas.numLives < 5) {
          this.mCanvas.numLives++;
          this.mCanvas.mPaintUIFlag = true;
        } 
        this.mCanvas.tileMap[yPos][xPos] = 128;
        sound = this.mCanvas.mSoundPop;
        break;
      case 39:
      case 40:
      case 41:
      case 42:
    	  paramBoolean = false;
        if (this.mBallSize == 16)
          c(); 
        break;
      case 43:
      case 44:
      case 45:
      case 46:
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
        	paramBoolean = false;
          if (this.mBallSize == 12)
            f(); 
        } 
        break;
      case 47:
      case 48:
      case 49:
      case 50:
        this.gravBonusCntr = 300;
        sound = this.mCanvas.mSoundPop;
        this.m = false;
        paramBoolean = false;
        break;
      case 51:
      case 52:
      case 53:
      case 54:
        this.jumpBonusCntr = 300;
        sound = this.mCanvas.mSoundPop;
        paramBoolean = false;
        break;
      case 38:
        this.speedBonusCntr = 300;
        sound = this.mCanvas.mSoundPop;
        paramBoolean = false;
        break;
    } 
    if (sound != null)
      sound.play(1); 
    return paramBoolean;
  }
  
  public void update() {
    int i = this.xPos;
    int j = 0;
    int k = 0;
    byte b1 = 0;
    boolean bool1 = false;
    if (this.ballState == 2) {
      this.q--;
      if (this.q == 0) {
        this.ballState = 1;
        if (this.mCanvas.numLives < 0)
          this.mCanvas.mLeaveGame = true; 
      } 
      return;
    } 
    int m = this.xPos / 12;
    int n = this.yPos / 12;
    boolean bool2 = ((this.mCanvas.tileMap[n][m] & 0x40) != 0) ? true : false;
    if (bool2) {
      if (this.mBallSize == 16) {
        k = -30;
        j = -2;
        if (this.m)
          this.ySpeed = -10; 
      } else {
        k = 42;
        j = 6;
      } 
    } else if (this.mBallSize == 16) {
      k = 38;
      j = 3;
    } else {
      k = 80;
      j = 4;
    } 
    if (this.gravBonusCntr != 0) {
      bool1 = true;
      k *= -1;
      j *= -1;
      this.gravBonusCntr--;
      if (this.gravBonusCntr == 0) {
        bool1 = false;
        this.m = false;
        k *= -1;
        j *= -1;
      } 
    } 
    if (this.jumpBonusCntr != 0) {
      if (-1 * Math.abs(this.t) > -80)
        if (bool1) {
          this.t = 80;
        } else {
          this.t = -80;
        }  
      this.jumpBonusCntr--;
    } 
    this.C++;
    if (this.C == 3)
      this.C = 0; 
    if (this.ySpeed < -150) {
      this.ySpeed = -150;
    } else if (this.ySpeed > 150) {
      this.ySpeed = 150;
    } 
    if (this.xSpeed < -150) {
      this.xSpeed = -150;
    } else if (this.xSpeed > 150) {
      this.xSpeed = 150;
    } 
    if (this.ySpeed < 10 && this.ySpeed > 0 && !bool2 && !bool1)
      this.ySpeed = 10; 
    for (byte b2 = 0; b2 < Math.abs(this.ySpeed) / 10; b2++) {
      byte b = 0;
      if (this.ySpeed != 0)
        b = (byte) ((this.ySpeed < 0) ? -1 : 1); 
      if (b(this.xPos, this.yPos + b)) {
        this.yPos += b;
        this.m = false;
        if (k == -30) {
          n = this.yPos / 12;
          if ((this.mCanvas.tileMap[n][m] & 0x40) == 0) {
            this.ySpeed >>= 1;
            if (this.ySpeed <= 10 && this.ySpeed >= -10)
              this.ySpeed = 0; 
          } 
        } 
      } else {
        if (this.u && this.xSpeed < 10 && this.C == 0) {
          byte b4 = 1;
          if (b(this.xPos + b4, this.yPos + b)) {
            this.xPos += b4;
            this.yPos += b;
            this.u = false;
          } else if (b(this.xPos - b4, this.yPos + b)) {
            this.xPos -= b4;
            this.yPos += b;
            this.u = false;
          } 
        } 
        if (b > 0 || (bool1 && b < 0)) {
          this.ySpeed = this.ySpeed * -1 / 2;
          this.m = true;
          if (this.v && (this.x & 0x8) != 0) {
            this.v = false;
            if (bool1) {
              this.t += 10;
            } else {
              this.t += -10;
            } 
          } else if (this.jumpBonusCntr == 0) {
            this.t = 0;
          } 
          if (this.ySpeed < 10 && this.ySpeed > -10) {
            if (bool1) {
              this.ySpeed = -10;
              break;
            } 
            this.ySpeed = 10;
          } 
          break;
        } 
        if (b < 0 || (bool1 && b > 0))
          if (bool1) {
            this.ySpeed = -20;
          } else {
            this.ySpeed = -this.ySpeed >> 1;
          }  
      } 
    } 
    if (bool1) {
      if (j == -2 && this.ySpeed < k) {
        this.ySpeed += j;
        if (this.ySpeed > k)
          this.ySpeed = k; 
      } else if (!this.m && this.ySpeed > k) {
        this.ySpeed += j;
        if (this.ySpeed < k)
          this.ySpeed = k; 
      } 
    } else if (j == -2 && this.ySpeed > k) {
      this.ySpeed += j;
      if (this.ySpeed < k)
        this.ySpeed = k; 
    } else if (!this.m && this.ySpeed < k) {
      this.ySpeed += j;
      if (this.ySpeed > k)
        this.ySpeed = k; 
    } 
    if (this.speedBonusCntr != 0) {
      b1 = 100;
      this.speedBonusCntr--;
    } else {
      b1 = 50;
    } 
    if ((this.x & 0x2) != 0 && this.xSpeed < b1) {
      this.xSpeed += 6;
    } else if ((this.x & 0x1) != 0 && this.xSpeed > -b1) {
      this.xSpeed -= 6;
    } else if (this.xSpeed > 0) {
      this.xSpeed -= 4;
    } else if (this.xSpeed < 0) {
      this.xSpeed += 4;
    } 
    if (this.mBallSize == 16 && this.jumpBonusCntr == 0)
      if (bool1) {
        this.t += 5;
      } else {
        this.t += -5;
      }  
    if (this.m && (this.x & 0x8) != 0) {
      if (bool1) {
        this.ySpeed = 67 + this.t;
      } else {
        this.ySpeed = -67 + this.t;
      } 
      this.m = false;
    } 
    int i1 = Math.abs(this.xSpeed);
    int i2 = i1 / 10;
    for (byte b3 = 0; b3 < i2; b3++) {
      byte b = 0;
      if (this.xSpeed != 0)
        b = (byte) ((this.xSpeed < 0) ? -1 : 1); 
      if (b(this.xPos + b, this.yPos)) {
        this.xPos += b;
      } else if (this.u) {
        this.u = false;
        byte b4 = 0;
        if (bool1) {
          b4 = 1;
        } else {
          b4 = -1;
        } 
        if (b(this.xPos + b, this.yPos + b4)) {
          this.xPos += b;
          this.yPos += b4;
        } else if (b(this.xPos + b, this.yPos - b4)) {
          this.xPos += b;
          this.yPos -= b4;
        } else {
          this.xSpeed = -(this.xSpeed >> 1);
        } 
      } 
    } 
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    return (paramInt1 <= paramInt7 && paramInt2 <= paramInt8 && paramInt5 <= paramInt3 && paramInt6 <= paramInt4);
  }
}
