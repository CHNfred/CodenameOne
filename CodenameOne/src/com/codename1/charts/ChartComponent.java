/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *  
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * 
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Please contact Codename One through http://www.codenameone.com/ if you 
 * need additional information or have any questions.
 */
package com.codename1.charts;

import com.codename1.charts.models.Point;
import com.codename1.charts.models.SeriesSelection;
import com.codename1.charts.views.AbstractChart;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.animations.Animation;
import com.codename1.ui.animations.Motion;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.GeneralPath;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.geom.Shape;
import java.util.LinkedList;
import java.util.Queue;


/**
 * <p>The top level component for displaying charts</p>
 *         <p>
        The <code>charts</code> package enables Codename One developers to add charts
 * and visualizations to their apps without having to include external libraries
 * or embedding web views. We also wanted to harness the new features in the
 * graphics pipeline to maximize performance.</p>  
 *       <h4>Device Support</h4>
 * <p>
 * Since the charts package makes use of 2D transformations and shapes, it
 * requires some of the graphics features that are not yet available on all
 * platforms. Currently the following platforms are supported:
 * </p>
 * <ol>
 * <li>Simulator</li>
 * <li>Android</li>
 * <li>iOS</li>
 * </ol>  
 *       <h4>Features</h4>
 * <ol>
 * <li><strong>Built-in support for many common types of charts</strong>
 * including bar charts, line charts, stacked charts, scatter charts, pie charts
 * and more.</li>
 * <li><strong>Pinch Zoom</strong> - The
 * {@link com.codename1.charts,ChartComponent} class includes optional pinch
 * zoom support.</li>
 * <li><strong>Panning Support</strong> - The
 * {@link com.codename1.charts,ChartComponent} class includes optional support
 * for panning.</li>
 * </ol>
 *
        <h4>Chart Types</h4>
 * <p>
 * The <code>com.codename1.charts</code> package includes models and renderers
 * for many different types of charts. It is also extensible so that you can add
 * your own chart types if required. The following screen shots demonstrate a
 * small sampling of the types of charts that can be created.
 * </p>
 * <img src="https://www.codenameone.com/img/developer-guide/line_chart.png" alt="Line Charts">
 * <img src="https://www.codenameone.com/img/developer-guide/line_chart_cubic_multi.png" alt="Cubic Line Charts">  *
 *  <img src="https://www.codenameone.com/img/developer-guide/bar_chart.png" alt="Bar Charts">
 * <img src="https://www.codenameone.com/img/developer-guide/bar_chart_stacked.png" alt="Stacked Bar Charts">
 * <img src="https://www.codenameone.com/img/developer-guide/range_bar_chart.png" alt="Range Bar Charts">
 * <img src="https://www.codenameone.com/img/developer-guide/pie_chart.png" alt="Pie Charts">
 * <img src="https://www.codenameone.com/img/developer-guide/doughnut_chart.png" alt="Doughnut Charts">
 * <img src="https://www.codenameone.com/img/developer-guide/scatter_chart.png" alt="Scatter Charts">
 * <img src="https://www.codenameone.com/img/developer-guide/dial_chart.png" alt="Dial Charts">
 * <img src="https://www.codenameone.com/img/developer-guide/combined.png" alt="Combined Charts">
 * <img src="https://www.codenameone.com/img/developer-guide/bubble_chart.png" alt="Bubble Charts">
 * <img src="https://www.codenameone.com/img/developer-guide/time_chart.png" alt="Time Charts">  
 *       <table>
 * <tbody><tr> <td class="icon"> <i class="fa icon-note" title="Note"></i> </td>
 * <td class="content">
 * The above screenshots were taken from the
 * <a href="https://github.com/codenameone/codenameone-demos/tree/master/ChartsDemo">ChartsDemo
 * app</a>. Y ou can start playing with this app by checking it out from our git
 * repository. </td> </tr>
 * </tbody>
 * </table>  
 *       <h4>How to Create A Chart</h4>
 * <p>
 * Adding a chart to your app involves four steps:</p>
 * <ol>
 * <li><strong>Build the model</strong>. You can construct a model (aka data
 * set) for the chart using one of the existing model classes in the
 * <code>com.codename1.charts.models</code> package. Essentially, this is just
 * where you add the data that you want to display.</li>
 * <li> <strong>Set up a renderer</strong>. You can create a renderer for your
 * chart using one of the existing renderer classes in the
 * <code>com.codename1.charts.renderers</code> package. The renderer allows you
 * to specify how the chart should look. E.g. the colors, fonts, styles, to use.
 * </li>
 * <li> <strong>Create the Chart View</strong>. Use one of the existing
 * <em>view</em> classes in the
 * <code>com.codename1.charts.views</code> package.
 * </li>
 * <li> <strong>Create a {@link com.codename1.charts,ChartComponent} </strong>.
 * In order to add your chart to the UI, you need to wrap it in a
 * {@link com.codename1.charts,ChartComponent} object.</li>
 * </ol>
 *
        <p>
 * You can check out the
 * <a href="https://github.com/codenameone/codenameone-demos/tree/master/ChartsDemo">ChartsDemo</a>
 * app for specific examples, but here is a high level view of some code that
 * creates a Pie Chart.</p>
 *
        <script src="https://gist.github.com/codenameone/c5b5bf22cd1db36d8c07.js"></script>
 *
        <p>
 * The charts package is derived work from the excellent
 * <a href="http://www.achartengine.org/">open source aChartEngine API.</a>
 * </p>
 *
 * @author shannah
 */
public class ChartComponent extends Component {
    
    private Queue<ZoomTransition> animations = new LinkedList<ZoomTransition>();
    
    /**
     * The chart that is to be rendered in this component.
     */
    private AbstractChart chart;
    
    /**
     * Util object for rendering the chart.
     */
    private final ChartUtil util = new ChartUtil();
    
    /**
     * The transform for the chart.  This can be used to scale, translate, and
     * rotate the chart.  This transform assumes its origin at the (absoluteX, absoluteY)
     * of the component at the time it is drawn rather than the screen's origin as is 
     * normally the case with transforms.  This allows the transform to be applied consistently
     * with respect to the chart's coordinates even when the component is moved around the screen.
     */
    private Transform transform = null;
    
    /**
     * The transform that was applied during the last paint() method.
     * This is generally the {@link #transform} concatenated with a
     * translation to the screen origin from the component's origin.  This 
     * is used to convert chart coordinates to screen coordinates and respond
     * properly to events.
     */
    private Transform currentTransform = null;
    
    /**
     * Flag to enable panning the chart.  Default is false.
     */
    private boolean panEnabled = false;
    
    /**
     * During a pan operation, used to store the transform as it was before
     * the start of the pan.
     */
    private Transform dragTransformStart = null;
    
    private Transform tmpTransform = null;
    
    /**
     * The starting position of a pan operation.
     */
    private Point dragStart = null;
    
    /**
     * Flag to enable pinch zoom.
     */
    private boolean zoomEnabled = false;
    
    /**
     * During a pinch zoom operation, this is the middle point between the
     * two touch points at the start of the zoom operation.  This is in
     * screen coordinates.
     */
    private Point zoomStart = null;
    
    /**
     * During a pinch zoom operation, this is the transform as it was at the start
     * of the zoom.
     */
    private Transform zoomTransformStart = null;
    
    /**
     * During a pinch zoom operation, this is the distance between the two touch
     * points at the start of the zoom operation.
     */
    private double zoomDistStart = 0;
    
    /**
     * Creates a new chart component to display the provided chart.
     * @param chart The chart to be displayed in this component.
     */
    public ChartComponent(AbstractChart chart){
        this.chart = chart;
    }
    
    /**
     * Gets the chart that is being displayed in this component.
     * @return 
     */
    public AbstractChart getChart(){
        return chart;
    }

    @Override
    protected Dimension calcPreferredSize() {
        return new Dimension(
                Display.getInstance().convertToPixels(100, true),
                Display.getInstance().convertToPixels(100, false)
        );
    }
    
    
    
    /**
     * Sets the chart to be displayed in this component.
     * @param chart 
     */
    public void setChart(AbstractChart chart){
        this.chart = chart;
    }
    
    /**
     * Paints the chart.
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        boolean oldAntialias = g.isAntiAliased();
        g.setAntiAliased(true);
        
        boolean transformed = false;
        if ( getTransform() != null ){
            transformed = true;
            if (tmpTransform == null) {
                tmpTransform = Transform.makeIdentity();
            }
            g.getTransform(tmpTransform);
            
            if (currentTransform == null) {
                currentTransform = Transform.makeTranslation(getAbsoluteX(), getAbsoluteY());
            } else {
                currentTransform.setTranslation(getAbsoluteX(), getAbsoluteY());
            }
            currentTransform.concatenate(transform);
            currentTransform.translate(-getAbsoluteX(), -getAbsoluteY());
            
            g.setTransform(currentTransform);
        } else {
            currentTransform = null;
        }
        
        
        util.paintChart(g, chart, getBounds(), getAbsoluteX(), getAbsoluteY());
        
        if ( transformed){
            g.setTransform(tmpTransform);
        }
        
        g.setAntiAliased(oldAntialias);
    }

    /**
     * Converts screen coordinates to chart coordinates.
     * @param x screen x position
     * @param y screen y position
     * @return The chart coordinate corresponding to the given screen coordinate.
     */
    public Point screenToChartCoord(int x, int y){
        if ( currentTransform != null ){
            Transform inverse = currentTransform.getInverse();
            float[] pt = inverse.transformPoint(new float[]{x,y, 0});
            x = (int)pt[0];
            y = (int)pt[1];
            
        }
        return new Point(x-getAbsoluteX(), y-getAbsoluteY());
    }
    
    /**
     * Returns the screen position from a chart coordinate
     *
     * @param x the x position within the chart
     * @param y the y position within the chart
     * @return a position within the screen
     */
    public Point chartToScreenCoord(int x, int y){
        x += getAbsoluteX();
        y += getAbsoluteY();
        if ( currentTransform != null ){
            float[] pt = currentTransform.transformPoint(new float[]{x,y, 0});
            x = (int)pt[0];
            y = (int)pt[1];
            
        }
        return new Point(x, y);
    }
    
    /**
     * Converts a chart coordinate spaced shape to the same shape in the screen coordinate space
     * @param s shape in screen coordinates
     * @return same shape using chart space coordinates
     */
    public Shape screenToChartShape(Shape s){
        GeneralPath p = new GeneralPath();
        Transform t = Transform.makeIdentity();
        if ( currentTransform != null ){
            t.concatenate(currentTransform.getInverse());
        }
        t.translate(-getAbsoluteX(), -getAbsoluteY());
        p.append(s.getPathIterator(t), false);
        return p;
    }
        
    /**
     * Converts a screen coordinate spaced shape to the same shape in the chart  coordinate space
     * @param s shape in chart  coordinates
     * @return same shape using screen coordinate space
     */
    public Shape chartToScreenShape(Shape s){
        GeneralPath p = new GeneralPath();
        Transform inverse = Transform.makeTranslation(getAbsoluteX(), getAbsoluteY());
        if ( currentTransform != null ){
            inverse.concatenate(currentTransform);
        }
        
        p.append(s.getPathIterator(inverse), false);
        return p;
    }
    
    
    
    /**
     * Zooms the view port to show a specified shape.  The shape should be 
     * expressed in chart coordinates (not screen coordinates).
     * @param s The shape that should be shown.
     */
    public void zoomToShapeInChartCoords(Shape s){
        zoomToShapeInChartCoords(s, 1);
        
    }
    
    /**
     * Zooms the view port to show a specified shape.  The shape should be 
     * expressed in chart coordinates (not screen coordinates).
     * @param s The shape that should be shown.
     * @param duration The duration of the transition.
     */
    public void zoomToShapeInChartCoords(Shape s, int duration){
        zoomTransition(s.getBounds(), duration);
    }
    
    
    @Override
    public void pointerPressed(int x, int y) {
       
        Point chartCoord = screenToChartCoord(x, y);
        SeriesSelection sel = chart.getSeriesAndPointForScreenCoordinate(chartCoord);
        if ( sel == null ){
            super.pointerPressed(x, y);
            return;
        }
        
        seriesPressed(sel);
        super.pointerPressed(x, y); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    /**
     * Called when a pointer is pressed on a series in the chart.  This can be 
     * overridden by subclasses to respond to this event.
     * @param sel 
     */
    protected void seriesPressed(SeriesSelection sel){
        
    }
    

    @Override
    public void pointerReleased(int x, int y) {
        dragStart = null;
        dragTransformStart = null;
        zoomStart = null;
        zoomDistStart = 0;
        zoomTransformStart = null;
        
        Point chartCoord = screenToChartCoord(x, y);
        SeriesSelection sel = chart.getSeriesAndPointForScreenCoordinate(chartCoord);
        if ( sel == null ){
            super.pointerReleased(x, y);
            return;
        }
        
        seriesReleased(sel);
        super.pointerReleased(x, y); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Called when a pointer is released from a series in the chart.  This can be 
     * overridden in subclasses to handle these events.
     * @param sel 
     */
    protected void seriesReleased(SeriesSelection sel){
        
    }

    /**
     * 
     * Gets the transform for the chart.  This can be used to scale, translate, and
     * rotate the chart.  This transform assumes its origin at the (absoluteX, absoluteY)
     * of the component at the time it is drawn rather than the screen's origin as is 
     * normally the case with transforms.  This allows the transform to be applied consistently
     * with respect to the chart's coordinates even when the component is moved around the screen.
     * @return The transform for the chart in component coordinates.
     */
    public Transform getTransform() {
        return transform;
    }

    /**
     * Sets the transform for the chart.  Transforms origin assumed to be at (getAbsoluteX, getAbsoluteY).
     * @param transform the transform to set
     */
    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    @Override
    public void pointerDragged(int[] x, int[] y) {
        if ( x.length > 1 ){
            if ( !zoomEnabled ){
                super.pointerDragged(x, y);
                return;
            }
            // Pinch zoom
            if ( zoomStart == null ){
                zoomStart = new Point((x[0]+x[1])/2, (y[0]+y[1])/2);
                zoomTransformStart = Transform.makeIdentity();
                if ( transform != null ){
                    zoomTransformStart.concatenate(transform);
                }
                int dx = Math.abs(x[0]-x[1])/2;
                int dy = Math.abs(y[0]-y[1])/2;
                zoomDistStart = Math.sqrt(dx*dx+dy*dy);
                
                
                
            } else {
                int dx = Math.abs(x[0]-x[1])/2;
                int dy = Math.abs(y[0]-y[1])/2;
                double zoomDist = Math.sqrt(dx*dx+dy*dy);
                if ( zoomDist == 0 ){
                    zoomDist = 1;
                }
                transform = Transform.makeIdentity();
                transform.translate(zoomStart.getX(), zoomStart.getY());
                transform.scale((float)(zoomDist/zoomDistStart), (float)(zoomDist/zoomDistStart));
                transform.translate(-zoomStart.getX(), -zoomStart.getY());
                transform.concatenate(zoomTransformStart);
                this.repaint();
            }
            
        } else {
            if ( !panEnabled ){
                super.pointerDragged(x, y);
                return;
            }
            if ( dragStart == null ){
                dragStart = new Point(x[0],y[0]);
                dragTransformStart = Transform.makeIdentity();
                if ( transform != null ){
                    dragTransformStart.concatenate(transform);
                }

            } else {
                transform = Transform.makeIdentity();
                transform.translate(x[0]-dragStart.getX(), y[0]-dragStart.getY());
                transform.concatenate(dragTransformStart);
                this.repaint();
            }
        }
        
        super.pointerDragged(x, y); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

    /**
     * Checks if panning is enabled.
     * @return the panEnabled
     */
    public boolean isPanEnabled() {
        return panEnabled;
    }

    /**
     * @param panEnabled the panEnabled to set
     */
    public void setPanEnabled(boolean panEnabled) {
        this.panEnabled = panEnabled;
    }

    /**
     * @return the zoomEnabled
     */
    public boolean isZoomEnabled() {
        return zoomEnabled;
    }

    /**
     * @param zoomEnabled the zoomEnabled to set
     */
    public void setZoomEnabled(boolean zoomEnabled) {
        this.zoomEnabled = zoomEnabled;
    }
    
    
    
    
    private void zoomTransition(Rectangle newViewPort, int duration){
        Shape currentViewPort = screenToChartShape(new Rectangle(getAbsoluteX(), getAbsoluteY(), getWidth(), getHeight()));
        float[] currentRect = currentViewPort.getBounds2D();
        float[] newRect = newViewPort.getBounds2D();
        
        float currentAspect =currentRect[2]/currentRect[3];
        float newAspect = newRect[3]/newRect[3];
        
        if ( newAspect != currentAspect ){
            newViewPort.setHeight((int)(((double)newViewPort.getWidth())/currentAspect));
            newRect = newViewPort.getBounds2D();
            newAspect = newRect[2]/newRect[3];
        }
        
        ZoomTransition zt = new ZoomTransition(currentViewPort.getBounds(), newViewPort, duration);
        
        animations.add(zt);
        if ( animations.size() == 1 ){
            zt.start();
        }
    }
    
    private class ZoomTransition implements Animation {
        private final Rectangle currentViewPort;
        private final Rectangle newViewPort;
        private Motion motion;
        private final Transform origTransform;
        private boolean finished = false;
        
        ZoomTransition(Rectangle currentViewPort, Rectangle newViewPort, int duration){
            
            this.currentViewPort = currentViewPort;
            this.newViewPort = newViewPort;
            this.motion = Motion.createLinearMotion(0, 100, duration);
            this.origTransform = Transform.makeIdentity();
            if ( transform != null ){
                this.origTransform.setTransform(transform);
            }
            
        }
        
        public void start(){
            Form f = ChartComponent.this.getComponentForm();
            if ( f != null ){
                f.registerAnimated(this);
                this.motion.start();
            } else {
                animations.remove();
            }
        }
        
        public void cleanup(){
            Form f = ChartComponent.this.getComponentForm();
            if ( f != null ){
                f.deregisterAnimated(this);
            }
        }

        public boolean animate() {
            
            if (finished){
                animations.remove();
                if ( !animations.isEmpty() ){
                    animations.peek().start();
                }
                cleanup();
                return false;
            } else if ( motion.isFinished() ){
                finished = true;
                
            }
            return true;
        }

        public void paint(Graphics g) {
            Rectangle newBounds = new Rectangle(newViewPort.getBounds());
            Rectangle currentBounds = new Rectangle(currentViewPort.getBounds());
            
            
            double nW = newBounds.getWidth();
            double nH = newBounds.getHeight();
            double cW = currentBounds.getWidth();
            double cH = currentBounds.getHeight();
            
            double scale = cW/nW;
            if ( nH * scale > cH){
                scale = cH/nH;
            }
            Point newCenter = new Point(newBounds.getX()+newBounds.getWidth()/2, newBounds.getY()+newBounds.getHeight()/2);
            Point currentCenter = new Point(currentBounds.getX()+currentBounds.getWidth()/2, currentBounds.getY()+currentBounds.getHeight()/2);
            double motionVal = motion.getValue();
            
            double tx = ((double)newCenter.getX()-currentCenter.getX())*motionVal/100.0;
            double ty = ((double)newCenter.getY()-currentCenter.getY())*motionVal/100.0;
            
            scale = 1.0 + (scale - 1f)*motionVal/100.0;
            
            Transform t = Transform.makeIdentity();
            t.setTransform(origTransform);
            
            int cX = (int)(currentCenter.getX()+tx);
            int cY = (int)(currentCenter.getY()+ty);
            
            t.translate(currentCenter.getX(), currentCenter.getY());
            t.scale((float)scale, (float)scale);
            t.translate(-cX, -cY);
            
            setTransform(t);
            ChartComponent.this.repaint();
            
        }
        
    }
    
    
    
    
    
}
