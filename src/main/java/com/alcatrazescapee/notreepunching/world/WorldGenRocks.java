/*
 *  Part of the No Tree Punching Mod by alcatrazEscapee
 *  Work under Copyright. Licensed under the GPL-3.0.
 *  See the project LICENSE.md for more information.
 */

package com.alcatrazescapee.notreepunching.world;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.alcatrazescapee.alcatrazcore.util.CoreHelpers;
import com.alcatrazescapee.notreepunching.ModConfig;
import com.alcatrazescapee.notreepunching.common.blocks.BlockRock;
import com.alcatrazescapee.notreepunching.util.types.Stone;

public class WorldGenRocks implements IWorldGenerator
{
    private static final Set<Material> MATERIALS = Sets.newHashSet(Material.GROUND, Material.SAND, Material.GRASS, Material.CLAY, Material.GOURD, Material.SNOW);
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        if (world.provider != null && world.provider.getDimension() == 0 && ModConfig.GENERAL.looseRocksGeneration)
        {
            for (int i = 0; i < ModConfig.GENERAL.looseRocksFrequency; i++)
            {
                int xCoord = chunkX * 16 + random.nextInt(16) + 8;
                int zCoord = chunkZ * 16 + random.nextInt(16) + 8;
                if (random.nextFloat() < 0.5)
                {
                    Stone stone = Stone.getRandom(random);
                    placeRock(world, CoreHelpers.getTopSolidBlock(world, new BlockPos(xCoord, 0, zCoord)), stone);
                }
            }
        }
    }

    private void placeRock(World world, BlockPos pos, Stone stone)
    {
        IBlockState state = world.getBlockState(pos);
        IBlockState stateDown = world.getBlockState(pos.down());
        if (!state.getMaterial().isLiquid() && state.getBlock().isReplaceable(world, pos) && !state.isOpaqueCube() &&
                stateDown.isNormalCube() && MATERIALS.contains(stateDown.getMaterial()))
            world.setBlockState(pos, BlockRock.get(stone).getDefaultState());
    }
}
