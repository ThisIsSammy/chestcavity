package net.tigereye.chestcavity.managers;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.tigereye.chestcavity.ChestCavity;
import net.tigereye.chestcavity.registration.CCItems;
import net.tigereye.chestcavity.registration.CCOrganScores;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SkeletonChestCavityManager extends ChestCavityManager{


    public SkeletonChestCavityManager(LivingEntity owner) {
        super(owner);
    }
    public SkeletonChestCavityManager(LivingEntity owner, int size) {
        super(owner,size);
    }

    @Override
    public void fillChestCavityInventory() {
        chestCavity.clear();
        chestCavity.setStack(0, ItemStack.EMPTY);
        chestCavity.setStack(1, new ItemStack(CCItems.ROTTEN_RIB, CCItems.ROTTEN_RIB.getMaxCount()));
        chestCavity.setStack(2, ItemStack.EMPTY);
        chestCavity.setStack(3, ItemStack.EMPTY);
        chestCavity.setStack(4, ItemStack.EMPTY);
        chestCavity.setStack(5, ItemStack.EMPTY);
        chestCavity.setStack(6, ItemStack.EMPTY);
        chestCavity.setStack(7, new ItemStack(CCItems.ROTTEN_RIB, CCItems.ROTTEN_RIB.getMaxCount()));
        chestCavity.setStack(8, ItemStack.EMPTY);
        chestCavity.setStack(9, ItemStack.EMPTY);
        chestCavity.setStack(10, new ItemStack(CCItems.ROTTEN_RIB, CCItems.ROTTEN_RIB.getMaxCount()));
        chestCavity.setStack(11, ItemStack.EMPTY);
        chestCavity.setStack(12, ItemStack.EMPTY);
        chestCavity.setStack(13, new ItemStack(CCItems.ROTTEN_SPINE, CCItems.ROTTEN_SPINE.getMaxCount()));
        chestCavity.setStack(14, ItemStack.EMPTY);
        chestCavity.setStack(15, ItemStack.EMPTY);
        chestCavity.setStack(16, new ItemStack(CCItems.ROTTEN_RIB, CCItems.ROTTEN_RIB.getMaxCount()));
        chestCavity.setStack(17, ItemStack.EMPTY);
        chestCavity.setStack(18, ItemStack.EMPTY);
        chestCavity.setStack(19, ItemStack.EMPTY);
        chestCavity.setStack(20, ItemStack.EMPTY);
        chestCavity.setStack(21, ItemStack.EMPTY);
        chestCavity.setStack(22, ItemStack.EMPTY);
        chestCavity.setStack(23, ItemStack.EMPTY);
        chestCavity.setStack(24, ItemStack.EMPTY);
        chestCavity.setStack(25, ItemStack.EMPTY);
        chestCavity.setStack(26, ItemStack.EMPTY);
    }

    @Override
    protected void resetOrganScores(){
        //animated by unholy magic, skeletons get to pretend they have organs they actually don't!
        //they also don't have any organs, but imagine if they did...
        organScores.clear();
        organScores.put(CCOrganScores.APPENDIX, 1f);
        organScores.put(CCOrganScores.BONE, 2.375f);
        organScores.put(CCOrganScores.HEART, 1f);
        organScores.put(CCOrganScores.INTESTINE, 4f);
        organScores.put(CCOrganScores.KIDNEY, 2f);
        organScores.put(CCOrganScores.LIVER, 1f);
        organScores.put(CCOrganScores.STRENGTH, 8f);
        organScores.put(CCOrganScores.SPEED, 8f);
        organScores.put(CCOrganScores.NERVOUS_SYSTEM, .5f);
        organScores.put(CCOrganScores.SPLEEN, 1f);
        organScores.put(CCOrganScores.STOMACH, 1f);
        organScores.put(CCOrganScores.LUNG, 2f);
    }

    @Override
    public List<ItemStack> generateLootDrops(Random random, int looting){
        List<ItemStack> loot = new ArrayList<>();
        if(random.nextFloat() < ChestCavity.config.ORGAN_BUNDLE_DROP_RATE + (ChestCavity.config.ORGAN_BUNDLE_LOOTING_BOOST*looting)) {
            LinkedList<Item> organPile = new LinkedList<>();
            for(int i = 0; i < 4; i++){
                organPile.add(CCItems.ROTTEN_RIB);
            }
            organPile.add(CCItems.ROTTEN_SPINE);
            int rolls = 1 + random.nextInt(1) + random.nextInt(1);
            for (int i = 0; i < rolls; i++){
                int roll = random.nextInt(organPile.size());
                int count = 1;
                Item rolledItem = organPile.get(roll);
                if(rolledItem.getMaxCount() > 1){
                    count += random.nextInt(rolledItem.getMaxCount());
                }
                loot.add(new ItemStack(organPile.remove(roll),count));
            }
        }
        return loot;
    }
}
