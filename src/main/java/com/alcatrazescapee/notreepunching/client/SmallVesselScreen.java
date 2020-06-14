package com.alcatrazescapee.notreepunching.client;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import com.alcatrazescapee.core.screen.ModContainerScreen;
import com.alcatrazescapee.notreepunching.common.container.SmallVesselContainer;

import static com.alcatrazescapee.notreepunching.NoTreePunching.MOD_ID;

public class SmallVesselScreen extends ModContainerScreen<SmallVesselContainer>
{
    private static final ResourceLocation SMALL_VESSEL_BACKGROUND = new ResourceLocation(MOD_ID, "textures/gui/small_vessel.png");

    public SmallVesselScreen(SmallVesselContainer screenContainer, PlayerInventory inv, ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn, SMALL_VESSEL_BACKGROUND);
    }
}