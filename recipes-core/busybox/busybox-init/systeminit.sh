#!/bin/sh

create_dir()
{
    if [ ! -d $1 ];then
        mkdir -m 755 $1
    fi
}

echo "Setting hostname ..."
hostname -F /etc/hostname

echo "Mounting all filesystems ... "
create_dir /dev/pts
create_dir /dev/shm
create_dir /dev/input
mount -a

create_dir /lib/modules/`uname -r`

ifconfig lo up

echo "Starting mdev ..."
echo /sbin/mdev > /proc/sys/kernel/hotplug
mdev -s

echo "open cpu1"
echo 1 > /sys/bus/cpu/devices/cpu1/online

# echo "resize /dev/mmcblk2p3"
resize2fs /dev/mmcblk2p3 > /dev/null 2>&1
