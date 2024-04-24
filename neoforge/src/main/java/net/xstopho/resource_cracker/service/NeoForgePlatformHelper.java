package net.xstopho.resource_cracker.service;

import net.xstopho.resource_cracker.service.platform.IPlatformHelper;

public class NeoForgePlatformHelper implements IPlatformHelper {
    @Override
    public Platforms getPlatform() {
        return Platforms.NEOFORGE;
    }
}
