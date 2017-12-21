SUMMARY = "Init configuration for busybox init"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://inittab \
		   file://rcS \
		   file://presysteminit.sh \
		   file://systeminit.sh \
		   file://udisk.sh \
		   file://mmc.sh \
		   file://mdev.conf \
		   file://modules.sh \
		   file://FzLt.TTF \
		   file://msyh.ttf \
		   file://FZLanTingHei.ttf \
		   file://app.ini \
		   file://startapp.sh \
		   file://startup.raw \
		   "

S = "${WORKDIR}"

do_compile() {
	:
}

do_install() {
	install -d ${D}${sysconfdir}
    install -d ${D}${sysconfdir}/init.d/
    install -d ${D}${sysconfdir}/mdev/
    install -d ${D}/usr/lib/fonts/

    install -m 755 ${WORKDIR}/app.ini ${D}${sysconfdir}/

    install -m 0644 ${WORKDIR}/inittab ${D}${sysconfdir}/inittab
    install -m 0644 ${WORKDIR}/mdev.conf ${D}${sysconfdir}/
    install -m 0755 ${WORKDIR}/udisk.sh ${D}${sysconfdir}/mdev/
    install -m 0755 ${WORKDIR}/mmc.sh ${D}${sysconfdir}/mdev/
    install -m 0755 ${WORKDIR}/msyh.ttf ${D}/usr/lib/fonts/
    install -m 0755 ${WORKDIR}/FzLt.TTF ${D}/usr/lib/fonts/
	install -m 0755 ${WORKDIR}/FZLanTingHei.ttf ${D}/usr/lib/fonts/
    install -m 0755 ${WORKDIR}/startup.raw ${D}/home/root/

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
    install -m 755 ${WORKDIR}/modules.sh ${D}${sysconfdir}/init.d/
    install -m 755 ${WORKDIR}/startapp.sh ${D}${sysconfdir}/init.d/
    install -m 755 ${WORKDIR}/rcS ${D}${sysconfdir}/init.d/

	update-rc.d -r ${D} asysteminit.sh start 00 5 . stop 00 6 .
	update-rc.d -r ${D} systeminit.sh start 00 5 . stop 00 6 .
	update-rc.d -r ${D} startapp.sh start 00 5 . stop 00 6 .
	update-rc.d -r ${D} modules.sh start 99 5 . stop 99 6 .
}

FILES_${PN} += "${sysconfdir}/inittab ${sysconfdir}/init.d/rcS /usr/lib/fonts"
