#!/bin/sh

MDIR=/mnt/$MDEV

if [ "$ACTION" = "add" ];
then
	# At mdev -s state during boot.
	if [ -z $DEVTYPE ];
	then
		COUNT=`find /dev -name "mmcblk*" | wc -l`
		if [ $COUNT -gt 1 ];
		then
			umount $MDIR > /dev/null 2>&1
		fi
		# Device has partition, not mount at disk node
	elif [ "$DEVTYPE" = "disk" -a $NPARTS -gt 0 ];
	then
		exit 0
	fi

	exec 1>/dev/console
	exec 2>/dev/console

	echo "Auto mount SDCARD(/dev/$MDEV) to $MDIR"
	mkdir -p $MDIR
	if ! mount /dev/$MDEV $MDIR; then
		exit 1
	fi
else
	echo "umount SDCARD from $MDIR"
	umount -l $MDIR
fi
