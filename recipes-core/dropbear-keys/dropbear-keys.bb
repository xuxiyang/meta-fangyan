DESCRIPTION = "Static dropbear keys"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " \
    file://dropbear_dss_host_key \
    file://dropbear_rsa_host_key \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/dropbear
    install -m 0600 ${WORKDIR}/dropbear_dss_host_key ${D}${sysconfdir}/dropbear
    install -m 0600 ${WORKDIR}/dropbear_rsa_host_key ${D}${sysconfdir}/dropbear
}

PACKAGE_ARCH = "all"

RDEPENDS_${PN} = "dropbear"

do_compile[noexec] = "1"
