package openlyfay.ancientgateways;


import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import openlyfay.ancientgateways.block.GatewayBlock;
import openlyfay.ancientgateways.block.runes.*;
import openlyfay.ancientgateways.block.blockitem.*;
import openlyfay.ancientgateways.blockentity.GatewayBlockEntity;

// getString(ctx, "string")
import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static com.mojang.brigadier.arguments.StringArgumentType.getString;
// word()
import static com.mojang.brigadier.arguments.StringArgumentType.word;
// literal("foo")
import static net.minecraft.server.command.CommandManager.literal;
// argument("bar", word())
import static net.minecraft.server.command.CommandManager.argument;
// Import everything
import static net.minecraft.server.command.CommandManager.*;

public class AncientGateways implements ModInitializer {

    public static final String MOD_ID = "ancientgateways";
    
    public static final Block gateway_block = new GatewayBlock(FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES,3).lightLevel(10).hardness(50).resistance(1200));
    public static BlockEntityType<GatewayBlockEntity> GATEWAY_BLOCK_ENTITY;
    public static final Block black_rune_block = new BlackRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block red_rune_block = new RedRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block green_rune_block = new GreenRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block brown_rune_block = new BrownRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block blue_rune_block = new BlueRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block purple_rune_block = new PurpleRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block cyan_rune_block = new CyanRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block light_grey_rune_block = new LightGreyRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block grey_rune_block = new GreyRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block pink_rune_block = new PinkRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block lime_rune_block = new LimeRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block yellow_rune_block = new YellowRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block light_blue_rune_block = new LightBlueRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block magenta_rune_block = new MagentaRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block orange_rune_block = new OrangeRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());
    public static final Block white_rune_block = new WhiteRuneBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque());


    @Override
    public void onInitialize(){
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "gatewayblock"), gateway_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "gatewayblock"),new GatewayBlockItem(gateway_block, new Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN).rarity(Rarity.UNCOMMON)));
        GATEWAY_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,MOD_ID + ":gateway_block_entity", BlockEntityType.Builder.create(GatewayBlockEntity::new, gateway_block).build(null));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_black"),black_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_black"), new BlackRuneItem(black_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_red"),red_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_red"), new RedRuneItem(red_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_green"),green_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_green"), new GreenRuneItem(green_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_brown"),brown_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_brown"), new BrownRuneItem(brown_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_blue"),blue_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_blue"), new BlueRuneItem(blue_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_purple"),purple_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_purple"), new PurpleRuneItem(purple_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_cyan"),cyan_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_cyan"), new CyanRuneItem(cyan_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_light_grey"),light_grey_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_light_grey"), new LightGreyRuneItem(light_grey_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_grey"),grey_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_grey"), new GreyRuneItem(grey_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_pink"),pink_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_pink"), new PinkRuneItem(pink_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_lime"),lime_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_lime"), new LimeRuneItem(lime_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_yellow"),yellow_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_yellow"), new YellowRuneItem(yellow_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_light_blue"),light_blue_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_light_blue"), new LightBlueRuneItem(light_blue_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_magenta"),magenta_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_magenta"), new MagentaRuneItem(magenta_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_orange"),orange_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_orange"), new OrangeRuneItem(orange_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rune_white"),white_rune_block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rune_white"), new WhiteRuneItem(white_rune_block, new  Item.Settings().maxCount(16).group(ANCIENT_GATEWAYS_MAIN)));

        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("setgatewaydelay").requires(source -> source.hasPermissionLevel(4)).then(argument("delay", integer()).executes(ctx -> {
                StateConfig.get(ctx.getSource().getWorld()).setDelay(Math.abs(getInteger(ctx, "delay")));
                int delay = StateConfig.get(ctx.getSource().getWorld()).getDelay();
                if(delay == 0 || delay == 400){
                    ctx.getSource().sendFeedback(new LiteralText("Gateway delay set to default (400 ticks or 20 seconds)"), true);
                } else {
                    ctx.getSource().sendFeedback(new LiteralText("Gateway delay set to " + delay + " ticks or " + delay/20 + " seconds"), true);
                }
                return 1;
            })));
        });

        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("getgatewaydelay").requires(source -> source.hasPermissionLevel(4)).executes(ctx -> {
                int delay = StateConfig.get(ctx.getSource().getWorld()).getDelay();
                if(delay == 0 || delay == 400){
                    ctx.getSource().sendFeedback(new LiteralText("The portal delay is set to default which is 400 ticks or 20 seconds"), false);
                } else {
                    ctx.getSource().sendFeedback(new LiteralText("The portal delay is set to " + delay + " ticks or " + delay/20 + " seconds"), false);
                }
                return 1;
            }));
        });
    }

    public static final ItemGroup ANCIENT_GATEWAYS_MAIN = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "general")).icon(() -> new ItemStack(gateway_block))
            .build();
}