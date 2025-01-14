package net.tigereye.chestcavity.registration;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.tigereye.chestcavity.ChestCavity;

public class CCTags {
    //unused, notes which organs are normal within humanoids
    public static final Tag<Item> HUMAN_ORGANS = TagRegistry.item(new Identifier(ChestCavity.MODID,"human_organs"));
    //unused, notes which organs are normal within undead
    public static final Tag<Item> UNDEAD_ORGANS = TagRegistry.item(new Identifier(ChestCavity.MODID,"undead_organs"));
    //used to know which organs are more effective when used by animals
    public static final Tag<Item> ANIMAL_ORGANS = TagRegistry.item(new Identifier(ChestCavity.MODID,"animal_organs"));
    public static final Tag<Item> SMALL_ANIMAL_ORGANS = TagRegistry.item(new Identifier(ChestCavity.MODID,"small_animal_organs"));
    //used in crafting recipes, though currently unused outside of JSONs
    public static final Tag<Item> SALVAGEABLE_ROTTEN_ORGANS = TagRegistry.item(new Identifier(ChestCavity.MODID,"salvageable_rotten_organs"));
    public static final Tag<Item> SALVAGEABLE_ANIMAL_MEAT_ORGANS = TagRegistry.item(new Identifier(ChestCavity.MODID,"salvageable_animal_meat_organs"));
    public static final Tag<Item> SALVAGEABLE_SMALL_ANIMAL_MEAT_ORGANS = TagRegistry.item(new Identifier(ChestCavity.MODID,"salvageable_small_animal_meat_organs"));
    public static final Tag<Item> SALVAGEABLE_BONE_ORGANS = TagRegistry.item(new Identifier(ChestCavity.MODID,"salvageable_bone_organs"));
}
