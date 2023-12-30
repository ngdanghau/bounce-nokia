package com.nokia.mid.appl.boun;

import com.nokia.mid.sound.Sound;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class BounceCanvas extends TileCanvas {
  public int ap;
  
  public Image t;
  
  private int n;
  
  
  // âm thanh 
  public Sound mSoundHoop;
  
  public Sound mSoundPickup;
  
  public Sound mSoundPop;
  
  public BounceUI mUI;
  
  public Ball mBall;
  
  public int numRings;
  
  public int numLives;
  
  // diem số hiện tại
  public int mScore;
  
  public int bonusCntrValue;
  
  public int mLevelDisCntr;
  
  public boolean mLeaveGame;
  
  public boolean mOpenExitFlag;
  
  public boolean mPaintUIFlag;
  
  public final Font font = Font.getFont(32, 0, 8);
  
  public Image F;
  
  public Graphics X = null;
  
  public boolean T;
  
  private boolean mCheat = false;
  
  public boolean mInvincible = false;
  
  private int mCheatSeq = 0;
  
  private static final String[] SPLASH_NAME = new String[] { "/icons/nokiagames.png", "/icons/bouncesplash.png" };
  
  public boolean mIncomingCall = true;
  
  private long mLastTimeRepainted = System.currentTimeMillis();
  
  public BounceCanvas(BounceUI parama, int paramInt) {
    super(parama.m);
    this.mUI = parama;
    this.mSoundHoop = b("/sounds/up.ott");
    this.mSoundPickup = b("/sounds/pickup.ott");
    this.mSoundPop = b("/sounds/pop.ott");
    this.F = Image.createImage(128, 128);
    this.ap = 1;
    try {
      this.t = Image.createImage(SPLASH_NAME[this.ap]);
    } catch (IOException iOException) {
      this.t = Image.createImage(1, 1);
    } 
    d();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    this.currentLevel = paramInt1;
    this.numRings = 0;
    this.numLives = paramInt3;
    this.mScore = paramInt2;
    this.mLeaveGame = false;
    this.mOpenExitFlag = false;
    l();
    this.T = true;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.currentLevel = this.mUI.B;
    this.numRings = this.mUI.t;
    this.numLives = this.mUI.C;
    this.mScore = this.mUI.G;
    r();
    ReadLevelMap(this.currentLevel);
    k();
    b();
    this.mLevelDisCntr = 120;
    this.mPaintUIFlag = true;
    if (this.mUI.e != this.s && this.mUI.b != this.S)
      this.tileMap[this.mUI.b][this.mUI.e] = (short)(0x8 | this.tileMap[this.mUI.b][this.mUI.e] & 0x40); 
    a(paramInt1, paramInt2, this.mUI.A, this.mUI.a, this.mUI.g);
    synchronized (this.mBall) {
      this.mBall.a(this.mUI.e, this.mUI.b);
      this.mBall.h = this.mUI.w;
      this.mBall.g = this.mUI.z;
      this.mBall.y = this.mUI.n;
      this.T = true;
    } 
  }
  
  private void l() {
    r();
    ReadLevelMap(this.currentLevel);
    this.numRings = 0;
    this.mLevelDisCntr = 120;
    this.mPaintUIFlag = true;
    a(this.s * 12 + 6, this.S * 12 + 6, this.a, 0, 0);
    this.mBall.a(this.s, this.S);
    this.T = true;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    this.mBall = new Ball(paramInt1, paramInt2, paramInt3, this);
    this.mBall.xSpeed = paramInt4;
    this.mBall.ySpeed = paramInt5;
    this.l = 0;
    this.k = 0;
    e();
  }
  
  public void e() {
    int i = this.mBall.xPos - 64;
    if (i < 0) {
      i = 0;
    } else if (i > this.width * 12 - 156) {
      i = this.width * 12 - 156;
    } 
    this.l = i / 12;
    this.v = this.l * 12 - i;
    this.Z = 156;
    this.G = this.l + 13;
    while (this.mBall.yPos - 6 < this.k * 12)
      this.k -= 7; 
    while (this.mBall.yPos + 6 > this.k * 12 + 96)
      this.k += 7; 
    f();
  }
  
  public void add2Score(int paramInt) {
    this.mScore += paramInt;
    this.mPaintUIFlag = true;
  }
  
  public void q() {
    if (this.X == null)
      this.X = this.F.getGraphics(); 
    this.X.setClip(0, 0, 128, 96);
    if (this.E != null) {
      i();
      if (this.v <= 0) {
        this.X.drawImage(this.E, this.v, 0, 20);
      } else {
        this.X.drawImage(this.E, this.v, 0, 20);
        this.X.drawImage(this.E, this.v - 156, 0, 20);
      }
    } 
    a(this.X, this.v);
    a(this.X, this.mBall.xPos, this.mBall.yPos, this.mBall.mHalfBallSize, this.v);
    this.X.setClip(0, 0, 128, 128);
    
    if (this.mPaintUIFlag) {
      this.X.setColor(545706); // 0853AA = xanh dương
      this.X.fillRect(0, 97, 128, 32);
      // vẽ lại số lượng mạng sống còn lại
      for (byte b1 = 0; b1 < this.numLives; b1++)
        this.X.drawImage(this.A, 5 + b1 * (this.A.getWidth() - 1), 99, 20);
      
      // vẽ số lượng ring còn lại
      for (byte b2 = 0; b2 < this.totalRingInLevel - this.numRings; b2++)
        this.X.drawImage(this.D, 5 + b2 * (this.D.getWidth() - 4), 112, 20); 
     
      // vẽ lại điểm số
      this.X.setColor(16777214); // FFFFFE = trắng
      this.X.setFont(this.font);
      this.X.drawString(ShowScoreZeroPad(this.mScore), 64, 100, 20);
      
      if (this.bonusCntrValue != 0) {
        this.X.setColor(16750611);
        this.X.fillRect(1, 128 - 3 * this.bonusCntrValue / 30, 5, 128);
      } 
      this.mPaintUIFlag = false;
    } 
  }
  
  public void paint(Graphics paramGraphics) {
    if (this.ap != -1) {
      if (this.t != null) {
        paramGraphics.setColor(0);
        paramGraphics.fillRect(0, 0, this.ag, this.am);
        paramGraphics.drawImage(this.t, this.ag >> 1, this.am >> 1, 3);
      } 
    } else {
      paramGraphics.drawImage(this.F, 0, 0, 20);
      if (this.mLevelDisCntr != 0) {
        paramGraphics.setColor(16777214);
        paramGraphics.setFont(this.font);
        paramGraphics.drawString(this.levelTitle, 44, 84, 20);
      } 
    } 
  }
  
  public void a(Graphics paramGraphics, int paramInt) {
    if (this.mBall == null)
      return; 
    int i = this.mBall.xPos - this.l * 12;
    int j = this.mBall.yPos - this.k * 12;
    if (this.mBall.z == 2) {
      paramGraphics.drawImage(this.mBall.k, i - 6 + paramInt, j - 6, 20);
    } else {
      paramGraphics.drawImage(this.mBall.i, i - this.mBall.mHalfBallSize + paramInt, j - this.mBall.mHalfBallSize, 20);
    } 
  }
  
  public void a() {
    if (this.isCheatLevel) {
      l();
      repaint();
      return;
    } 
    if (this.ap != -1) {
      if (this.t == null || this.t == null) {
        this.mIncomingCall = false;
        this.mUI.displayMainMenu();
      } else if (this.n > 30) {
        this.t = null;
        Runtime.getRuntime().gc();
        switch (this.ap) {
          case 0:
            this.ap = 1;
            try {
              this.t = Image.createImage(SPLASH_NAME[this.ap]);
            } catch (IOException iOException) {
              this.t = Image.createImage(1, 1);
            } 
            repaint();
            break;
          case 1:
            this.ap = -1;
            this.mIncomingCall = false;
            this.mUI.displayMainMenu();
            break;
        } 
        this.n = 0;
      } else {
        this.n++;
      } 
      repaint();
      return;
    } 
    if (this.mLevelDisCntr != 0)
      this.mLevelDisCntr--; 
    synchronized (this.mBall) {
      if (this.mBall.yPos - 6 < this.k * 12 || this.mBall.yPos + 6 > this.k * 12 + 96) {
        e();
      } else {
        this.mBall.b();
      } 
      if (this.mBall.z == 1) {
        if (this.numLives < 0) {
          this.mUI.CompletedLevel();
          stop();
          this.mUI.b(false);
          return;
        } 
        int i = this.mBall.d;
        int j = this.mBall.c;
        int k = this.mBall.b;
        a(this.mBall.d * 12 + 6, this.mBall.c * 12 + 6, this.mBall.b, 0, 0);
        this.mBall.d = i;
        this.mBall.c = j;
        this.mBall.b = k;
      } 
      if (this.B != 0)
        o(); 
      if (this.numRings == this.totalRingInLevel)
        this.mOpenExitFlag = true; 
      if (this.mOpenExitFlag && this.z && (this.W + 1) * 12 > m() && this.W * 12 < g()) {
        if (this.mOpenFlag) {
          this.z = false;
          this.mOpenExitFlag = false;
        } else {
          h();
        } 
        this.tileMap[this.u][this.al] = (short)(this.tileMap[this.u][this.al] | 0x80);
        this.tileMap[this.u][this.al + 1] = (short)(this.tileMap[this.u][this.al + 1] | 0x80);
        this.tileMap[this.u + 1][this.al] = (short)(this.tileMap[this.u + 1][this.al] | 0x80);
        this.tileMap[this.u + 1][this.al + 1] = (short)(this.tileMap[this.u + 1][this.al + 1] | 0x80);
      } 
      this.bonusCntrValue = 0;
      if (this.mBall.h != 0 || this.mBall.g != 0 || this.mBall.y != 0) {
        if (this.mBall.h > this.bonusCntrValue)
          this.bonusCntrValue = this.mBall.h; 
        if (this.mBall.g > this.bonusCntrValue)
          this.bonusCntrValue = this.mBall.g; 
        if (this.mBall.y > this.bonusCntrValue)
          this.bonusCntrValue = this.mBall.y; 
        if (this.bonusCntrValue % 30 == 0 || this.bonusCntrValue == 1)
          this.mPaintUIFlag = true; 
      } 
    } 
    c(this.mBall.xPos);
    q();
    repaint();
    if (this.mLeaveGame) {
      this.mLeaveGame = false;
      this.mOpenExitFlag = false;
      this.isCheatLevel = true;
      this.currentLevel = 1 + this.currentLevel;
      add2Score(5000);
      this.mUI.CompletedLevel();
      if (this.currentLevel > 11) {
        this.mUI.b(true);
      } else {
        this.mIncomingCall = false;
        this.mUI.d();
        repaint();
      } 
    } 
  }
  
  // hàm chính nè
  public void keyPressed(int keyCode) {
    if (this.ap != -1) {
      this.n = 31;
      return;
    } 
    if (this.mBall == null)
      return; 
    synchronized (this.mBall) {
      switch (keyCode) {
        case KEY_NUM1:
          this.isCheatLevel = true;
          if (this.mCheat && --this.currentLevel < 1)
            this.currentLevel = 11; 
          break;
        case KEY_NUM3:
          this.isCheatLevel = true;
          if (this.mCheat && ++this.currentLevel > 11)
            this.currentLevel = 1; 
          break;
        case KEY_NUM7:
          if (this.mCheatSeq == 0 || this.mCheatSeq == 2) {
            this.mCheatSeq++;
            break;
          } 
          this.mCheatSeq = 0;
          break;
        case KEY_NUM8:
          if (this.mCheatSeq == 1 || this.mCheatSeq == 3) {
            this.mCheatSeq++;
            break;
          } 
          if (this.mCheatSeq == 5) {
            this.mSoundHoop.play(1);
            this.mInvincible = true;
            this.mCheatSeq = 0;
            break;
          } 
          this.mCheatSeq = 0;
          break;
        case KEY_NUM9:
          if (this.mCheatSeq == 4) {
            this.mCheatSeq++;
            break;
          } 
          if (this.mCheatSeq == 5) {
            this.mSoundPop.play(1);
            this.mCheat = true;
            this.mCheatSeq = 0;
            break;
          } 
          this.mCheatSeq = 0;
          break;
        case KEY_POUND:
          if (this.mCheat)
            this.mBall.g = 300; 
          break;
        case -7:
        case -6:
          this.mIncomingCall = false;
          this.mUI.displayMainMenu();
          break;
        default:
          switch (getGameAction(keyCode)) {
            case UP:
              this.mBall.move(8);
              break;
            case DOWN:
              this.mBall.move(4);
              break;
            case LEFT:
              this.mBall.move(1);
              break;
            case RIGHT:
              this.mBall.move(2);
              break;
            case FIRE:
              if (this.mInvincible)
                this.mLeaveGame = true; 
              break;
          } 
          break;
      } 
    } 
  }
  
  public void keyReleased(int keyCode) {
    if (this.mBall == null)
      return; 
    synchronized (this.mBall) {
      switch (getGameAction(keyCode)) {
        case 1:
          this.mBall.a(8);
          break;
        case 6:
          this.mBall.a(4);
          break;
        case 2:
          this.mBall.a(1);
          break;
        case 5:
          this.mBall.a(2);
          break;
      } 
    } 
  }
  
  public static String ShowScoreZeroPad(int paramInt) {
    String str;
    if (paramInt < 100) {
      str = "0000000";
    } else if (paramInt < 1000) {
      str = "00000";
    } else if (paramInt < 10000) {
      str = "0000";
    } else if (paramInt < 100000) {
      str = "000";
    } else if (paramInt < 1000000) {
      str = "00";
    } else if (paramInt < 10000000) {
      str = "0";
    } else {
      str = "";
    } 
    return str + paramInt;
  }
  
  protected Sound b(String paramString) {
    byte[] arrayOfByte = new byte[100];
    Sound sound = null;
    DataInputStream dataInputStream = new DataInputStream(getClass().getResourceAsStream(paramString));
    try {
      int i = dataInputStream.read(arrayOfByte);
      dataInputStream.close();
      byte[] arrayOfByte1 = new byte[i];
      System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, i);
      sound = new Sound(arrayOfByte1, 1);
    } catch (IOException iOException) {
      sound = new Sound(1000, 500L);
      sound.play(3);
    } 
    return sound;
  }
  
  public void hideNotify() {
    if (this.mIncomingCall) {
      if (this.mBall != null)
        this.mBall.a(); 
      this.mUI.displayMainMenu();
    } 
    this.mIncomingCall = true;
  }
  
  public void b() {
    for (byte b1 = 0; b1 < this.mUI.r; b1++) {
      this.ae[b1][0] = this.mUI.l[b1][0];
      this.ae[b1][1] = this.mUI.l[b1][1];
      this.w[b1][0] = this.mUI.D[b1][0];
      this.w[b1][1] = this.mUI.D[b1][1];
    } 
    this.mUI.D = null;
    this.mUI.l = null;
    this.mUI.r = 0;
  }
  
  public void k() {
    for (byte b1 = 0; b1 < this.height; b1++) {
      for (byte b2 = 0; b2 < this.width; b2++) {
        byte b3 = (byte)(this.tileMap[b1][b2] & 0xFF7F & 0xFFFFFFBF);
        switch (b3) {
          case 7:
          case 29:
            if (a(b1, b2, b3))
              this.tileMap[b1][b2] = (short)(0x0 | this.tileMap[b1][b2] & 0x40); 
            break;
          case 13:
            if (a(b1, b2, b3))
              this.tileMap[b1][b2] = (short)(0x11 | this.tileMap[b1][b2] & 0x40); 
            break;
          case 14:
            if (a(b1, b2, b3))
              this.tileMap[b1][b2] = (short)(0x12 | this.tileMap[b1][b2] & 0x40); 
            break;
          case 21:
            if (a(b1, b2, b3))
              this.tileMap[b1][b2] = (short)(0x19 | this.tileMap[b1][b2] & 0x40); 
            break;
          case 22:
            if (a(b1, b2, b3))
              this.tileMap[b1][b2] = (short)(0x1A | this.tileMap[b1][b2] & 0x40); 
            break;
          case 15:
            if (a(b1, b2, b3))
              this.tileMap[b1][b2] = (short)(0x13 | this.tileMap[b1][b2] & 0x40); 
            break;
          case 16:
            if (a(b1, b2, b3))
              this.tileMap[b1][b2] = (short)(0x14 | this.tileMap[b1][b2] & 0x40); 
            break;
          case 23:
            if (a(b1, b2, b3))
              this.tileMap[b1][b2] = (short)(0x1B | this.tileMap[b1][b2] & 0x40); 
            break;
          case 24:
            if (a(b1, b2, b3))
              this.tileMap[b1][b2] = (short)(0x1C | this.tileMap[b1][b2] & 0x40); 
            break;
        } 
      } 
    } 
    this.mUI.u = null;
    this.mUI.p = 0;
  }
  
  public boolean a(int paramInt1, int paramInt2, byte paramByte) {
    for (byte b1 = 0; b1 < this.mUI.p; b1++) {
      if (this.mUI.u[b1][0] == paramInt1 && this.mUI.u[b1][1] == paramInt2)
        return false; 
    } 
    return true;
  }
}
