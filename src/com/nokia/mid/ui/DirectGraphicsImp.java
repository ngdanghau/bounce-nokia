// Decompiled with: CFR 0.152
// Class Version: 4
package com.nokia.mid.ui;

import com.nokia.mid.ui.DirectGraphics;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import org.microemu.device.DisplayGraphics;
import org.microemu.device.MutableImage;

public class DirectGraphicsImp implements DirectGraphics {
    private Graphics graphics;
    private int alphaComponent;

    public DirectGraphicsImp(Graphics g) {
        this.graphics = g;
    }

    public void drawImage(Image img, int x, int y, int anchor, int manipulation) {
        if (img == null) {
            throw new NullPointerException();
        }
        if (anchor >= 64 || manipulation == -1) {
            throw new IllegalArgumentException();
        }
        this.graphics.drawImage(img, x + this.graphics.getTranslateX(), y + this.graphics.getTranslateY(), anchor);
    }

    public void setARGBColor(int argb) {
        this.alphaComponent = argb >> 24 & 0xFF;
        this.graphics.setColor(argb & 0xFFFFFF);
    }

    public int getAlphaComponent() {
        return this.alphaComponent;
    }

    public int getNativePixelFormat() {
        return 1;
    }

    public void drawPolygon(int[] xPoints, int xOffset, int[] yPoints, int yOffset, int nPoints, int argbColor) {
        System.out.println("public void drawPolygon(int xPoints[], int xOffset, int yPoints[], int yOffset, int nPoints, int argbColor)");
    }

    public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int argbColor) {
        System.out.println("public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int argbColor)");
    }

    public void fillPolygon(int[] xPoints, int xOffset, int[] yPoints, int yOffset, int nPoints, int argbColor) {
        System.out.println("public void fillPolygon(int xPoints[], int xOffset, int yPoints[], int yOffset, int nPoints, int argbColor)");
    }

    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int argbColor) {
        System.out.println("public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int argbColor)");
    }

    public void drawPixels(byte[] pix, byte[] alpha, int off, int scanlen, int x, int y, int width, int height, int manipulation, int format) {
        System.out.println("public void drawPixels(byte[] pix, byte[] alpha, int off, int scanlen, int x, int y, int width, int height, int manipulation, int format)");
        if (pix == null) {
            throw new NullPointerException();
        }
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException();
        }
        Graphics g = this.graphics;
        if (format == 1) {
            int b = 7;
            for (int yj = 0; yj < height; ++yj) {
                int line = off + yj * scanlen;
                int ypos = yj * width;
                for (int xj = 0; xj < width; ++xj) {
                    int c = DirectGraphicsImp.doAlpha(pix, alpha, (line + xj) / 8, b);
                    if ((c >> 24 & 0xFF) != 0) {
                        if (g.getColor() != c) {
                            g.setColor(c);
                        }
                        g.drawLine(xj + x, yj + y, xj + x, yj + y);
                    }
                    if (--b >= 0) continue;
                    b = 7;
                }
            }
        } else if (format == -1) {
            int ods = off / scanlen;
            int oms = off % scanlen;
            int b = 0;
            for (int yj = 0; yj < height; ++yj) {
                int ypos = yj * width;
                int tmp = (ods + yj) / 8 * scanlen + oms;
                for (int xj = 0; xj < width; ++xj) {
                    int c = DirectGraphicsImp.doAlpha(pix, alpha, tmp + xj, b);
                    if (g.getColor() != c) {
                        g.setColor(c);
                    }
                    if ((c >> 24 & 0xFF) == 0) continue;
                    g.drawLine(xj + x, yj + y, xj + x, yj + y);
                }
                if (++b <= 7) continue;
                b = 0;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void drawPixels(short[] pix, boolean trans, int off, int scanlen, int x, int y, int width, int height, int manipulation, int format) {
        if (format != 4444) {
            throw new IllegalArgumentException("Illegal format: " + format);
        }
        Graphics g = this.graphics;
        for (int iy = 0; iy < height; ++iy) {
            for (int ix = 0; ix < width; ++ix) {
                int c = DirectGraphicsImp.toARGB(pix[off + ix + iy * scanlen], 4444);
                if (DirectGraphicsImp.isTransparent(c)) continue;
                g.setColor(c);
                g.drawLine(x + ix, y + iy, x + ix, y + iy);
            }
        }
    }

    public void drawPixels(int[] pix, boolean trans, int off, int scanlen, int x, int y, int width, int height, int manipulation, int format) {
        System.out.println("public void drawPixels(int pix[], boolean trans, int off, int scanlen, int x, int y, int width, int height, int manipulation, int format)");
        throw new IllegalArgumentException();
    }

    public void getPixels(byte[] pix, byte[] alpha, int offset, int scanlen, int x, int y, int width, int height, int format) {
        System.out.println("public void getPixels(byte pix[], byte alpha[], int offset, int scanlen, int x, int y, int width, int height, int format)");
        throw new IllegalArgumentException();
    }

    public void getPixels(short[] pix, int offset, int scanlen, int x, int y, int width, int height, int format) {
        switch (format) {
            case 4444: {
                MutableImage img = ((DisplayGraphics)((Object)this.graphics)).getImage();
                int[] data = img.getData();
                for (int iy = 0; iy < height; ++iy) {
                    for (int ix = 0; ix < width; ++ix) {
                        pix[offset + ix + iy * scanlen] = (short)DirectGraphicsImp.fromARGB(data[ix + iy * width], 4444);
                    }
                }
                break;
            }
            case 444: {
                MutableImage img = ((DisplayGraphics)((Object)this.graphics)).getImage();
                int[] data = img.getData();
                for (int iy = 0; iy < height; ++iy) {
                    for (int ix = 0; ix < width; ++ix) {
                        pix[offset + ix + iy * scanlen] = (short)DirectGraphicsImp.fromARGB(data[ix + iy * width], 444);
                    }
                }
                break;
            }
            default: {
                throw new IllegalArgumentException("Illegal format: " + format);
            }
        }
    }

    public void getPixels(int[] pix, int offset, int scanlen, int x, int y, int width, int height, int format) {
        System.out.println("public void getPixels(int pix[], int offset, int scanlen, int x, int y, int width, int height, int format");
        throw new IllegalArgumentException();
    }

    private static int doAlpha(byte[] pix, byte[] alpha, int pos, int shift) {
        int p = DirectGraphicsImp.isBitSet(pix[pos], shift) ? 0 : 0xFFFFFF;
        int a = alpha == null || DirectGraphicsImp.isBitSet(alpha[pos], shift) ? -16777216 : 0;
        return p | a;
    }

    private static boolean isBitSet(byte b, int pos) {
        return (b & (byte)(1 << pos)) != 0;
    }

    private static int toARGB(int s, int type) {
        switch (type) {
            case 4444: {
                int a = (s & 0xF000) >>> 12;
                int r = (s & 0xF00) >>> 8;
                int g = (s & 0xF0) >>> 4;
                int b = s & 0xF;
                s = a * 15 << 24 | r * 15 << 16 | g * 15 << 8 | b * 15;
                break;
            }
            case 444: {
                int r = (s & 0xF00) >>> 8;
                int g = (s & 0xF0) >>> 4;
                int b = s & 0xF;
                s = r * 15 << 16 | g * 15 << 8 | b * 15;
                break;
            }
        }
        return s;
    }

    private static int fromARGB(int s, int type) {
        switch (type) {
            case 4444: {
                int a = (s & 0xFF000000) >>> 24;
                int r = (s & 0xFF0000) >>> 16;
                int g = (s & 0xFF00) >>> 8;
                int b = s & 0xFF;
                s = a / 15 << 12 | r / 15 << 8 | g / 15 << 4 | b / 15;
                break;
            }
            case 444: {
                int r = (s & 0xFF0000) >>> 16;
                int g = (s & 0xFF00) >>> 8;
                int b = s & 0xFF;
                s = r / 15 << 8 | g / 15 << 4 | b / 15;
                break;
            }
        }
        return s;
    }

    private static boolean isTransparent(int s) {
        return (s & 0xFF000000) == 0;
    }
}
