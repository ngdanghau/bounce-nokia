package com.nokia.mid.appl.boun;

import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import com.nokia.mid.ui.FullCanvas;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public abstract class TileCanvas extends FullCanvas {
  protected int l;
  
  protected int k;
  
  protected int G;
  
  protected int Z;
  
  protected int v;
  
  protected boolean z;
  
  protected Image E;
  
  private Image[] Q;
  
  private Image I;
  
  private Graphics J;
  
  public int currentLevel = -1;
  
  public String levelTitle;
  
  public String levelCompletedText;
  
  public boolean isCheatLevel;
  
  protected int s;
  
  protected int S;
  
  public int a;
  
  protected int W;
  
  protected int V;
  
  public short[][] map;
  
  public int width;
  
  public int height;
  
  public int totalRingInLevel;
  
  public int B;
  
  public short[][] P;
  
  public short[][] O;
  
  public short[][] ae;
  
  public short[][] w;
  
  public Image[] r;
  
  public Graphics[] an;
  
  public Image L;
  
  public Image A;
  
  public Image D;
  
  public int al;
  
  public int u;
  
  public Image aa;
  
  public Image o;
  
  public int b;
  
  public boolean M;
  
  protected int ag = 0;
  
  protected int am = 0;
  
  protected Display m;
  
  public com.nokia.mid.appl.boun.g ab = null;
  
  public TileCanvas(Display paramDisplay) {
    this.m = paramDisplay;
    this.ag = getWidth();
    this.am = getHeight();
    this.v = 0;
    this.Z = 156;
    this.E = Image.createImage(156, 96);
    this.I = Image.createImage(12, 12);
    this.J = this.I.getGraphics();
    c();
    this.isCheatLevel = false;
    this.l = 0;
    this.k = 0;
    this.z = false;
    this.G = this.l + 13;
    this.map = null;
  }
  
  public void ReadLevelMap(int paramInt) {
    InputStream inputStream = null;
    DataInputStream dataInputStream = null;
    this.isCheatLevel = false;
    String str = "";
    String[] arrayOfString = new String[1];
    arrayOfString[0] = (new Integer(this.currentLevel)).toString();
    this.levelTitle = com.nokia.mid.appl.boun.c.a(9, arrayOfString); // Level {}
    this.levelCompletedText = com.nokia.mid.appl.boun.c.a(10, arrayOfString); // Level {} completed!
    arrayOfString[0] = null;
    arrayOfString = null;
    if (paramInt < 10) {
      str = "00" + paramInt;
    } else if (paramInt < 100) {
      str = "0" + paramInt;
    } 
    try {
      inputStream = getClass().getResourceAsStream("/levels/J2MElvl." + str);
      dataInputStream = new DataInputStream(inputStream);
      this.s = dataInputStream.read();
      this.S = dataInputStream.read();
      int i = dataInputStream.read();
      if (i == 0) {
        this.a = 12;
      } else {
        this.a = 16;
      } 
      this.W = dataInputStream.read();
      this.V = dataInputStream.read();
      a(this.W, this.V, this.Q[12]);
      this.totalRingInLevel = dataInputStream.read();
      this.width = dataInputStream.read();
      this.height = dataInputStream.read();
      this.map = new short[this.height][this.width];
      for (byte b1 = 0; b1 < this.height; b1++) {
        for (byte b2 = 0; b2 < this.width; b2++)
          this.map[b1][b2] = (short)dataInputStream.read(); 
      } 
      this.B = dataInputStream.read();
      if (this.B != 0)
        a(dataInputStream); 
      dataInputStream.close();
    } catch (IOException iOException) {}
  }
  
  public static Image a(Image paramImage, int paramInt) {
    Image image = DirectUtils.createImage(paramImage.getWidth(), paramImage.getHeight(), 0);
    if (image == null)
      image = Image.createImage(paramImage.getWidth(), paramImage.getHeight()); 
    Graphics graphics = image.getGraphics();
    DirectGraphics directGraphics = DirectUtils.getDirectGraphics(graphics);
    switch (paramInt) {
      case 0:
        directGraphics.drawImage(paramImage, 0, 0, 20, 8192);
        return image;
      case 1:
        directGraphics.drawImage(paramImage, 0, 0, 20, 16384);
        return image;
      case 2:
        directGraphics.drawImage(paramImage, 0, 0, 20, 24576);
        return image;
      case 3:
        directGraphics.drawImage(paramImage, 0, 0, 20, 90);
        return image;
      case 4:
        directGraphics.drawImage(paramImage, 0, 0, 20, 180);
        return image;
      case 5:
        directGraphics.drawImage(paramImage, 0, 0, 20, 270);
        return image;
    } 
    graphics.drawImage(paramImage, 0, 0, 20);
    return image;
  }
  
  public void a(DataInputStream paramDataInputStream) throws IOException {
    this.P = new short[this.B][2];
    this.O = new short[this.B][2];
    this.ae = new short[this.B][2];
    this.w = new short[this.B][2];
    this.r = new Image[this.B];
    this.an = new Graphics[this.B];
    for (byte b1 = 0; b1 < this.B; b1++) {
      this.P[b1][0] = (short)paramDataInputStream.read();
      this.P[b1][1] = (short)paramDataInputStream.read();
      this.O[b1][0] = (short)paramDataInputStream.read();
      this.O[b1][1] = (short)paramDataInputStream.read();
      this.ae[b1][0] = (short)paramDataInputStream.read();
      this.ae[b1][1] = (short)paramDataInputStream.read();
      int i = paramDataInputStream.read();
      int j = paramDataInputStream.read();
      this.w[b1][0] = (short)i;
      this.w[b1][1] = (short)j;
    } 
    this.L = Image.createImage(24, 24);
    Graphics graphics = this.L.getGraphics();
    graphics.drawImage(this.Q[46], 0, 0, 20);
    graphics.drawImage(a(this.Q[46], 0), 12, 0, 20);
    graphics.drawImage(a(this.Q[46], 4), 12, 12, 20);
    graphics.drawImage(a(this.Q[46], 1), 0, 12, 20);
    graphics = null;
  }
  
  public void r() {
    for (byte b1 = 0; b1 < this.B; b1++) {
      this.r[b1] = null;
      this.an[b1] = null;
    } 
    this.r = null;
    this.an = null;
    this.map = null;
    Runtime.getRuntime().gc();
  }
  
  public void o() {
    for (byte b1 = 0; b1 < this.B; b1++) {
      short s1 = this.P[b1][0];
      short s2 = this.P[b1][1];
      short s3 = this.w[b1][0];
      short s4 = this.w[b1][1];
      this.w[b1][0] = (short)(this.w[b1][0] + this.ae[b1][0]);
      int n = (this.O[b1][0] - s1 - 2) * 12;
      int i1 = (this.O[b1][1] - s2 - 2) * 12;
      if (this.w[b1][0] < 0) {
        this.w[b1][0] = 0;
      } else if (this.w[b1][0] > n) {
        this.w[b1][0] = (short)n;
      } 
      if (this.w[b1][0] == 0 || this.w[b1][0] == n)
        this.ae[b1][0] = (short)-this.ae[b1][0]; 
      this.w[b1][1] = (short)(this.w[b1][1] + this.ae[b1][1]);
      if (this.w[b1][1] < 0) {
        this.w[b1][1] = 0;
      } else if (this.w[b1][1] > i1) {
        this.w[b1][1] = (short)i1;
      } 
      if (this.w[b1][1] == 0 || this.w[b1][1] == i1)
        this.ae[b1][1] = (short)(this.ae[b1][1] * -1); 
      short s5 = this.w[b1][0];
      short s6 = this.w[b1][1];
      if (s5 < s3) {
        short s = s5;
        s5 = s3;
        s3 = s;
      } 
      if (s6 < s4) {
        short s = s6;
        s6 = s4;
        s4 = s;
      } 
      s5 += 23;
      s6 += 23;
      int i = s3 / 12;
      int j = s4 / 12;
      int k = s5 / 12 + 1;
      int m = s6 / 12 + 1;
      for (int i2 = i; i2 < k; i2++) {
        for (int i3 = j; i3 < m; i3++)
          this.map[s2 + i3][s1 + i2] = (short)(this.map[s2 + i3][s1 + i2] | 0x80); 
      } 
    } 
  }
  
  public int b(int paramInt1, int paramInt2) {
    for (byte b1 = 0; b1 < this.B; b1++) {
      if (this.P[b1][0] <= paramInt1 && this.O[b1][0] > paramInt1 && this.P[b1][1] <= paramInt2 && this.O[b1][1] > paramInt2)
        return b1; 
    } 
    return -1;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int j;
    int k;
    Graphics graphics = this.E.getGraphics();
    if (paramInt1 < 0 || paramInt2 < 0 || paramInt1 >= this.width || paramInt2 >= this.height) {
      graphics.drawImage(this.Q[0], paramInt3, paramInt4, 20);
      return;
    } 
    this.map[paramInt2][paramInt1] = (short)(this.map[paramInt2][paramInt1] & 0xFF7F);
    int i = this.map[paramInt2][paramInt1];
    boolean bool = ((i & 0x40) != 0) ? true : false;
    if (bool)
      i = i & 0xFFFFFFBF; 
    graphics.setColor(bool ? 1073328 : 11591920);
    switch (i) {
      case 1:
        graphics.drawImage(this.Q[0], paramInt3, paramInt4, 20);
        break;
      case 0:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        break;
      case 2:
        graphics.drawImage(this.Q[1], paramInt3, paramInt4, 20);
        break;
      case 3:
        if (bool) {
          graphics.drawImage(this.Q[6], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.Q[2], paramInt3, paramInt4, 20);
        break;
      case 4:
        if (bool) {
          graphics.drawImage(this.Q[9], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.Q[5], paramInt3, paramInt4, 20);
        break;
      case 5:
        if (bool) {
          graphics.drawImage(this.Q[7], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.Q[3], paramInt3, paramInt4, 20);
        break;
      case 6:
        if (bool) {
          graphics.drawImage(this.Q[8], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.Q[4], paramInt3, paramInt4, 20);
        break;
      case 7:
        graphics.drawImage(this.Q[10], paramInt3, paramInt4, 20);
        break;
      case 8:
        graphics.drawImage(this.Q[11], paramInt3, paramInt4, 20);
        break;
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.Q[com.nokia.mid.appl.boun.d.a[i - 13]], paramInt3, paramInt4, 20);
        graphics.drawImage(this.Q[com.nokia.mid.appl.boun.d.b[i - 13]], paramInt3, paramInt4, 20);
        break;
      case 9:
        j = (paramInt1 - this.al) * 12;
        k = (paramInt2 - this.u) * 12;
        graphics.setClip(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.aa, paramInt3 - j, paramInt4 - k, 20);
        graphics.setClip(0, 0, this.E.getWidth(), this.E.getHeight());
        this.z = true;
        break;
      case 10:
        j = b(paramInt1, paramInt2);
        if (j != -1) {
          k = (paramInt1 - this.P[j][0]) * 12;
          int m = (paramInt2 - this.P[j][1]) * 12;
          int n = this.w[j][0] - k;
          int i1 = this.w[j][1] - m;
          if ((n > -36 && n < 12) || (i1 > -36 && i1 < 12)) {
            this.J.setColor(11591920);
            this.J.fillRect(0, 0, 12, 12);
            this.J.drawImage(this.L, n, i1, 20);
            graphics.drawImage(this.I, paramInt3, paramInt4, 20);
            break;
          } 
          graphics.setColor(11591920);
          graphics.fillRect(paramInt3, paramInt4, 12, 12);
        } 
        break;
      case 29:
        graphics.drawImage(this.Q[45], paramInt3, paramInt4, 20);
        break;
      case 30:
        if (bool) {
          graphics.drawImage(this.Q[61], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.Q[57], paramInt3, paramInt4, 20);
        break;
      case 31:
        if (bool) {
          graphics.drawImage(this.Q[60], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.Q[56], paramInt3, paramInt4, 20);
        break;
      case 32:
        if (bool) {
          graphics.drawImage(this.Q[59], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.Q[55], paramInt3, paramInt4, 20);
        break;
      case 33:
        if (bool) {
          graphics.drawImage(this.Q[62], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.Q[58], paramInt3, paramInt4, 20);
        break;
      case 34:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.Q[65], paramInt3, paramInt4, 20);
        break;
      case 35:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.Q[64], paramInt3, paramInt4, 20);
        break;
      case 36:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.Q[63], paramInt3, paramInt4, 20);
        break;
      case 37:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.Q[66], paramInt3, paramInt4, 20);
        break;
      case 39:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.Q[50], paramInt3, paramInt4, 20);
        break;
      case 40:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(a(this.Q[50], 5), paramInt3, paramInt4, 20);
        break;
      case 41:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(a(this.Q[50], 4), paramInt3, paramInt4, 20);
        break;
      case 42:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(a(this.Q[50], 3), paramInt3, paramInt4, 20);
        break;
      case 43:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.Q[51], paramInt3, paramInt4, 20);
        break;
      case 44:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(a(this.Q[51], 5), paramInt3, paramInt4, 20);
        break;
      case 45:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(a(this.Q[51], 4), paramInt3, paramInt4, 20);
        break;
      case 46:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(a(this.Q[51], 3), paramInt3, paramInt4, 20);
        break;
      case 47:
        graphics.drawImage(this.Q[52], paramInt3, paramInt4, 20);
        break;
      case 48:
        graphics.drawImage(a(this.Q[52], 5), paramInt3, paramInt4, 20);
        break;
      case 49:
        graphics.drawImage(a(this.Q[52], 4), paramInt3, paramInt4, 20);
        break;
      case 50:
        graphics.drawImage(a(this.Q[52], 3), paramInt3, paramInt4, 20);
        break;
      case 38:
        graphics.drawImage(this.Q[53], paramInt3, paramInt4, 20);
        break;
      case 51:
        graphics.drawImage(this.Q[54], paramInt3, paramInt4, 20);
        break;
      case 52:
        graphics.drawImage(a(this.Q[54], 5), paramInt3, paramInt4, 20);
        break;
      case 53:
        graphics.drawImage(a(this.Q[54], 4), paramInt3, paramInt4, 20);
        break;
      case 54:
        graphics.drawImage(a(this.Q[54], 3), paramInt3, paramInt4, 20);
        break;
    } 
  }
  
  public void a(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = (paramInt1 - paramInt3) / 12;
    int j = (paramInt2 - paramInt3) / 12;
    int k = (paramInt1 + paramInt3 - 1) / 12 + 1;
    int m = (paramInt2 + paramInt3 - 1) / 12 + 1;
    if (i < 0)
      i = 0; 
    if (j < 0)
      j = 0; 
    if (k > this.width)
      k = this.width; 
    if (m > this.height)
      m = this.height; 
    for (int n = i; n < k; n++) {
      for (int i1 = j; i1 < m; i1++) {
        int i2 = this.map[i1][n] & 0xFFFFFFBF;
        if (i2 >= 13 && i2 <= 28) {
          int i3 = (n - this.l) * 12 + paramInt4;
          int i4 = (i1 - this.k) * 12;
          paramGraphics.drawImage(this.Q[com.nokia.mid.appl.boun.d.b[i2 - 13]], i3, i4, 20);
        } 
      } 
    } 
  }
  
  public void f() {
    for (byte b1 = 0; b1 < 13; b1++) {
      for (byte b2 = 0; b2 < 8; b2++)
        a(this.l + b1, this.k + b2, b1 * 12, b2 * 12); 
    } 
  }
  
  public void i() {
    int i = this.l;
    int j = this.k;
    for (byte b1 = 0; b1 < 13; b1++) {
      if (b1 * 12 >= this.Z && i >= this.l)
        i = this.G - 13; 
      for (byte b2 = 0; b2 < 8; b2++) {
        if ((this.map[j][i] & 0x80) != 0)
          a(i, j, b1 * 12, b2 * 12); 
        j++;
      } 
      j = this.k;
      i++;
    } 
  }
  
  public void c(int paramInt) {
    int i = this.G - 13;
    int j = this.G;
    int k = paramInt - 64;
    if (k < 0) {
      k = 0;
    } else if (k > (this.width + 1) * 12 - 156) {
      k = (this.width + 1) * 12 - 156;
    } 
    while (k / 12 < i) {
      this.Z -= 12;
      int m = this.Z;
      this.G--;
      j--;
      i--;
      if (this.Z <= 0) {
        this.Z = 156;
        this.l -= 13;
      } 
      for (byte b1 = 0; b1 < 8; b1++)
        a(this.G - 13, this.k + b1, m, b1 * 12); 
    } 
    while ((k + 128) / 12 >= j) {
      if (this.Z >= 156) {
        this.Z = 0;
        this.l += 13;
      } 
      int m = this.Z;
      this.Z += 12;
      this.G++;
      j++;
      i++;
      for (byte b1 = 0; b1 < 8; b1++)
        a(this.l + m / 12, this.k + b1, m, b1 * 12); 
    } 
    this.v = this.l * 12 - k;
  }
  
  public int m() {
    return this.l * 12 - this.v;
  }
  
  public int g() {
    return this.l * 12 - this.v + 128;
  }
  
  public Image a(Image paramImage) {
    Image image = DirectUtils.createImage(16, 16, 0);
    if (image == null)
      image = Image.createImage(16, 16); 
    Graphics graphics = image.getGraphics();
    DirectGraphics directGraphics = DirectUtils.getDirectGraphics(graphics);
    graphics.drawImage(paramImage, -4, -4, 20);
    directGraphics.drawImage(paramImage, 8, -4, 20, 8192);
    directGraphics.drawImage(paramImage, -4, 8, 20, 16384);
    directGraphics.drawImage(paramImage, 8, 8, 20, 180);
    return image;
  }
  
  public Image b(Image paramImage) {
    Image image = Image.createImage(24, 48);
    Graphics graphics = image.getGraphics();
    graphics.setColor(11591920);
    graphics.fillRect(0, 0, 24, 48);
    graphics.setColor(16555422);
    graphics.fillRect(4, 0, 16, 48);
    graphics.setColor(14891583);
    graphics.fillRect(6, 0, 10, 48);
    graphics.setColor(12747918);
    graphics.fillRect(10, 0, 4, 48);
    graphics.drawImage(paramImage, 0, 0, 20);
    graphics.drawImage(a(paramImage, 0), 12, 0, 20);
    graphics.drawImage(a(paramImage, 1), 0, 12, 20);
    graphics.drawImage(a(paramImage, 2), 12, 12, 20);
    return image;
  }
  
  public void c() {
    Image image = a("/icons/objects_nm.png");
    this.Q = new Image[67];
    this.Q[0] = a(image, 1, 0);
    this.Q[1] = a(image, 1, 2);
    this.Q[2] = a(image, 0, 3, -5185296);
    this.Q[3] = a(this.Q[2], 1);
    this.Q[4] = a(this.Q[2], 3);
    this.Q[5] = a(this.Q[2], 5);
    this.Q[6] = a(image, 0, 3, -15703888);
    this.Q[7] = a(this.Q[6], 1);
    this.Q[8] = a(this.Q[6], 3);
    this.Q[9] = a(this.Q[6], 5);
    this.Q[10] = a(image, 0, 4);
    this.Q[11] = a(image, 3, 4);
    this.Q[12] = b(a(image, 2, 3));
    this.Q[14] = a(image, 0, 5);
    this.Q[13] = a(this.Q[14], 1);
    this.Q[15] = a(this.Q[13], 0);
    this.Q[16] = a(this.Q[14], 0);
    this.Q[18] = a(image, 1, 5);
    this.Q[17] = a(this.Q[18], 1);
    this.Q[19] = a(this.Q[17], 0);
    this.Q[20] = a(this.Q[18], 0);
    this.Q[22] = a(image, 2, 5);
    this.Q[21] = a(this.Q[22], 1);
    this.Q[23] = a(this.Q[21], 0);
    this.Q[24] = a(this.Q[22], 0);
    this.Q[26] = a(image, 3, 5);
    this.Q[25] = a(this.Q[26], 1);
    this.Q[27] = a(this.Q[25], 0);
    this.Q[28] = a(this.Q[26], 0);
    this.Q[29] = a(this.Q[14], 5);
    this.Q[30] = a(this.Q[29], 1);
    this.Q[31] = a(this.Q[29], 0);
    this.Q[32] = a(this.Q[30], 0);
    this.Q[33] = a(this.Q[18], 5);
    this.Q[34] = a(this.Q[33], 1);
    this.Q[35] = a(this.Q[33], 0);
    this.Q[36] = a(this.Q[34], 0);
    this.Q[37] = a(this.Q[22], 5);
    this.Q[38] = a(this.Q[37], 1);
    this.Q[39] = a(this.Q[37], 0);
    this.Q[40] = a(this.Q[38], 0);
    this.Q[41] = a(this.Q[26], 5);
    this.Q[42] = a(this.Q[41], 1);
    this.Q[43] = a(this.Q[41], 0);
    this.Q[44] = a(this.Q[42], 0);
    this.Q[45] = a(image, 3, 3);
    this.Q[46] = a(image, 1, 3);
    this.Q[47] = a(image, 2, 0);
    this.Q[48] = a(image, 0, 1);
    this.Q[49] = a(a(image, 3, 0));
    this.Q[50] = a(image, 3, 1);
    this.Q[51] = a(image, 2, 4);
    this.Q[52] = a(image, 3, 2);
    this.Q[53] = a(image, 1, 1);
    this.Q[54] = a(image, 2, 2);
    this.Q[55] = a(image, 0, 0, -5185296);
    this.Q[56] = a(this.Q[55], 3);
    this.Q[57] = a(this.Q[55], 4);
    this.Q[58] = a(this.Q[55], 5);
    this.Q[59] = a(image, 0, 0, -15703888);
    this.Q[60] = a(this.Q[59], 3);
    this.Q[61] = a(this.Q[59], 4);
    this.Q[62] = a(this.Q[59], 5);
    this.Q[63] = a(image, 0, 2);
    this.Q[64] = a(this.Q[63], 3);
    this.Q[65] = a(this.Q[63], 4);
    this.Q[66] = a(this.Q[63], 5);
    this.A = a(image, 2, 1);
    this.D = a(image, 1, 4);
  }
  
  public void a(Ball paramf) {
    paramf.A = this.Q[47];
    paramf.k = this.Q[48];
    paramf.B = this.Q[49];
  }
  
  public static Image a(Image paramImage, int paramInt1, int paramInt2) {
    return a(paramImage, paramInt1, paramInt2, 0);
  }
  
  public static Image a(Image paramImage, int paramInt1, int paramInt2, int paramInt3) {
    Image image = DirectUtils.createImage(12, 12, paramInt3);
    if (image == null) {
      image = Image.createImage(12, 12);
      Graphics graphics1 = image.getGraphics();
      graphics1.setColor(paramInt3);
      graphics1.fillRect(0, 0, 12, 12);
    } 
    Graphics graphics = image.getGraphics();
    graphics.drawImage(paramImage, -paramInt1 * 12, -paramInt2 * 12, 20);
    return image;
  }
  
  public static Image a(String paramString) {
    Image image = null;
    try {
      image = Image.createImage(paramString);
    } catch (IOException iOException) {}
    return image;
  }
  
  public void a(int paramInt1, int paramInt2, Image paramImage) {
    this.al = paramInt1;
    this.u = paramInt2;
    this.o = paramImage;
    this.aa = Image.createImage(24, 24);
    this.b = 0;
    p();
    this.M = false;
  }
  
  public void p() {
    Graphics graphics = this.aa.getGraphics();
    graphics.drawImage(this.o, 0, 0 - this.b, 20);
  }
  
  public void h() {
    this.b += 4;
    if (this.b >= 24) {
      this.b = 24;
      this.M = true;
    } 
    p();
  }
  
  public abstract void a();
  
  public synchronized void d() {
    if (this.ab != null)
      return; 
    this.ab = new com.nokia.mid.appl.boun.g(this, this);
  }
  
  public synchronized void stop() {
    if (this.ab == null)
      return; 
    this.ab.a();
    this.ab = null;
  }
  
  protected void n() {
    a();
  }
  
  protected class g extends TimerTask {
    TileCanvas a;
    
    Timer c;
    
    private final TileCanvas b;
    
    public g(TileCanvas this$0, TileCanvas param1b1) {
      this.b = this$0;
      this.a = param1b1;
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
}


/* Location:              D:\Java Mobile\nokiabounc_jdifc8jb.jar!\com\nokia\mid\appl\boun\b.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */