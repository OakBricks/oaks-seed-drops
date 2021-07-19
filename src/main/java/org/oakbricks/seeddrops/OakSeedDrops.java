package org.oakbricks.seeddrops;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.util.Identifier;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.entry.ItemEntry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

public class OakSeedDrops implements ModInitializer {
	
	public static final OakSeedDropsConfig CONFIG = AutoConfig.register(OakSeedDropsConfig.class, Toml4jConfigSerializer::new).getConfig();
	public static final String MOD_ID = "oak_seed_drops";
	public static final Logger LOGGER = LogManager.getLogger("OakBricks' Seed Drops Mod");
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Carrot Drop Rolls: " + CONFIG.drops.carrot_rolls);
		LOGGER.info("Potato Drop Rolls: " + CONFIG.drops.potato_rolls);
		LOGGER.info("Beetroot Seeds Drop Rolls: " + CONFIG.drops.beetroot_seeds_rolls);
		LOGGER.info("Melon Seeds Drop Rolls: " + CONFIG.drops.melon_seeds_rolls);
		LOGGER.info("Pumpkin Seeds Drop Rolls: " + CONFIG.drops.pumpkin_seeds_rolls);

		/*private static */final Identifier GRASS_LOOT_TABLE_ID = Blocks.GRASS.getLootTableId();

		LootTableLoadingCallback.EVENT.register(((resourceManager, lootManager, id, table, setter) -> {
		   	if (GRASS_LOOT_TABLE_ID.equals(id)) {
		       	if (GRASS_LOOT_TABLE_ID.equals(id)) {
		           	FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
		           			.rolls(ConstantLootTableRange.create(CONFIG.drops.carrot_rolls))
		           			.with(ItemEntry.builder(Items.CARROT))
		           			.rolls(ConstantLootTableRange.create(CONFIG.drops.melon_seeds_rolls))
		           			.with(ItemEntry.builder(Items.MELON_SEEDS))
		           			.rolls(ConstantLootTableRange.create(CONFIG.drops.pumpkin_seeds_rolls))
		           			.with(ItemEntry.builder(Items.PUMPKIN_SEEDS))
		           			.rolls(ConstantLootTableRange.create(CONFIG.drops.beetroot_seeds_rolls))
		           			.with(ItemEntry.builder(Items.BEETROOT_SEEDS))
		           			.rolls(ConstantLootTableRange.create(CONFIG.drops.wheat_seeds_booster_rolls))
		           			.with(ItemEntry.builder(Items.WHEAT_SEEDS))
		           			.rolls(ConstantLootTableRange.create(CONFIG.drops.potato_rolls))
		           			.with(ItemEntry.builder(Items.POTATO));
		           
		           	table.pool(poolBuilder);
		        }
		    }
		
		}));
	}
}
