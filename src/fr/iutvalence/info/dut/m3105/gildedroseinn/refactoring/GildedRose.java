package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	private static List<Item> items = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		updateQualityAndSellInForAllItems();
	}
	 
	// update quality and sellIn for all items
	public static void updateQualityAndSellInForAllItems()
	{
		// picks up each item of the list
		for (int i = 0; i < getSize(items); i++)
		{
			// update picked up item's quality and sell in
			if ((!"Aged Brie".equals(getItem(items, i).getName()))
					&& !"Backstage passes to a TAFKAL80ETC concert".equals(getItem(items, i).getName()))
			{
				if (getItem(items, i).getQuality() > 0)
				{
					if (!"Sulfuras, Hand of Ragnaros".equals(getItem(items, i).getName()))
					{
						getItem(items, i).setQuality(getItem(items, i).getQuality() - 1);
					}
				}
			}
			else
			{
				if (getItem(items, i).getQuality() < 50)
				{
					getItem(items, i).setQuality(getItem(items, i).getQuality() + 1);

					if ("Backstage passes to a TAFKAL80ETC concert".equals(getItem(items, i).getName()))
					{
						if (getItem(items, i).getSellIn() < 11)
						{
							if (getItem(items, i).getQuality() < 50)
							{
								getItem(items, i).setQuality(getItem(items, i).getQuality() + 1);
							}
						}

						if (getItem(items, i).getSellIn() < 6)
						{
							if (getItem(items, i).getQuality() < 50)
							{
								getItem(items, i).setQuality(getItem(items, i).getQuality() + 1);
							}
						}
					}
				}
			}
			// update picked up item's sellIn
			if (!"Sulfuras, Hand of Ragnaros".equals(getItem(items, i).getName()))
			{
				getItem(items, i).setSellIn(getItem(items, i).getSellIn() - 1);
			}
			// update picked up item's quality depending on the sellIn
			if (getItem(items, i).getSellIn() < 0)
			{
				if (!"Aged Brie".equals(getItem(items, i).getName()))
				{
					if (!"Backstage passes to a TAFKAL80ETC concert".equals(getItem(items, i).getName()))
					{
						if (getItem(items, i).getQuality() > 0)
						{
							if (!"Sulfuras, Hand of Ragnaros".equals(getItem(items, i).getName()))
							{
								getItem(items, i).setQuality(getItem(items, i).getQuality() - 1);
							}
						}
					}
					else
					{
						getItem(items, i).setQuality(getItem(items, i).getQuality() - getItem(items, i).getQuality());
					}
				}
				else
				{
					if (getItem(items, i).getQuality() < 50)
					{
						getItem(items, i).setQuality(getItem(items, i).getQuality() + 1);
					}
				}
			}
		}
	}
	
	public static Item getItem(List<Item> itemsList, int i) {
		return itemsList.get(i);
	}
	
	public static Item getItem(Item[] itemsTab, int i) {
		return itemsTab[i];
	}
	
	public static int getSize(List<Item> itemsList) {
		return itemsList.size();
	}

	public static int getSize(Item[] itemsTab) {
		return itemsTab.length;
	}
}