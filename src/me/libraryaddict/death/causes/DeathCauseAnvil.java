package me.libraryaddict.death.causes;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import me.libraryaddict.death.DeathCause;

public class DeathCauseAnvil extends DeathCause {

    @Override
    public Entity getKiller(EntityDamageEvent event) {
        return null;
    }

    @Override
    public boolean isCauseOfDeath(EntityDamageEvent event) {
        if (event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent entityEvent = (EntityDamageByEntityEvent) event;
            if (entityEvent.getDamager() instanceof FallingBlock && event.getDamage() > 0) {
                FallingBlock block = (FallingBlock) entityEvent.getDamager();
                return block.getBlockData().getMaterial() == Material.ANVIL;
            }
        }
        return false;
    }

}
