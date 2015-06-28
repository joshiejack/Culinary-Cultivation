package thaumcraft.api;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ThaumcraftMaterials {

	public static ToolMaterial TOOLMAT_THAUMIUM = EnumHelper.addToolMaterial("THAUMIUM", 3, 400, 7F, 2, 22);
	public static ToolMaterial TOOLMAT_VOID = EnumHelper.addToolMaterial("VOID", 4, 150, 8F, 3, 10);
	public static ToolMaterial TOOLMAT_ELEMENTAL = EnumHelper.addToolMaterial("THAUMIUM_ELEMENTAL", 3, 1500, 10F, 3, 18);
	public static ArmorMaterial ARMORMAT_THAUMIUM = EnumHelper.addArmorMaterial("THAUMIUM","THAUMIUM", 25, new int[] { 2, 6, 5, 2 }, 25);
	public static ArmorMaterial ARMORMAT_SPECIAL = EnumHelper.addArmorMaterial("SPECIAL","SPECIAL", 25, new int[] { 1, 3, 2, 1 }, 25);
	public static ArmorMaterial ARMORMAT_VOID = EnumHelper.addArmorMaterial("VOID","VOID", 10, new int[] { 3, 7, 6, 3 }, 10);
	
	public static final Material MATERIAL_TAINT = new MaterialTaint(MapColor.purpleColor);
	
	public static class MaterialTaint extends Material
	{
	    public MaterialTaint(MapColor par1MapColor)
	    {
	        super(par1MapColor);
	        this.setNoPushMobility();
	        this.setRequiresTool();
	    }

	    @Override
	    public boolean isSolid()
	    {
	        return false;
	    }
	    
	    @Override
	    public boolean isReplaceable()
	    {
	        return false;
	    }

	    /**
	     * Returns if this material is considered solid or not
	     */
	    @Override
	    public boolean blocksMovement()
	    {
	        return true;
	    }

		@Override
		protected Material setRequiresTool() {
//			this.requiresNoTool = true;
	        return this;
		}

		
		@Override
		protected Material setNoPushMobility()
	    {
	        this.mobilityFlag = 1;
	        return this;
	    }
		
		private int mobilityFlag;
		
		@Override
		public int getMaterialMobility()
	    {
	        return this.mobilityFlag;
	    }
	    
	    
	}

	public static class MaterialAiry extends Material
	{
	    public MaterialAiry(MapColor par1MapColor)
	    {
	        super(par1MapColor);
	        this.setNoPushMobility();
	        this.setRequiresTool();
	    }

	    @Override
	    public boolean isSolid()
	    {
	        return false;
	    }
	    
	    @Override
	    public boolean blocksLight()
	    {
	        return false;
	    }
	    
	    @Override
	    public boolean isReplaceable()
	    {
	        return false;
	    }   

	    @Override
	    public boolean blocksMovement()
	    {
	        return false;
	    }

		@Override
		protected Material setRequiresTool() {
	        return this;
		}

		
		@Override
		protected Material setNoPushMobility()
	    {
	        this.mobilityFlag = 1;
	        return this;
	    }
		
		private int mobilityFlag;
		
		@Override
		public int getMaterialMobility()
	    {
	        return this.mobilityFlag;
	    }
	    
	    
	}
}
