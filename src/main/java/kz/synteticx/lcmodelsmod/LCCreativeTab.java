package kz.synteticx.lcmodelsmod;

import com.tterrag.registrate.util.entry.RegistryEntry;
import kz.synteticx.lcmodelsmod.loader.LCRegistrate;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

import static kz.synteticx.lcmodelsmod.LCModelsMod.REGISTRATE;

public class LCCreativeTab {
    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LCModelsMod.MOD_ID);

    private static final Map<RegistryEntry<?>, RegistryObject<CreativeModeTab>> TAB_LOOKUP = Collections.synchronizedMap(new IdentityHashMap<>());

    public static final RegistryObject<CreativeModeTab> BASE_CREATIVE_TAB = REGISTER.register("vehiclebindings",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("Vehicle Bindings"))
                    .icon(() -> Items.CARROT.getDefaultInstance()).displayItems((displayParams, output) -> {
                        for (RegistryEntry<Block> entry : REGISTRATE.getAll(Registries.BLOCK)) {
                            if (LCRegistrate.isInCreativeTab(entry, LCCreativeTab.BASE_CREATIVE_TAB)) {
                                output.accept(entry.get().asItem());
                            }
                        }
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
