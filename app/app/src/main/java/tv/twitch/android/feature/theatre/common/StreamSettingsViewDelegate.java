package tv.twitch.android.feature.theatre.common;

import android.view.View;
import android.view.ViewGroup;

import tv.purple.monolith.features.vodsync.bridge.VodSyncHook;
import tv.purple.monolith.models.exception.VirtualImpl;
import tv.twitch.android.core.mvp.viewdelegate.RxViewDelegate;
import tv.twitch.android.core.mvp.viewdelegate.ViewDelegateEvent;
import tv.twitch.android.core.mvp.viewdelegate.ViewDelegateState;

public class StreamSettingsViewDelegate extends RxViewDelegate<StreamSettingsViewDelegate.State, ViewDelegateEvent> {

    private final ViewGroup chommentSeekerSection; // TODO: __INJECT_CODE
    private final View chommentSeekerHeader; // TODO: __INJECT_CODE

    public StreamSettingsViewDelegate(View view) {
        super(view);

        /* ... */

        chommentSeekerSection = VodSyncHook.getChommentSeekerSection(this); // TODO: __INJECT_CODE
        chommentSeekerHeader = VodSyncHook.getChommentSeekerHeader(this); // TODO: __INJECT_CODE

        throw new VirtualImpl();
    }

    @Override
    public void render(State viewDelegateState) {
        /* ... */

        VodSyncHook.renderChommentSeekerSection(chommentSeekerSection, chommentSeekerHeader, viewDelegateState.getSettingsModel().getConfigurablePlayer()); // TODO: __INJECT_CODE

        throw new VirtualImpl();
    }

    /* ... */

    public static final class State implements ViewDelegateState {
        /* ... */

        public final StreamSettingsPresenter.StreamSettingsModel getSettingsModel() {
            throw new VirtualImpl();
        }

        /* ... */
    }
}
