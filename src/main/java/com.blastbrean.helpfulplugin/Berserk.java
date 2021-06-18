package com.blastbrean.helpfulplugin;

import org.bukkit.potion.PotionEffect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffectType;

public class Berserk implements Listener {
    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity.getType() == EntityType.PLAYER) {
            if (!entity.isDead()) {
                LivingEntity livingEntity = (LivingEntity) entity;
                // 11 = 5.5 hearts
                if (livingEntity.getHealth() < 11 && livingEntity.getHealth() - event.getFinalDamage() != 0) {
                    event.setDamage(event.getFinalDamage() / event.getFinalDamage() * 1.5);
                    livingEntity.addPotionEffect(
                            new PotionEffect(PotionEffectType.INCREASE_DAMAGE,100,3,true,true,true)
                    );
                }
            }
        }
    }
}
