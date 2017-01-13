SUMMARY = "init script for dashboard startup"
SECTION = "fangyan"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://dashboard"

INITSCRIPT_NAME = "dashboard"
INITSCRIPT_PARAMS = "start 06 S ."

inherit update-rc.d

do_compile () {
}

do_install () {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/dashboard ${D}${sysconfdir}/init.d/
}
