/*
 * Written by Pierce Clinger
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class TriangleFractals extends Canvas
{
	
	public static final int h = 600;
	public static final int w = 600;
	
	public int recursion = 4;
	
	public static void main(String[] args) 
	{	
		JFrame frame = new JFrame("Triangle Fractals");
		frame.setSize(h, w);
		TriangleFractals tf = new TriangleFractals();
		frame.add(tf);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g)
	{
		Point pt1 = new Point(w/2,0);
		Point pt2 = new Point(0,h);
		Point pt3 = new Point(w,h);
		
		g.setColor(Color.WHITE);
		drawTriangle(pt1,pt2,pt3,g);
		g.setColor(Color.BLACK);
		subPoly(pt1,pt2,pt3,g,w/2);
	}
	
	public void drawTriangle(Point pt1, Point pt2, Point pt3, Graphics g)
	{
		Polygon triangle = new Polygon();
		triangle.addPoint(pt1.x, pt1.y);
		triangle.addPoint(pt2.x, pt2.y);
		triangle.addPoint(pt3.x, pt3.y);
		g.fillPolygon(triangle);
	}
	
	public void subPoly(Point pt1, Point pt2, Point pt3, Graphics g, int r)
	{
		if(r <= recursion)
			drawTriangle(pt1,pt2,pt3,g);
		else
		{
			Point pt4 = new Point((pt1.x + pt2.x) / 2, (pt1.y + pt2.y) / 2);
            Point pt5 = new Point((pt2.x + pt3.x) / 2, (pt2.y + pt3.y) / 2);
            Point pt6 = new Point((pt1.x + pt3.x) / 2, (pt1.y + pt3.y) / 2);
            
            subPoly(pt1, pt4, pt6, g, r / 2);
            subPoly(pt4, pt2, pt5, g, r / 2);
            subPoly(pt6, pt5, pt3, g, r / 2);
		}
		
	}

}
