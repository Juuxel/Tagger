/* This file is a part of the Tagger project
 * by Juuxel, licensed under the MIT license.
 * Full code and license: https://github.com/Juuxel/Tagger
 */
package juuxel.tagger.mixin;

import juuxel.tagger.Tagger;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.Tag;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(World.class)
public abstract class WorldMixin {
    @Redirect(method = "doesAreaContainFireSource", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;getBlock()Lnet/minecraft/block/Block;"))
    private Block fireSourceProxy(BlockState state) {
        return genericBlockProxy(state, Tagger.FIRE);
    }

    @Redirect(method = "method_8506", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;getBlock()Lnet/minecraft/block/Block;"))
    private Block instaDestroyProxy(BlockState state) {
        return genericBlockProxy(state, Tagger.EXTINGUISHES_LIKE_FIRE);
    }

    private Block genericBlockProxy(BlockState state, Tag<Block> tag) {
        if (state.getBlock().matches(tag))
            return Blocks.FIRE;

        return state.getBlock();
    }
}
