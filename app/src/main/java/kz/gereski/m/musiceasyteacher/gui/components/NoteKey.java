package kz.gereski.m.musiceasyteacher.gui.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import kz.gereski.m.musiceasyteacher.R;
import kz.gereski.m.musiceasyteacher.core.music.Note.Notes;

public class NoteKey extends FrameLayout {
    String TAG = NoteKey.class.getSimpleName();

    Notes note = Notes.s4do;
    String noteName = "";
    boolean isBlack = false;
    int noteSound;
    NoteHelper noteHelper;

    private enum State {UP, DOWN}

    int[] whiteState = {R.drawable.white_up, R.drawable.white_down};
    int[] blackState = {R.drawable.black_up, R.drawable.black_down};

    public NoteKey(Context context) {
        super(context);
    }

    public NoteKey(Context context, AttributeSet attrs) {
        super(context, attrs);
        getNoteAttributes(attrs);
        setNote(note);
        addLayers();
    }

    private void getNoteAttributes(AttributeSet attrs) {
        @SuppressLint("Recycle")
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.notes);
        note = Notes.valueOf(a.getString(R.styleable.notes_note));
        noteName = a.getString(R.styleable.notes_noteName);
    }

    public NoteKey(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setNote(Notes note) {
        this.note = note;
        if (note.toString().contains("#")) isBlack = true;
        setBackgroundResource(getNoteColor(State.UP));
        noteHelper = NoteHelper.getInstance();
        noteSound = noteHelper
                .load(this.getContext(), note.getSoundLink(this.getContext()));
    }

    private void addLayers() {
        TextView txt = new TextView(this.getContext());
        txt.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        txt.setGravity(Gravity.CENTER_VERTICAL);
        txt.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        txt.setTextColor(Color.GREEN);
        txt.setText(noteName);
        addView(txt);

        ImageView iv = new ImageView(this.getContext());
        iv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        iv.setBackgroundColor(Color.argb(50,255,2,2));
        addView(iv);
    }

    private int getNoteColor(State state) {
        if (isBlack)
            return state == State.UP ? blackState[0] : blackState[1];
        else return state == State.UP ? whiteState[0] : whiteState[1];
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                setBackgroundResource(getNoteColor(State.UP));
                break;
            case MotionEvent.ACTION_DOWN:
                setBackgroundResource(getNoteColor(State.DOWN));
                noteHelper.play(noteSound);
                break;
        }
        return true;
    }
}
