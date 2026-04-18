package net.itsfirecat.axissmp.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PulseArcItem extends Item {
    public PulseArcItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient()) {
            double radius = 5.0;

            world.getEntitiesByClass(
                    LivingEntity.class,
                    user.getBoundingBox().expand(radius),
                    entity -> entity != user
            ).forEach(entity -> {
                Vec3d direction = entity.getPos()
                        .subtract(user.getPos())
                        .normalize();

                // knockback 3 equivalent is around 2.5 velocity according to claude sonnet 4.6*
                double strength = 2.5;

                entity.setVelocity(
                        direction.x * strength,
                        1,  // very slight pop (source: trust me bro 👍)
                        direction.z * strength
                );
                entity.velocityModified = true;
            });

            // 10 min cooldown = 12000t
            user.getItemCooldownManager().set(this, 12000);

            world.playSound(
                    null,
                    user.getBlockPos(),
                    SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE,
                    SoundCategory.PLAYERS,
                    1.0f,
                    1.2f
            );

            user.incrementStat(net.minecraft.stat.Stats.USED.getOrCreateStat(this));
        }

        return TypedActionResult.success(stack, world.isClient());
    }
}