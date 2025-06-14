package tv.twitch.android.shared.player.overlay.databinding;

import android.view.View;
import android.widget.ImageView;

import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;

import tv.purple.monolith.features.chapters.bridge.ChaptersHook;
import tv.purple.monolith.features.timer.bridge.TimerHook;
import tv.purple.monolith.models.exception.VirtualImpl;

public class PlayerControlOverlayBinding {
    public final ImageView shareButton = null;
    public final ImageView createClipButton = null;
    public final ComposeView createClipTextButton = null;


    /* ... */

    public ImageView timerButton = null; // TODO: __INJECT_FIELD
    public ImageView chaptersButton = null; // TODO: __INJECT_FIELD

    /* ... */

    public ConstraintLayout getRoot() {
        throw new VirtualImpl();
    }

    /* ... */

    public static PlayerControlOverlayBinding bind(View view) {
        PlayerControlOverlayBinding instance = new PlayerControlOverlayBinding();
        instance.bindPurpleTVStuff(); // TODO: __INJECT_CODE

        /* ... */

        throw new VirtualImpl();
    }

    private void bindPurpleTVStuff() { // TODO: __INJECT_METHOD
        timerButton = TimerHook.getTimerButton(getRoot());
        chaptersButton = ChaptersHook.getChaptersButton(getRoot());
    }
}