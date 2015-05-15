package net.pravian.bukkitlib.metrics;

/**
 * Represents a plotter with special data for a donut-type graph.
 */
public abstract class DonutPlotter extends Plotter {

    private String majorName, minorName;

    /**
     * Creates a new DonutPlotter instance with the specified major and minor names.
     *
     * <p>The major name indicates the center area of the donut graph whilst the minor name indicates the edges.</p>
     *
     * @param major The donut filling (usually air).
     * @param minor The donut crust (usually dough with icing).
     */
    public DonutPlotter(String major, String minor) {
        super(major + "~=~" + minor);
    }
}
