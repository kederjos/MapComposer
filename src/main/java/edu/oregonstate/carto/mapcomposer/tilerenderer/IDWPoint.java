package edu.oregonstate.carto.mapcomposer.tilerenderer;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author darbyshj
 */
public class IDWPoint {
    //color values for the point (0-255)
    private int r; 
    private int g; 
    private int b;
    
    private double attribute1; //ex: precipitation
    private double attribute2; //ex: elevation

    public String toString() {
        return " " + r + " " + g + " " + b;
    }

    /**
     * @return the r
     */
    public double getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(int r) {
        this.r = r;
    }

    /**
     * @return the g
     */
    public double getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * @return the b
     */
    public double getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(int b) {
        this.b = b;
    }

    public Color getColor() {
        return new Color(r, g, b);
    }
    
    public void setColor(Color rgb) {
        this.r = rgb.getRed();
        this.g = rgb.getGreen();
        this.b = rgb.getBlue();
    }
    
    /**
     * @return the attribute1
     */
    public double getAttribute1() {
        return attribute1;
    }

    /**
     * @param attribute1 the attribute1 to set
     */
    public void setAttribute1(double attribute1) {
        this.attribute1 = attribute1;
    }

    /**
     * @return the attribute2
     */
    public double getAttribute2() {
        return attribute2;
    }

    /**
     * @param attribute2 the attribute2 to set
     */
    public void setAttribute2(double attribute2) {
        this.attribute2 = attribute2;
    }
}