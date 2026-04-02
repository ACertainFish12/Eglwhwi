package it.paranoidsquirrels.idleguildmaster;

import com.instacart.library.truetime.TrueTime;

public class TrueTimeUtils
{
    public static void init() {
        new Thread((Runnable)TrueTimeUtils$$ExternalSyntheticLambda0.INSTANCE).start();
    }
    
    public static long millis() {
        try {
            return TrueTime.now().getTime();
        }
        catch (final Exception ex) {
            if (ex instanceof IllegalStateException) {
                init();
            }
            ex.printStackTrace();
            return System.currentTimeMillis();
        }
    }
}
