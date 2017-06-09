SUMMARY = "Tiny versions of many common UNIX utilities in a single small executable"
DESCRIPTION = "BusyBox combines tiny versions of many common UNIX utilities into a single small executable. It provides minimalist replacements for most of the utilities you usually find in GNU fileutils, shellutils, etc. The utilities in BusyBox generally have fewer options than their full-featured GNU cousins; however, the options that are included provide the expected functionality and behave very much like their GNU counterparts. BusyBox provides a fairly complete POSIX environment for any small or embedded system."
HOMEPAGE = "http://www.busybox.net"
BUGTRACKER = "https://bugs.busybox.net/"

# bzip2 applet in busybox is based on lightly-modified bzip2 source
# the GPL is version 2 only
LICENSE = "GPLv2 & bzip2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SECTION = "base"

FILES_${PN} += "/linuxrc"
FILES_${PN}-mdev = "${sysconfdir}/init.d/mdev ${sysconfdir}/mdev.conf ${sysconfdir}/mdev/*"
FILES_${PN}-hwclock = "${sysconfdir}/init.d/hwclock.sh"

do_configure () {
	cp ${WORKDIR}/busybox-${PV}/. ${B}/ -a
	cp ${WORKDIR}/wisehmi_defconfig ${B}/configs/
	make wisehmi_defconfig
	touch /tmp/aaaaaaa_configure
}

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    make
	touch /tmp/aaaaaaa_configure
}

do_install () {
	install -d ${D}
    make CONFIG_PREFIX="${D}" install
	cp -f busybox_unstripped ${D}/bin/busybox
	touch /tmp/aaaaaaa_install
}
