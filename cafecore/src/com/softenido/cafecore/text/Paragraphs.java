/*
 * Phrases.java
 *
 * Copyright (c) 2012  Francisco Gómez Carrasco
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Report bugs or new features to: flikxxi@gmail.com
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softenido.cafecore.text;

import com.softenido.cafecore.util.Strings;
import java.util.ArrayList;

/**
 *
 * @author franci
 */
public class Paragraphs
{
    static final String SEP = "\n[\\s]*\n";
    static final String UFFF = "[\ufff0-\uffff]+";
    //static final String TRIM = "(^\\s+)|(\\s+$)";
    

    public static String[] split(String doc)
    {
        return doc.split(SEP);
    }
    public static String[] split(String doc, boolean cleanUnicode)
    {
        //clean dirty characters
        doc = cleanUnicode?doc.replaceAll(UFFF, " "):doc;
        //trim
        doc = Strings.trimWhitespaces(doc);
        //split into paragraphs
        String[] array = doc.split(SEP);
        
        ArrayList<String> list = new ArrayList<String>(array.length);
        for(String item : array)
        {
            item = Strings.trimWhitespaces(item);
            if(item.length()>0)
            {
                list.add(item);
            }
        }
        return list.toArray(new String[0]);
    }
}
