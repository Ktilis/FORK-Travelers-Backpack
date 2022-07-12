package com.tiviacz.travelersbackpack.fluids;

import com.tiviacz.travelersbackpack.TravelersBackpack;
import com.tiviacz.travelersbackpack.util.FluidUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.client.IFluidTypeRenderProperties;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class PotionFluidType extends FluidType
{
    public static final ResourceLocation POTION_STILL_RL = new ResourceLocation(TravelersBackpack.MODID, "block/potion_still");
    public static final ResourceLocation POTION_FLOW_RL = new ResourceLocation(TravelersBackpack.MODID, "block/potion_flow");

    public PotionFluidType(Properties properties)
    {
        super(properties);
    }

    @Override
    public void initializeClient(Consumer<IFluidTypeRenderProperties> consumer)
    {
        consumer.accept(new IFluidTypeRenderProperties() {
            @Override
            public int getColorTint(FluidStack stack)
            {
                return PotionUtils.getColor(FluidUtils.getItemStackFromFluidStack(stack)) | 0xFF000000;
            }

            @Override
            public int getColorTint()
            {
                return 13458603;
            }

            @Override
            public ResourceLocation getStillTexture() {
                return POTION_STILL_RL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return POTION_FLOW_RL;
            }
        });
    }
}
