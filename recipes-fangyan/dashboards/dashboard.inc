SECTION = "fangyan"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

#PROVIDES = "virtual/dashboard"

S = "${WORKDIR}/git"

inherit qmake5-static
DEPENDS += "qtquickcompiler-static"
DEPENDS += "qtdbcommit-static"

FILES_${PN}-dbg += "/startup/.debug"
FILES_${PN} += "/"
