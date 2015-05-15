package net.pravian.bukkitlib.implementation;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.bukkit.plugin.Plugin;

/*
 * Represents a Plugin-specific Logger . <p><b>Note</b>: The methods in this class also accept all instances of {@link java.lang.Throwable} and will print the attached StackTrace.
 */
public class BukkitLogger extends Logger {

    private String pluginName;
    private boolean debugMode;
    /**
     * The "raw" logger used to display messages without a plugin-tag.
     */
    public final Logger BUKKIT_LOGGER;

    /**
     * Creates a new BukkitLogger instance.
     *
     * <p><b>Note</b>: This method also accepts all instances of {@link java.lang.Throwable} and will print the attached StackTrace.
     *
     * @param plugin The plugin for which the logger will be used.
     */
    public BukkitLogger(Plugin plugin) {
        this(plugin, plugin.getServer().getLogger());
    }

    public BukkitLogger(Plugin plugin, Logger raw) {
        super(plugin.getClass().getCanonicalName(), null);
        String prefix = plugin.getDescription().getPrefix();
        pluginName = prefix != null ? new StringBuilder().append("[").append(prefix).append("] ").toString() : "[" + plugin.getDescription().getName() + "] ";
        setParent(raw);
        setLevel(Level.ALL);
        BUKKIT_LOGGER = raw;
    }

    /**
     * Prints an info-message to the plugin logger.
     *
     * <p><b>Note</b>: This method also accepts all instances of {@link java.lang.Throwable} and will print the attached StackTrace.
     *
     * @param message The message to print.
     */
    public void info(Object message) {
        super.info(getLogMessage(message));
    }

    /**
     * Prints an info-message to the raw Bukkit logger.
     *
     * <p><b>Note</b>: This method also accepts all instances of {@link java.lang.Throwable} and will print the attached StackTrace.
     *
     * @param message The message to print.
     */
    public void rawInfo(Object message) {
        BUKKIT_LOGGER.info(getLogMessage(message));
    }

    /**
     * Prints a warning-message to the plugin logger.
     *
     * <p><b>Note</b>: This method also accepts all instances of {@link java.lang.Throwable} and will print the attached StackTrace.
     *
     * @param message The message to print.
     */
    public void warning(Object message) {
        super.warning(getLogMessage(message));
    }

    /**
     * Prints a warning-message to the raw Bukkit logger.
     *
     * <p><b>Note</b>: This method also accepts all instances of {@link java.lang.Throwable} and will print the attached StackTrace.
     *
     * @param message The message to print.
     */
    public void rawWarning(Object message) {
        BUKKIT_LOGGER.warning(getLogMessage(message));
    }

    /**
     * Prints a severe-message to the plugin logger.
     *
     * <p><b>Note</b>: This method also accepts all instances of {@link java.lang.Throwable} and will print the attached StackTrace.
     *
     * @param message The message to print.
     */
    public void severe(Object message) {
        super.severe(getLogMessage(message));
    }

    /**
     * Prints a severe-message to the raw Bukkit logger.
     *
     * <p><b>Note</b>: This method also accepts all instances of {@link java.lang.Throwable} and will print the attached StackTrace.
     *
     * @param message The message to print.
     */
    public void rawSevere(Object message) {
        BUKKIT_LOGGER.severe(getLogMessage(message));
    }

    /**
     * Prints a debug-message to the plugin logger if debug-mode is enabled.
     *
     * <p><b>Note</b>: This method also accepts all instances of {@link java.lang.Throwable} and will print the attached StackTrace.
     */
    public void debug(Object message) {
        if (!debugMode) {
            return;
        }

        super.info("[DEBUG] " + getLogMessage(message));
    }

    /**
     * Prints a debug-message to the raw Bukkit logger if debug-mode is enabled.
     *
     * <p><b>Note</b>: This method also accepts all instances of {@link java.lang.Throwable} and will print the attached StackTrace.
     */
    public void rawDebug(Object message) {
        if (!debugMode) {
            return;
        }

        BUKKIT_LOGGER.info("[DEBUG] " + getLogMessage(message));
    }

    /**
     * Enables/disables debug-mode.
     *
     * @param enabled If debug-mode should be enabled.
     * @see #debug(Object)
     */
    public void setDebugMode(boolean enabled) {
        this.debugMode = enabled;
    }

    /**
     * Validates if debug-mode is enabled.
     *
     * @return true if debug-mode is enabled.
     */
    public boolean getDebugMode() {
        return debugMode;
    }

    /**
     * Logs a LogRecord to the plugin logger.
     *
     * @param logRecord The record to log.
     */
    @Override
    public void log(LogRecord logRecord) {
        logRecord.setMessage(pluginName + logRecord.getMessage());
        super.log(logRecord);
    }

    /**
     * Logs a LogRecord to the raw Bukkit logger.
     *
     * @param logRecord The record to log.
     */
    public void rawLog(LogRecord logRecord) {
        logRecord.setMessage(pluginName + logRecord.getMessage());
        BUKKIT_LOGGER.log(logRecord);
    }

    private String getLogMessage(Object message) {
        if (message instanceof Throwable) {
            return ExceptionUtils.getStackTrace((Throwable) message);
        } else {
            return String.valueOf(message);
        }
    }
}
