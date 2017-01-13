DESCRIPTION = "Static openssh keys"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " \
    file://ssh_host_dsa_key \
    file://ssh_host_ecdsa_key \
    file://ssh_host_rsa_key \
    file://ssh_host_ed25519_key \
    file://ssh_host_dsa_key.pub \
    file://ssh_host_ecdsa_key.pub \
    file://ssh_host_rsa_key.pub \
    file://ssh_host_ed25519_key.pub \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/ssh
    install -m 0600 ${WORKDIR}/ssh_host_dsa_key ${D}${sysconfdir}/ssh
    install -m 0600 ${WORKDIR}/ssh_host_rsa_key ${D}${sysconfdir}/ssh
    install -m 0600 ${WORKDIR}/ssh_host_ecdsa_key ${D}${sysconfdir}/ssh
    install -m 0600 ${WORKDIR}/ssh_host_ed25519_key ${D}${sysconfdir}/ssh
    install -m 0644 ${WORKDIR}/ssh_host_dsa_key.pub ${D}${sysconfdir}/ssh
    install -m 0644 ${WORKDIR}/ssh_host_rsa_key.pub ${D}${sysconfdir}/ssh
    install -m 0644 ${WORKDIR}/ssh_host_ecdsa_key.pub ${D}${sysconfdir}/ssh
    install -m 0644 ${WORKDIR}/ssh_host_ed25519_key.pub ${D}${sysconfdir}/ssh
}

PACKAGE_ARCH = "all"

RDEPENDS_${PN} = "openssh"

do_compile[noexec] = "1"
