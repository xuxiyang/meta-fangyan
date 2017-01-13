DEPENDS = "emutils-native"

inherit deploy

PACK_IMG = "pack-${MACHINE}-${PV}-${PR}-${DATETIME}.img"
PACK_IMG_SYMLINK = "pack-${MACHINE}.img"
PACK_IMG_SYMLINK_SIMPLE = "pack.img"

do_deploy() {
    install -m 0644 ${B}/${PACK_IMG} ${DEPLOYDIR}/
    ln -snf ${PACK_IMG} ${DEPLOYDIR}/${PACK_IMG_SYMLINK}
    ln -snf ${PACK_IMG} ${DEPLOYDIR}/${PACK_IMG_SYMLINK_SIMPLE}
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

