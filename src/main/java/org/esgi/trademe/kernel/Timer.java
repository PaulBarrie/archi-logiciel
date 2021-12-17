package org.esgi.trademe.kernel;

public final class Timer {
    private final String cron;
    private final String timeZone;

    private Timer(String cron, String timeZone) {
        this.cron = cron;
        this.timeZone = timeZone;
    }

    public static Timer of(String cron, String timeZone) {
        return new Timer(cron, timeZone);
    }

    public String getCron() {
        return cron;
    }

    public String getTimeZone() {
        return timeZone;
    }
}
