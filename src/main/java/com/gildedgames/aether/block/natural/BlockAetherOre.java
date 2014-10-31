package com.gildedgames.aether.block.natural;

import java.util.Random;

import com.gildedgames.aether.init.CreativeTabsAether;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

public abstract class BlockAetherOre extends Block
{
	
	protected Item itemDropped;
	
    protected Random rand = new Random();
    
    public BlockAetherOre()
    {
    	super(Material.rock);
    	
    	this.setHardness(3.0F);
    	this.setResistance(5.0F);
    	this.setStepSound(Block.soundTypeStone);
    	
    	this.setCreativeTab(CreativeTabsAether.blocksNatural);
    }
	
    public BlockAetherOre(Item itemDropped)
    {
    	this();
        
        this.itemDropped = itemDropped;
    }

    @Override
    public Item getItemDropped(int blockMetadata, Random rand, int fortuneLevel)
    {
        return this.itemDropped != null ? this.itemDropped : Item.getItemFromBlock(this);
    }

    @Override
    public int quantityDropped(Random rand)
    {
        return this.getQuantityDropped(rand);
    }

    public int quantityDroppedWithBonus(int fortuneLevel, Random rand)
    {
        if (fortuneLevel > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, rand, fortuneLevel))
        {
            int quantityWeight = rand.nextInt(fortuneLevel + 2) - 1;

            if (quantityWeight < 0)
            {
                quantityWeight = 0;
            }

            return this.quantityDropped(rand) * (quantityWeight + 1);
        }
        
        return this.quantityDropped(rand);
    }

    @Override
    public int getExpDrop(IBlockAccess iBlockAccess, int blockMetadata, int fortuneLevel)
    {
        return this.getExperience(iBlockAccess, blockMetadata, fortuneLevel);
    }
    
    public abstract int getExperience(IBlockAccess iBlockAccess, int blockMetadata, int fortuneLevel);
    
    public abstract int getQuantityDropped(Random rand);
    
}
