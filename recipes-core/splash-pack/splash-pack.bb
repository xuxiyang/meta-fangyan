DESCRIPTION = "Generate splash.bin"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "emutils-native"

PV = "1.0"

SRC_URI = "file://logo.bmp"

S = "${WORKDIR}"

inherit deploy

SPLASH_BIN = "splash-${MACHINE}-${PV}-${PR}-${DATETIME}.bin"
SPLASH_BIN_SYMLINK = "splash-${MACHINE}.bin"
SPLASH_BIN_SYMLINK_SIMPLE = "splash.bin"

do_compile() {
    mksplash -b32 ${WORKDIR}/logo.bmp -o ${B}/${SPLASH_BIN}
}

do_deploy() {
    install -m 0644 ${B}/${SPLASH_BIN} ${DEPLOYDIR}/
    ln -snf ${SPLASH_BIN} ${DEPLOYDIR}/${SPLASH_BIN_SYMLINK}
    ln -snf ${SPLASH_BIN} ${DEPLOYDIR}/${SPLASH_BIN_SYMLINK_SIMPLE}
}
addtask deploy before do_build after do_compile

PACKAGES = ""

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install[noexec] = "1"
do_package[noexec] = "1"
do_packagedata[noexec] = "1"
do_package_write[noexec] = "1"
do_package_write_ipk[noexec] = "1"
do_package_write_rpm[noexec] = "1"
do_package_write_deb[noexec] = "1"
do_populate_sysroot[noexec] = "1"

