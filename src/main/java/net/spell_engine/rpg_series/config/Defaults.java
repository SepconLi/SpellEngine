package net.spell_engine.rpg_series.config;

import net.spell_engine.api.loot.LootConfig;

import java.util.*;

public class Defaults {

    public final static LootConfig lootConfig;

    private static String armors(int tier) {
        return "#rpg_series:tier_" + tier + "_armors";
    }
    
    private static String weapons(int tier) {
        return "#rpg_series:tier_" + tier + "_weapons";
    }

    private static String equipment(int tier) {
        return "#rpg_series:tier_" + tier + "_equipment";
    }

    static {

        var WG = "#rpg_series:golden_weapons";
        var W0 = "#rpg_series:tier_0_weapons";
        var W1 = "#rpg_series:tier_1_weapons";
        var W2 = "#rpg_series:tier_2_weapons";
        var W3 = "#rpg_series:tier_3_weapons";
        var W4 = "#rpg_series:tier_4_weapons";
        var W5 = "#rpg_series:tier_5_weapons";
        var A1 = "#rpg_series:tier_1_armors";
        var A2 = "#rpg_series:tier_2_armors";
        var A3 = "#rpg_series:tier_3_armors";
        var X0 = "#rpg_series:tier_0_accessories";
        var X1 = "#rpg_series:tier_1_accessories";
        var X2 = "#rpg_series:tier_2_accessories";
        var X3 = "#rpg_series:tier_3_accessories";
        var X4 = "#rpg_series:tier_4_accessories";

        lootConfig = new LootConfig();
        var injectors = lootConfig.injectors;
        var regexInjectors = lootConfig.regex_injectors;

        // Vanilla loot table injectors

        injectors.put("minecraft:chests/ruined_portal", new LootConfig.Pool()
                .rolls(2)
                .add(WG)
                .add(WG, true)
        );

        List.of("minecraft:chests/abandoned_mineshaft",
                "minecraft:chests/igloo_chest",
                "minecraft:chests/shipwreck_supply",
                "minecraft:chests/spawn_bonus_chest").
                forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(0.5)
                        .add(W0)
                        .add(X0)
                ));


        List.of("minecraft:chests/bastion_bridge",
                "minecraft:chests/simple_dungeon",
                "minecraft:chests/stronghold_corridor",
                "minecraft:chests/stronghold_crossing",
                "minecraft:chests/buried_treasure")
                .forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(0.5)
                        .add(W1)
                        .add(X2)
                ));

        List.of("minecraft:chests/shipwreck_treasure")
                .forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(0.5)
                        .add(A1)
                ));

        List.of("minecraft:chests/stronghold_crossing",
                "minecraft:chests/desert_pyramid",
                "minecraft:chests/underwater_ruin_small",
                "minecraft:chests/jungle_temple",
                "minecraft:chests/pillager_outpost",
                "minecraft:chests/woodland_mansion")
                .forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(0.5)
                        .add(W1, true)
                        .add(A1, true)
                        .add(X1, true)
                ));

        List.of("minecraft:chests/nether_bridge",
                "minecraft:chests/underwater_ruin_big")
                .forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(0.5)
                        .add(W2)
                        .add(X2)
                ));

        List.of("minecraft:chests/bastion_other")
                .forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(0.5)
                        .add(W1, true)
                        .add(X3)
                ));

        injectors.put("minecraft:chests/bastion_treasure", new LootConfig.Pool()
                .rolls(2)
                .add(A2, true)
                .add(W3, true)
                .add(X3)
        );

        List.of("minecraft:chests/nether_bridge",
                "minecraft:chests/underwater_ruin_big")
                .forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(0.75)
                        .add(W2)
                        .add(X2)
                ));

        List.of("minecraft:chests/ancient_city",
                "minecraft:chests/stronghold_library")
                .forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(0.8)
                        .add(A2, true)
                        .add(X2, 2, false)
                ));

        List.of("minecraft:chests/end_city_treasure")
                .forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(1)
                        .bonus_rolls(0)
                        .add(W4, true)
                        .add(A2, true)
                        .add(A3, true)
                        .add(X4)
                ));

        List.of("minecraft:chests/trial_chambers/corridor",
                        "minecraft:chests/trial_chambers/entrance")
                .forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(0.5)
                        .add(W0)
                ));

        List.of("minecraft:chests/trial_chambers/reward_ominous_common",
                        "minecraft:chests/trial_chambers/reward_common")
                .forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(0.5)
                        .add(W1)
                        .add(A1)
                ));

        List.of("minecraft:chests/trial_chambers/reward_ominous_rare",
                        "minecraft:chests/trial_chambers/reward_rare")
                .forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(1)
                        .add(W2, true)
                        .add(A2, true)
                        .add(X2)
                ));

        List.of("minecraft:chests/trial_chambers/reward_ominous_unique",
                        "minecraft:chests/trial_chambers/reward_unique")
                .forEach(id -> injectors.put(id, new LootConfig.Pool()
                        .rolls(1)
                        .add(W3, true)
                        .add(X4)
                ));

        // BOSSES

        // Vanilla bosses

        injectors.put("minecraft:entities/ender_dragon", new LootConfig.Pool()
                .rolls(3)
                .add(W3, true)
                .add(A3, true)
                .add(X4)
        );

        injectors.put("minecraft:entities/wither", new LootConfig.Pool()
                .rolls(2)
                .add(W3, true)
                .add(A3, true)
                .add(X3)
        );

        injectors.put("minecraft:entities/warden", new LootConfig.Pool()
                .rolls(2)
                .add(W2, true)
                .add(A2, true)
                .add(X2)
        );

        // MineCells bosses

        injectors.put("minecells:entities/conjunctivius", new LootConfig.Pool()
                .rolls(2)
                .add(W2, true)
                .add(A2, true)
                .add(X4)
        );

        injectors.put("minecells:entities/concierge", new LootConfig.Pool()
                .rolls(2)
                .add(W2, true)
                .add(A2, true)
                .add(X4)
        );

        // Bosses of Mass Destruction mod

        injectors.put("bosses_of_mass_destruction:entities/lich", new LootConfig.Pool()
                .rolls(2)
                .add(W2, true)
                .add(A2, true)
                .add(X2)
        );

        injectors.put("bosses_of_mass_destruction:entities/void_blossom", new LootConfig.Pool()
                .rolls(2)
                .add(W2, true)
                .add(A2, true)
                .add(X2)
        );

        injectors.put("bosses_of_mass_destruction:chests/gauntlet", new LootConfig.Pool()
                .rolls(2)
                .add(W2, true)
                .add(A2, true)
                .add(X3)
        );

        injectors.put("bosses_of_mass_destruction:chests/obsidilith", new LootConfig.Pool()
                .rolls(2)
                .add(W4, true)
                .add(A3, true)
                .add(X4)
        );

        // MOD CHESTS

        // Graveyard mod

        injectors.put("graveyard:chests/great_crypt_loot", new LootConfig.Pool()
                .rolls(1)
                .add(A2, true)
                .add(W2, true)
                .add(X2)
        );

        injectors.put("graveyard:chests/crypt_loot", new LootConfig.Pool()
                .rolls(0.2)
                .add(W1, true)
        );

        injectors.put("graveyard:chests/small_loot", new LootConfig.Pool()
                .rolls(1)
                .add(W1)
                .add(A1)
        );

        injectors.put("graveyard:chests/medium_loot", new LootConfig.Pool()
                .rolls(1)
                .add(W1, true)
                .add(A1, true)
        );

        injectors.put("graveyard:chests/large_loot", new LootConfig.Pool()
                .rolls(1)
                .add(A2, true)
                .add(W2, true)
                .add(X2)
        );

        // Illager Invasion mod

        injectors.put("illagerinvasion:chests/illager_fort_tower", new LootConfig.Pool()
                .rolls(0.5)
                .add(W1)
                .add(W1, true)
        );

        // YUNG Better Dungeons mod

        injectors.put("betterdungeons:skeleton_dungeon/chests/common", new LootConfig.Pool()
                .rolls(0.5)
                .add(W1, true)
        );

        injectors.put("betterdungeons:zombie_dungeon/chests/common", new LootConfig.Pool()
                .rolls(0.5)
                .add(W0)
                .add(W1)
                .add(W2)
                .add(A1)
                .add(X1)
        );

        injectors.put("betterdungeons:small_nether_dungeon/chests/common", new LootConfig.Pool()
                .rolls(0.5)
                .add(WG)
                .add(W1, true)
                .add(A1, true)
                .add(X1)
        );

        injectors.put("betterdungeons:zombie_dungeon/chests/special", new LootConfig.Pool()
                .rolls(0.5)
                .add(W0)
                .add(W1)
                .add(W2)
                .add(A1)
                .add(X1)
        );

        injectors.put("betterdungeons:zombie_dungeon/chests/tombstone", new LootConfig.Pool()
                .rolls(0.5)
                .add(W2, true)
                .add(X2)
        );

        // YUNG Better Strongholds mod

        injectors.put("betterstrongholds:chests/cmd_yung", new LootConfig.Pool()
                .add(W2, true)
        );

        injectors.put("betterstrongholds:chests/armoury", new LootConfig.Pool()
                .rolls(3)
                .add(W0)
                .add(W1)
                .add(W1, true)
                .add(W2)
                .add(W2, true)
                .add(A1)
                .add(A1, true)
                .add(A2)
                .add(A2, true)
        );

        injectors.put("betterstrongholds:chests/crypt", new LootConfig.Pool()
                .add(W1)
                .add(X1)
        );

        // YUNG Better Desert Temples mod

        injectors.put("betterdeserttemples:chests/wardrobe", new LootConfig.Pool()
                .rolls(0.5)
                .add(A1, true)
        );

        injectors.put("betterdeserttemples:chests/tomb_pharaoh", new LootConfig.Pool()
                .add(WG, 2, false)
                .add(X2)
        );

        injectors.put("betterdeserttemples:chests/pharaoh_hidden", new LootConfig.Pool()
                .add(WG, 2, false)
                .add(X2)
        );

        // YUNG Better Nether Fortress mod

        injectors.put("betterfortresses:chests/keep", new LootConfig.Pool()
                .rolls(0.25)
                .add(W0)
                .add(WG)
                .add(X1)
        );

        // Philip's Ruins mod

        injectors.put("philipsruins:chest/lost_soul_city_loot", new LootConfig.Pool()
                .add(A2)
                .add(A2, true)
                .add(X2)
        );

        injectors.put("philipsruins:chest/desert_pyramid_loot", new LootConfig.Pool()
                .add(A1)
                .add(A1, true)
                .add(X1)
        );

        injectors.put("philipsruins:chest/badlands_dungeon_loot_high", new LootConfig.Pool()
                .add(W1)
                .add(A1)
                .add(X2)
        );

        injectors.put("philipsruins:chest/level_three_ruins_loot", new LootConfig.Pool()
                .add(W1, true)
                .add(W2)
                .add(A1)
                .add(X1)
        );

        injectors.put("philipsruins:chest/ocean_ruins_loot", new LootConfig.Pool()
                .add(W1, true)
                .add(W2)
                .add(X1)
        );

        injectors.put("philipsruins:chest/ocean_ruin_fortress", new LootConfig.Pool()
                .add(W1, true)
                .add(A1, true)
                .add(X1)
        );

        injectors.put("philipsruins:chest/nether_lava_ruins_loot", new LootConfig.Pool()
                .add(A3, true)
                .add(X3)
        );

        injectors.put("philipsruins:chest/badlands_dungeon_loot_low", new LootConfig.Pool()
                .add(A1)
                .add(X1)
        );

        injectors.put("philipsruins:chest/end_ruins_loot", new LootConfig.Pool()
                .add(W1, true)
                .add(W2, true)
                .add(W4)
                .add(A2, true)
                .add(X2)
                .add(X4)
        );

        injectors.put("philipsruins:chest/level_one_ruins_loot", new LootConfig.Pool()
                .add(W0)
                .add(A1)
                .add(X1)
        );

        injectors.put("philipsruins:chest/bone_dungeon_loot", new LootConfig.Pool()
                .add(W0)
                .add(W1, 3, false)
                .add(W2)
                .add(W2, true)
                .add(A1)
                .add(A1, true)
                .add(A2)
                .add(X1)
                .add(X2)
        );

        injectors.put("philipsruins:chest/ruin_loot", new LootConfig.Pool()
                .add(W1)
                .add(A1)
                .add(X1)
        );

        injectors.put("philipsruins:chest/ancient_ruins_loot", new LootConfig.Pool()
                .add(A2)
                .add(X2)
        );

        // Awesome Dungeons mod

        injectors.put("awesomedungeonnether:chests/awesome_dungeon", new LootConfig.Pool()
                .add(W1)
                .add(X1)
        );

        injectors.put("awesomedungeonocean:chests/awesome_dungeon", new LootConfig.Pool()
                .add(W1)
                .add(X1)
        );

        injectors.put("awesomedungeonend:chests/awesome_dungeon", new LootConfig.Pool()
                .add(W3, true)
                .add(A2, true)
                .add(X2)
        );

        injectors.put("awesomedungeon:chests/awesome_dungeon", new LootConfig.Pool()
                .add(W1)
                .add(X1)
        );

        // Structory mod

        injectors.put("structory:outcast/bandit/desert_copper", new LootConfig.Pool()
                .rolls(0.5)
                .add(W1, true)
        );

        injectors.put("structory:outcast/generic/bandit", new LootConfig.Pool()
                .rolls(0.5)
                .add(W1, true)
        );

        injectors.put("structory:outcast/mine/loot", new LootConfig.Pool()
                .add(W1, true)
                .add(X1)
        );

        injectors.put("structory:outcast/settlement", new LootConfig.Pool()
                .rolls(0.5)
                .add(W1, true)
                .add(X1)
        );

        injectors.put("structory:outcast/generic/miner", new LootConfig.Pool()
                .rolls(0.5)
                .add(W1, true)
                .add(X1)
        );

        injectors.put("structory:outcast/bandit/desert", new LootConfig.Pool()
                .add(W1)
        );

        injectors.put("structory:outcast/farm_ruin", new LootConfig.Pool()
                .rolls(0.5)
                .add(W0, true)
                .add(W1, true)
        );

        injectors.put("structory:outcast/ruin/ruin", new LootConfig.Pool()
                .rolls(0.5)
                .add(W1, true)
        );

        // Kaisyn?? mod

        injectors.put("kaisyn:village/exclusives/village_piglin_house", new LootConfig.Pool()
                .rolls(0.5)
                .add(WG)
                .add(W1, true)
                .add(X1)
        );

        injectors.put("kaisyn:outpost/common/armory", new LootConfig.Pool()
                .add(W1, true)
                .add(W1)
                .add(A1)
        );

        injectors.put("kaisyn:village/exclusives/village_piglin_barrel", new LootConfig.Pool()
                .rolls(0.2)
                .add(WG)
        );

        // Terralith mod

        injectors.put("terralith:underground/chest", new LootConfig.Pool()
                .rolls(0.5)
                .add(A1, true)
                .add(X1)
        );

        injectors.put("terralith:spire/common", new LootConfig.Pool()
                .add(WG)
                .add(W1, true)
                .add(X1)
        );

        injectors.put("terralith:underground/chest", new LootConfig.Pool()
                .add(WG)
        );

        injectors.put("terralith:spire/junk", new LootConfig.Pool()
                .rolls(0.5)
                .add(W0)
                .add(X1)
        );

        injectors.put("terralith:ruin/glacial/main_cs", new LootConfig.Pool()
                .rolls(0.5)
                .add(W0)
        );

        injectors.put("terralith:spire/treasure", new LootConfig.Pool()
                .rolls(0.5)
                .bonus_rolls(0)
                .add(W2, true)
                .add(A2, true)
                .add(X2)
        );

        injectors.put("terralith:desert_outpost", new LootConfig.Pool()
                .add(W1)
        );

        injectors.put("terralith:ruin/glacial/junk", new LootConfig.Pool()
                .rolls(0.5)
                .add(W0)
                .add(X1)
        );

        // BetterNether mod

        injectors.put("betternether:chests/wither_tower_bonus", new LootConfig.Pool()
                .add(W4)
                .add(A3)
                .add(X3)
        );

        injectors.put("betternether:chests/city_surprise", new LootConfig.Pool()
                .rolls(0.5)
                .add(W4)
                .add(X3)
        );

        // BetterEnd mod

        injectors.put("betterend:chests/shadow_forest", new LootConfig.Pool()
                .rolls(0.5)
                .add(W3)
                .add(X3)
        );

        injectors.put("betterend:chests/umbrella_jungle", new LootConfig.Pool()
                .rolls(0.5)
                .add(W3)
        );

        injectors.put("betterend:chests/foggy_mushroomland", new LootConfig.Pool()
                .rolls(0.5)
                .add(W3)
        );

        injectors.put("betterend:chests/biome", new LootConfig.Pool()
                .rolls(0.5)
                .add(W3)
        );


        // Dungeons Arise mod

        regexInjectors.put("^dungeons_arise:chests.*barrels$", new LootConfig.Pool()
                .rolls(0.2)
                .add(W1, true)
                .add(A1, true)
                .add(X1)
        );
        regexInjectors.put("^dungeons_arise:chests.*normal$", new LootConfig.Pool()
                .rolls(0.35)
                .add(W1, true)
                .add(A1, true)
                .add(X1)
        );

        injectors.put("dungeons_arise:chests/thornborn_towers/thornborn_towers_top_treasure", new LootConfig.Pool()
                .add(W1)
                .add(A1, true)
                .add(X1)
        );
        injectors.put("dungeons_arise_seven_seas:chests/victory_frigate/victory_frigate_treasure", new LootConfig.Pool()
                .add(A2, true)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/infested_temple/infested_temple_top_treasure", new LootConfig.Pool()
                .add(W2, true)
                .add(A2, true)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/illager_windmill/illager_windmill_treasure", new LootConfig.Pool()
                .add(W1, true)
                .add(A1, true)
                .add(X1)
        );
        injectors.put("dungeons_arise:chests/bandit_towers/bandit_towers_treasure", new LootConfig.Pool()
                .add(W1, true)
                .add(A1, true)
                .add(A2)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/ceryneian_hind/ceryneian_hind_treasure", new LootConfig.Pool()
                .add(W2, true)
                .add(A2)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/small_blimp/small_blimp_treasure", new LootConfig.Pool()
                .add(A1, true)
                .add(W1, true)
                .add(X1)
        );
        injectors.put("dungeons_arise:chests/heavenly_conqueror/heavenly_conqueror_treasure", new LootConfig.Pool()
                .add(WG)
                .add(A2, true)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/aviary/aviary_treasure", new LootConfig.Pool()
                .add(WG)
                .add(W2)
                .add(A2)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/illager_corsair/illager_corsair_treasure", new LootConfig.Pool()
                .add(W1, true)
                .add(A1, true)
                .add(X1)
        );
        injectors.put("dungeons_arise:chests/typhon/typhon_treasure", new LootConfig.Pool()
                .add(W1, true)
                .add(A1, true)
                .add(X1)
        );
        injectors.put("dungeons_arise_seven_seas:chests/corsair_corvette/corsair_corvette_treasure", new LootConfig.Pool()
                .add(W1, true)
                .add(A1, true)
                .add(X1)
        );
        injectors.put("dungeons_arise_seven_seas:chests/small_yacht/small_yacht_treasure", new LootConfig.Pool()
                .add(W1, true)
                .add(A1, true)
                .add(X1)
        );
        injectors.put("dungeons_arise:chests/mushroom_house/mushroom_house_treasure", new LootConfig.Pool()
                .add(W0)
                .add(W1)
                .add(W1, true)
                .add(A1)
                .add(A1, true)
        );
        injectors.put("dungeons_arise:chests/jungle_tree_house/jungle_tree_house_treasure", new LootConfig.Pool()
                .add(W1, true)
                .add(A1)
                .add(X1)
        );
        injectors.put("dungeons_arise:chests/illager_galley/illager_galley_treasure", new LootConfig.Pool()
                .add(W1, true)
                .add(A1, true)
                .add(X1)
        );
        injectors.put("dungeons_arise:chests/undead_pirate_ship/undead_pirate_ship_treasure", new LootConfig.Pool()
                .add(W1, true)
                .add(A1, true)
                .add(X1)
        );
        injectors.put("dungeons_arise:chests/heavenly_challenger/heavenly_challenger_treasure", new LootConfig.Pool()
                .add(WG)
                .add(W2, true)
                .add(W3)
                .add(A2, true)
                .add(A3, true)
                .add(X2)
                .add(X3)
        );
        injectors.put("dungeons_arise:chests/heavenly_rider/heavenly_rider_treasure", new LootConfig.Pool()
                .add(WG)
                .add(A2, true)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/illager_fort/illager_fort_treasure", new LootConfig.Pool()
                .add(W1)
                .add(A2, true)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/keep_kayra/keep_kayra_treasure", new LootConfig.Pool()
                .add(W2)
                .add(W2, true)
                .add(A2, true)
                .add(A3)
                .add(X2)
                .add(X3)
        );
        injectors.put("dungeons_arise_seven_seas:chests/pirate_junk/pirate_junk_treasure", new LootConfig.Pool()
                .rolls(0.5)
                .add(A1, true)
                .add(A2)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/mushroom_mines/mushroom_mines_treasure", new LootConfig.Pool()
                .add(A1, true)
                .add(A2, true)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/mines_treasure_medium", new LootConfig.Pool()
                .add(W1, true)
                .add(A1, true)
                .add(A2, true)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/keep_kayra/keep_kayra_library_treasure", new LootConfig.Pool()
                .add(W2, true)
                .add(A2, true)
                .add(A3)
                .add(X2)
                .add(X3)
        );
        injectors.put("dungeons_arise:chests/mining_system/mining_system_treasure", new LootConfig.Pool()
                .add(A1, true)
                .add(A2, true)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/shiraz_palace/shiraz_palace_treasure", new LootConfig.Pool()
                .rolls(2)
                .add(W3, true)
                .add(A2, true)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/foundry/foundry_treasure", new LootConfig.Pool()
                .add(A2)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/keep_kayra/keep_kayra_garden_treasure", new LootConfig.Pool()
                .add(W2, true)
                .add(A2, true)
                .add(A3)
                .add(X2)
                .add(X3)
        );
        injectors.put("dungeons_arise:chests/plague_asylum/plague_asylum_treasure", new LootConfig.Pool()
                .add(A2, true)
                .add(X2)
        );
        injectors.put("dungeons_arise_seven_seas:chests/unicorn_galleon/unicorn_galleon_treasure", new LootConfig.Pool()
                .add(A1, true)
                .add(A2, true)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/shiraz_palace/shiraz_palace_library", new LootConfig.Pool()
                .rolls(0.5)
                .add(A1)
                .add(A2)
                .add(X2)
        );
        injectors.put("dungeons_arise:chests/shiraz_palace/shiraz_palace_elite", new LootConfig.Pool()
                .rolls(2)
                .add(W2, true)
                .add(A2, true)
                .add(A3)
                .add(X2)
                .add(X3)
        );
    }
}
