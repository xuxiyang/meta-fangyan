SUMMARY = "Init configuration for busybox init"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://inittab \
		   file://rcS \
		   file://presysteminit.sh \
		   file://systeminit.sh \
		   "

S = "${WORKDIR}"

do_compile() {
	:
}

do_install() {
	install -d ${D}${sysconfdir}
    install -d ${D}${sysconfdir}/init.d/

    install -m 0644 ${WORKDIR}/inittab ${D}${sysconfdir}/inittab

    set -x
    tmp="${SERIAL_CONSOLES}"
    for i in $tmp
    do
	j=`echo ${i} | sed s/\;/\ /g`
	label=`echo ${i} | sed -e 's/^.*;//' -e 's/;.*//'`

	# need login
	echo "$label::respawn:/bin/login" >> ${D}${sysconfdir}/inittab
	# No need login
	#echo "$label::askfirst:/bin/sh" >> ${D}${sysconfdir}/inittab

    done

    install -m 755 ${WORKDIR}/presysteminit.sh ${D}${sysconfdir}/init.d/asysteminit.sh
    install -m 755 ${WORKDIR}/systeminit.sh ${D}${sysconfdir}/init.d/
    install -m 755 ${WORKDIR}/rcS ${D}${sysconfdir}/init.d/

	update-rc.d -r ${D} asysteminit.sh start 00 5 . stop 00 6 .
	update-rc.d -r ${D} systeminit.sh start 00 5 . stop 00 6 .
}

FILES_${PN} += "${sysconfdir}/inittab ${sysconfdir}/init.d/rcS"
