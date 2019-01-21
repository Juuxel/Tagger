/* This file is a part of the Tagger project
 * by Juuxel, licensed under the MIT license.
 * Full code and license: https://github.com/Juuxel/Tagger
 */
package juuxel.tagger.mixin;

import juuxel.tagger.internal.TagEntryExtensions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.Tag;
import net.minecraft.world.loot.context.LootContext;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

// fixme pls
@Pseudo
@Mixin(targets = "net.minecraft.class_91", remap = false)
public class TagEntryObfMixin implements TagEntryExtensions {
    @Shadow @Final private Tag<Item> field_1005;
    private boolean random = false;

    @Override
    public boolean isRandom() {
        return random;
    }

    @Override
    public void setRandom(boolean random) {
        this.random = random;
    }

    @Inject(method = "method_433", at = @At("HEAD"), cancellable = true)
    private void onDrop(Consumer<ItemStack> consumer, LootContext context, CallbackInfo info) {
        if (random) {
            consumer.accept(new ItemStack(field_1005.getRandom(context.getRandom())));
            info.cancel();
        }
    }
}
