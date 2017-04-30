package com.mcmoddev.lib.item;

import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.material.IMMDObject;
import com.mcmoddev.lib.material.MMDMaterial;

import net.minecraft.block.BlockDoor;

/**
 * Doors
 */
public class ItemMMDDoor extends net.minecraft.item.ItemDoor implements IMMDObject {

	private final MMDMaterial material;

	/**
	 *
	 * @param material
	 *            The material to make the door from
	 */
	public ItemMMDDoor(MMDMaterial material) {
		super(material.getBlock(Names.DOORBLOCK));
		this.material = material;
	}

	/**
	 *
	 * @param block
	 *            The block to use to make the door
	 * @param material
	 *            The material to make the door from
	 */
	public ItemMMDDoor(BlockDoor block, MMDMaterial material) {
		super(block);
		this.material = material;
	}

	@Override
	public MMDMaterial getMaterial() {
		return this.material;
	}

	/**
	 * @deprecated
	 */
	@Override
	@Deprecated
	public MMDMaterial getMetalMaterial() {
		return this.material;
	}
}