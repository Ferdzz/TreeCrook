package me.ferdz.treecrook;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TreeCrook extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(e.getPlayer().getItemInHand() == null)
			return;
		
		Material hoeType = e.getPlayer().getItemInHand().getType();
		if(hoeType.equals(Material.DIAMOND_HOE) || hoeType.equals(Material.GOLD_HOE) || hoeType.equals(Material.IRON_HOE) || hoeType.equals(Material.STONE_HOE) || hoeType.equals(Material.WOOD_HOE)
				&& (e.getBlock().getType().equals(Material.LEAVES) || e.getBlock().getType().equals(Material.LEAVES_2))) {
			
			int baseX = e.getBlock().getX(), baseY = e.getBlock().getY(), baseZ = e.getBlock().getZ();
			for (int x = baseX - 1; x <= baseX + 1; x++) {
				for (int y = baseY - 1; y <= baseY + 1; y++) {
					for (int z = baseZ - 1; z <= baseZ + 1; z++) {
						Block b = e.getBlock().getWorld().getBlockAt(x, y, z);
						if(b.getType().equals(Material.LEAVES) || b.getType().equals(Material.LEAVES_2))
							b.breakNaturally();
					}
				}
			}
		}
	}
}
