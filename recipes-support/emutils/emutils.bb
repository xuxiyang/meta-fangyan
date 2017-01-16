DESCRIPTION = "EMUTILS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"
PV = "1.1"
SRCBRANCH = "master"
SRCREV = "644c216d454a589e88cc21e0097d55ac5f07563f"
SRC_URI = "git://git@192.168.3.200:10022/utils/utils.git;branch=${SRCBRANCH};protocol=ssh"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"

do_compile() {
    oe_runmake -C emconfig
#   oe_runmake -C monserver
    oe_runmake -C packimg
    oe_runmake -C mksplash
    oe_runmake -C catprogress
    oe_runmake -C initroot_startup_qt5
}

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${sbindir}
    install -m 755 ${B}/emconfig/emconfig ${D}${sbindir}
    install -m 755 ${B}/mksplash/mksplash ${D}${sbindir}
    install -m 755 ${B}/catprogress/catprogress ${D}${bindir}
#   install -m 755 ${B}/monserver/monserver ${D}${sbindir}
#   ln -snf monserver ${D}${sbindir}/enumd
    install -m 755 ${B}/packimg/packimg ${D}${bindir}
    ln -snf packimg ${D}${bindir}/packimg_burn
    ln -snf packimg ${D}${bindir}/unpackimg

    install -d ${D}${libdir}
    install -d ${D}${includedir}
    install -m 755 ${B}/initroot_startup_qt5/libinitroot_startup.a ${D}${libdir}
    install -m 644 ${S}/initroot_startup_qt5/initroot_startup.h ${D}${includedir}
}

# prevent already-stripped QA Issue
INHIBIT_SYSROOT_STRIP = "1"
INSANE_SKIP_${PN} += "already-stripped"

PACKAGES = "emconfig mksplash packimg initfs-staticdev initfs-dev catprogress"
#PACKAGES += "monserver"

FILES_emconfig = "${sbindir}/emconfig"
FILES_mksplash = "${sbindir}/mksplash"
FILES_catprogress = "${bindir}/catprogress"
#FILES_monserver = "${sbindir}/monserver ${sbindir}/enumd"
FILES_packimg = "${bindir}/packimg ${bindir}/packimg_burn ${bindir}/unpackimg"
FILES_initfs-staticdev = "${libdir}/libinitroot_startup.a"
FILES_initfs-dev = "${includedir}/initroot_startup.h"
