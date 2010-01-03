/*
 * This file is part of aion-emu <aion-emu.com>.
 *
 *  aion-emu is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-emu is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-emu.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.gameserver.network.aion.serverpackets;

import java.nio.ByteBuffer;
import org.apache.log4j.Logger;
import com.aionemu.gameserver.network.aion.AionConnection;
import com.aionemu.gameserver.network.aion.AionServerPacket;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.world.World;
import com.google.inject.Inject;

/** 
 * Opens a yes/no question window on the client.
 * Question based on the code given, defined in client_strings.xml
 * 
 * @author Ben, avol, Lyahim
 *
 */
public class SM_QUESTION_WINDOW extends AionServerPacket
{
	private static final Logger	log	= Logger.getLogger(SM_QUESTION_WINDOW.class);
	
	public static final int STR_BUDDYLIST_ADD_BUDDY_REQUETS = 0x0DBEE9;
	public static final int STR_EXCHANGE_DO_YOU_ACCEPT_EXCHANGE = 0x15f91;
	public static final int STR_EXCHANGE_HE_REJECTED_EXCHANGE = 0x13D782;// TODO: make it a simple box, not a question.
	public static final int STR_DUEL_DO_YOU_CONFIRM_DUEL = 0xc36e;
	public static final int STR_DUEL_DO_YOU_ACCEPT_DUEL = 0xc36c;
	public static final int STR_SOUL_HEALING = 160011;
	public static final int STR_BIND_TO_LOCATION = 160012;
	public static final int	STR_REQUEST_GROUP_INVITE = 60000;
	public static final int	STR_WAREHOUSE_EXPAND_WARNING = 900686;
	
	private int code;
	private int senderId;
	private String[] params;

	/**
	 * Creates a new <tt>SM_QUESTION_WINDOW<tt> packet
	 * @param code code The string code to display, found in client_strings.xml
	 * @param senderId sender Object id
	 * @param params params The parameters for the string, if any
	 */
	public SM_QUESTION_WINDOW(int code, int senderId, String... params) {
		this.code = code;
		this.senderId = senderId;
		this.params = params;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeImpl(AionConnection con, ByteBuffer buf)
	{
		writeD(buf, code);
		
		for (String string : params) 
			writeS(buf, string);
		
		writeD(buf, 0x00);//unk
		writeH(buf, 0x00);//unk
		writeC(buf, 0x01);//unk
		writeD(buf, senderId);
		writeD(buf, 0x06); //group 6, unk
	}

}
