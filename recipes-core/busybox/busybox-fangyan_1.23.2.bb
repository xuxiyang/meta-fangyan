require busybox.inc

SRC_URI = "http://www.busybox.net/downloads/busybox-${PV}.tar.bz2;name=tarball \
		   file://wisehmi_defconfig \
"

PROVIDES += "busybox"
RPROVIDES_${PN} = "busybox"

SRC_URI[tarball.md5sum] = "7925683d7dd105aabe9b6b618d48cc73"
SRC_URI[tarball.sha256sum] = "05a6f9e21aad8c098e388ae77de7b2361941afa7157ef74216703395b14e319a"

EXTRA_OEMAKE += "V=1 ARCH=arm CROSS_COMPILE=arm-linux-gnueabi-"
