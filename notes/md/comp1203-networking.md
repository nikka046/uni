---
title:  'COMP1203 - Metadata'
author: Dominik Tarnowski (tdom.dev)
date: 12/11/19
---
# Networking

## Network layers

### Network access layer
 * deals with local (physical) link
 * each host has a link-unique address (48-bit MAC)
This operates on one of the following physical standards:
 * LAN
   * Ethernet
   * Wireless LAN
   * Wireless Personal Area Network
     * Bluetooth
     * Low-rate WPAN
 * ADSL
 * Mobile (3G, 4G, 5G, ...)

## Switches
 * switches operate at the Network access layer
 * only forwards traffic between the ports

## Internet layer (IPv4, IPv6)
 * handles next-hop routing (routing between different networks)
 * passes received packet's payload to correct transport layer
 * provides unique addressing
 * only provides "best effort" packet delivery -> packets are not checked if transmitted correctly or even delivered

### IPv4

 * 32-bit address
 * $2^{32}$ devices (4.3 billion)
 * minimum 20 byte header

Obviously these days we are running out of public IPv4 addresses.
This can be solved by **NAT** and **IPv6**.

### NAT

Router has one public IP and uses a translation table to send/receive data.
This does propose new issues as the individual devices cannot be directly connected to without e.g. port forwarding.

### IPv6

 * 128-bit
 * Written in colon-delimiter hex (2001:0db8:85a3:0000:0000:8a2e:0370:7334a)
 * 40 byte header

### ICMP & ICMPv6
 * used for diagnostic and control purposes
 * contained within standard IP packet
 * used by ping and traceroute
 
## Transport Layer
 * provides host-to-host connection (hides previous abstraction)
 * Uses TCP or UDP
 
| | TCP | UDP |
|--|--|--|
|Connection|Stable|"Fire and forget"|
|Reliability|Handles ACK & retransmissions|-|
|Data order|Always in order|-|
|Packet size|

### TCP Flow / Congestion flow
 * **TCP FLOW**: prevents fast sender from overwhelming a slow receiver
 * **Congestion flow**: reduces send rate to cope with network congestion

## Application Layer
 * software that uses the network

## Naming and addressing

|Layer|Name|
|--|:--:|
|Application|Domain|
|Transport|Port|
|Internet|IP|
|Link Layer|MAC|

## DNS
 * maps domain names to IPv4 or IPv6

## ARP / NPD
 * Address Resolution Protocol (IPv4)
 * Neighbour Discovery Protocol (IPv6)
 * Operates at link layer, translates IP to MAC

## Routing
 * At the Internet Layer
 * Each router has an IP address in each address space it routes between
 * Can also have a firewall, DNS, DHCP, etc

## Multiple paths for routing
 * Globally, to use the shortest/fastest path, we use **BGP**
 * Locally, we use **RIP** or **OSPF**

## Monitoring
 * In the UK, ISPs can be required to store certain connection information.

### Staying anonymous
 * Anonymous VPNs (still create logs, exit points can be monitored)
 * ToR
   * Routes traffic through random series of hops
   * Encrypted up to exit node
   * Reduces performance

