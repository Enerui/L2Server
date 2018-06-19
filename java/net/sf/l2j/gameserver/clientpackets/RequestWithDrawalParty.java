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
package net.sf.l2j.gameserver.clientpackets;

import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

public final class RequestWithDrawalParty extends L2GameClientPacket {
  private static final String _C__2B_REQUESTWITHDRAWALPARTY = "[C] 2B RequestWithDrawalParty";

  @Override
  protected void readImpl() {
    // trigger
  }

  @Override
  protected void runImpl() {
    L2PcInstance player = getClient().getActiveChar();
    if(player == null) {
      return;
    }

    if(player.isInParty()) {
      player.getParty().oustPartyMember(player);
    }
  }

  @Override
  public String getType() {
    return _C__2B_REQUESTWITHDRAWALPARTY;
  }
}