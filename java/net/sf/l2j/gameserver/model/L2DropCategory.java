/* This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package net.sf.l2j.gameserver.model;

import javolution.util.FastList;
import net.sf.l2j.Config;
import net.sf.l2j.util.Rnd;

public class L2DropCategory {
  private final FastList<L2DropData> _drops;
  private int _categoryChance; // a sum of chances for calculating if an item will be dropped from this category
  private int _categoryBalancedChance; // sum for balancing drop selection inside categories in high rate servers
  private final int _categoryType;

  public L2DropCategory(int categoryType) {
    _categoryType = categoryType;
    _drops = new FastList<>(0);
    _categoryChance = 0;
    _categoryBalancedChance = 0;
  }

  public void addDropData(L2DropData drop) {
    if(drop.isQuestDrop()) {
    } else {
      _drops.add(drop);
      _categoryChance += drop.getChance();
      // for drop selection inside a category: max 100 % chance for getting an item, scaling all values to that.
      _categoryBalancedChance += Math.min((drop.getChance() * Config.RATE_DROP_ITEMS), L2DropData.MAX_CHANCE);
    }
  }

  public FastList<L2DropData> getAllDrops() {
    return _drops;
  }

  public void clearAllDrops() {
    _drops.clear();
  }

  public boolean isSweep() {
    return (getCategoryType() == -1);
  }

  // this returns the chance for the category to be visited in order to check if
  // drops might come from it. Category -1 (spoil) must always be visited
  // (but may return 0 or many drops)
  public int getCategoryChance() {
    if(getCategoryType() >= 0) {
      return _categoryChance;
    }
    return L2DropData.MAX_CHANCE;
  }

  public int getCategoryBalancedChance() {
    if(getCategoryType() >= 0) {
      return _categoryBalancedChance;
    }
    return L2DropData.MAX_CHANCE;
  }

  public int getCategoryType() {
    return _categoryType;
  }

  /**
   * useful for seeded conditions...the category will attempt to drop only among items that are allowed to be dropped when a mob is seeded. Previously, this only included adena. According to sh1ny, sealstones are also acceptable drops. if no acceptable drops are in the category, nothing will be
   * dropped. otherwise, it will check for the item's chance to drop and either drop it or drop nothing.
   *
   * @return acceptable drop when mob is seeded, if it exists. Null otherwise.
   */
  public synchronized L2DropData dropSeedAllowedDropsOnly() {
    FastList<L2DropData> drops = new FastList<>();
    int subCatChance = 0;
    for(L2DropData drop : getAllDrops()) {
      if((drop.getItemId() == 57) || (drop.getItemId() == 6360) || (drop.getItemId() == 6361) || (drop.getItemId() == 6362)) {
        drops.add(drop);
        subCatChance += drop.getChance();
      }
    }

    // among the results choose one.
    int randomIndex = Rnd.get(subCatChance);
    int sum = 0;
    for(L2DropData drop : drops) {
      sum += drop.getChance();

      if(sum > randomIndex) // drop this item and exit the function
      {
        drops.clear();
        drops = null;
        return drop;
      }
    }
    // since it is still within category, only drop one of the acceptable drops from the results.
    return null;
  }

  public synchronized L2DropData dropOne() {
    int randomIndex = Rnd.get(getCategoryBalancedChance());
    int sum = 0;
    for(L2DropData drop : getAllDrops()) {
      sum += Math.min((drop.getChance() * Config.RATE_DROP_ITEMS), L2DropData.MAX_CHANCE);

      if(sum >= randomIndex) {
        return drop;
      }
    }
    return null;
  }
}
