package com.lantern.physics.items.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class WindDebuggerItem extends Item {
    public WindDebuggerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            List<Entity> nearbyEntities = world.getEntitiesByClass(
                    Entity.class,
                    user.getBoundingBox().expand(5),
                    entity -> entity != user
            );

            for (Entity entity : nearbyEntities) {
                Vec3d dir = user.getRotationVec(1.0F);
                double force = 1.5;
                entity.addVelocity(dir.x * force, 0.2, dir.z * force);
            }

            user.playSound(SoundEvents.ENTITY_ENDER_DRAGON_FLAP, 1.0F, 1.0F);
            ((ServerWorld) world).spawnParticles(ParticleTypes.CLOUD, user.getX(), user.getY(), user.getZ(), 30, 1, 1, 1, 0.05);
        }

        return ActionResult.SUCCESS;
    }
}
