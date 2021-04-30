package carpetextra.mixins;

import carpetextra.CarpetExtraSettings;
import com.mojang.serialization.Codec;
import net.minecraft.entity.EntityType;
import net.minecraft.util.collection.Pool;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.JungleTempleFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(JungleTempleFeature.class)
public abstract class JungleTempleFeature_creeperMixin extends StructureFeature<DefaultFeatureConfig>
{

    
    private static final Pool<SpawnSettings.SpawnEntry> MONSTER_SPAWNS;

    public JungleTempleFeature_creeperMixin(Codec<DefaultFeatureConfig> codec)
    {
        super(codec);
    }

    @Override
    public Pool<SpawnSettings.SpawnEntry> getMonsterSpawns()
    {
        if (CarpetExtraSettings.creeperSpawningInJungleTemples)
        {
            return MONSTER_SPAWNS;
        }
        return SpawnSettings.EMPTY_ENTRY_POOL;
    }
    
    static
    {
        MONSTER_SPAWNS = Pool.of(new SpawnSettings.SpawnEntry(EntityType.CREEPER, 1, 1, 1));
    }
}
