package it.paranoidsquirrels.idleguildmaster.storage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import android.app.Activity;
import com.google.android.gms.games.PlayGames;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import java.io.FileOutputStream;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import it.paranoidsquirrels.idleguildmaster.Utils;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange$Builder;
import com.google.android.gms.games.SnapshotsClient$DataOrConflict;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.games.SnapshotsClient;
import java.lang.reflect.Type;
import it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer;
import it.paranoidsquirrels.idleguildmaster.storage.data.Data;
import com.google.gson.GsonBuilder;
import java.io.File;
import android.content.Context;
import com.google.gson.Gson;

public class FileManager
{
    private static final String FILE_NAME = "data.txt";
    private static final String FILE_NAME_BACKUP = "databackup.txt";
    private static Gson gson;
    private static boolean saveToggle;
    private static boolean writeToCloud;
    
    private FileManager() {
    }
    
    public static void cleanFile(final Context context) {
        context.deleteFile("data.txt");
        context.deleteFile("databackup.txt");
    }
    
    public static File getSaveFile(final Context context) {
        final File file = new File(context.getFilesDir(), "data.txt");
        if (file.exists()) {
            return file;
        }
        return null;
    }
    
    private static void initGson() {
        if (FileManager.gson == null) {
            FileManager.gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter((Type)Data.class, (Object)new DataDeserializer()).create();
        }
    }
    
    public static Data load(final Context context) {
        Data loadFile;
        try {
            loadFile = loadFile(context, "data.txt");
        }
        catch (final Exception ex) {
            loadFile = new Data();
        }
        Data loadFile2;
        try {
            loadFile2 = loadFile(context, "databackup.txt");
        }
        catch (final Exception ex2) {
            loadFile2 = new Data();
        }
        return Utils.getNewestSaveFile(loadFile, loadFile2);
    }
    
    private static Data loadFile(final Context context, String s) throws IOException {
        final FileInputStream openFileInput = context.openFileInput(s);
        final InputStreamReader inputStreamReader = new InputStreamReader((InputStream)openFileInput, StandardCharsets.UTF_8);
        final StringBuilder sb = new StringBuilder();
        s = (String)new BufferedReader((Reader)inputStreamReader);
        try {
            for (String s2 = ((BufferedReader)s).readLine(); s2 != null; s2 = ((BufferedReader)s).readLine()) {
                sb.append(s2);
            }
            final String string = sb.toString();
            openFileInput.close();
            ((BufferedReader)s).close();
            if (string.isEmpty()) {
                return new Data();
            }
            if (FileManager.gson == null) {
                initGson();
            }
            return (Data)FileManager.gson.fromJson(string, (Class)Data.class);
        }
        finally {
            try {
                ((BufferedReader)s).close();
            }
            finally {
                final Throwable t;
                ((Throwable)context).addSuppressed(t);
            }
        }
    }
    
    public static Data loadFromTestFile(final Context context) {
        final StringBuilder sb = new StringBuilder();
        final AssetManager assets = context.getAssets();
        try {
            final BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader(assets.open("manual_load.txt")));
            while (true) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            bufferedReader.close();
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        final String string = sb.toString();
        if (string.isEmpty()) {
            return new Data();
        }
        if (FileManager.gson == null) {
            initGson();
        }
        return (Data)FileManager.gson.fromJson(string, (Class)Data.class);
    }
    
    public static void overwriteFile(final Context context, final String s) {
        final boolean saveToggle = FileManager.saveToggle;
        String s2;
        if (saveToggle) {
            s2 = "data.txt";
        }
        else {
            s2 = "databackup.txt";
        }
        FileManager.saveToggle = (saveToggle ^ true);
        try {
            final FileOutputStream openFileOutput = context.openFileOutput(s2, 0);
            try {
                openFileOutput.write(s.getBytes());
                openFileOutput.flush();
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
            }
            finally {
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    }
                    finally {
                        final Throwable t;
                        ((Throwable)context).addSuppressed(t);
                    }
                }
            }
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void save(final Context context) {
        if (FileManager.gson == null) {
            initGson();
        }
        try {
            final String json = FileManager.gson.toJson((Object)MainActivity.data);
            overwriteFile(context, json);
            if (FileManager.writeToCloud) {
                int n = 0;
                FileManager.writeToCloud = false;
                int n2;
                if (MainActivity.data.isImperialVanguardPurchased()) {
                    n2 = 4;
                }
                else {
                    n2 = 0;
                }
                if (MainActivity.data.isUnholyCrusadePurchased()) {
                    n = 4;
                }
                if (MainActivity.data.getAdventurers().size() > n2 + 3 + n) {
                    writeSnapshot(json.getBytes(StandardCharsets.UTF_8));
                }
            }
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void writeSnapshot(final byte[] array) {
        try {
            final SnapshotsClient snapshotsClient = PlayGames.getSnapshotsClient((Activity)MainActivity.dungeonsFragment.getActivity());
            snapshotsClient.open("game_saved", true, 3).addOnFailureListener((OnFailureListener)FileManager$$ExternalSyntheticLambda1.INSTANCE).continueWith((Continuation)new FileManager$$ExternalSyntheticLambda0(array, snapshotsClient));
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void writeToCloud() {
        FileManager.writeToCloud = true;
    }
}
