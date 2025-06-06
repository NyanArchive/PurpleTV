package tv.twitch.android.shared.player.overlay.seekable;

import android.widget.SeekBar;

import tv.purple.monolith.models.exception.VirtualImpl;
import tv.twitch.android.models.player.SeekTrigger;

public class SeekbarOverlayViewDelegate {
    /* ... */

    private SeekBar seekbar;

    /* ... */

    private final void manualSeekToPosition(int i, SeekTrigger seekTrigger) {
        /* ... */

        throw new VirtualImpl();
    }

    public void xSeekTo(int seconds) { // TODO: __INJECT_METHOD
        seekbar.setProgress(seconds);
        manualSeekToPosition(seekbar.getProgress(), SeekTrigger.SEEK_MODAL);
    }

    /* ... */
}
