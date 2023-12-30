package com.nokia.mid.appl.boun;

import com.nokia.mid.sound.Sound;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class MainScene extends b {
  public int ap;
  
  public Image t;
  
  private int n;
  
  
  // âm thanh 
  public Sound upSFX;
  
  public Sound pickupSFX;
  
  public Sound popSFX;
  
  public Game game;
  
  public Player player;
  
  public int noOfRingCollected;
  
  public int noOfLife;
  
  // diem số hiện tại
  public int sessionScore;
  
  public int ad;
  
  public int p;
  
  public boolean e;
  
  public boolean openPortal;
  
  public boolean y;
  
  public final Font font = Font.getFont(32, 0, 8);
  
  public Image F;
  
  public Graphics X = null;
  
  public boolean T;
  
  private boolean isFly = false;
  
  public boolean isInvincibility = false;
  
  private int triggerCheat = 0;
  
  private static final String[] aj = new String[] { "/icons/nokiagames.png", "/icons/bouncesplash.png" };
  
  public boolean isPlaying = true;
  
  private long K = System.currentTimeMillis();
  
  public MainScene(Game parama, int paramInt) {
    super(parama.m);
    this.game = parama;
    this.upSFX = b("/sounds/up.ott");
    this.pickupSFX = b("/sounds/pickup.ott");
    this.popSFX = b("/sounds/pop.ott");
    this.F = Image.createImage(128, 128);
    this.ap = 1;
    try {
      this.t = Image.createImage(aj[this.ap]);
    } catch (IOException iOException) {
      this.t = Image.createImage(1, 1);
    } 
    d();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    this.currentLevel = paramInt1;
    this.noOfRingCollected = 0;
    this.noOfLife = paramInt3;
    this.sessionScore = paramInt2;
    this.e = false;
    this.openPortal = false;
    l();
    this.T = true;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.currentLevel = this.game.B;
    this.noOfRingCollected = this.game.t;
    this.noOfLife = this.game.C;
    this.sessionScore = this.game.G;
    r();
    ReadLevelMap(this.currentLevel);
    k();
    b();
    this.p = 120;
    this.y = true;
    if (this.game.e != this.s && this.game.b != this.S)
      this.map[this.game.b][this.game.e] = (short)(0x8 | this.map[this.game.b][this.game.e] & 0x40); 
    a(paramInt1, paramInt2, this.game.A, this.game.a, this.game.g);
    synchronized (this.player) {
      this.player.a(this.game.e, this.game.b);
      this.player.h = this.game.w;
      this.player.g = this.game.z;
      this.player.y = this.game.n;
      this.T = true;
    } 
  }
  
  private void l() {
    r();
    ReadLevelMap(this.currentLevel);
    this.noOfRingCollected = 0;
    this.p = 120;
    this.y = true;
    a(this.s * 12 + 6, this.S * 12 + 6, this.a, 0, 0);
    this.player.a(this.s, this.S);
    this.T = true;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    this.player = new Player(paramInt1, paramInt2, paramInt3, this);
    this.player.l = paramInt4;
    this.player.o = paramInt5;
    this.l = 0;
    this.k = 0;
    e();
  }
  
  public void e() {
    int i = this.player.s - 64;
    if (i < 0) {
      i = 0;
    } else if (i > this.width * 12 - 156) {
      i = this.width * 12 - 156;
    } 
    this.l = i / 12;
    this.v = this.l * 12 - i;
    this.Z = 156;
    this.G = this.l + 13;
    while (this.player.r - 6 < this.k * 12)
      this.k -= 7; 
    while (this.player.r + 6 > this.k * 12 + 96)
      this.k += 7; 
    f();
  }
  
  public void addSessionScore(int paramInt) {
    this.sessionScore += paramInt;
    this.y = true;
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
    a(this.X, this.player.s, this.player.r, this.player.p, this.v);
    this.X.setClip(0, 0, 128, 128);
    
    if (this.y) {
      this.X.setColor(545706); // 0853AA = xanh dương
      this.X.fillRect(0, 97, 128, 32);
      // vẽ lại số lượng mạng sống còn lại
      for (byte b1 = 0; b1 < this.noOfLife; b1++)
        this.X.drawImage(this.A, 5 + b1 * (this.A.getWidth() - 1), 99, 20);
      
      // vẽ số lượng ring còn lại
      for (byte b2 = 0; b2 < this.totalRingInLevel - this.noOfRingCollected; b2++)
        this.X.drawImage(this.D, 5 + b2 * (this.D.getWidth() - 4), 112, 20); 
     
      // vẽ lại điểm số
      this.X.setColor(16777214); // FFFFFE = trắng
      this.X.setFont(this.font);
      this.X.drawString(ShowScoreZeroPad(this.sessionScore), 64, 100, 20);
      
      if (this.ad != 0) {
        this.X.setColor(16750611);
        this.X.fillRect(1, 128 - 3 * this.ad / 30, 5, 128);
      } 
      this.y = false;
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
      if (this.p != 0) {
        paramGraphics.setColor(16777214);
        paramGraphics.setFont(this.font);
        paramGraphics.drawString(this.levelTitle, 44, 84, 20);
      } 
    } 
  }
  
  public void a(Graphics paramGraphics, int paramInt) {
    if (this.player == null)
      return; 
    int i = this.player.s - this.l * 12;
    int j = this.player.r - this.k * 12;
    if (this.player.z == 2) {
      paramGraphics.drawImage(this.player.k, i - 6 + paramInt, j - 6, 20);
    } else {
      paramGraphics.drawImage(this.player.i, i - this.player.p + paramInt, j - this.player.p, 20);
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
        this.isPlaying = false;
        this.game.Home();
      } else if (this.n > 30) {
        this.t = null;
        Runtime.getRuntime().gc();
        switch (this.ap) {
          case 0:
            this.ap = 1;
            try {
              this.t = Image.createImage(aj[this.ap]);
            } catch (IOException iOException) {
              this.t = Image.createImage(1, 1);
            } 
            repaint();
            break;
          case 1:
            this.ap = -1;
            this.isPlaying = false;
            this.game.Home();
            break;
        } 
        this.n = 0;
      } else {
        this.n++;
      } 
      repaint();
      return;
    } 
    if (this.p != 0)
      this.p--; 
    synchronized (this.player) {
      if (this.player.r - 6 < this.k * 12 || this.player.r + 6 > this.k * 12 + 96) {
        e();
      } else {
        this.player.b();
      } 
      if (this.player.z == 1) {
        if (this.noOfLife < 0) {
          this.game.CompletedLevel();
          j();
          this.game.b(false);
          return;
        } 
        int i = this.player.d;
        int j = this.player.c;
        int k = this.player.b;
        a(this.player.d * 12 + 6, this.player.c * 12 + 6, this.player.b, 0, 0);
        this.player.d = i;
        this.player.c = j;
        this.player.b = k;
      } 
      if (this.B != 0)
        o(); 
      if (this.noOfRingCollected == this.totalRingInLevel)
        this.openPortal = true; 
      if (this.openPortal && this.z && (this.W + 1) * 12 > m() && this.W * 12 < g()) {
        if (this.M) {
          this.z = false;
          this.openPortal = false;
        } else {
          h();
        } 
        this.map[this.u][this.al] = (short)(this.map[this.u][this.al] | 0x80);
        this.map[this.u][this.al + 1] = (short)(this.map[this.u][this.al + 1] | 0x80);
        this.map[this.u + 1][this.al] = (short)(this.map[this.u + 1][this.al] | 0x80);
        this.map[this.u + 1][this.al + 1] = (short)(this.map[this.u + 1][this.al + 1] | 0x80);
      } 
      this.ad = 0;
      if (this.player.h != 0 || this.player.g != 0 || this.player.y != 0) {
        if (this.player.h > this.ad)
          this.ad = this.player.h; 
        if (this.player.g > this.ad)
          this.ad = this.player.g; 
        if (this.player.y > this.ad)
          this.ad = this.player.y; 
        if (this.ad % 30 == 0 || this.ad == 1)
          this.y = true; 
      } 
    } 
    c(this.player.s);
    q();
    repaint();
    if (this.e) {
      this.e = false;
      this.openPortal = false;
      this.isCheatLevel = true;
      this.currentLevel = 1 + this.currentLevel;
      addSessionScore(5000);
      this.game.CompletedLevel();
      if (this.currentLevel > 11) {
        this.game.b(true);
      } else {
        this.isPlaying = false;
        this.game.d();
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
    if (this.player == null)
      return; 
    synchronized (this.player) {
      switch (keyCode) {
        case KEY_NUM1:
          this.isCheatLevel = true;
          if (this.isFly && --this.currentLevel < 1)
            this.currentLevel = 11; 
          break;
        case KEY_NUM3:
          this.isCheatLevel = true;
          if (this.isFly && ++this.currentLevel > 11)
            this.currentLevel = 1; 
          break;
        case KEY_NUM7:
          if (this.triggerCheat == 0 || this.triggerCheat == 2) {
            this.triggerCheat++;
            break;
          } 
          this.triggerCheat = 0;
          break;
        case KEY_NUM8:
          if (this.triggerCheat == 1 || this.triggerCheat == 3) {
            this.triggerCheat++;
            break;
          } 
          if (this.triggerCheat == 5) {
            this.upSFX.play(1);
            this.isInvincibility = true;
            this.triggerCheat = 0;
            break;
          } 
          this.triggerCheat = 0;
          break;
        case KEY_NUM9:
          if (this.triggerCheat == 4) {
            this.triggerCheat++;
            break;
          } 
          if (this.triggerCheat == 5) {
            this.popSFX.play(1);
            this.isFly = true;
            this.triggerCheat = 0;
            break;
          } 
          this.triggerCheat = 0;
          break;
        case KEY_POUND:
          if (this.isFly)
            this.player.g = 300; 
          break;
        case -7:
        case -6:
          this.isPlaying = false;
          this.game.Home();
          break;
        default:
          switch (getGameAction(keyCode)) {
            case UP:
              this.player.move(8);
              break;
            case DOWN:
              this.player.move(4);
              break;
            case LEFT:
              this.player.move(1);
              break;
            case RIGHT:
              this.player.move(2);
              break;
            case FIRE:
              if (this.isInvincibility)
                this.e = true; 
              break;
          } 
          break;
      } 
    } 
  }
  
  public void keyReleased(int keyCode) {
    if (this.player == null)
      return; 
    synchronized (this.player) {
      switch (getGameAction(keyCode)) {
        case 1:
          this.player.a(8);
          break;
        case 6:
          this.player.a(4);
          break;
        case 2:
          this.player.a(1);
          break;
        case 5:
          this.player.a(2);
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
    if (this.isPlaying) {
      if (this.player != null)
        this.player.a(); 
      this.game.Home();
    } 
    this.isPlaying = true;
  }
  
  public void b() {
    for (byte b1 = 0; b1 < this.game.r; b1++) {
      this.ae[b1][0] = this.game.l[b1][0];
      this.ae[b1][1] = this.game.l[b1][1];
      this.w[b1][0] = this.game.D[b1][0];
      this.w[b1][1] = this.game.D[b1][1];
    } 
    this.game.D = null;
    this.game.l = null;
    this.game.r = 0;
  }
  
  public void k() {
    for (byte b1 = 0; b1 < this.height; b1++) {
      for (byte b2 = 0; b2 < this.width; b2++) {
        byte b3 = (byte)(this.map[b1][b2] & 0xFF7F & 0xFFFFFFBF);
        switch (b3) {
          case 7:
          case 29:
            if (a(b1, b2, b3))
              this.map[b1][b2] = (short)(0x0 | this.map[b1][b2] & 0x40); 
            break;
          case 13:
            if (a(b1, b2, b3))
              this.map[b1][b2] = (short)(0x11 | this.map[b1][b2] & 0x40); 
            break;
          case 14:
            if (a(b1, b2, b3))
              this.map[b1][b2] = (short)(0x12 | this.map[b1][b2] & 0x40); 
            break;
          case 21:
            if (a(b1, b2, b3))
              this.map[b1][b2] = (short)(0x19 | this.map[b1][b2] & 0x40); 
            break;
          case 22:
            if (a(b1, b2, b3))
              this.map[b1][b2] = (short)(0x1A | this.map[b1][b2] & 0x40); 
            break;
          case 15:
            if (a(b1, b2, b3))
              this.map[b1][b2] = (short)(0x13 | this.map[b1][b2] & 0x40); 
            break;
          case 16:
            if (a(b1, b2, b3))
              this.map[b1][b2] = (short)(0x14 | this.map[b1][b2] & 0x40); 
            break;
          case 23:
            if (a(b1, b2, b3))
              this.map[b1][b2] = (short)(0x1B | this.map[b1][b2] & 0x40); 
            break;
          case 24:
            if (a(b1, b2, b3))
              this.map[b1][b2] = (short)(0x1C | this.map[b1][b2] & 0x40); 
            break;
        } 
      } 
    } 
    this.game.u = null;
    this.game.p = 0;
  }
  
  public boolean a(int paramInt1, int paramInt2, byte paramByte) {
    for (byte b1 = 0; b1 < this.game.p; b1++) {
      if (this.game.u[b1][0] == paramInt1 && this.game.u[b1][1] == paramInt2)
        return false; 
    } 
    return true;
  }
}
