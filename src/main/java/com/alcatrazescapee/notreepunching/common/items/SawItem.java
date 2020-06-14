/*
 *  Part of the No Tree Punching Mod by alcatrazEscapee
 *  Work under Copyright. Licensed under the GPL-3.0.
 *  See the project LICENSE.md for more information.
 */

package com.alcatrazescapee.notreepunching.common.items;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

import com.alcatrazescapee.core.util.CoreHelpers;
import com.alcatrazescapee.notreepunching.common.ModItemGroups;

public class SawItem extends AxeItem
{
    public SawItem(IItemTier tier, float attackDamageIn, float attackSpeedIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().group(ModItemGroups.ITEMS).setNoRepair());
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        return CoreHelpers.damageItem(itemStack.copy(), 1);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack)
    {
        return true;
    }
}