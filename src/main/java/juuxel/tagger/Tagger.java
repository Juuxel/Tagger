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
    /**
     * Deals fire damage to the player.
     */
    public static final Tag<Block> FIRE = TagRegistry.block(new Identifier("tagger", "fire"));

    /**
     * Can be punched to destroy (for blocks without a bounding box, doesn't drop items).
     */
    public static final Tag<Block> EXTINGUISHES_LIKE_FIRE = TagRegistry.block(new Identifier("tagger", "extinguishes_like_fire"));

    /**
     * Drops from grass like wheat seeds in vanilla.
     */
    public static final Tag<Item> SEEDS = TagRegistry.item(new Identifier("tagger", "seeds"));

    @Override
    public void onInitialize() {}
}
