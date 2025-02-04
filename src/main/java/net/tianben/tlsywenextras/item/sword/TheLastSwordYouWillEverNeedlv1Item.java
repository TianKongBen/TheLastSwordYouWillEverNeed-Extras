package net.tianben.tlsywenextras.item.sword;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.stat.Stats;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.tianben.tlsywen.entity.LDlv1Entity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TheLastSwordYouWillEverNeedlv1Item extends SwordItem {

    private final int attackDamage;

    private static final float ATTACK_SPEED = -2.4f;

    public TheLastSwordYouWillEverNeedlv1Item(ToolMaterial toolMaterial) {
        super(toolMaterial, -1, ATTACK_SPEED, new FabricItemSettings());

        attackDamage = (int)toolMaterial.getAttackDamage();
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return 60.0f;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("tooltip.tlsywen." + Registries.ITEM.getId(this).getPath()).fillStyle(Style.EMPTY.withColor(Formatting.GRAY).withItalic(false)));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
            LDlv1Entity lightningProjectileEntity = new LDlv1Entity(world, user);
            lightningProjectileEntity.setItem(itemStack);
            lightningProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 0.0f);
            world.spawnEntity(lightningProjectileEntity);
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(itemStack, world.isClient());
        }
        return TypedActionResult.pass(itemStack);
    }
}
