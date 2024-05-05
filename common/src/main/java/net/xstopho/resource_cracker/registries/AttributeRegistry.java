package net.xstopho.resource_cracker.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

public class AttributeRegistry {
    private static final RegistryProvider<Attribute> ATTRIBUTES = RegistryProvider.get(Registries.ATTRIBUTE, CrackerConstants.MOD_ID);

    public static final RegistryObject<Attribute> ATTACK_RANGE = ATTRIBUTES.register("attack_range",
            () -> new RangedAttribute("attribute.generic.attack_range", 4.5, 0.0, 1024.0).setSyncable(true));

    public static void init() {}
}
