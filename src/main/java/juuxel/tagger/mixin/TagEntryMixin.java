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

@Pseudo
@Mixin(targets = "net.minecraft.world.loot.entry.TagEntry")
public class TagEntryMixin implements TagEntryExtensions {
    @Shadow @Final private Tag<Item> name;
    private boolean random = false;

    @Override
    public boolean isRandom() {
        return random;
    }

    @Override
    public void setRandom(boolean random) {
        this.random = random;
    }

    @Inject(method = "drop", at = @At("HEAD"), cancellable = true)
    private void onDrop(Consumer<ItemStack> consumer, LootContext context, CallbackInfo info) {
        if (random) {
            consumer.accept(new ItemStack(name.getRandom(context.getRandom())));
            info.cancel();
        }
    }
}
