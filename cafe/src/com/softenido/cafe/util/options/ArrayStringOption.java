/*
 *  ArrayStringOption.java
 *
 *  Copyright (C) 2009  Francisco Gómez Carrasco
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Report bugs or new features to: flikxxi@gmail.com
 *
 */
package com.softenido.cafe.util.options;

import java.util.ArrayList;

/**
 *
 * @author franci
 */
public class ArrayStringOption extends StringOption
{

    private ArrayList<String> values = new ArrayList<String>();
    private final String separator;

    public ArrayStringOption(String longName)
    {
        super(longName);
        separator = null;
    }

    public ArrayStringOption(String longName, char separator)
    {
        super(longName);
        this.separator = Character.toString(separator);
    }

    public ArrayStringOption(char shortName, String longName)
    {
        super(shortName, longName);
        separator = null;
    }

    public ArrayStringOption(char shortName, String longName, char separator)
    {
        super(shortName, longName);
        this.separator = Character.toString(separator);
    }

    public String[] getValues()
    {
        return values.toArray(new String[0]);
    }

    @Override
    public void setValue(String value)
    {
        if (separator == null)
        {
            values.add(value);
        }
        else
        {
            String[] tokens = value.split(separator);
            for (String item : tokens)
            {
                if (!item.isEmpty())
                {
                    values.add(item);
                }
            }
        }
    }
}
