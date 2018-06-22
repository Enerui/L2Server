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
package net.sf.l2j.gameserver.handler.itemhandlers;

import net.sf.l2j.gameserver.datatables.SkillTable;
import net.sf.l2j.gameserver.handler.IItemHandler;
import net.sf.l2j.gameserver.model.L2ItemInstance;
import net.sf.l2j.gameserver.model.L2Skill;
import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
import net.sf.l2j.gameserver.model.actor.instance.L2PetInstance;
import net.sf.l2j.gameserver.model.actor.instance.L2PlayableInstance;
import net.sf.l2j.gameserver.network.SystemMessageId;
import net.sf.l2j.gameserver.serverpackets.ActionFailed;
import net.sf.l2j.gameserver.serverpackets.MagicSkillUser;
import net.sf.l2j.gameserver.serverpackets.SystemMessage;

public class Scrolls implements IItemHandler {
  private static final int[] ITEM_IDS =
      {
          3926,
          3927,
          3928,
          3929,
          3930,
          3931,
          3932,
          3933,
          3934,
          3935,
          4218,
          5593,
          5594,
          5595,
          6037,
          5703,
          5803,
          5804,
          5805,
          5806,
          5807, // lucky charm
          8515,
          8516,
          8517,
          8518,
          8519,
          8520, // charm of courage
          8594,
          8595,
          8596,
          8597,
          8598,
          8599, // scrolls of recovery
          8954,
          8955,
          8956, // primeval crystal
          9146,
          9147,
          9148,
          9149,
          9150,
          9151,
          9152,
          9153,
          9154,
          9155
      };

  @Override
  public void useItem(L2PlayableInstance playable, L2ItemInstance item) {
    L2PcInstance activeChar;
    if(playable instanceof L2PcInstance) {
      activeChar = (L2PcInstance) playable;
    } else if(playable instanceof L2PetInstance) {
      activeChar = ((L2PetInstance) playable).getOwner();
    } else {
      return;
    }

    if(activeChar.isAllSkillsDisabled()) {
      activeChar.sendPacket(new ActionFailed());
      return;
    }

    if(activeChar.isInOlympiadMode()) {
      activeChar.sendPacket(new SystemMessage(SystemMessageId.THIS_ITEM_IS_NOT_AVAILABLE_FOR_THE_OLYMPIAD_EVENT));
      return;
    }

    int itemId = item.getItemId();

    // for the rest, there are no extra conditions
    if(!playable.destroyItem("Consume", item.getObjectId(), 1, null, false)) {
      return;
    }

    switch(itemId) {
      case 3926: // Scroll of Guidance XML:2050
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2050, 1, 1, 0));
        useScroll(activeChar, 2050, 1);
        break;
      case 3927: // Scroll of Death Whipser XML:2051
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2051, 1, 1, 0));
        useScroll(activeChar, 2051, 1);
        break;
      case 3928: // Scroll of Focus XML:2052
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2052, 1, 1, 0));
        useScroll(activeChar, 2052, 1);
        break;
      case 3929: // Scroll of Greater Acumen XML:2053
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2053, 1, 1, 0));
        useScroll(activeChar, 2053, 1);
        break;
      case 3930: // Scroll of Haste XML:2054
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2054, 1, 1, 0));
        useScroll(activeChar, 2054, 1);
        break;
      case 3931: // Scroll of Agility XML:2055
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2055, 1, 1, 0));
        useScroll(activeChar, 2055, 1);
        break;
      case 3932: // Scroll of Mystic Enpower XML:2056
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2056, 1, 1, 0));
        useScroll(activeChar, 2056, 1);
        break;
      case 3933: // Scroll of Might XML:2057
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2057, 1, 1, 0));
        useScroll(activeChar, 2057, 1);
        break;
      case 3934: // Scroll of Wind Walk XML:2058
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2058, 1, 1, 0));
        useScroll(activeChar, 2058, 1);
        break;
      case 3935: // Scroll of Shield XML:2059
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2059, 1, 1, 0));
        useScroll(activeChar, 2059, 1);
        break;
      case 4218: // Scroll of Mana Regeneration XML:2064
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2064, 1, 1, 0));
        useScroll(activeChar, 2064, 1);
        break;
      case 5593: // SP Scroll Low Grade XML:2167
        activeChar.sendPacket(new MagicSkillUser(playable, playable, 2167, 1, 1, 0));
        activeChar.broadcastPacket(new MagicSkillUser(playable, playable, 2167, 1, 1, 0));
        activeChar.addExpAndSp(0, 500);
        break;
      case 5594: // SP Scroll Medium Grade XML:2167
        activeChar.sendPacket(new MagicSkillUser(playable, playable, 2167, 1, 1, 0));
        activeChar.broadcastPacket(new MagicSkillUser(playable, playable, 2167, 1, 1, 0));
        activeChar.addExpAndSp(0, 5000);
        break;
      case 5595: // SP Scroll High Grade XML:2167
        activeChar.sendPacket(new MagicSkillUser(playable, playable, 2167, 1, 1, 0));
        activeChar.broadcastPacket(new MagicSkillUser(playable, playable, 2167, 1, 1, 0));
        activeChar.addExpAndSp(0, 100000);
        break;
      case 6037: // Scroll of Waking XML:2170
        activeChar.broadcastPacket(new MagicSkillUser(playable, playable, 2170, 1, 1, 0));
        useScroll(activeChar, 2170, 1);
        break;
      case 9146: // Scroll of Guidance - For Event XML:2050
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2050, 1, 1, 0));
        useScroll(activeChar, 2050, 1);
        break;
      case 9147: // Scroll of Death Whipser - For Event XML:2051
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2051, 1, 1, 0));
        useScroll(activeChar, 2051, 1);
        break;
      case 9148: // Scroll of Focus - For Event XML:2052
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2052, 1, 1, 0));
        useScroll(activeChar, 2052, 1);
        break;
      case 9149: // Scroll of Acumen - For Event XML:2053
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2053, 1, 1, 0));
        useScroll(activeChar, 2053, 1);
        break;
      case 9150: // Scroll of Haste - For Event XML:2054
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2054, 1, 1, 0));
        useScroll(activeChar, 2054, 1);
        break;
      case 9151: // Scroll of Agility - For Event XML:2055
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2055, 1, 1, 0));
        useScroll(activeChar, 2055, 1);
        break;
      case 9152: // Scroll of Enpower - For Event XML:2056
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2056, 1, 1, 0));
        useScroll(activeChar, 2056, 1);
        break;
      case 9153: // Scroll of Might - For Event XML:2057
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2057, 1, 1, 0));
        useScroll(activeChar, 2057, 1);
        break;
      case 9154: // Scroll of Wind Walk - For Event XML:2058
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2058, 1, 1, 0));
        useScroll(activeChar, 2058, 1);
        break;
      case 9155: // Scroll of Shield - For Event XML:2059
        activeChar.broadcastPacket(new MagicSkillUser(playable, activeChar, 2059, 1, 1, 0));
        useScroll(activeChar, 2059, 1);
        break;
      default:
        break;
    }
  }

  public void useScroll(L2PcInstance activeChar, int magicId, int level) {
    L2Skill skill = SkillTable.getInstance().getInfo(magicId, level);
    if(skill != null) {
      activeChar.doCast(skill);
    }
  }

  @Override
  public int[] getItemIds() {
    return ITEM_IDS;
  }
}
