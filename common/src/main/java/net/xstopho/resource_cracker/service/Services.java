package net.xstopho.resource_cracker.service;

import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.service.platform.IPlatformHelper;

import java.util.ServiceLoader;

public class Services {

    public static IPlatformHelper.Platforms PLATFORM = load(IPlatformHelper.class).getPlatform();

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        Constants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}
