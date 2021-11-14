package me.marbanz.mcbasic.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Spawnmob implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawnmob")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.spawnmob")) {
                    if (args.length == 1) {
                        Location playerlocation = p.getLocation();
                        World world = p.getWorld();
                        if (args[0].equalsIgnoreCase("Wolf")) {
                            world.spawnEntity(playerlocation, EntityType.WOLF);
                            p.sendMessage("§aSpawned Wolf!");
                        } else if (args[0].equalsIgnoreCase("Pig")) {
                            world.spawnEntity(playerlocation, EntityType.PIG);
                            p.sendMessage("§aSpawned Pig!");
                        } else if (args[0].equalsIgnoreCase("Cow")) {
                            world.spawnEntity(playerlocation, EntityType.COW);
                            p.sendMessage("§aSpawned Cow!");
                        } else if (args[0].equalsIgnoreCase("Blaze")) {
                            world.spawnEntity(playerlocation, EntityType.BLAZE);
                            p.sendMessage("§aSpawned Blaze!");
                        } else if (args[0].equalsIgnoreCase("CaveSpider")) {
                            world.spawnEntity(playerlocation, EntityType.CAVE_SPIDER);
                            p.sendMessage("§aSpawned Cave Spider!");
                        } else if (args[0].equalsIgnoreCase("Chicken")) {
                            world.spawnEntity(playerlocation, EntityType.CHICKEN);
                            p.sendMessage("§aSpawned Chicken!");
                        } else if (args[0].equalsIgnoreCase("Creeper")) {
                            world.spawnEntity(playerlocation, EntityType.CREEPER);
                            p.sendMessage("§aSpawned Creeper!");
                        } else if (args[0].equalsIgnoreCase("EnderDragon")) {
                            world.spawnEntity(playerlocation, EntityType.ENDER_DRAGON);
                            p.sendMessage("§aSpawned Ender Dragon!");
                        } else if (args[0].equalsIgnoreCase("Enderman")) {
                            world.spawnEntity(playerlocation, EntityType.ENDERMAN);
                            p.sendMessage("§aSpawned Enderman!");
                        } else if (args[0].equalsIgnoreCase("Ghast")) {
                            world.spawnEntity(playerlocation, EntityType.GHAST);
                            p.sendMessage("§aSpawned Ghast!");
                        } else if (args[0].equalsIgnoreCase("Giant")) {
                            world.spawnEntity(playerlocation, EntityType.GIANT);
                            p.sendMessage("§aSpawned Giant!");
                        } else if (args[0].equalsIgnoreCase("IronGolem")) {
                            world.spawnEntity(playerlocation, EntityType.IRON_GOLEM);
                            p.sendMessage("§aSpawned Iron Golem!");
                        } else if (args[0].equalsIgnoreCase("MagmaCube")) {
                            world.spawnEntity(playerlocation, EntityType.MAGMA_CUBE);
                            p.sendMessage("§aSpawned Magma Cube!");
                        } else if (args[0].equalsIgnoreCase("Ocelot")) {
                            world.spawnEntity(playerlocation, EntityType.OCELOT);
                            p.sendMessage("§aSpawned Ocelot!");
                        } else if (args[0].equalsIgnoreCase("Sheep")) {
                            world.spawnEntity(playerlocation, EntityType.SHEEP);
                            p.sendMessage("§aSpawned Sheep!");
                        } else if (args[0].equalsIgnoreCase("SilverFish")) {
                            world.spawnEntity(playerlocation, EntityType.SILVERFISH);
                            p.sendMessage("§aSpawned Silver Fish!");
                        } else if (args[0].equalsIgnoreCase("Skeleton")) {
                            world.spawnEntity(playerlocation, EntityType.SKELETON);
                            p.sendMessage("§aSpawned Skeleton!");
                        } else if (args[0].equalsIgnoreCase("Slime")) {
                            world.spawnEntity(playerlocation, EntityType.SLIME);
                            p.sendMessage("§aSpawned Slime!");
                        } else if (args[0].equalsIgnoreCase("Spider")) {
                            world.spawnEntity(playerlocation, EntityType.SPIDER);
                            p.sendMessage("§aSpawned Spider!");
                        } else if (args[0].equalsIgnoreCase("Squid")) {
                            world.spawnEntity(playerlocation, EntityType.SQUID);
                            p.sendMessage("§aSpawned Squid!");
                        } else if (args[0].equalsIgnoreCase("Villager")) {
                            world.spawnEntity(playerlocation, EntityType.VILLAGER);
                            p.sendMessage("§aSpawned Villager!");
                        } else if (args[0].equalsIgnoreCase("Zombie")) {
                            world.spawnEntity(playerlocation, EntityType.ZOMBIE);
                            p.sendMessage("§aSpawned Zombie!");
                        } else if (args[0].equalsIgnoreCase("Axolotl")) {
                            world.spawnEntity(playerlocation, EntityType.AXOLOTL);
                            p.sendMessage("§aSpawned Axolotl!");
                        } else if (args[0].equalsIgnoreCase("Bat")) {
                            world.spawnEntity(playerlocation, EntityType.BAT);
                            p.sendMessage("§aSpawned Bat!");
                        } else if (args[0].equalsIgnoreCase("Bee")) {
                            world.spawnEntity(playerlocation, EntityType.BEE);
                            p.sendMessage("§aSpawned Bee!");
                        } else if (args[0].equalsIgnoreCase("Cat")) {
                            world.spawnEntity(playerlocation, EntityType.CAT);
                            p.sendMessage("§aSpawned Cat!");
                        } else if (args[0].equalsIgnoreCase("Dolphin")) {
                            world.spawnEntity(playerlocation, EntityType.DOLPHIN);
                            p.sendMessage("§aSpawned Dolphin!");
                        } else if (args[0].equalsIgnoreCase("Donkey")) {
                            world.spawnEntity(playerlocation, EntityType.DONKEY);
                            p.sendMessage("§aSpawned Donkey!");
                        } else if (args[0].equalsIgnoreCase("Drowned")) {
                            world.spawnEntity(playerlocation, EntityType.DROWNED);
                            p.sendMessage("§aSpawned Drowned!");
                        } else if (args[0].equalsIgnoreCase("ElderGuardian")) {
                            world.spawnEntity(playerlocation, EntityType.ELDER_GUARDIAN);
                            p.sendMessage("§aSpawned Elder Guardian!");
                        } else if (args[0].equalsIgnoreCase("Endermite")) {
                            world.spawnEntity(playerlocation, EntityType.ENDERMITE);
                            p.sendMessage("§aSpawned Endermite!");
                        } else if (args[0].equalsIgnoreCase("Cod")) {
                            world.spawnEntity(playerlocation, EntityType.COD);
                            p.sendMessage("§aSpawned Cod!");
                        } else if (args[0].equalsIgnoreCase("Evoker")) {
                            world.spawnEntity(playerlocation, EntityType.EVOKER);
                            p.sendMessage("§aSpawned Evoker!");
                        } else if (args[0].equalsIgnoreCase("Fox")) {
                            world.spawnEntity(playerlocation, EntityType.FOX);
                            p.sendMessage("§aSpawned Fox!");
                        } else if (args[0].equalsIgnoreCase("GlowSquid")) {
                            world.spawnEntity(playerlocation, EntityType.GLOW_SQUID);
                            p.sendMessage("§aSpawned Glow Squid!");
                        } else if (args[0].equalsIgnoreCase("Goat")) {
                            world.spawnEntity(playerlocation, EntityType.GOAT);
                            p.sendMessage("§aSpawned Goat!");
                        } else if (args[0].equalsIgnoreCase("Guardian")) {
                            world.spawnEntity(playerlocation, EntityType.GUARDIAN);
                            p.sendMessage("§aSpawned Guardian!");
                        } else if (args[0].equalsIgnoreCase("Hoglin")) {
                            world.spawnEntity(playerlocation, EntityType.HOGLIN);
                            p.sendMessage("§aSpawned Hoglin!");
                        } else if (args[0].equalsIgnoreCase("Horse")) {
                            world.spawnEntity(playerlocation, EntityType.HORSE);
                            p.sendMessage("§aSpawned Horse!");
                        } else if (args[0].equalsIgnoreCase("Husk")) {
                            world.spawnEntity(playerlocation, EntityType.HUSK);
                            p.sendMessage("§aSpawned Husk!");
                        } else if (args[0].equalsIgnoreCase("Illusioner")) {
                            world.spawnEntity(playerlocation, EntityType.ILLUSIONER);
                            p.sendMessage("§aSpawned Illusioner!");
                        } else if (args[0].equalsIgnoreCase("Llama")) {
                            world.spawnEntity(playerlocation, EntityType.LLAMA);
                            p.sendMessage("§aSpawned Llama!");
                        } else if (args[0].equalsIgnoreCase("Mule")) {
                            world.spawnEntity(playerlocation, EntityType.MULE);
                            p.sendMessage("§aSpawned Mule!");
                        } else if (args[0].equalsIgnoreCase("MushroomCow")) {
                            world.spawnEntity(playerlocation, EntityType.MUSHROOM_COW);
                            p.sendMessage("§aSpawned Mushroom Cow!");
                        } else if (args[0].equalsIgnoreCase("Panda")) {
                            world.spawnEntity(playerlocation, EntityType.PANDA);
                            p.sendMessage("§aSpawned Panda!");
                        } else if (args[0].equalsIgnoreCase("Parrot")) {
                            world.spawnEntity(playerlocation, EntityType.PARROT);
                            p.sendMessage("§aSpawned Parrot!");
                        } else if (args[0].equalsIgnoreCase("Phantom")) {
                            world.spawnEntity(playerlocation, EntityType.PHANTOM);
                            p.sendMessage("§aSpawned Phantom!");
                        } else if (args[0].equalsIgnoreCase("Piglin")) {
                            world.spawnEntity(playerlocation, EntityType.PIGLIN);
                            p.sendMessage("§aSpawned Piglin!");
                        } else if (args[0].equalsIgnoreCase("PiglinBrute")) {
                            world.spawnEntity(playerlocation, EntityType.PIGLIN_BRUTE);
                            p.sendMessage("§aSpawned Piglin Brute!");
                        } else if (args[0].equalsIgnoreCase("Pillager")) {
                            world.spawnEntity(playerlocation, EntityType.PILLAGER);
                            p.sendMessage("§aSpawned Pillager!");
                        } else if (args[0].equalsIgnoreCase("PolarBear")) {
                            world.spawnEntity(playerlocation, EntityType.POLAR_BEAR);
                            p.sendMessage("§aSpawned Polar Bear!");
                        } else if (args[0].equalsIgnoreCase("Pufferfish")) {
                            world.spawnEntity(playerlocation, EntityType.PUFFERFISH);
                            p.sendMessage("§aSpawned Pufferfish!");
                        } else if (args[0].equalsIgnoreCase("Rabbit")) {
                            world.spawnEntity(playerlocation, EntityType.RABBIT);
                            p.sendMessage("§aSpawned Rabbit!");
                        } else if (args[0].equalsIgnoreCase("Ravager")) {
                            world.spawnEntity(playerlocation, EntityType.RAVAGER);
                            p.sendMessage("§aSpawned Ravager!");
                        } else if (args[0].equalsIgnoreCase("Salmon")) {
                            world.spawnEntity(playerlocation, EntityType.SALMON);
                            p.sendMessage("§aSpawned Salmon!");
                        } else if (args[0].equalsIgnoreCase("Shulker")) {
                            world.spawnEntity(playerlocation, EntityType.SHULKER);
                            p.sendMessage("§aSpawned Shulker!");
                        } else if (args[0].equalsIgnoreCase("SkeletonHorse")) {
                            world.spawnEntity(playerlocation, EntityType.SKELETON_HORSE);
                            p.sendMessage("§aSpawned Skeleton Horse!");
                        } else if (args[0].equalsIgnoreCase("Snowman")) {
                            world.spawnEntity(playerlocation, EntityType.SNOWMAN);
                            p.sendMessage("§aSpawned Snowman!");
                        } else if (args[0].equalsIgnoreCase("Stray")) {
                            world.spawnEntity(playerlocation, EntityType.STRAY);
                            p.sendMessage("§aSpawned Stray!");
                        } else if (args[0].equalsIgnoreCase("Strider")) {
                            world.spawnEntity(playerlocation, EntityType.STRIDER);
                            p.sendMessage("§aSpawned Strider!");
                        } else if (args[0].equalsIgnoreCase("TropicalFish")) {
                            world.spawnEntity(playerlocation, EntityType.TROPICAL_FISH);
                            p.sendMessage("§aSpawned Tropical Fish!");
                        } else if (args[0].equalsIgnoreCase("Turtle")) {
                            world.spawnEntity(playerlocation, EntityType.TURTLE);
                            p.sendMessage("§aSpawned Turtle!");
                        } else if (args[0].equalsIgnoreCase("Vex")) {
                            world.spawnEntity(playerlocation, EntityType.VEX);
                            p.sendMessage("§aSpawned Vex!");
                        } else if (args[0].equalsIgnoreCase("Vindicator")) {
                            world.spawnEntity(playerlocation, EntityType.VINDICATOR);
                            p.sendMessage("§aSpawned Vindicator!");
                        } else if (args[0].equalsIgnoreCase("WanderingTrader")) {
                            world.spawnEntity(playerlocation, EntityType.WANDERING_TRADER);
                            p.sendMessage("§aSpawned Wandering Trader!");
                        } else if (args[0].equalsIgnoreCase("Witch")) {
                            world.spawnEntity(playerlocation, EntityType.WITCH);
                            p.sendMessage("§aSpawned Witch!");
                        } else if (args[0].equalsIgnoreCase("Wither")) {
                            world.spawnEntity(playerlocation, EntityType.WITHER);
                            p.sendMessage("§aSpawned Wither!");
                        } else if (args[0].equalsIgnoreCase("WitherSkeleton")) {
                            world.spawnEntity(playerlocation, EntityType.WITHER_SKELETON);
                            p.sendMessage("§aSpawned Wither Skeleton!");
                        } else if (args[0].equalsIgnoreCase("Zoglin")) {
                            world.spawnEntity(playerlocation, EntityType.ZOGLIN);
                            p.sendMessage("§aSpawned Zoglin!");
                        } else if (args[0].equalsIgnoreCase("ZombieHorse")) {
                            world.spawnEntity(playerlocation, EntityType.ZOMBIE_HORSE);
                            p.sendMessage("§aSpawned Zombie Horse!");
                        } else if (args[0].equalsIgnoreCase("ZombieVillager")) {
                            world.spawnEntity(playerlocation, EntityType.ZOMBIE_VILLAGER);
                            p.sendMessage("§aSpawned Zombie Villager!");
                        } else if (args[0].equalsIgnoreCase("ZombifiedPiglin")) {
                            world.spawnEntity(playerlocation, EntityType.ZOMBIFIED_PIGLIN);
                            p.sendMessage("§aSpawned Zombified Piglin!");
                        } else {
                            p.sendMessage("§cMob not found");
                        }
                        return true;
                    } else if (args.length == 2) {
                        Player target = Bukkit.getServer().getPlayerExact(args[1]);
                        if (target != null) {
                            World world = target.getWorld();
                            Location playerlocation = target.getLocation();
                            if (args[0].equalsIgnoreCase("Wolf")) {
                                world.spawnEntity(playerlocation, EntityType.WOLF);
                                p.sendMessage("§aSpawned Wolf!");
                            } else if (args[0].equalsIgnoreCase("Pig")) {
                                world.spawnEntity(playerlocation, EntityType.PIG);
                                p.sendMessage("§aSpawned Pig!");
                            } else if (args[0].equalsIgnoreCase("Cow")) {
                                world.spawnEntity(playerlocation, EntityType.COW);
                                p.sendMessage("§aSpawned Cow!");
                            } else if (args[0].equalsIgnoreCase("Blaze")) {
                                world.spawnEntity(playerlocation, EntityType.BLAZE);
                                p.sendMessage("§aSpawned Blaze!");
                            } else if (args[0].equalsIgnoreCase("CaveSpider")) {
                                world.spawnEntity(playerlocation, EntityType.CAVE_SPIDER);
                                p.sendMessage("§aSpawned Cave Spider!");
                            } else if (args[0].equalsIgnoreCase("Chicken")) {
                                world.spawnEntity(playerlocation, EntityType.CHICKEN);
                                p.sendMessage("§aSpawned Chicken!");
                            } else if (args[0].equalsIgnoreCase("Creeper")) {
                                world.spawnEntity(playerlocation, EntityType.CREEPER);
                                p.sendMessage("§aSpawned Creeper!");
                            } else if (args[0].equalsIgnoreCase("EnderDragon")) {
                                world.spawnEntity(playerlocation, EntityType.ENDER_DRAGON);
                                p.sendMessage("§aSpawned Ender Dragon!");
                            } else if (args[0].equalsIgnoreCase("Enderman")) {
                                world.spawnEntity(playerlocation, EntityType.ENDERMAN);
                                p.sendMessage("§aSpawned Enderman!");
                            } else if (args[0].equalsIgnoreCase("Ghast")) {
                                world.spawnEntity(playerlocation, EntityType.GHAST);
                                p.sendMessage("§aSpawned Ghast!");
                            } else if (args[0].equalsIgnoreCase("Giant")) {
                                world.spawnEntity(playerlocation, EntityType.GIANT);
                                p.sendMessage("§aSpawned Giant!");
                            } else if (args[0].equalsIgnoreCase("IronGolem")) {
                                world.spawnEntity(playerlocation, EntityType.IRON_GOLEM);
                                p.sendMessage("§aSpawned Iron Golem!");
                            } else if (args[0].equalsIgnoreCase("MagmaCube")) {
                                world.spawnEntity(playerlocation, EntityType.MAGMA_CUBE);
                                p.sendMessage("§aSpawned Magma Cube!");
                            } else if (args[0].equalsIgnoreCase("Ocelot")) {
                                world.spawnEntity(playerlocation, EntityType.OCELOT);
                                p.sendMessage("§aSpawned Ocelot!");
                            } else if (args[0].equalsIgnoreCase("Sheep")) {
                                world.spawnEntity(playerlocation, EntityType.SHEEP);
                                p.sendMessage("§aSpawned Sheep!");
                            } else if (args[0].equalsIgnoreCase("SilverFish")) {
                                world.spawnEntity(playerlocation, EntityType.SILVERFISH);
                                p.sendMessage("§aSpawned Silver Fish!");
                            } else if (args[0].equalsIgnoreCase("Skeleton")) {
                                world.spawnEntity(playerlocation, EntityType.SKELETON);
                                p.sendMessage("§aSpawned Skeleton!");
                            } else if (args[0].equalsIgnoreCase("Slime")) {
                                world.spawnEntity(playerlocation, EntityType.SLIME);
                                p.sendMessage("§aSpawned Slime!");
                            } else if (args[0].equalsIgnoreCase("Spider")) {
                                world.spawnEntity(playerlocation, EntityType.SPIDER);
                                p.sendMessage("§aSpawned Spider!");
                            } else if (args[0].equalsIgnoreCase("Squid")) {
                                world.spawnEntity(playerlocation, EntityType.SQUID);
                                p.sendMessage("§aSpawned Squid!");
                            } else if (args[0].equalsIgnoreCase("Villager")) {
                                world.spawnEntity(playerlocation, EntityType.VILLAGER);
                                p.sendMessage("§aSpawned Villager!");
                            } else if (args[0].equalsIgnoreCase("Zombie")) {
                                world.spawnEntity(playerlocation, EntityType.ZOMBIE);
                                p.sendMessage("§aSpawned Zombie!");
                            } else if (args[0].equalsIgnoreCase("Axolotl")) {
                                world.spawnEntity(playerlocation, EntityType.AXOLOTL);
                                p.sendMessage("§aSpawned Axolotl!");
                            } else if (args[0].equalsIgnoreCase("Bat")) {
                                world.spawnEntity(playerlocation, EntityType.BAT);
                                p.sendMessage("§aSpawned Bat!");
                            } else if (args[0].equalsIgnoreCase("Bee")) {
                                world.spawnEntity(playerlocation, EntityType.BEE);
                                p.sendMessage("§aSpawned Bee!");
                            } else if (args[0].equalsIgnoreCase("Cat")) {
                                world.spawnEntity(playerlocation, EntityType.CAT);
                                p.sendMessage("§aSpawned Cat!");
                            } else if (args[0].equalsIgnoreCase("Dolphin")) {
                                world.spawnEntity(playerlocation, EntityType.DOLPHIN);
                                p.sendMessage("§aSpawned Dolphin!");
                            } else if (args[0].equalsIgnoreCase("Donkey")) {
                                world.spawnEntity(playerlocation, EntityType.DONKEY);
                                p.sendMessage("§aSpawned Donkey!");
                            } else if (args[0].equalsIgnoreCase("Drowned")) {
                                world.spawnEntity(playerlocation, EntityType.DROWNED);
                                p.sendMessage("§aSpawned Drowned!");
                            } else if (args[0].equalsIgnoreCase("ElderGuardian")) {
                                world.spawnEntity(playerlocation, EntityType.ELDER_GUARDIAN);
                                p.sendMessage("§aSpawned Elder Guardian!");
                            } else if (args[0].equalsIgnoreCase("Endermite")) {
                                world.spawnEntity(playerlocation, EntityType.ENDERMITE);
                                p.sendMessage("§aSpawned Endermite!");
                            } else if (args[0].equalsIgnoreCase("Cod")) {
                                world.spawnEntity(playerlocation, EntityType.COD);
                                p.sendMessage("§aSpawned Cod!");
                            } else if (args[0].equalsIgnoreCase("Evoker")) {
                                world.spawnEntity(playerlocation, EntityType.EVOKER);
                                p.sendMessage("§aSpawned Evoker!");
                            } else if (args[0].equalsIgnoreCase("Fox")) {
                                world.spawnEntity(playerlocation, EntityType.FOX);
                                p.sendMessage("§aSpawned Fox!");
                            } else if (args[0].equalsIgnoreCase("GlowSquid")) {
                                world.spawnEntity(playerlocation, EntityType.GLOW_SQUID);
                                p.sendMessage("§aSpawned Glow Squid!");
                            } else if (args[0].equalsIgnoreCase("Goat")) {
                                world.spawnEntity(playerlocation, EntityType.GOAT);
                                p.sendMessage("§aSpawned Goat!");
                            } else if (args[0].equalsIgnoreCase("Guardian")) {
                                world.spawnEntity(playerlocation, EntityType.GUARDIAN);
                                p.sendMessage("§aSpawned Guardian!");
                            } else if (args[0].equalsIgnoreCase("Hoglin")) {
                                world.spawnEntity(playerlocation, EntityType.HOGLIN);
                                p.sendMessage("§aSpawned Hoglin!");
                            } else if (args[0].equalsIgnoreCase("Horse")) {
                                world.spawnEntity(playerlocation, EntityType.HORSE);
                                p.sendMessage("§aSpawned Horse!");
                            } else if (args[0].equalsIgnoreCase("Husk")) {
                                world.spawnEntity(playerlocation, EntityType.HUSK);
                                p.sendMessage("§aSpawned Husk!");
                            } else if (args[0].equalsIgnoreCase("Illusioner")) {
                                world.spawnEntity(playerlocation, EntityType.ILLUSIONER);
                                p.sendMessage("§aSpawned Illusioner!");
                            } else if (args[0].equalsIgnoreCase("Llama")) {
                                world.spawnEntity(playerlocation, EntityType.LLAMA);
                                p.sendMessage("§aSpawned Llama!");
                            } else if (args[0].equalsIgnoreCase("Mule")) {
                                world.spawnEntity(playerlocation, EntityType.MULE);
                                p.sendMessage("§aSpawned Mule!");
                            } else if (args[0].equalsIgnoreCase("MushroomCow")) {
                                world.spawnEntity(playerlocation, EntityType.MUSHROOM_COW);
                                p.sendMessage("§aSpawned Mushroom Cow!");
                            } else if (args[0].equalsIgnoreCase("Panda")) {
                                world.spawnEntity(playerlocation, EntityType.PANDA);
                                p.sendMessage("§aSpawned Panda!");
                            } else if (args[0].equalsIgnoreCase("Parrot")) {
                                world.spawnEntity(playerlocation, EntityType.PARROT);
                                p.sendMessage("§aSpawned Parrot!");
                            } else if (args[0].equalsIgnoreCase("Phantom")) {
                                world.spawnEntity(playerlocation, EntityType.PHANTOM);
                                p.sendMessage("§aSpawned Phantom!");
                            } else if (args[0].equalsIgnoreCase("Piglin")) {
                                world.spawnEntity(playerlocation, EntityType.PIGLIN);
                                p.sendMessage("§aSpawned Piglin!");
                            } else if (args[0].equalsIgnoreCase("PiglinBrute")) {
                                world.spawnEntity(playerlocation, EntityType.PIGLIN_BRUTE);
                                p.sendMessage("§aSpawned Piglin Brute!");
                            } else if (args[0].equalsIgnoreCase("Pillager")) {
                                world.spawnEntity(playerlocation, EntityType.PILLAGER);
                                p.sendMessage("§aSpawned Pillager!");
                            } else if (args[0].equalsIgnoreCase("PolarBear")) {
                                world.spawnEntity(playerlocation, EntityType.POLAR_BEAR);
                                p.sendMessage("§aSpawned Polar Bear!");
                            } else if (args[0].equalsIgnoreCase("Pufferfish")) {
                                world.spawnEntity(playerlocation, EntityType.PUFFERFISH);
                                p.sendMessage("§aSpawned Pufferfish!");
                            } else if (args[0].equalsIgnoreCase("Rabbit")) {
                                world.spawnEntity(playerlocation, EntityType.RABBIT);
                                p.sendMessage("§aSpawned Rabbit!");
                            } else if (args[0].equalsIgnoreCase("Ravager")) {
                                world.spawnEntity(playerlocation, EntityType.RAVAGER);
                                p.sendMessage("§aSpawned Ravager!");
                            } else if (args[0].equalsIgnoreCase("Salmon")) {
                                world.spawnEntity(playerlocation, EntityType.SALMON);
                                p.sendMessage("§aSpawned Salmon!");
                            } else if (args[0].equalsIgnoreCase("Shulker")) {
                                world.spawnEntity(playerlocation, EntityType.SHULKER);
                                p.sendMessage("§aSpawned Shulker!");
                            } else if (args[0].equalsIgnoreCase("SkeletonHorse")) {
                                world.spawnEntity(playerlocation, EntityType.SKELETON_HORSE);
                                p.sendMessage("§aSpawned Skeleton Horse!");
                            } else if (args[0].equalsIgnoreCase("Snowman")) {
                                world.spawnEntity(playerlocation, EntityType.SNOWMAN);
                                p.sendMessage("§aSpawned Snowman!");
                            } else if (args[0].equalsIgnoreCase("Stray")) {
                                world.spawnEntity(playerlocation, EntityType.STRAY);
                                p.sendMessage("§aSpawned Stray!");
                            } else if (args[0].equalsIgnoreCase("Strider")) {
                                world.spawnEntity(playerlocation, EntityType.STRIDER);
                                p.sendMessage("§aSpawned Strider!");
                            } else if (args[0].equalsIgnoreCase("TropicalFish")) {
                                world.spawnEntity(playerlocation, EntityType.TROPICAL_FISH);
                                p.sendMessage("§aSpawned Tropical Fish!");
                            } else if (args[0].equalsIgnoreCase("Turtle")) {
                                world.spawnEntity(playerlocation, EntityType.TURTLE);
                                p.sendMessage("§aSpawned Turtle!");
                            } else if (args[0].equalsIgnoreCase("Vex")) {
                                world.spawnEntity(playerlocation, EntityType.VEX);
                                p.sendMessage("§aSpawned Vex!");
                            } else if (args[0].equalsIgnoreCase("Vindicator")) {
                                world.spawnEntity(playerlocation, EntityType.VINDICATOR);
                                p.sendMessage("§aSpawned Vindicator!");
                            } else if (args[0].equalsIgnoreCase("WanderingTrader")) {
                                world.spawnEntity(playerlocation, EntityType.WANDERING_TRADER);
                                p.sendMessage("§aSpawned Wandering Trader!");
                            } else if (args[0].equalsIgnoreCase("Witch")) {
                                world.spawnEntity(playerlocation, EntityType.WITCH);
                                p.sendMessage("§aSpawned Witch!");
                            } else if (args[0].equalsIgnoreCase("Wither")) {
                                world.spawnEntity(playerlocation, EntityType.WITHER);
                                p.sendMessage("§aSpawned Wither!");
                            } else if (args[0].equalsIgnoreCase("WitherSkeleton")) {
                                world.spawnEntity(playerlocation, EntityType.WITHER_SKELETON);
                                p.sendMessage("§aSpawned Wither Skeleton!");
                            } else if (args[0].equalsIgnoreCase("Zoglin")) {
                                world.spawnEntity(playerlocation, EntityType.ZOGLIN);
                                p.sendMessage("§aSpawned Zoglin!");
                            } else if (args[0].equalsIgnoreCase("ZombieHorse")) {
                                world.spawnEntity(playerlocation, EntityType.ZOMBIE_HORSE);
                                p.sendMessage("§aSpawned Zombie Horse!");
                            } else if (args[0].equalsIgnoreCase("ZombieVillager")) {
                                world.spawnEntity(playerlocation, EntityType.ZOMBIE_VILLAGER);
                                p.sendMessage("§aSpawned Zombie Villager!");
                            } else if (args[0].equalsIgnoreCase("ZombifiedPiglin")) {
                                world.spawnEntity(playerlocation, EntityType.ZOMBIFIED_PIGLIN);
                                p.sendMessage("§aSpawned Zombified Piglin!");
                            } else {
                                p.sendMessage("§cMob not found");
                            }
                        } else {
                            sender.sendMessage("§cPlayer not found");
                        }
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            if (sender instanceof ConsoleCommandSender) {
                if (args.length == 2) {
                    Player target = Bukkit.getServer().getPlayerExact(args[1]);
                    if (target != null) {
                        World world = target.getWorld();
                        Location playerlocation = target.getLocation();
                        if (args[0].equalsIgnoreCase("Wolf")) {
                            world.spawnEntity(playerlocation, EntityType.WOLF);
                            sender.sendMessage("§aSpawned Wolf!");
                        } else if (args[0].equalsIgnoreCase("Pig")) {
                            world.spawnEntity(playerlocation, EntityType.PIG);
                            sender.sendMessage("§aSpawned Pig!");
                        } else if (args[0].equalsIgnoreCase("Cow")) {
                            world.spawnEntity(playerlocation, EntityType.COW);
                            sender.sendMessage("§aSpawned Cow!");
                        } else if (args[0].equalsIgnoreCase("Blaze")) {
                            world.spawnEntity(playerlocation, EntityType.BLAZE);
                            sender.sendMessage("§aSpawned Blaze!");
                        } else if (args[0].equalsIgnoreCase("CaveSpider")) {
                            world.spawnEntity(playerlocation, EntityType.CAVE_SPIDER);
                            sender.sendMessage("§aSpawned Cave Spider!");
                        } else if (args[0].equalsIgnoreCase("Chicken")) {
                            world.spawnEntity(playerlocation, EntityType.CHICKEN);
                            sender.sendMessage("§aSpawned Chicken!");
                        } else if (args[0].equalsIgnoreCase("Creeper")) {
                            world.spawnEntity(playerlocation, EntityType.CREEPER);
                            sender.sendMessage("§aSpawned Creeper!");
                        } else if (args[0].equalsIgnoreCase("EnderDragon")) {
                            world.spawnEntity(playerlocation, EntityType.ENDER_DRAGON);
                            sender.sendMessage("§aSpawned Ender Dragon!");
                        } else if (args[0].equalsIgnoreCase("Enderman")) {
                            world.spawnEntity(playerlocation, EntityType.ENDERMAN);
                            sender.sendMessage("§aSpawned Enderman!");
                        } else if (args[0].equalsIgnoreCase("Ghast")) {
                            world.spawnEntity(playerlocation, EntityType.GHAST);
                            sender.sendMessage("§aSpawned Ghast!");
                        } else if (args[0].equalsIgnoreCase("Giant")) {
                            world.spawnEntity(playerlocation, EntityType.GIANT);
                            sender.sendMessage("§aSpawned Giant!");
                        } else if (args[0].equalsIgnoreCase("IronGolem")) {
                            world.spawnEntity(playerlocation, EntityType.IRON_GOLEM);
                            sender.sendMessage("§aSpawned Iron Golem!");
                        } else if (args[0].equalsIgnoreCase("MagmaCube")) {
                            world.spawnEntity(playerlocation, EntityType.MAGMA_CUBE);
                            sender.sendMessage("§aSpawned Magma Cube!");
                        } else if (args[0].equalsIgnoreCase("Ocelot")) {
                            world.spawnEntity(playerlocation, EntityType.OCELOT);
                            sender.sendMessage("§aSpawned Ocelot!");
                        } else if (args[0].equalsIgnoreCase("Sheep")) {
                            world.spawnEntity(playerlocation, EntityType.SHEEP);
                            sender.sendMessage("§aSpawned Sheep!");
                        } else if (args[0].equalsIgnoreCase("SilverFish")) {
                            world.spawnEntity(playerlocation, EntityType.SILVERFISH);
                            sender.sendMessage("§aSpawned Silver Fish!");
                        } else if (args[0].equalsIgnoreCase("Skeleton")) {
                            world.spawnEntity(playerlocation, EntityType.SKELETON);
                            sender.sendMessage("§aSpawned Skeleton!");
                        } else if (args[0].equalsIgnoreCase("Slime")) {
                            world.spawnEntity(playerlocation, EntityType.SLIME);
                            sender.sendMessage("§aSpawned Slime!");
                        } else if (args[0].equalsIgnoreCase("Spider")) {
                            world.spawnEntity(playerlocation, EntityType.SPIDER);
                            sender.sendMessage("§aSpawned Spider!");
                        } else if (args[0].equalsIgnoreCase("Squid")) {
                            world.spawnEntity(playerlocation, EntityType.SQUID);
                            sender.sendMessage("§aSpawned Squid!");
                        } else if (args[0].equalsIgnoreCase("Villager")) {
                            world.spawnEntity(playerlocation, EntityType.VILLAGER);
                            sender.sendMessage("§aSpawned Villager!");
                        } else if (args[0].equalsIgnoreCase("Zombie")) {
                            world.spawnEntity(playerlocation, EntityType.ZOMBIE);
                            sender.sendMessage("§aSpawned Zombie!");
                        } else if (args[0].equalsIgnoreCase("Axolotl")) {
                            world.spawnEntity(playerlocation, EntityType.AXOLOTL);
                            sender.sendMessage("§aSpawned Axolotl!");
                        } else if (args[0].equalsIgnoreCase("Bat")) {
                            world.spawnEntity(playerlocation, EntityType.BAT);
                            sender.sendMessage("§aSpawned Bat!");
                        } else if (args[0].equalsIgnoreCase("Bee")) {
                            world.spawnEntity(playerlocation, EntityType.BEE);
                            sender.sendMessage("§aSpawned Bee!");
                        } else if (args[0].equalsIgnoreCase("Cat")) {
                            world.spawnEntity(playerlocation, EntityType.CAT);
                            sender.sendMessage("§aSpawned Cat!");
                        } else if (args[0].equalsIgnoreCase("Dolphin")) {
                            world.spawnEntity(playerlocation, EntityType.DOLPHIN);
                            sender.sendMessage("§aSpawned Dolphin!");
                        } else if (args[0].equalsIgnoreCase("Donkey")) {
                            world.spawnEntity(playerlocation, EntityType.DONKEY);
                            sender.sendMessage("§aSpawned Donkey!");
                        } else if (args[0].equalsIgnoreCase("Drowned")) {
                            world.spawnEntity(playerlocation, EntityType.DROWNED);
                            sender.sendMessage("§aSpawned Drowned!");
                        } else if (args[0].equalsIgnoreCase("ElderGuardian")) {
                            world.spawnEntity(playerlocation, EntityType.ELDER_GUARDIAN);
                            sender.sendMessage("§aSpawned Elder Guardian!");
                        } else if (args[0].equalsIgnoreCase("Endermite")) {
                            world.spawnEntity(playerlocation, EntityType.ENDERMITE);
                            sender.sendMessage("§aSpawned Endermite!");
                        } else if (args[0].equalsIgnoreCase("Cod")) {
                            world.spawnEntity(playerlocation, EntityType.COD);
                            sender.sendMessage("§aSpawned Cod!");
                        } else if (args[0].equalsIgnoreCase("Evoker")) {
                            world.spawnEntity(playerlocation, EntityType.EVOKER);
                            sender.sendMessage("§aSpawned Evoker!");
                        } else if (args[0].equalsIgnoreCase("Fox")) {
                            world.spawnEntity(playerlocation, EntityType.FOX);
                            sender.sendMessage("§aSpawned Fox!");
                        } else if (args[0].equalsIgnoreCase("GlowSquid")) {
                            world.spawnEntity(playerlocation, EntityType.GLOW_SQUID);
                            sender.sendMessage("§aSpawned Glow Squid!");
                        } else if (args[0].equalsIgnoreCase("Goat")) {
                            world.spawnEntity(playerlocation, EntityType.GOAT);
                            sender.sendMessage("§aSpawned Goat!");
                        } else if (args[0].equalsIgnoreCase("Guardian")) {
                            world.spawnEntity(playerlocation, EntityType.GUARDIAN);
                            sender.sendMessage("§aSpawned Guardian!");
                        } else if (args[0].equalsIgnoreCase("Hoglin")) {
                            world.spawnEntity(playerlocation, EntityType.HOGLIN);
                            sender.sendMessage("§aSpawned Hoglin!");
                        } else if (args[0].equalsIgnoreCase("Horse")) {
                            world.spawnEntity(playerlocation, EntityType.HORSE);
                            sender.sendMessage("§aSpawned Horse!");
                        } else if (args[0].equalsIgnoreCase("Husk")) {
                            world.spawnEntity(playerlocation, EntityType.HUSK);
                            sender.sendMessage("§aSpawned Husk!");
                        } else if (args[0].equalsIgnoreCase("Illusioner")) {
                            world.spawnEntity(playerlocation, EntityType.ILLUSIONER);
                            sender.sendMessage("§aSpawned Illusioner!");
                        } else if (args[0].equalsIgnoreCase("Llama")) {
                            world.spawnEntity(playerlocation, EntityType.LLAMA);
                            sender.sendMessage("§aSpawned Llama!");
                        } else if (args[0].equalsIgnoreCase("Mule")) {
                            world.spawnEntity(playerlocation, EntityType.MULE);
                            sender.sendMessage("§aSpawned Mule!");
                        } else if (args[0].equalsIgnoreCase("MushroomCow")) {
                            world.spawnEntity(playerlocation, EntityType.MUSHROOM_COW);
                            sender.sendMessage("§aSpawned Mushroom Cow!");
                        } else if (args[0].equalsIgnoreCase("Panda")) {
                            world.spawnEntity(playerlocation, EntityType.PANDA);
                            sender.sendMessage("§aSpawned Panda!");
                        } else if (args[0].equalsIgnoreCase("Parrot")) {
                            world.spawnEntity(playerlocation, EntityType.PARROT);
                            sender.sendMessage("§aSpawned Parrot!");
                        } else if (args[0].equalsIgnoreCase("Phantom")) {
                            world.spawnEntity(playerlocation, EntityType.PHANTOM);
                            sender.sendMessage("§aSpawned Phantom!");
                        } else if (args[0].equalsIgnoreCase("Piglin")) {
                            world.spawnEntity(playerlocation, EntityType.PIGLIN);
                            sender.sendMessage("§aSpawned Piglin!");
                        } else if (args[0].equalsIgnoreCase("PiglinBrute")) {
                            world.spawnEntity(playerlocation, EntityType.PIGLIN_BRUTE);
                            sender.sendMessage("§aSpawned Piglin Brute!");
                        } else if (args[0].equalsIgnoreCase("Pillager")) {
                            world.spawnEntity(playerlocation, EntityType.PILLAGER);
                            sender.sendMessage("§aSpawned Pillager!");
                        } else if (args[0].equalsIgnoreCase("PolarBear")) {
                            world.spawnEntity(playerlocation, EntityType.POLAR_BEAR);
                            sender.sendMessage("§aSpawned Polar Bear!");
                        } else if (args[0].equalsIgnoreCase("Pufferfish")) {
                            world.spawnEntity(playerlocation, EntityType.PUFFERFISH);
                            sender.sendMessage("§aSpawned Pufferfish!");
                        } else if (args[0].equalsIgnoreCase("Rabbit")) {
                            world.spawnEntity(playerlocation, EntityType.RABBIT);
                            sender.sendMessage("§aSpawned Rabbit!");
                        } else if (args[0].equalsIgnoreCase("Ravager")) {
                            world.spawnEntity(playerlocation, EntityType.RAVAGER);
                            sender.sendMessage("§aSpawned Ravager!");
                        } else if (args[0].equalsIgnoreCase("Salmon")) {
                            world.spawnEntity(playerlocation, EntityType.SALMON);
                            sender.sendMessage("§aSpawned Salmon!");
                        } else if (args[0].equalsIgnoreCase("Shulker")) {
                            world.spawnEntity(playerlocation, EntityType.SHULKER);
                            sender.sendMessage("§aSpawned Shulker!");
                        } else if (args[0].equalsIgnoreCase("SkeletonHorse")) {
                            world.spawnEntity(playerlocation, EntityType.SKELETON_HORSE);
                            sender.sendMessage("§aSpawned Skeleton Horse!");
                        } else if (args[0].equalsIgnoreCase("Snowman")) {
                            world.spawnEntity(playerlocation, EntityType.SNOWMAN);
                            sender.sendMessage("§aSpawned Snowman!");
                        } else if (args[0].equalsIgnoreCase("Stray")) {
                            world.spawnEntity(playerlocation, EntityType.STRAY);
                            sender.sendMessage("§aSpawned Stray!");
                        } else if (args[0].equalsIgnoreCase("Strider")) {
                            world.spawnEntity(playerlocation, EntityType.STRIDER);
                            sender.sendMessage("§aSpawned Strider!");
                        } else if (args[0].equalsIgnoreCase("TropicalFish")) {
                            world.spawnEntity(playerlocation, EntityType.TROPICAL_FISH);
                            sender.sendMessage("§aSpawned Tropical Fish!");
                        } else if (args[0].equalsIgnoreCase("Turtle")) {
                            world.spawnEntity(playerlocation, EntityType.TURTLE);
                            sender.sendMessage("§aSpawned Turtle!");
                        } else if (args[0].equalsIgnoreCase("Vex")) {
                            world.spawnEntity(playerlocation, EntityType.VEX);
                            sender.sendMessage("§aSpawned Vex!");
                        } else if (args[0].equalsIgnoreCase("Vindicator")) {
                            world.spawnEntity(playerlocation, EntityType.VINDICATOR);
                            sender.sendMessage("§aSpawned Vindicator!");
                        } else if (args[0].equalsIgnoreCase("WanderingTrader")) {
                            world.spawnEntity(playerlocation, EntityType.WANDERING_TRADER);
                            sender.sendMessage("§aSpawned Wandering Trader!");
                        } else if (args[0].equalsIgnoreCase("Witch")) {
                            world.spawnEntity(playerlocation, EntityType.WITCH);
                            sender.sendMessage("§aSpawned Witch!");
                        } else if (args[0].equalsIgnoreCase("Wither")) {
                            world.spawnEntity(playerlocation, EntityType.WITHER);
                            sender.sendMessage("§aSpawned Wither!");
                        } else if (args[0].equalsIgnoreCase("WitherSkeleton")) {
                            world.spawnEntity(playerlocation, EntityType.WITHER_SKELETON);
                            sender.sendMessage("§aSpawned Wither Skeleton!");
                        } else if (args[0].equalsIgnoreCase("Zoglin")) {
                            world.spawnEntity(playerlocation, EntityType.ZOGLIN);
                            sender.sendMessage("§aSpawned Zoglin!");
                        } else if (args[0].equalsIgnoreCase("ZombieHorse")) {
                            world.spawnEntity(playerlocation, EntityType.ZOMBIE_HORSE);
                            sender.sendMessage("§aSpawned Zombie Horse!");
                        } else if (args[0].equalsIgnoreCase("ZombieVillager")) {
                            world.spawnEntity(playerlocation, EntityType.ZOMBIE_VILLAGER);
                            sender.sendMessage("§aSpawned Zombie Villager!");
                        } else if (args[0].equalsIgnoreCase("ZombifiedPiglin")) {
                            world.spawnEntity(playerlocation, EntityType.ZOMBIFIED_PIGLIN);
                            sender.sendMessage("§aSpawned Zombified Piglin!");
                        } else {
                            sender.sendMessage("§cMob not found");
                        }
                    } else {
                        sender.sendMessage("§cPlayer not found");
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
