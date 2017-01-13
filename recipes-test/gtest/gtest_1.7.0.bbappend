FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI = " \
    file://gtest-1.7.0.zip \
    file://cmake-Add-install-command-for-libraries-and-headers.patch \
    file://CMakeLists-gtest.pc.in-Add-pkg-config-support-to-gte.patch \
"

SRC_URI[md5sum] = "2d6ec8ccdf5c46b05ba54a9fd1d130d7"
SRC_URI[sha256sum] = "247ca18dd83f53deb1328be17e4b1be31514cedfc1e3424f672bf11fd7e0d60d"
