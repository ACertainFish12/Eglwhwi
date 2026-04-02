package it.paranoidsquirrels.idleguildmaster.storage;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import android.content.Context;
import java.util.TimerTask;
import java.util.Timer;

public class SaveManager
{
    private static SaveManager SAVE_TIMER;
    public static boolean inhibitSave;
    private Timer timer;
    private TimerTask timerTask;
    
    private SaveManager() {
    }
    
    public static SaveManager getInstance() {
        if (SaveManager.SAVE_TIMER == null) {
            SaveManager.SAVE_TIMER = new SaveManager();
        }
        return SaveManager.SAVE_TIMER;
    }
    
    private void saveToFile(final Context context) {
        if (MainActivity.IDLE_THREAD_FINISHED.value) {
            if (!SaveManager.inhibitSave) {
                FileManager.save(context);
            }
        }
    }
    
    public void initializeTimerTask(final Context context) {
        this.timerTask = new TimerTask(this, context) {
            final SaveManager this$0;
            final Context val$context;
            
            public void run() {
                this.this$0.saveToFile(this.val$context);
            }
        };
    }
    
    public void save(final Context context) {
        new Thread((Runnable)new SaveManager$$ExternalSyntheticLambda0(this, context)).start();
    }
    
    public void startTimer(final Context context) {
        this.stopTimerTask();
        this.timer = new Timer();
        this.initializeTimerTask(context);
        this.timer.schedule(this.timerTask, 8000L, 3000L);
    }
    
    public void stopTimerTask() {
        final Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }
}
