package org.eval.moretech.twogis.route.adapter.parboiledwkt;

/**
 * The Abstract class for Curves.
 * @author Jared Erickson
 */
public abstract class Curve extends Geometry {

    /**
     * Create a new Curve
     * @param dimension The Dimension
     * @param srid The SRID
     */
    public Curve(Dimension dimension, String srid) {
        super(dimension, srid);
    }

}
