package org.oakbricks.seeddrops;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

import static net.devtech.arrp.api.RuntimeResourcePack.id;
import static net.devtech.arrp.json.loot.JLootTable.*;

public class OakSeedDrops implements ModInitializer {
	
	public static final OakSeedDropsConfig CONFIG = AutoConfig.register(OakSeedDropsConfig.class, JanksonConfigSerializer::new).getConfig();
	public static final String MOD_ID = "oak_seed_drops";
	public static final Logger LOGGER = LogManager.getLogger("OakBricks' Seed Drops Mod");
	public static final Identifier GRASS_LOOT_TABLE_ID = Blocks.GRASS.getLootTableId();
//	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(MOD_ID + ":drops");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.debug("Carrot Drop Rolls: " + CONFIG.rolls.carrot_rolls);
		LOGGER.debug("Potato Drop Rolls: " + CONFIG.rolls.potato_rolls);
		LOGGER.debug("Beetroot Seeds Drop Rolls: " + CONFIG.rolls.beetroot_seeds_rolls);
		LOGGER.debug("Melon Seeds Drop Rolls: " + CONFIG.rolls.melon_seeds_rolls);
		LOGGER.debug("Pumpkin Seeds Drop Rolls: " + CONFIG.rolls.pumpkin_seeds_rolls);


		LootTableLoadingCallback.EVENT.register(((resourceManager, lootManager, id, table, setter) -> {
		   	if (GRASS_LOOT_TABLE_ID.equals(id)) {
		       	if (GRASS_LOOT_TABLE_ID.equals(id)) {
		           	FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
		           			.rolls(ConstantLootNumberProvider.create(CONFIG.rolls.carrot_rolls))
							.conditionally(RandomChanceLootCondition.builder(CONFIG.chances.carrot_chances))
		           			.with(ItemEntry.builder(Items.CARROT))
		           			.rolls(ConstantLootNumberProvider.create(CONFIG.rolls.melon_seeds_rolls))
							.conditionally(RandomChanceLootCondition.builder(CONFIG.chances.melon_seeds_chances))
		           			.with(ItemEntry.builder(Items.MELON_SEEDS))
		           			.rolls(ConstantLootNumberProvider.create(CONFIG.rolls.pumpkin_seeds_rolls))
							.conditionally(RandomChanceLootCondition.builder(CONFIG.chances.pumpkin_seeds_chances))
		           			.with(ItemEntry.builder(Items.PUMPKIN_SEEDS))
		           			.rolls(ConstantLootNumberProvider.create(CONFIG.rolls.beetroot_seeds_rolls))
							.conditionally(RandomChanceLootCondition.builder(CONFIG.chances.beetroot_seeds_chances))
		           			.with(ItemEntry.builder(Items.BEETROOT_SEEDS))
		           			.rolls(ConstantLootNumberProvider.create(CONFIG.rolls.wheat_seeds_booster_rolls))
							.conditionally(RandomChanceLootCondition.builder(CONFIG.chances.wheat_seeds_booster_chances))
		           			.with(ItemEntry.builder(Items.WHEAT_SEEDS))
		           			.rolls(ConstantLootNumberProvider.create(CONFIG.rolls.potato_rolls))
							.conditionally(RandomChanceLootCondition.builder(CONFIG.chances.potato_chances))
		           			.with(ItemEntry.builder(Items.POTATO));

		           	table.pool(poolBuilder);
		        }
		    }

		}));
//		RESOURCE_PACK.addLootTable(id("minecraft:blocks/grass"),
//				loot("minecraft:block")
//						.pool(pool()
//								.rolls(CONFIG.rolls.carrot_rolls)
//								.entry(entry()
//										.type("minecraft:item")
//										.name("minecraft:carrot")
//								.condition(predicate("minecraft:random_chance").parameter("chance", CONFIG.chances.carrot_chances)))
//								.rolls(CONFIG.rolls.potato_rolls)
//								.entry(entry()
//										.type("minecraft:item")
//										.name("minecraft:potato")
//								)
//								.condition(predicate("minecraft:random_chance").parameter("chance", CONFIG.chances.potato_chances)))
//		);
//		RRPCallback.BEFORE_VANILLA.register(a -> a.add(RESOURCE_PACK));
	}
}
