package tv.purple.monolith.bridge.di;

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.internal.GeneratedComponent
import tv.purple.monolith.component.api.di.module.ApiModule
import tv.purple.monolith.core.LifecycleCore
import tv.purple.monolith.core.di.module.NetworkModule
import tv.purple.monolith.features.chapters.VodChapters
import tv.purple.monolith.features.chat.ChatHookProvider
import tv.purple.monolith.features.logs.ChatLogs
import tv.purple.monolith.features.proxy.Proxy
import tv.purple.monolith.features.settings.PurpleTVSettings
import tv.purple.monolith.features.tracking.Tracker
import tv.purple.monolith.features.ui.UI
import tv.purple.monolith.features.updater.Updater
import tv.purple.monolith.features.vodhunter.VodHunter
import tv.twitch.android.core.user.TwitchAccountManager
import javax.inject.Singleton

@Singleton
@Component(modules = [MotherModule::class, NetworkModule::class, ApiModule::class])
interface MotherComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Context): MotherComponent
    }

    fun twitchActivityComponentFactory(): TwitchActivityComponent.Factory

    @Singleton
    fun provideChatHookProvider(): ChatHookProvider

    @Singleton
    fun provideLifecycle(): LifecycleCore

    @Singleton
    fun provideTwitchAccountManager(): TwitchAccountManager

    @Singleton
    fun provideOrangeSettings(): PurpleTVSettings

    @Singleton
    fun provideUI(): UI

    @Singleton
    fun provideUpdater(): Updater

    @Singleton
    fun provideTracker(): Tracker

    @Singleton
    fun provideChatLogs(): ChatLogs

    @Singleton
    fun provideProxy(): Proxy

    @Singleton
    fun provideSingletonC(): GeneratedComponent

    @Singleton
    fun provideVodChapters(): VodChapters

    @Singleton
    fun provideVodHunter(): VodHunter
}
