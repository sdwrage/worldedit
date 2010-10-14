// $Id$
/*
 * WorldEdit
 * Copyright (C) 2010 sk89q <http://www.sk89q.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

import com.sk89q.worldedit.*;

/**
 *
 * @author sk89q
 */
public class SMServerInterface implements ServerInterface {
    /**
     * Set block type.
     *
     * @param pt
     * @param type
     * @return
     */
    public boolean setBlockType(Vector pt, int type) {
        return etc.getMCServer().e.d(pt.getBlockX(), pt.getBlockY(),
                pt.getBlockZ(), type);
    }
    
    /**
     * Get block type.
     *
     * @param pt
     * @return
     */
    public int getBlockType(Vector pt) {
        return etc.getMCServer().e.a(pt.getBlockX(), pt.getBlockY(), pt.getBlockZ());
    }

    /**
     * Set block data.
     *
     * @param pt
     * @param data
     * @return
     */
    public void setBlockData(Vector pt, int data) {
        etc.getMCServer().e.c(pt.getBlockX(), pt.getBlockY(),
                        pt.getBlockZ(), data);
    }

    /**
     * Get block data.
     *
     * @param pt
     * @return
     */
    public int getBlockData(Vector pt) {
        return etc.getMCServer().e.b(pt.getBlockX(), pt.getBlockY(), pt.getBlockZ());
    }
    
    /**
     * Set sign text.
     *
     * @param pt
     * @param text
     */
    public void setSignText(Vector pt, String[] text) {
        Sign signData = (Sign)etc.getServer().getComplexBlock(
                pt.getBlockX(), pt.getBlockY(), pt.getBlockZ());
        for (byte i = 0; i < 4; i++) {
            signData.setText(i, text[i]);
        }
        signData.update();
    }
    
    /**
     * Get sign text.
     *
     * @param pt
     * @return
     */
    public String[] getSignText(Vector pt) {
        Sign signData = (Sign)etc.getServer().getComplexBlock(
                pt.getBlockX(), pt.getBlockY(), pt.getBlockZ());
        String[] text = new String[4];
        for (byte i = 0; i < 4; i++) {
            text[i] = signData.getText(i);
        }
        return text;
    }
}