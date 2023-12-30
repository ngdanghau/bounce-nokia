package com.nokia.mid.appl.boun;

import com.nokia.mid.sound.Sound;
import javax.microedition.lcdui.Image;

public class Player {
  private boolean j = true;
  
  public int s;
  
  public int r;
  
  public int l;
  
  public int o;
  
  // tọa độ x của player
  public int x;
  
  public int a;
  
  public int p;
  
  public int d;
  
  public int c;
  
  public int b;
  
  public int z;
  
  public int t;
  
  public int h;
  
  public int g;
  
  public int y;
  
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
  
  public MainScene mainScene;
  
  public Image i;
  
  public Image k;
  
  public Image B;
  
  public Image A;
  
  private int q;
  
  public Player(int paramInt1, int paramInt2, int paramInt3, MainScene parame) {
    this.s = paramInt1;
    this.r = paramInt2;
    this.l = 0;
    this.o = 0;
    this.mainScene = parame;
    this.t = 0;
    this.m = false;
    this.v = false;
    this.u = false;
    this.q = 0;
    this.h = 0;
    this.g = 0;
    this.y = 0;
    this.C = 0;
    this.z = 0;
    this.x = 0;
    this.mainScene.a(this);
    if (paramInt3 == 12) {
      c();
    } else {
      f();
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.d = paramInt1;
    this.c = paramInt2;
    this.b = this.a;
  }
  
  public void move(int paramInt) {
    if (paramInt == 8 || paramInt == 4 || paramInt == 2 || paramInt == 1)
      this.x |= paramInt; 
  }
  
  public void a(int paramInt) {
    if (paramInt == 8 || paramInt == 4 || paramInt == 2 || paramInt == 1)
      this.x &= paramInt ^ 0xFFFFFFFF; 
  }
  
  public void a() {
    this.x &= 0xFFFFFFF0;
  }
  
  public boolean b(int paramInt1, int paramInt2) {
    int i = (paramInt1 - this.p) / 12;
    int j = (paramInt2 - this.p) / 12;
    int k = (paramInt1 - 1 + this.p) / 12 + 1;
    int m = (paramInt2 - 1 + this.p) / 12 + 1;
    for (int n = i; n < k; n++) {
      for (int i1 = j; i1 < m; i1++) {
        if (!OnCollisionEnter(paramInt1, paramInt2, i1, n))
          return false; 
      } 
    } 
    return true;
  }
  
  public void f() {
    this.a = 16;
    this.p = 8;
    this.i = this.B;
    boolean bool = false;
    for (byte b = 1; !bool; b++) {
      bool = true;
      if (b(this.s, this.r - b)) {
        this.r -= b;
        continue;
      } 
      if (b(this.s - b, this.r - b)) {
        this.s -= b;
        this.r -= b;
        continue;
      } 
      if (b(this.s + b, this.r - b)) {
        this.s += b;
        this.r -= b;
        continue;
      } 
      if (b(this.s, this.r + b)) {
        this.r += b;
        continue;
      } 
      if (b(this.s - b, this.r + b)) {
        this.s -= b;
        this.r += b;
        continue;
      } 
      if (b(this.s + b, this.r + b)) {
        this.s += b;
        this.r += b;
        continue;
      } 
      bool = false;
    } 
  }
  
  public void c() {
    this.a = 12;
    this.p = 6;
    this.i = this.A;
  }
  
  public void e() {
    if (!this.mainScene.isInvincibility) {
      this.q = 7;
      this.z = 2;
      this.mainScene.noOfLife--;
      this.h = 0;
      this.g = 0;
      this.y = 0;
      this.mainScene.y = true;
      this.mainScene.popSFX.play(1);
    } 
  }
  
  
  // chạm ring
  public void OnRingCollisionEnter() {
    this.mainScene.addSessionScore(500);
    this.mainScene.noOfRingCollected++;
    this.mainScene.y = true;
  }
  
  public void b(int paramInt) {
    int i = this.l;
    switch (paramInt) {
      case 35:
        this.l = (this.l > -this.o) ? this.l : this.o;
        this.o = i;
        break;
      case 37:
        this.l = (-this.l > this.o) ? this.l : this.o;
        this.o = i;
        break;
      case 34:
        this.l = (this.l < this.o) ? this.l : -this.o;
        this.o = -i;
        break;
      case 36:
        this.l = (this.l > this.o) ? this.l : -this.o;
        this.o = -i;
        break;
      case 31:
        this.l = (this.l > -this.o) ? this.l : (this.o >> 1);
        this.o = i;
        break;
      case 33:
        this.l = (-this.l > this.o) ? this.l : (this.o >> 1);
        this.o = i;
        break;
      case 30:
        this.l = (this.l < this.o) ? this.l : -(this.o >> 1);
        this.o = -i;
        break;
      case 32:
        this.l = (this.l > this.o) ? this.l : -(this.o >> 1);
        this.o = -i;
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
    int k = paramInt1 - this.p - i;
    int m = paramInt2 - this.p - j;
    if (k >= 0) {
      b1 = (byte) k;
      n = 12;
    } else {
      b1 = 0;
      n = this.a + k;
    } 
    if (m >= 0) {
      b2 = (byte) m;
      i1 = 12;
    } else {
      b2 = 0;
      i1 = this.a + m;
    } 
    if (this.a == 16) {
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
    int k = paramInt1 - this.p - i;
    int m = paramInt2 - this.p - j;
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
      n = this.a + k;
    } 
    if (m >= 0) {
      b4 = (byte) m;
      i1 = 12;
    } else {
      b4 = 0;
      i1 = this.a + m;
    } 
    if (this.a == 16) {
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
            b(paramInt5); 
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
    return a(paramInt1 - this.p, paramInt2 - this.p, paramInt1 + this.p - 1, paramInt2 + this.p - 1, i, j, k - 1, m - 1);
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
    return a(paramInt1 - this.p, paramInt2 - this.p, paramInt1 + this.p, paramInt2 + this.p, i, j, k, m);
  }
  
  public boolean OnCollisionEnter(int paramInt1, int paramInt2, int yPos, int xPos) {
    int k;
    if (yPos >= this.mainScene.height || yPos < 0 || xPos >= this.mainScene.width || xPos < 0)
      return false; 
    if (this.z == 2)
      return false; 
    boolean isCollisionBlueGround = true;
    int i = this.mainScene.map[yPos][xPos] & 0x40;
    int j = this.mainScene.map[yPos][xPos] & 0xFFFFFFBF & 0xFFFFFF7F;
    Sound sound = null;
    switch (j) {
      case 1:
    	  // nền đất đỏ
        if (b(paramInt1, paramInt2, yPos, xPos)) {
        	isCollisionBlueGround = false;
          this.u = true;
          break;
        } 
        this.u = true;
        break;
      case 2:
    	  // nền đất xanh full
        if (b(paramInt1, paramInt2, yPos, xPos)) {
          this.v = true;
          isCollisionBlueGround = false;
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
          isCollisionBlueGround = false;
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
        	isCollisionBlueGround = false;
          this.u = true;
        } 
        break;
      case 10:
    	  // Dyn Thorn Axis
        k = this.mainScene.b(xPos, yPos);
        if (k != -1) {
          int m = this.mainScene.P[k][0] * 12 + this.mainScene.w[k][0];
          int n = this.mainScene.P[k][1] * 12 + this.mainScene.w[k][1];
          if (a(paramInt1 - this.p + 1, paramInt2 - this.p + 1, paramInt1 + this.p - 1, paramInt2 + this.p - 1, m + 1, n + 1, m + 24 - 1, n + 24 - 1)) {
        	  isCollisionBlueGround = false;
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
        	isCollisionBlueGround = false;
          e();
        } 
        break;
      case 7:
    	 // checkpoint item
        this.mainScene.addSessionScore(200);
        this.mainScene.map[this.c][this.d] = 128;
        a(xPos, yPos);
        this.mainScene.map[yPos][xPos] = 136;
        sound = this.mainScene.popSFX;
        break;
      case 23:
    	  // Left Big Ring
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (a(paramInt1, paramInt2, yPos, xPos, j)) {
        	  isCollisionBlueGround = false;
            break;
          } 
          OnRingCollisionEnter();
          this.mainScene.map[yPos][xPos] = (short)(0x9B | i);
          this.mainScene.map[yPos][xPos + 1] = (short)(0x9C | i);
          sound = this.mainScene.upSFX;
        } 
        break;
      case 15:
    	// Left Small Ring 
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (this.a == 16) {
        	  isCollisionBlueGround = false;
            break;
          } 
          if (a(paramInt1, paramInt2, yPos, xPos, j))
        	  isCollisionBlueGround = false; 
          OnRingCollisionEnter();
          this.mainScene.map[yPos][xPos] = (short)(0x93 | i);
          this.mainScene.map[yPos][xPos + 1] = (short)(0x94 | i);
          sound = this.mainScene.upSFX;
        } 
        break;
      case 24:
    	// Right Big Ring
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (a(paramInt1, paramInt2, yPos, xPos, j))
        	  isCollisionBlueGround = false; 
          OnRingCollisionEnter();
          this.mainScene.map[yPos][xPos] = (short)(0x9C | i);
          this.mainScene.map[yPos][xPos - 1] = (short)(0x9B | i);
          sound = this.mainScene.upSFX;
        } 
        break;
      case 16:
    	// Right Small Ring 
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (this.a == 16) {
        	  isCollisionBlueGround = false;
            break;
          } 
          if (a(paramInt1, paramInt2, yPos, xPos, j))
        	  isCollisionBlueGround = false; 
          OnRingCollisionEnter();
          this.mainScene.map[yPos][xPos] = (short)(0x94 | i);
          this.mainScene.map[yPos][xPos - 1] = (short)(0x93 | i);
          sound = this.mainScene.upSFX;
        } 
        break;
      case 21:
    	// Top Big Ring
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (a(paramInt1, paramInt2, yPos, xPos, j))
        	  isCollisionBlueGround = false; 
          OnRingCollisionEnter();
          this.mainScene.map[yPos][xPos] = (short)(0x99 | i);
          this.mainScene.map[yPos + 1][xPos] = (short)(0x9A | i);
          sound = this.mainScene.upSFX;
        } 
        break;
      case 13:
    	// Top Small Ring
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (this.a == 16) {
        	  isCollisionBlueGround = false;
            break;
          } 
          if (a(paramInt1, paramInt2, yPos, xPos, j))
        	  isCollisionBlueGround = false; 
          OnRingCollisionEnter();
          this.mainScene.map[yPos][xPos] = (short)(0x91 | i);
          this.mainScene.map[yPos + 1][xPos] = (short)(0x92 | i);
          sound = this.mainScene.upSFX;
        } 
        break;
      case 22:
    	// Bottom Big Ring
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
        	OnRingCollisionEnter();
          this.mainScene.map[yPos][xPos] = (short)(0x9A | i);
          this.mainScene.map[yPos - 1][xPos] = (short)(0x99 | i);
          sound = this.mainScene.upSFX;
        } 
        break;
      case 14:
    	// Bottom Small Ring
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (this.a == 16) {
        	  isCollisionBlueGround = false;
            break;
          } 
          OnRingCollisionEnter();
          this.mainScene.map[yPos][xPos] = (short)(0x92 | i);
          this.mainScene.map[yPos - 1][xPos] = (short)(0x91 | i);
          sound = this.mainScene.upSFX;
        } 
        break;
      case 17:
      case 19:
      case 20:
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (this.a == 16) {
        	  isCollisionBlueGround = false;
            break;
          } 
          if (a(paramInt1, paramInt2, yPos, xPos, j))
        	  isCollisionBlueGround = false; 
        } 
        break;
      case 25:
      case 27:
      case 28:
        if (a(paramInt1, paramInt2, yPos, xPos, j))
        	isCollisionBlueGround = false; 
        break;
      case 18:
        if (b(paramInt1, paramInt2, yPos, xPos, j) && this.a == 16)
        	isCollisionBlueGround = false; 
        break;
      case 9:
    	  // cổng
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
          if (this.mainScene.M) {
            this.mainScene.e = true;
            sound = this.mainScene.popSFX;
            break;
          } 
          isCollisionBlueGround = false;
        } 
        break;
      case 29:
    	  // life item
        this.mainScene.addSessionScore(1000);
        if (this.mainScene.noOfLife < 5) {
          this.mainScene.noOfLife++;
          this.mainScene.y = true;
        } 
        this.mainScene.map[yPos][xPos] = 128;
        sound = this.mainScene.popSFX;
        break;
      case 39:
      case 40:
      case 41:
      case 42:
    	  isCollisionBlueGround = false;
        if (this.a == 16)
          c(); 
        break;
      case 43:
      case 44:
      case 45:
      case 46:
        if (b(paramInt1, paramInt2, yPos, xPos, j)) {
        	isCollisionBlueGround = false;
          if (this.a == 12)
            f(); 
        } 
        break;
      case 47:
      case 48:
      case 49:
      case 50:
        this.g = 300;
        sound = this.mainScene.popSFX;
        this.m = false;
        isCollisionBlueGround = false;
        break;
      case 51:
      case 52:
      case 53:
      case 54:
        this.y = 300;
        sound = this.mainScene.popSFX;
        isCollisionBlueGround = false;
        break;
      case 38:
        this.h = 300;
        sound = this.mainScene.popSFX;
        isCollisionBlueGround = false;
        break;
    } 
    if (sound != null)
      sound.play(1); 
    return isCollisionBlueGround;
  }
  
  public void b() {
    int i = this.s;
    int j = 0;
    int k = 0;
    byte b1 = 0;
    boolean bool1 = false;
    if (this.z == 2) {
      this.q--;
      if (this.q == 0) {
        this.z = 1;
        if (this.mainScene.noOfLife < 0)
          this.mainScene.e = true; 
      } 
      return;
    } 
    int m = this.s / 12;
    int n = this.r / 12;
    boolean bool2 = ((this.mainScene.map[n][m] & 0x40) != 0) ? true : false;
    if (bool2) {
      if (this.a == 16) {
        k = -30;
        j = -2;
        if (this.m)
          this.o = -10; 
      } else {
        k = 42;
        j = 6;
      } 
    } else if (this.a == 16) {
      k = 38;
      j = 3;
    } else {
      k = 80;
      j = 4;
    } 
    if (this.g != 0) {
      bool1 = true;
      k *= -1;
      j *= -1;
      this.g--;
      if (this.g == 0) {
        bool1 = false;
        this.m = false;
        k *= -1;
        j *= -1;
      } 
    } 
    if (this.y != 0) {
      if (-1 * Math.abs(this.t) > -80)
        if (bool1) {
          this.t = 80;
        } else {
          this.t = -80;
        }  
      this.y--;
    } 
    this.C++;
    if (this.C == 3)
      this.C = 0; 
    if (this.o < -150) {
      this.o = -150;
    } else if (this.o > 150) {
      this.o = 150;
    } 
    if (this.l < -150) {
      this.l = -150;
    } else if (this.l > 150) {
      this.l = 150;
    } 
    if (this.o < 10 && this.o > 0 && !bool2 && !bool1)
      this.o = 10; 
    for (byte b2 = 0; b2 < Math.abs(this.o) / 10; b2++) {
      byte b = 0;
      if (this.o != 0)
        b = (byte) ((this.o < 0) ? -1 : 1); 
      if (b(this.s, this.r + b)) {
        this.r += b;
        this.m = false;
        if (k == -30) {
          n = this.r / 12;
          if ((this.mainScene.map[n][m] & 0x40) == 0) {
            this.o >>= 1;
            if (this.o <= 10 && this.o >= -10)
              this.o = 0; 
          } 
        } 
      } else {
        if (this.u && this.l < 10 && this.C == 0) {
          byte b4 = 1;
          if (b(this.s + b4, this.r + b)) {
            this.s += b4;
            this.r += b;
            this.u = false;
          } else if (b(this.s - b4, this.r + b)) {
            this.s -= b4;
            this.r += b;
            this.u = false;
          } 
        } 
        if (b > 0 || (bool1 && b < 0)) {
          this.o = this.o * -1 / 2;
          this.m = true;
          if (this.v && (this.x & 0x8) != 0) {
            this.v = false;
            if (bool1) {
              this.t += 10;
            } else {
              this.t += -10;
            } 
          } else if (this.y == 0) {
            this.t = 0;
          } 
          if (this.o < 10 && this.o > -10) {
            if (bool1) {
              this.o = -10;
              break;
            } 
            this.o = 10;
          } 
          break;
        } 
        if (b < 0 || (bool1 && b > 0))
          if (bool1) {
            this.o = -20;
          } else {
            this.o = -this.o >> 1;
          }  
      } 
    } 
    if (bool1) {
      if (j == -2 && this.o < k) {
        this.o += j;
        if (this.o > k)
          this.o = k; 
      } else if (!this.m && this.o > k) {
        this.o += j;
        if (this.o < k)
          this.o = k; 
      } 
    } else if (j == -2 && this.o > k) {
      this.o += j;
      if (this.o < k)
        this.o = k; 
    } else if (!this.m && this.o < k) {
      this.o += j;
      if (this.o > k)
        this.o = k; 
    } 
    if (this.h != 0) {
      b1 = 100;
      this.h--;
    } else {
      b1 = 50;
    } 
    if ((this.x & 0x2) != 0 && this.l < b1) {
      this.l += 6;
    } else if ((this.x & 0x1) != 0 && this.l > -b1) {
      this.l -= 6;
    } else if (this.l > 0) {
      this.l -= 4;
    } else if (this.l < 0) {
      this.l += 4;
    } 
    if (this.a == 16 && this.y == 0)
      if (bool1) {
        this.t += 5;
      } else {
        this.t += -5;
      }  
    if (this.m && (this.x & 0x8) != 0) {
      if (bool1) {
        this.o = 67 + this.t;
      } else {
        this.o = -67 + this.t;
      } 
      this.m = false;
    } 
    int i1 = Math.abs(this.l);
    int i2 = i1 / 10;
    for (byte b3 = 0; b3 < i2; b3++) {
      byte b = 0;
      if (this.l != 0)
        b = (byte) ((this.l < 0) ? -1 : 1); 
      if (b(this.s + b, this.r)) {
        this.s += b;
      } else if (this.u) {
        this.u = false;
        byte b4 = 0;
        if (bool1) {
          b4 = 1;
        } else {
          b4 = -1;
        } 
        if (b(this.s + b, this.r + b4)) {
          this.s += b;
          this.r += b4;
        } else if (b(this.s + b, this.r - b4)) {
          this.s += b;
          this.r -= b4;
        } else {
          this.l = -(this.l >> 1);
        } 
      } 
    } 
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    return (paramInt1 <= paramInt7 && paramInt2 <= paramInt8 && paramInt5 <= paramInt3 && paramInt6 <= paramInt4);
  }
}
