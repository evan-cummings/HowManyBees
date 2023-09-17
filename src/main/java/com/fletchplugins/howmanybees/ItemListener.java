package com.fletchplugins.howmanybees;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.block.Beehive;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ItemListener implements Listener {
    @EventHandler
    public void onItemPickup(EntityPickupItemEvent event){
        ItemStack item= event.getItem().getItemStack();
        if(item.getType()== Material.BEEHIVE||item.getType()==Material.BEE_NEST) {
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Beehive hive = (Beehive) meta.getBlockState();
            int BeeCount=hive.getEntityCount();
            String honeyString=item.getItemMeta().toString();
            String honeyAmount=""+honeyString.charAt(honeyString.indexOf("honey_level")+12);
            String[] bees;
            if(BeeCount==1){
                bees=new String[]{"§eThere is "+"§l"+BeeCount+"§r§e bee in this hive!","§6The honey level in this hive is"+" §l"+honeyAmount};
            }
            else{
                bees=new String[]{"§eThere are "+"§l"+BeeCount+"§r§e bees in this hive!","§6The honey level in this hive is"+" §l"+honeyAmount};
            }

            meta.setLore(Arrays.asList(bees));
            item.setItemMeta(meta);
        }
    }
}
