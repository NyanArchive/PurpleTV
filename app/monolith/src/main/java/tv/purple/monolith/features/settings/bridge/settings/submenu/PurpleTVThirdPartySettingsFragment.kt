package tv.purple.monolith.features.settings.bridge.settings.submenu

import tv.purple.monolith.features.settings.bridge.IModFragment
import tv.twitch.android.shared.settings.BaseSettingsFragment
import tv.twitch.android.shared.settings.BaseSettingsPresenter

class PurpleTVThirdPartySettingsFragment : BaseSettingsFragment(), IModFragment {
    lateinit var presenterImpl: BaseSettingsPresenter

    override fun createPresenter(): BaseSettingsPresenter {
        return presenterImpl
    }

    override fun setPresenter(presenter: BaseSettingsPresenter) {
        presenterImpl = presenter
    }
}