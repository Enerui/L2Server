/*
 * This program is free software; you can redistribute it and/or modify
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
package net.sf.l2j.gameserver.serverpackets;

import java.util.List;
import net.sf.l2j.Config;
import net.sf.l2j.gameserver.model.L2ItemInstance;
import net.sf.l2j.gameserver.model.L2TradeList;
import net.sf.l2j.gameserver.templates.L2Item;

public class WearList extends L2GameServerPacket {
  private static final String _S__EF_WEARLIST = "[S] EF WearList";
  private final int _listId;
  private final L2ItemInstance[] _list;
  private final int _money;

  public WearList(L2TradeList list, int currentMoney, int expertiseIndex) {
    _listId = list.getListId();
    List<L2ItemInstance> lst = list.getItems();
    _list = lst.toArray(new L2ItemInstance[lst.size()]);
    _money = currentMoney;
  }

  public WearList(List<L2ItemInstance> lst, int listId, int currentMoney) {
    _listId = listId;
    _list = lst.toArray(new L2ItemInstance[lst.size()]);
    _money = currentMoney;
  }

  @Override
  protected final void writeImpl() {
    writeC(0xef);
    writeC(0xc0); // ?
    writeC(0x13); // ?
    writeC(0x00); // ?
    writeC(0x00); // ?
    writeD(_money); // current money
    writeD(_listId);

    int newlength = 0;
    writeH(newlength);
  }

  @Override
  public String getType() {
    return _S__EF_WEARLIST;
  }
}
