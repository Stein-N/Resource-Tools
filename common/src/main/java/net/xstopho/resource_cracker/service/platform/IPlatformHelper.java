package net.xstopho.resource_cracker.service.platform;

public interface IPlatformHelper {

    Platforms getPlatform();

    enum Platforms {
        FABRIC, FORGE, NEOFORGE;
    }
}
