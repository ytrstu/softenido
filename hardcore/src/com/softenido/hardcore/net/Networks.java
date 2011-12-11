/*
 * Networks.java
 *
 * Copyright (c) 2011  Francisco Gómez Carrasco
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
package com.softenido.hardcore.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 *
 * @author franci
 */
public class Networks 
{
    static final String[][] LANS  = 
    {
        { "192.168.","192.168.0.0","192.168.255.255"},
        { "10.",     "10.0.0.0",   "10.255.255.255"},
        { "172.16.", "172.16.0.0", "172.16.255.255"},
        { "172.17.", "172.17.0.0", "172.17.255.255"},
        { "172.18.", "172.18.0.0", "172.186.255.255"},
        { "172.19.", "172.19.0.0", "172.19.255.255"},
        { "172.20.", "172.20.0.0", "172.20.255.255"},
        { "172.21.", "172.21.0.0", "172.21.255.255"},
        { "172.22.", "172.22.0.0", "172.22.255.255"},
        { "172.23.", "172.23.0.0", "172.23.255.255"},
        { "172.24.", "172.23.0.0", "172.24.255.255"},
        { "172.25.", "172.25.0.0", "172.25.255.255"},
        { "172.26.", "172.26.0.0", "172.26.255.255"},
        { "172.27.", "172.27.0.0", "172.27.255.255"},
        { "172.28.", "172.28.0.0", "172.28.255.255"},
        { "172.29.", "172.29.0.0", "172.29.255.255"},
        { "172.30.", "172.30.0.0", "172.30.255.255"},
        { "172.31.", "172.31.0.0", "172.31.255.255"}
    };
    static public InetAddress[] getSiteAddresses() throws SocketException
    {
        ArrayList<InetAddress> list = new ArrayList<InetAddress>();
        Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
        for(; networks.hasMoreElements();)
        {
            NetworkInterface net = networks.nextElement();
            Enumeration<InetAddress> addresses = net.getInetAddresses();
            for(; addresses.hasMoreElements();)
            {
                InetAddress address = addresses.nextElement();
                if(address.isSiteLocalAddress())
                {
                    list.add(address);
                }
            }
        }
        return list.toArray(new InetAddress[0]);
    }
    static public InetAddress getFirstSiteAddress() throws SocketException
    {
        InetAddress[] list = getSiteAddresses();
        if(list.length>0)
        {
            return list[0];
        }
        return null;
    }
    
    static public String getNetAddress(String address)
    {
        for(int i=0;i<LANS.length;i++)
        {
            if(address.startsWith(LANS[i][0]))
                return LANS[i][1];
        }
        return null;
    }
    static public InetAddress getNetAddress(InetAddress address) throws UnknownHostException
    {
        String net = getNetAddress(address.getHostAddress());
        if(net!=null)
        {
            return InetAddress.getByName(net);
        }
        return null;
    }
    static public String getBroadCastAddress(String address)
    {
        for(int i=0;i<LANS.length;i++)
        {
            if(address.startsWith(LANS[i][0]))
                return LANS[i][2];
        }
        return null;
    }
    static public InetAddress getBroadCastAddress(InetAddress address) throws UnknownHostException
    {
        String net = getBroadCastAddress(address.getHostAddress());
        if(net!=null)
        {
            return InetAddress.getByName(net);
        }
        return null;
    }
}
