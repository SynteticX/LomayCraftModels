package kz.synteticx.lcmodelsmod;

import com.tterrag.registrate.util.entry.RegistryEntry;
import kz.synteticx.lcmodelsmod.blocks.CarBaseBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;

import static kz.synteticx.lcmodelsmod.LCModelsMod.REGISTRATE;

public class LCBlocks {
    static {
        REGISTRATE.setCreativeTab(LCCreativeTab.BASE_CREATIVE_TAB);
    }

    public static final RegistryEntry<CarBaseBlock> CAR_BLOCK = REGISTRATE.block("sprinter312d", CarBaseBlock::new)
            .properties(p -> p.mapColor(MapColor.METAL))
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .lang("Binding Block Up")
            .item()
            .build()
            .register();

    public static void register(IEventBus eventBus) {
        // Регистрируем блоки в EventBus
        REGISTRATE.registerEventListeners(eventBus);
    }
}
