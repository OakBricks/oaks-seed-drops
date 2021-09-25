package org.oakbricks.seeddrops;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class OakSeedDrops implements ModInitializer {
	
	public static final OakSeedDropsConfig CONFIG = AutoConfig.register(OakSeedDropsConfig.class, JanksonConfigSerializer::new).getConfig();
	public static final String MOD_ID = "oak_seed_drops";
	public static final Logger LOGGER = LogManager.getLogger("OakBricks' Seed Drops Mod");
	public static final Identifier GRASS_LOOT_TABLE_ID = Blocks.GRASS.getLootTableId();
//	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(MOD_ID + ":drops");

	@Override
	public void onInitialize() {
		LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, table, setter) -> {
			if (GRASS_LOOT_TABLE_ID.equals(id)) {
				FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
						.rolls(ConstantLootNumberProvider.create(0.9f))
						.with(ItemEntry.builder(Items.EGG));

				table.pool(poolBuilder);
			}
		});
	}
}
