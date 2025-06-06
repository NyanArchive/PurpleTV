package tv.twitch.android.feature.viewer.main;

import android.os.Bundle;
import android.view.ViewGroup;

import tv.purple.monolith.features.ui.UI;
import tv.purple.monolith.features.ui.bridge.UIHook;
import tv.purple.monolith.features.updater.Updater;
import tv.purple.monolith.models.exception.VirtualImpl;
import tv.twitch.android.core.activities.TwitchDaggerActivity;
import tv.twitch.android.feature.viewer.main.navigation.PersistentBannerPresenter;

public class MainActivity extends TwitchDaggerActivity {
    private ViewGroup mWrapper;

    private final PersistentBannerPresenter.PersistentBannerPresenterListener mPersistentBannerPresenterListener = new PersistentBannerPresenter.PersistentBannerPresenterListener() {
        @Override
        public void updateDismissed() {
            throw new VirtualImpl();
        }

        @Override
        public void installBannerShown() {
            throw new VirtualImpl();
        }

        @Override
        public void installUpdate() { // TODO: __REPLACE_METHOD
            // Updater.get().onBannerInstallUpdateClicked(MainActivity.this);
        }
    };

    /* ... */

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        /* ... */

        this.mWrapper = null;
        UI.attachToMainActivityWrapper(this.mWrapper); // TODO: __INJECT_CODE

        /* ... */

        throw new VirtualImpl();
    }

    /* ... */
}
