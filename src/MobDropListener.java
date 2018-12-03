import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MobDropListener implements Listener {

    public MobDropListener() {
        super();
    }

    @EventHandler
    public void onMobDrop(EntityDeathEvent event) {
        final LivingEntity entity;
        final EntityType type;
        entity = event.getEntity();
        type = entity.getType();
        if (type == EntityType.IRON_GOLEM) {
            final List<ItemStack> drops;
            drops = event.getDrops();
            replaceIronWithQuartz(drops);
        } else if (type == EntityType.PIG_ZOMBIE) {
            final List<ItemStack> drops;
            drops = event.getDrops();
            replaceGoldWithEmeralds(drops);
        }
    }

    private void replaceIronWithQuartz(List<ItemStack> drops) {
        for (int i = 0; i < drops.size(); i++) {
            ItemStack itemStack;
            final Material material;
            itemStack = drops.get(i);
            material = itemStack.getType();
            if (material == Material.IRON_INGOT) {
                itemStack.setType(Material.QUARTZ);
            }
        }
    }

    private void replaceGoldWithEmeralds(List<ItemStack> drops) {
        for (int i = 0; i < drops.size(); i++) {
            ItemStack itemStack;
            final Material material;
            itemStack = drops.get(i);
            material = itemStack.getType();
            if (material == Material.GOLD_INGOT || material == Material.GOLD_NUGGET) {
                itemStack.setType(Material.EMERALD);
            }
        }
    }

}
