#!/usr/bin/env python3

import subprocess, sys, os

print("Connect to {}".format(sys.argv[1]))
os.system("rfcomm -i hci0 connect {} 1".format(sys.argv[1]))
print("Connecting...")