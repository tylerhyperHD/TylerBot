package net.pravian.bukkitlib.util;

import org.bukkit.Location;

/**
 * Represents all Location-related utilities.
 */
public class LocationUtils {

    private LocationUtils() {
    }

    /**
     * Returns a "pretty" formatted location.
     *
     * @param location The location to format.
     * @return The formatted location.
     */
    public static String format(Location location) {
        return String.format("%s: (%d, %d, %d)",
                location.getWorld().getName(),
                Math.round(location.getX()),
                Math.round(location.getY()),
                Math.round(location.getZ()));
    }
}
