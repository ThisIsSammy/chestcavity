package net.tigereye.chestcavity.items;

import com.google.common.collect.Maps;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.tigereye.chestcavity.ChestCavity;
import net.tigereye.chestcavity.managers.ChestCavityManager;
import net.tigereye.chestcavity.registration.CCItems;
import net.tigereye.chestcavity.registration.CCOrganScores;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static net.tigereye.chestcavity.managers.ChestCavityManager.COMPATIBILITY_TAG;

public class OrganBase extends Item implements ChestCavityOrgan {


	protected Map<Identifier, Float> organQualityMap = Maps.newHashMap();


	public OrganBase() {
		super(CCItems.ORGAN_SETTINGS_1);
	}

	public OrganBase(Item.Settings settings) {
		super(settings);
	}

	public Map<Identifier, Float> getOrganQualityMap() {
		return organQualityMap;
	}
	public Map<Identifier, Float> getOrganQualityMap(ItemStack item, LivingEntity entity) {
		return getOrganQualityMap();
	}

	public float getOrganQuality(Identifier id) {
		return organQualityMap.getOrDefault(id, 0f);
	}

	public OrganBase setOrganQuality(Identifier id, float value) {
		organQualityMap.put(id, value);
		return this;
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		displayOrganQuality(itemStack,world,tooltip,tooltipContext);
		displaySoulBinding(itemStack,world,tooltip,tooltipContext);
		super.appendTooltip(itemStack,world,tooltip,tooltipContext);
	}

	protected void displayOrganQuality(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext){
		organQualityMap.forEach((organ,score) -> {
			String tier;
			if(score > 1){
				tier = "Exceptional ";
			}
			else if(score > .75f){
				tier = "Quality ";
			}
			else if(score > .5f){
				tier = "Average ";
			}
			else if(score > .25f){
				tier = "Poor ";
			}
			else{
				tier = "Pathetic ";
			}
			LiteralText text = new LiteralText(tier+organ.getPath());
			tooltip.add(text);
		});
	}

	protected void displaySoulBinding(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		CompoundTag tag = itemStack.getTag();
		if (tag != null && tag.contains(COMPATIBILITY_TAG.toString())) {
			tag = tag.getCompound(COMPATIBILITY_TAG.toString());
			if (tag.getInt("type") == ChestCavityManager.COMPATIBILITY_TYPE_PERSONAL) {
				String name = tag.getString("name");
				Text text = new LiteralText("Owner: "+name);
				tooltip.add(text);
			}
		}
	}
}
