/*
 * This file is part of aion-unique <www.aion-unique.com>.
 *
 *  aion-unique is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-unique is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-unique.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.gameserver.network.aion.serverpackets;

import java.nio.ByteBuffer;

import com.aionemu.gameserver.network.aion.AionConnection;
import com.aionemu.gameserver.network.aion.AionServerPacket;

/**
 * @author Avol
 */
public class SM_EXCHANGE_ADD_KINAH extends AionServerPacket
{
	private int itemCount;
	private int action;

	public SM_EXCHANGE_ADD_KINAH(int itemCount, int action)
	{
		this.itemCount = itemCount;	
		this.action = action;
	}

	@Override
	protected void writeImpl(AionConnection con, ByteBuffer buf)
	{
		writeC(buf, action); // 0 -self 1-other
		writeD(buf, itemCount); // itemId
		writeD(buf, 0); // unk
	}
}