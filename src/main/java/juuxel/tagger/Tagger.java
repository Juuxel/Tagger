/* This file is a part of the Tagger project
 * by Juuxel, licensed under the MIT license.
 * Full code and license: https://github.com/Juuxel/Tagger
 */
package juuxel.tagger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.tags.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class Tagger implements ModInitializer {
    public static final Tag<Block> FIRE = TagRegistry.block(new Identifier("tagger", "fire"));
    public static final Tag<Block> EXTINGUISHES_LIKE_FIRE = TagRegistry.block(new Identifier("tagger", "extinguishes_like_fire"));
    public static final Tag<Block> CAN_SUPPORT_TORCHES = TagRegistry.block(new Identifier("tagger", "can_support_torches"));
    public static final Tag<Item> SEEDS = TagRegistry.item(new Identifier("tagger", "seeds"));

    @Override
    public void onInitialize() {}
}
