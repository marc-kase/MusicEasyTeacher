package kz.gereski.m.musiceasyteacher.gui.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import kz.gereski.m.musiceasyteacher.R;
import kz.gereski.m.musiceasyteacher.core.music.Note;

public class NoteHelper {
    public static final int MAX_STREAMS = 15;
    SoundPool soundPool;
    Context context;

    private static final NoteHelper instance = new NoteHelper();

    public NoteHelper() {
        soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
    }

    public int load(Context context, int resourse) {
        return soundPool
                .load(context, resourse, 1);
    }

    public void play(int noteSound) {
        soundPool.play(noteSound, 0.9f, 0.9f, 1, 0, 1);
    }

    public static NoteHelper getInstance() {
        return instance;
    }
}
