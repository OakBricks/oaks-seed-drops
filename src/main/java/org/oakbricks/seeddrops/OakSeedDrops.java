package org.oakbricks.seeddrops;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.devtech.arrp.api.RuntimeResourcePack.id;
import static net.devtech.arrp.json.loot.JLootTable.*;

public class OakSeedDrops implements ModInitializer {
	
	public static final OakSeedDropsConfig CONFIG = AutoConfig.register(OakSeedDropsConfig.class, JanksonConfigSerializer::new).getConfig();
	public static final String MOD_ID = "oak_seed_drops";
	public static final Logger LOGGER = LogManager.getLogger("OakBricks' Seed Drops Mod");
	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(MOD_ID + ":drops");

	@Override
	public void onInitialize() {
		RESOURCE_PACK.addLootTable(id("minecraft:blocks/grass"),
				loot("minecraft:block")
						.pool(pool()
								.rolls(CONFIG.rolls.carrot_rolls)
								.entry(entry()
										.type("minecraft:item")
										.name("minecraft:carrot"))
								.condition(predicate("minecraft:random_chance").parameter("chance", CONFIG.chances.carrot_chances)))
		);
		RESOURCE_PACK.addLootTable(id("minecraft:blocks/grass"),
				loot("minecraft:block")
						.pool(pool()
								.rolls(CONFIG.rolls.potato_rolls)
								.entry(entry()
										.type("minecraft:item")
										.name("minecraft:potato"))
								.condition(predicate("minecraft:random_chance").parameter("chance", CONFIG.chances.potato_chances)))
		);
		RESOURCE_PACK.addLootTable(id("minecraft:blocks/grass"),
				loot("minecraft:block")
						.pool(pool()
								.rolls(CONFIG.rolls.beetroot_seeds_rolls)
								.entry(entry()
										.type("minecraft:item")
										.name("minecraft:beetroot_seeds"))
								.condition(predicate("minecraft:random_chance").parameter("chance", CONFIG.chances.beetroot_seeds_chances)))
		);
		RESOURCE_PACK.addLootTable(id("minecraft:blocks/grass"),
				loot("minecraft:block")
						.pool(pool()
								.rolls(CONFIG.rolls.melon_seeds_rolls)
								.entry(entry()
										.type("minecraft:item")
										.name("minecraft:melon_seeds"))
								.condition(predicate("minecraft:random_chance").parameter("chance", CONFIG.chances.melon_seeds_chances)))

		);
		RESOURCE_PACK.addLootTable(id("minecraft:blocks/grass"),
				loot("minecraft:block")
						.pool(pool()
								.rolls(CONFIG.rolls.pumpkin_seeds_rolls)
								.entry(entry()
										.type("minecraft:item")
										.name("minecraft:pumpkin_seeds"))
								.condition(predicate("minecraft:random_chance").parameter("chance", CONFIG.chances.pumpkin_seeds_chances)))
		);
		RRPCallback.AFTER_VANILLA.register(a -> a.add(RESOURCE_PACK));
		LOGGER.info("nuts nuts");
	}
}
